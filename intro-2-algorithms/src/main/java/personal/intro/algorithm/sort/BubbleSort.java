package personal.intro.algorithm.sort;

import personal.intro.algorithm.util.Functional;
import personal.intro.algorithm.util.ParamsInvalidException;

import java.util.Arrays;

/**
 * 冒泡排序算法实现
 * Created by Stubborn on 2017/10/25.
 */
public class BubbleSort {

    public static void sort(int[] array) {
        for (int i = 0; i < array.length; ++i) {
            for (int j = 0; j < array.length - i - 1; ++j) {
                if (array[j] > array[j + 1]) {
                    int tmp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = tmp;
                }
            }
            System.out.println("after " + i + "th sort, now array is: " + Arrays.toString(array));
        }
    }

    public static void main(String[] args) throws ParamsInvalidException {
        int[] originArray = Functional.getRandomIntegerArray();
        System.out.println("origin array: " + Arrays.toString(originArray));
        sort(originArray);
        System.out.println("sorted array: " + Arrays.toString(originArray));
    }
}
