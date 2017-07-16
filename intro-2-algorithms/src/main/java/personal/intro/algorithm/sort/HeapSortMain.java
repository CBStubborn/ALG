package personal.intro.algorithm.sort;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import personal.intro.algorithm.util.Functional;
import personal.intro.algorithm.util.ParamsInvalidException;

/**
 * Created by Stubborn on 2017/5/23.
 * 堆排序算法实现
 * 堆：是一个数组，可近似理解为一个完全二叉树
 * 最大堆：除了根节点之外，所有节点的值小于或等于其父节点的值
 */
public class HeapSortMain {

    private static final Logger LOG = LoggerFactory.getLogger(HeapSortMain.class);

    /**
     * find a given node's parent node
     *
     * @param index is given node's index
     * @return parent node's index
     */
    public static int findNodeParentIndex(int index) {
        return (index - 1) >> 1;
    }

    /**
     * find a given node's left child node
     *
     * @param index
     * @return left child node's index
     */
    public static int findLeftChildIndex(int index) {
        return (index << 1) + 1;
    }

    /**
     * find a given node's right child node
     *
     * @param index is given node's index
     * @return right child node's index
     */
    public static int findRightChildIndex(int index) {
        return (index << 1) + 2;
    }

    /**
     * build a max heap
     *
     * @param originArray
     */
    public static void buildMaxHeap(int[] originArray) {
        for (int i = (originArray.length / 2 - 1); i >= 0; i--) {
            maxHeapIFY(originArray, i, originArray.length);
        }
    }

    /**
     * maintain heap feature
     *
     * @param originArray
     * @param index
     */
    public static void maxHeapIFY(int[] originArray, int index, int heapSize) {
        int largestIndex;
        int leftChildIndex = findLeftChildIndex(index);
        int rightChildIndex = findRightChildIndex(index);
        if ((leftChildIndex <= (heapSize - 1)) && (originArray[leftChildIndex] > originArray[index])) {
            largestIndex = leftChildIndex;
        } else {
            largestIndex = index;
        }
        if (rightChildIndex <= (heapSize - 1) && (originArray[rightChildIndex] > originArray[largestIndex])) {
            largestIndex = rightChildIndex;
        }
        if (largestIndex != index) {
            //exchange index and largestIndex
            int temp = originArray[index];
            originArray[index] = originArray[largestIndex];
            originArray[largestIndex] = temp;
            maxHeapIFY(originArray, largestIndex, heapSize);
        }
    }

    /**
     * heap sort
     * @param originArray
     */
    public static void heapSort(int[] originArray) {
        for (int i = (originArray.length - 1); i >= 0; i--) {
            int temp = originArray[i];
            originArray[i] = originArray[0];
            originArray[0] = temp;
            maxHeapIFY(originArray, 0, i);
        }
    }

    public static void main(String[] args) throws ParamsInvalidException {
        int[] randomArray = Functional.getRandomIntegerArray(10);
        LOG.info("the random array is: [{}]", Functional.convertArray2String(randomArray));
        buildMaxHeap(randomArray);
        LOG.info("after build max heap, the array is: [{}]", Functional.convertArray2String(randomArray));
        heapSort(randomArray);
        LOG.info("the sorted array is: [{}]", Functional.convertArray2String(randomArray));
    }
}
