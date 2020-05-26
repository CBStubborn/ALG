import org.w3c.dom.ls.LSOutput;

/**
 * 给定两个大小为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。
 * <p>
 * 请你找出这两个正序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
 * <p>
 * 你可以假设 nums1 和 nums2 不会同时为空。
 * <p>
 *  
 * <p>
 * 示例 1:
 * <p>
 * nums1 = [1, 3]
 * nums2 = [2]
 * <p>
 * 则中位数是 2.0
 * 示例 2:
 * <p>
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 * <p>
 * 则中位数是 (2 + 3)/2 = 2.5
 */

public class MediumNumber {

    /**
     * 归并排序
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] mergeSort = new int[nums1.length + nums2.length];
        int i = 0;
        int j = 0;
        int index = 0;
        for (; i < nums1.length; ) {
            if (j < nums2.length) {
                if (nums1[i] <= nums2[j]) {
                    mergeSort[index] = nums1[i];
                    index++;
                    i++;
                } else {
                    mergeSort[index] = nums2[j];
                    j++;
                    index++;
                }
            } else {
                mergeSort[index] = nums1[i];
                index++;
                i++;
            }
        }
        for (; j < nums2.length; j++) {
            mergeSort[index] = nums2[j];
            index++;
        }


        int mid = mergeSort.length / 2;
        if (mergeSort.length % 2 == 0) {
            return (double) (mergeSort[mid] + mergeSort[mid - 1]) / 2.0;
        } else {
            return (double) mergeSort[mid];
        }
    }

    public static void main(String[] args) {
        System.out.println(findMedianSortedArrays(new int[]{1, 2}, new int[]{3, 4}));
    }
}
