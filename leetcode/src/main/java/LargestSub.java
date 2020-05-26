import com.sun.tools.javac.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 * <p>
 * 示例 1：
 * <p>
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 * 示例 2：
 * <p>
 * 输入: "cbbd"
 * 输出: "bb"
 */

public class LargestSub {

    /**
     * 思路：将输入反转，然后找两个字符串的最长公共子串即可。
     *
     * @param s
     * @return
     */
    public static String longestPalindrome(String s) {
        int length = s.length();
        if (length == 1) {
            return s;
        }
        String result = "";
        String revert = new StringBuffer(s).reverse().toString();
        for (int i = 1; i < 2 * length; i++) {
            String str_1;
            String str_2;
            if (i < length) {
                str_1 = s.substring(0, i);
                str_2 = revert.substring(length - i, length);
            } else {
                int index = i - length;
                str_1 = s.substring(index, length);
                str_2 = revert.substring(0, length - index);
            }

            int m = 0;
            int n = 0;
            for (int j = 0; j < str_1.length(); j ++) {
                if (str_1.charAt(j) == str_2.charAt(j) && m == 0) {
                    m = j;
                } else {
                    if (n == 0 || m > n) {
                        n = j;
                    }
                }
                if (n >= m) {
                    String str = str_1.substring(m, n);
                    if (str.length() > result.trim().length()) {
                        result = str;
                    }
                }

            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println("result: " + longestPalindrome("abcda"));
    }

}
