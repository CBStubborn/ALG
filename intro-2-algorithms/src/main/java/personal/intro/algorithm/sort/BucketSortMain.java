package personal.intro.algorithm.sort;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import personal.intro.algorithm.util.Functional;
import personal.intro.algorithm.util.ParamsInvalidException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Stubborn on 2017/5/24.
 * 桶排序算法实现
 */
public class BucketSortMain {

    private static final Logger LOG = LoggerFactory.getLogger(BucketSortMain.class);

    /**
     * bucket sort,1-100以内海量随机数排序
     * @param array
     */
    public static void sort(int[] array) {
        List<Integer>[] result = new List[100];
        for (int element : array) {
            if(result[element - 1] == null) {
                List<Integer> list = new ArrayList<>();
                result[element - 1] = list;
            }
            result[element - 1].add(element);
        }
        int index = 0;
        for (int i = 0; i < result.length; i++) {
            if (result[i] != null) {
                for (int k = 0; k < result[i].size(); k++) {
                    array[index] = result[i].get(k);
                    index++;
                }
            }
        }
    }

    public static void main(String[] args) throws ParamsInvalidException {
        int[] originArray = Functional.getRandomIntegerArray(100000000, 1, 100);
        //LOG.info("origin array: " + Arrays.toString(originArray));
        long current = System.currentTimeMillis();
        sort(originArray);
        //LOG.info("sorted array: " + Arrays.toString(originArray));
        LOG.info("cost time: " + (System.currentTimeMillis() - current));
    }
}
