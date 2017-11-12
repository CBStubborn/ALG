package personal.intro.algorithm.sort;

import personal.intro.algorithm.util.Functional;
import personal.intro.algorithm.util.ParamsInvalidException;

import java.util.Arrays;

/**
 * Created by Stubborn on 2017/7/12.
 * 希尔排序算法实现
 */
public class ShellSortMain {

    /**
     * 算法实现
     *
     * @param array 欲排序数组
     */
    public static void shellSort(int[] array) {
        int length = array.length;
        for (int step = length / 2; step > 0; step = step / 2) {
            for (int i = 0; i < step; i++) {
                for (int j = i + step; j < length; j += step) {
                    if (array[j] < array[j - step]) {
                        int temp = array[j];
                        int k = j - step;
                        while (k >= 0 && array[k] > temp) {
                            array[k + step] = array[k];
                            k -= step;
                        }
                        array[k + step] = temp;
                    }
                }
            }
        }
    }

    /**
     * 主入口
     *
     * @param args
     * @throws ParamsInvalidException
     */
    public static void main(String[] args) throws ParamsInvalidException {
        int[] originArray = Functional.getRandomIntegerArray(11);
        System.out.println("Origin array: " + Arrays.toString(originArray));
        shellSort(originArray);
        System.out.println("Sorted array: " + Arrays.toString(originArray));

    }

}
