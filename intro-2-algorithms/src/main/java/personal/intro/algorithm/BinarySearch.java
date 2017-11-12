package personal.intro.algorithm;

import personal.intro.algorithm.util.Functional;
import personal.intro.algorithm.util.ParamsInvalidException;

import java.util.Arrays;

/**
 * 二分查找算法实现
 * Created by Stubborn on 2017/10/25.
 */
public class BinarySearch {

    public static int binarySearch(int[] array, int element) {
        int low = 0;
        int high = array.length - 1;
        int mid;
        while (low <= high) {
            mid = (low + high) / 2;
            if (array[mid] < element) {
                low = mid + 1;
            } else if (array[mid] > element) {
                high = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    public static void main(String[] args) throws ParamsInvalidException {
        int[] originArray = Functional.getRandomIntegerArray();
        System.out.println("origin array is: " + Arrays.toString(originArray));
        System.out.println("index is: " + binarySearch(originArray, originArray[6]));
    }
}
