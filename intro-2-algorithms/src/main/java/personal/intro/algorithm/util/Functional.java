package personal.intro.algorithm.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Random;

/**
 * Created by Stubborn on 2017/5/22.
 * 功能类，用于生成随机数
 */
public class Functional {

    private static final Logger LOG = LoggerFactory.getLogger(Functional.class);

    /**
     * get a random integer value under a given value(default is 100)
     *
     * @return
     */
    public static int getRandomIntegerValue() {
        return getRandomIntegerValue(100);
    }

    /**
     * get random integer value under a given value
     *
     * @param upperValue
     * @return
     */
    public static int getRandomIntegerValue(int upperValue) {
        Random random = new Random();
        return random.nextInt(upperValue);
    }

    /**
     * get a random int array
     *
     * @return
     */
    public static int[] getRandomIntegerArray() throws ParamsInvalidException {
        return getRandomIntegerArray(10);
    }

    /**
     * get a random int array with a given size
     *
     * @param size array size
     * @return
     */
    public static int[] getRandomIntegerArray(int size) throws ParamsInvalidException {
        if (size <= 0) {
            throw new ParamsInvalidException("array size must be larger than zero");
        }
        return getRandomIntegerArray(size, 0, size + 100);
    }

    /**
     * get a random int array between left and right
     *
     * @param size  array size
     * @param left  array element's min value(inclusive)
     * @param right array element's max value(exclusive)
     * @return
     */
    public static int[] getRandomIntegerArray(int size, int left, int right) throws ParamsInvalidException {
        if (size <= 0) {
            throw new ParamsInvalidException("array size must be larger than zero");
        }
        if (left > right) {
            throw new ParamsInvalidException("left must be lower than right");
        }
        int[] array = new int[size];
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            int gen = random.nextInt(right);
            if (gen < left) {
                array[i] = gen + left;
            } else {
                array[i] = gen;
            }
        }
        return array;
    }

    /**
     * convert an array to string
     *
     * @param array
     * @return a string
     */
    public static String convertArray2String(int[] array) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < array.length; i++) {
            builder.append(array[i]);
            if (i < array.length - 1) {
                builder.append(", ");
            }
        }
        return builder.toString();
    }

    /**
     * calculate an array's sum
     *
     * @param array
     * @return array's sum
     */
    public static int calculateSum(int[] array) {
        int sum = 0;
        for (int element : array) {
            sum += element;
        }
        return sum;
    }

    /**
     * get an array's sub array
     *
     * @param array
     * @param left  (include)
     * @param right (include)
     * @return
     */
    public static int[] getSubArray(int[] array, int left, int right) throws ParamsInvalidException {
        if (left > right) {
            throw new ParamsInvalidException("left must be lower than right");
        }
        int[] subArray = new int[right - left + 1];
        for (int i = 0; i < subArray.length; i++) {
            subArray[i] = array[left + i];
        }
        return subArray;
    }

    /**
     * main enter
     *
     * @param args
     */
    public static void main(String[] args) throws ParamsInvalidException {
        LOG.info("a random value is: " + getRandomIntegerValue());
        int[] array = getRandomIntegerArray();
        LOG.info("the array is: [{}]", convertArray2String(array));
        int[] subArray = getSubArray(array, 2, 7);
        LOG.info("sub array is: [{}]", convertArray2String(subArray));
        int[] array_0 = getRandomIntegerArray(10, 0, 1);
        System.out.println(convertArray2String(array_0));
    }
}
