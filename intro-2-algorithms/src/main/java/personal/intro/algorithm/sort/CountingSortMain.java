package personal.intro.algorithm.sort;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import personal.intro.algorithm.util.Functional;
import personal.intro.algorithm.util.ParamsInvalidException;

/**
 * Created by Stubborn on 2017/5/24.
 * 计数排序算法实现
 * 在实际工作中，当k=O(n)时，一般采用计数排序
 * 其中，n为数组元素数目，k为数目元素的取值范围
 */
public class CountingSortMain {

    private static final Logger LOG = LoggerFactory.getLogger(CountingSortMain.class);

    /**
     * 计数排序算法实现
     *
     * @param origin 原始数组
     * @param k      取值范围
     * @return
     */
    public static int[] countSort(int[] origin, int k) {
        int[] result = new int[origin.length];
        int[] domain = new int[k];
        for (int i = 0; i < domain.length; i++) {
            domain[i] = 0;
        }
        for (int i = 0; i < origin.length; i++) {
            domain[origin[i]] += 1;
        }
        for (int i = 1; i < domain.length; i++) {
            domain[i] += domain[i - 1];
        }

        for (int i = 0; i < origin.length; i++) {
            result[domain[origin[i]] - 1] = origin[i];
            domain[origin[i]] -= 1;
        }

        return result;
    }

    public static void main(String[] args) throws ParamsInvalidException {
        int k = 10;
        int[] random = Functional.getRandomIntegerArray(10, 0, k);
        LOG.info("random array is: {}", Functional.convertArray2String(random));
        long beginTime = System.nanoTime();
        int[] sorted = countSort(random, k);
        long endTime = System.nanoTime();
        LOG.info("sorted result is: {}, and cost time is: {} nano seconds",
                Functional.convertArray2String(sorted), endTime - beginTime);
    }
}
