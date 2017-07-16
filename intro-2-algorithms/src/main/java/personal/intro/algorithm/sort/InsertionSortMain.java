package personal.intro.algorithm.sort;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import personal.intro.algorithm.util.Functional;
import personal.intro.algorithm.util.ParamsInvalidException;

/**
 * Created by Stubborn on 2017/5/22.
 * 插入排序算法实现
 */
public class InsertionSortMain {

    private static final Logger LOG = LoggerFactory.getLogger(InsertionSortMain.class);

    /**
     * 使用插入排序算法对数组排序
     *
     * @param originArray 欲实行排序的数组
     */
    public static void insertionSort(int[] originArray) {
        LOG.info("sort origin array");
        for (int i = 1; i < originArray.length; i++) {
            int key = originArray[i];
            int j = i - 1;
            while (j >= 0 && originArray[j] > key) {
                originArray[j + 1] = originArray[j];
                j = j - 1;
            }
            originArray[j + 1] = key;
            LOG.info("after " + i + " step, the sort result is: [{}]", Functional.convertArray2String(originArray));
        }
    }

    /**
     * 程序主入口
     *
     * @param args
     */
    public static void main(String[] args) throws ParamsInvalidException {
        int[] randomArrays = Functional.getRandomIntegerArray(10);
        LOG.info("the random array is: [{}]", Functional.convertArray2String(randomArrays));
        insertionSort(randomArrays);
        LOG.info("after sort, the array is: [{}]", Functional.convertArray2String(randomArrays));
    }

}
