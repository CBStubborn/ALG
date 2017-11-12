package personal.intro.algorithm.sort;

import personal.intro.algorithm.util.Functional;
import personal.intro.algorithm.util.ParamsInvalidException;

import java.util.Arrays;

/**
 * 选择排序算法实现
 * Created by Stubborn on 2017/10/25.
 */
public class SelectionSort {

    public static void sort(int[] array) {
        for (int i = 0; i < array.length; ++i) {
            int maxIndex = 0;
            for (int j = 0; j < array.length - i; ++j) {
                if (array[j] >= array[maxIndex]) {
                    maxIndex = j;
                }
            }
            int tmp = array[array.length - i - 1];
            array[array.length - i - 1] = array[maxIndex];
            array[maxIndex] = tmp;
            System.out.println("after " + i + "th sort, now array is: " + Arrays.toString(array));
        }
    }

    public static void main(String[] args) throws ParamsInvalidException {
        int[] originArray = Functional.getRandomIntegerArray();
        System.out.println("origin array is: " + Arrays.toString(originArray));
        sort(originArray);
        System.out.println("sorted array is: " + Arrays.toString(originArray));
    }
}
