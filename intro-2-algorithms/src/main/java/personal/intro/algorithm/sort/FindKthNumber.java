package personal.intro.algorithm.sort;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by Stubborn on 2017/8/11.
 */
public class FindKthNumber {

    private static final Logger LOG = LoggerFactory.getLogger(FindKthNumber.class);

    private static int findKthNumber(int k, int[] origin) {
        int splitPosition = QuickSortMain.partition(origin, 0, origin.length - 1);
        return 0;
    }
}
