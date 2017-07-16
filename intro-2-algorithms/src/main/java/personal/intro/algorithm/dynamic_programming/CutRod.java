package personal.intro.algorithm.dynamic_programming;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import personal.intro.algorithm.util.Functional;
import personal.intro.algorithm.util.ParamsInvalidException;

/**
 * Created by Stubborn on 2017/7/4.
 * 钢条切割问题：
 * 根据钢条尺寸不同，其价格也不同。
 * 现有一段长为n的钢条，要求给出最佳切割方案，使获取的价格最高
 */
public class CutRod {

    private static final Logger LOG = LoggerFactory.getLogger(CutRod.class);

    /**
     * 公式为：maxPrice = max(p[n], r[1] + r[n-1], r[2] + r[n-2] ... r[n-1] + r[1])
     *
     * @param length rod length
     * @param price  price array
     * @return
     * @throws ParamsInvalidException
     */
    public static int simpleCut(int length, int[] price) throws ParamsInvalidException {
        if (length + 1 > price.length) {
            throw new ParamsInvalidException("rod length shouldn't larger than the size of price array");
        }
        if (!(length > 0)) {
            throw new ParamsInvalidException("rod length should be a positive");
        }
        int maxPrice = price[length];
        for (int i = 1; i <= length / 2; i++) {
            int tmpPrice = simpleCut(i, price) + simpleCut(length - i, price);
            if (tmpPrice > maxPrice) {
                maxPrice = tmpPrice;
            }
        }
        return maxPrice;
    }

    /**
     * 思想为：从钢条左侧切下一段长为i的钢条，只对右侧长长度为n-i的一段继续进行切割
     * 公式为：r[n] = max(p[i] + r[n-i]), 其中1<= i <= n
     *
     * @param length rod length
     * @param price  price array
     * @return
     */
    public static int simpleCutButMoreEasy(int length, int[] price) throws ParamsInvalidException {
        if (length == 0) {
            return 0;
        }
        int maxPrice = Integer.MIN_VALUE;
        for (int i = 1; i <= length; i++) {
            int tmpPrice = price[i] + simpleCutButMoreEasy(length - i, price);
            if (tmpPrice > maxPrice) {
                maxPrice = tmpPrice;
            }
        }
        return maxPrice;
    }

    /**
     * 动态规划：仔细安排求解顺序，对每个子问题只求解一次，并将结果保存下来，之后如果需再次求解该子问题，只需查找保存的结果，不必重新计算
     * 因此，动态规划方法是付出额外的空间换取计算时间的策略
     * 本方法采用带备忘的自顶向下动态规划方法
     * 此方法在simpleCutButMoreEasy方法基础上加入了备忘机制，记录已经解决的子问题，从而大幅降低计算时间
     *
     * @param length rod length
     * @param price price array
     * @return
     */
    public static int memorizedCut(int length, int[] price) {
        int[] subResult = new int[length + 1];
        for (int i = 1; i < subResult.length; i++) {
            subResult[i] = Integer.MIN_VALUE;
        }
        subResult[0] = 0;
        int maxPrice = memorizedCutImplement(length, price, subResult);
        return maxPrice;
    }

    /**
     * @param length
     * @param price
     * @param subResult
     * @return
     */
    public static int memorizedCutImplement(int length, int[] price, int[] subResult) {
        int tmpMaxPrice = Integer.MIN_VALUE;
        if (subResult[length] >= 0) {
            return subResult[length];
        }
        if (length == 0) {
            tmpMaxPrice = 0;
        } else {
            for (int i = 1; i <= length; i++) {
                int tmpPrice = price[i] + memorizedCutImplement(length - i, price, subResult);
                if (tmpPrice > tmpMaxPrice) {
                    tmpMaxPrice = tmpPrice;
                }
            }
        }
        subResult[length] = tmpMaxPrice;
        return tmpMaxPrice;
    }

    /**
     * 自底向上的动态规划
     *
     * @param length
     * @param price
     * @return
     */
    public static int bottom2UpCut(int length, int[] price) {
        int[] subResult = new int[length + 1];
        subResult[0] = 0;
        for (int i = 1; i <= length; i++) {
            int tmpMaxPrice = Integer.MIN_VALUE;
            for (int j = 1; j <= i; j++) {
                int tmpPrice = price[j] + subResult[i - j];
                if (tmpPrice > tmpMaxPrice) {
                    tmpMaxPrice = tmpPrice;
                }
            }
            subResult[i] = tmpMaxPrice;
        }
        return subResult[length];
    }

    public static void main(String[] args) throws ParamsInvalidException {
        int[] randomPrice = Functional.getRandomIntegerArray(41, 1, 50);
        randomPrice[0] = 0;
        LOG.info("random price array is: {}", Functional.convertArray2String(randomPrice));
        int rodLength = 30;
        long time_begin_1 = System.currentTimeMillis();
        int maxPrice_1 = simpleCut(rodLength, randomPrice);
        long time_end_1 = System.currentTimeMillis();
        LOG.info("max price is: {} for rod length: {} by call simpleCut and cost time is: {} mill second", maxPrice_1, rodLength, time_end_1 - time_begin_1);
        long time_begin_2 = System.currentTimeMillis();
        int maxPrice_2 = simpleCutButMoreEasy(rodLength, randomPrice);
        long time_end_2 = System.currentTimeMillis();
        LOG.info("max price is: {} for rod length: {} by call simpleCutButMoreEasy and cost time is: {} mill second", maxPrice_2, rodLength, time_end_2 - time_begin_2);
        long time_begin_3 = System.nanoTime();
        int maxPrice_3 = memorizedCut(rodLength, randomPrice);
        long time_end_3 = System.nanoTime();
        LOG.info("max price is: {} for rod length: {} by call memorizedCut and cost time is: {} nano second", maxPrice_3, rodLength, time_end_3 - time_begin_3);
        long time_begin_4 = System.nanoTime();
        int maxPrice_4 = bottom2UpCut(rodLength, randomPrice);
        long time_end_4 = System.nanoTime();
        LOG.info("max price is: {} for rod length: {} by call bottom2UpCut and cost time is: {} nano second", maxPrice_4, rodLength, time_end_4 - time_begin_4);
    }
}
