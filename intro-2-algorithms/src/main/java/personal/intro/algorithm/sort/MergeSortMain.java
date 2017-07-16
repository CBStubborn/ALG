package personal.intro.algorithm.sort;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import personal.intro.algorithm.util.Functional;
import personal.intro.algorithm.util.ParamsInvalidException;

/**
 * Created by Stubborn on 2017/5/22.
 * 归并排序算法实现
 */
public class MergeSortMain {

    private static final Logger LOG = LoggerFactory.getLogger(MergeSortMain.class);

    /**
     * @param array_1 is an already sorted array
     * @param array_2 is an already sorted array
     */
    public static int[] mergeSort(int[] array_1, int[] array_2) {
        int[] sortedArray = new int[array_1.length + array_2.length];
        int i = 0;
        int j = 0;
        for (int k = 0; k < sortedArray.length; k++) {
            if (array_1[i] <= array_2[j]) {
                sortedArray[k] = array_1[i];
                if (i + 1 == array_1.length) {
                    //通过此方法设置“哨兵”,免去每轮检查是否有每个数组为空
                    //更好的方法是，为array_1和array_2各增添一个Integer.MAX_VALUE元素
                    array_1[i] = Integer.MAX_VALUE;
                } else {
                    i++;
                }
            } else {
                sortedArray[k] = array_2[j];
                if (j + 1 == array_2.length) {
                    array_2[j] = Integer.MAX_VALUE;
                } else {
                    j++;
                }
            }
        }
        return sortedArray;
    }

    /**
     * @param args
     */
    public static void main(String[] args) throws ParamsInvalidException{
        int[] originArray_1 = Functional.getRandomIntegerArray(5);
        InsertionSortMain.insertionSort(originArray_1);
        LOG.info("origin array 1 is: [{}]" + Functional.convertArray2String(originArray_1));
        int[] originArray_2 = Functional.getRandomIntegerArray(7);
        InsertionSortMain.insertionSort(originArray_2);
        LOG.info("origin array 2 is: [{}]" + Functional.convertArray2String(originArray_2));
        int[] resultArray = mergeSort(originArray_1, originArray_2);
        LOG.info("merge sorted result is: [{}]" + Functional.convertArray2String(resultArray));
    }
}
