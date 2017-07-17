package personal.intro.algorithm.sort;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import personal.intro.algorithm.util.Functional;
import personal.intro.algorithm.util.ParamsInvalidException;

/**
 * Created by Stubborn on 2017/7/17.
 * 使用大堆实现最大优先队列
 */
public class ConstructPriorityQueueByHeap {

    private static final Logger LOG = LoggerFactory.getLogger(ConstructPriorityQueueByHeap.class);

    /**
     * 获取优先队列最大值
     *
     * @param heapArray an heap array
     * @return max object
     */
    public static int getMax(int[] heapArray) {
        return heapArray[0];
    }

    /**
     * 获取并删除优先队列最大值
     *
     * @param heapArray an heap array
     * @param heapSize
     * @return max object
     * @throws ParamsInvalidException
     */
    public static int[] extractMax(int[] heapArray, int heapSize) throws ParamsInvalidException {
        if (heapSize < 1) {
            throw new ParamsInvalidException("heap underflow");
        }
        int max = heapArray[0];
        LOG.info("max value is: {}", max);
        heapArray[0] = heapArray[heapSize];
        int[] tmpArray = new int[heapSize];
        for (int i = 0; i < heapSize; i++) {
            tmpArray[i] = heapArray[i];
        }
        HeapSortMain.maxHeapIFY(tmpArray, 0, heapSize - 1);
        return tmpArray;
    }

    /**
     * 增加某一元素值
     *
     * @param heapArray an heap array
     * @param index
     * @param value
     */
    public static void increase(int[] heapArray, int index, int value) {
        if (value < heapArray[index]) {
            LOG.warn("new value is smaller than current value");
            return;
        } else {
            heapArray[index] = value;
            int parent = HeapSortMain.findNodeParentIndex(index);
            while (index > 0 && heapArray[parent] < heapArray[index]) {
                int tmp = heapArray[index];
                heapArray[index] = heapArray[parent];
                heapArray[parent] = tmp;
                index = HeapSortMain.findNodeParentIndex(index);
                parent = HeapSortMain.findNodeParentIndex(index);
            }
        }
    }

    /**
     * 插入一个元素
     *
     * @param heapArray an heap array
     * @param value
     * @param heapSize
     */
    public static int[] insert(int[] heapArray, int value, int heapSize) {
        heapSize += 1;
        int[] newArray = new int[heapSize + 1];
        for (int i = 0; i < heapSize - 1; i++) {
            newArray[i] = heapArray[i];
        }
        newArray[heapSize] = Integer.MIN_VALUE;
        increase(newArray, heapSize, value);
        return newArray;
    }

    public static void main(String[] args) throws ParamsInvalidException {
        int[] random = Functional.getRandomIntegerArray(10, 0, 10);
        LOG.info("random array is: {}", Functional.convertArray2String(random));
        HeapSortMain.buildMaxHeap(random);
        LOG.info("heap array is: {}", Functional.convertArray2String(random));
        int[] newArray = extractMax(random, random.length - 1);
        LOG.info("after extract this value the heap array is: {}", Functional.convertArray2String(newArray));
        increase(newArray, 5, 6);
        LOG.info("after do increase, heap array is: {}", Functional.convertArray2String(newArray));
        int[] insertArray = insert(newArray, 8, newArray.length - 1);
        LOG.info("after do insert, heap array is: {}", Functional.convertArray2String(insertArray));
    }

}
