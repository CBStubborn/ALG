package personal.intro.algorithm.sort;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import personal.intro.algorithm.util.Functional;
import personal.intro.algorithm.util.ParamsInvalidException;

import java.util.Arrays;

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
     *
     */
    public static void merge(int[] array, int low, int mid, int high) {
        int[] tmp = new int[high - low + 1];
        int i = low;
        int j = mid + 1;
        int k = 0;
        while (i <= mid && j <= high) {
            if (array[i] < array[j]) {
                tmp[k++] = array[i++];
            } else {
                tmp[k++] = array[j++];
            }
        }
        while (i <= mid) {
            tmp[k++] = array[i++];
        }
        while (j <= high) {
            tmp[k++] = array[j++];
        }
        for (int l = 0; l < k; l++) {
            array[low + l] = tmp[l];
        }
    }

    /**
     * @param array
     * @param low
     * @param high
     */
    public static void mergeSort(int[] array, int low, int high) {
        if (low < high) {
            int mid = (high + low) / 2;
            mergeSort(array, low, mid);
            mergeSort(array, mid + 1, high);
            merge(array, low, mid, high);
        }
    }

    /**
     * @param args
     */
    public static void main(String[] args) throws ParamsInvalidException {
        int[] originArray = Functional.getRandomIntegerArray(10);
        System.out.println("origin array: " + Arrays.toString(originArray));
        mergeSort(originArray, 0, originArray.length - 1);
        System.out.println("sorted array: " + Arrays.toString(originArray));

    }
}
