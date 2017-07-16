package personal.intro.algorithm.sort;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import personal.intro.algorithm.util.Functional;
import personal.intro.algorithm.util.ParamsInvalidException;

/**
 * Created by Stubborn on 2017/5/24.
 * 快速排序算法实现
 */
public class QuickSortMain {

    private static final Logger LOG = LoggerFactory.getLogger(QuickSortMain.class);

    /**
     * 快速排序
     * @param origin
     * @param beginIndex
     * @param endIndex
     */
    public static void quickSort(int[] origin, int beginIndex, int endIndex) {
        if (beginIndex < endIndex) {
            int split = partition(origin, beginIndex, endIndex);
            LOG.debug("split position is: {}", split);
            quickSort(origin, beginIndex, split - 1);
            quickSort(origin, split + 1, endIndex);
        }
    }

    /**
     * 分区算法实现
     * @param origin
     * @param beginIndex
     * @param endIndex
     * @return
     */
    public static int partition(int[] origin, int beginIndex, int endIndex) {
        int flag = origin[endIndex];
        int i = beginIndex - 1;
        for (int j = beginIndex; j < endIndex; j++) {
            if (origin[j] <= flag) {
                i += 1;
                int tmp = origin[i];
                origin[i] = origin[j];
                origin[j] = tmp;
            }
        }
        int tmp = origin[i + 1];
        origin[i + 1] = origin[endIndex];
        origin[endIndex] = tmp;
        return i + 1;
    }

    /**
     *
     * @param args
     * @throws ParamsInvalidException
     */
    public static void main(String[] args) throws ParamsInvalidException {
        int[] random = Functional.getRandomIntegerArray(10, 1, 10);
        LOG.info("random array is: {}", Functional.convertArray2String(random));
        long beginTime = System.nanoTime();
        quickSort(random, 0, random.length - 1);
        long endTime = System.nanoTime();
        LOG.info("sorted array is: {}, cost time: {} nano seconds",
                Functional.convertArray2String(random), endTime - beginTime);
    }
}
