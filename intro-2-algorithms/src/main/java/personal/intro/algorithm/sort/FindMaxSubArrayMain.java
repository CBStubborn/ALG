package personal.intro.algorithm.sort;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import personal.intro.algorithm.util.Functional;
import personal.intro.algorithm.util.ParamsInvalidException;

/**
 * Created by Stubborn on 2017/5/23.
 * 查找数组A[low...high]最大子数组A[i...j]算法实现
 * 算法思路：采用分治策略
 * 最大连续子数组A[i....j]必然是一下三种情况之一：
 * 1. 完全位于子数组A[low...mid]中
 * 2. 完全位于子数组A[mid + 1....high]中
 * 3. 跨越了中点mid
 * 1和2是原问题的子问题，因此只需考虑第3种情况：
 * 只需查找两个最大子数组A[i...mid],A[mid + 1...j]即可
 */
public class FindMaxSubArrayMain {

    private static final Logger LOG = LoggerFactory.getLogger(FindMaxSubArrayMain.class);

    /**
     * 查找最大子数组
     *
     * @param originArray
     * @param low
     * @param high
     * @return
     * @throws ParamsInvalidException
     */
    public static int[] findMaxSubArray(int[] originArray, int low, int high) throws ParamsInvalidException {
        if (low == high) {
            return originArray;
        } else {
            int mid = (low + high) / 2;
            int[] leftSubArray = findMaxSubArray(originArray, low, mid);
            int leftSum = Functional.calculateSum(leftSubArray);
            LOG.info("left sub array: [{}] and sum is: {}", Functional.convertArray2String(leftSubArray), leftSum);
            int[] rightSubArray = findMaxSubArray(originArray, mid + 1, high);
            int rightSum = Functional.calculateSum(rightSubArray);
            LOG.info("right sub array: [{}] and sum is: {}", Functional.convertArray2String(rightSubArray), rightSum);
            int[] crossingSubArray = findMaxCrossingMidSubArray(originArray, low, mid, high);
            int crossingSum = Functional.calculateSum(crossingSubArray);
            LOG.info("crossing sub array: [{}] and sum is: {}", Functional.convertArray2String(crossingSubArray), crossingSum);
            if (leftSum >= rightSum && leftSum >= crossingSum) {
                return leftSubArray;
            } else if (rightSum >= leftSum && rightSum >= crossingSum) {
                return rightSubArray;
            } else {
                return crossingSubArray;
            }
        }
    }

    /**
     * 查找跨越“中点”的最大子数组
     *
     * @param origin
     * @param low
     * @param mid
     * @param high
     * @return
     * @throws ParamsInvalidException
     */
    public static int[] findMaxCrossingMidSubArray(int[] origin, int low, int mid, int high) throws ParamsInvalidException {
        int leftSum = Integer.MIN_VALUE;
        int rightSum = Integer.MIN_VALUE;
        int maxLeft = Integer.MIN_VALUE;
        int maxRight = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = mid; i >= low; i--) {
            sum += origin[i];
            if (sum > leftSum) {
                leftSum = sum;
                maxLeft = i;
            }
        }
        sum = 0;
        for (int j = mid + 1; j <= high; j++) {
            sum += origin[j];
            if (sum > rightSum) {
                rightSum = sum;
                maxRight = j;
            }
        }
        return Functional.getSubArray(origin, maxLeft, maxRight);
    }

    public static void main(String[] args) throws ParamsInvalidException {
        int[] randomArray = Functional.getRandomIntegerArray(20, -10, 20);
        LOG.info("the origin random array is: [{}]", Functional.convertArray2String(randomArray));
        int[] maxSubArray = findMaxSubArray(randomArray, 0, randomArray.length - 1);
        int maxSum = Functional.calculateSum(maxSubArray);
        LOG.info("the max sub array is: [{}] and sum is: {}", Functional.convertArray2String(maxSubArray), maxSum);
    }
}
