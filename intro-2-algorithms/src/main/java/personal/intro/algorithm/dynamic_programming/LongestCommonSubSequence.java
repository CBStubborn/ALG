package personal.intro.algorithm.dynamic_programming;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import personal.intro.algorithm.util.Functional;
import personal.intro.algorithm.util.ParamsInvalidException;

/**
 * Created by Stubborn on 2017/7/11.
 * 最长公共子串算法实现：
 * c[i,j]表示 Xi 和 Yj 的LCS长度
 * 最长公共子序列最优子结构性质：
 * if i=0 or j=0
 * c[i,j]=0
 * else if i,j>0 and xi=yj
 * c[i,j]=c[i-1, j-1] + 1
 * else if i,j>0 and xi != yj
 * c[i,j]=max(c[i-1, j], c[i, j-1])
 */
public class LongestCommonSubSequence {

    private static final Logger LOG = LoggerFactory.getLogger(LongestCommonSubSequence.class);

    /**
     * @param x an int array
     * @param y another int array
     */
    private static void getLCS(int[] x, int[] y) {
        int m = x.length;
        int n = y.length;
        int[][] result = new int[m + 1][n + 1];
        int[][] direction = new int[m][n];  //用于存储移动方向，0表示斜向上，
        // 1表示横向移动，-1表示向上移动
        for (int i = 0; i < m + 1; i++) {
            result[i][0] = 0;
        }
        for (int i = 0; i < n + 1; i++) {
            result[0][i] = 0;
        }
        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if (x[i - 1] == y[j - 1]) {
                    result[i][j] = result[i - 1][j - 1] + 1;
                    direction[i - 1][j - 1] = 0;
                } else if (result[i][j - 1] >= result[i - 1][j]) {
                    result[i][j] = result[i][j - 1];
                    direction[i - 1][j - 1] = 1;
                } else {
                    result[i][j] = result[i - 1][j];
                    direction[i - 1][j - 1] = -1;
                }
            }
        }
        LOG.info("The longest common sub-sequence length is: {}", result[m][n]);
        printLCS(direction, x, m, n);
    }

    /**
     * 打印出最长公共子序列
     *
     * @param direction:value is -1, 0 or 1
     * @param x an int array
     * @param length1
     * @param length2
     */
    private static void printLCS(int[][] direction, int[] x, int length1, int length2) {
        if (length1 == 0 || length2 == 0) {
            return;
        }
        if (direction[length1 - 1][length2 - 1] == 0) {
            printLCS(direction, x, length1 - 1, length2 - 1);
            System.out.print(x[length1 - 1] + ",");
        } else if (direction[length1 - 1][length2 - 1] == -1) {
            printLCS(direction, x, length1 - 1, length2);
        } else {
            printLCS(direction, x, length1, length2 - 1);
        }
    }

    public static void main(String[] args) throws ParamsInvalidException {
        int[] random1 = Functional.getRandomIntegerArray(10, 1, 10);
        LOG.info("random 1 is: {}", Functional.convertArray2String(random1));
        int[] random2 = Functional.getRandomIntegerArray(15, 1, 10);
        LOG.info("random 2 is: {}", Functional.convertArray2String(random2));
        getLCS(random1, random2);
    }
}


