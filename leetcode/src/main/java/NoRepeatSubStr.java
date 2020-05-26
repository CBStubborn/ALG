import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 * <p>
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 * <p>
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 */

public class NoRepeatSubStr {

    /**
     * force method
     *
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring(String s) {
        if (s.length() <= 1) {
            return s.length();
        }
        int max = 1;
        for (int i = 0; i < s.length(); i++) {
            List<Character> sub = new ArrayList<>();
            sub.add(s.charAt(i));
            for (int j = i + 1; j < s.length(); j++) {
                if (!sub.contains(s.charAt(j))) {
                    sub.add(s.charAt(j));
                } else {
                    break;
                }
            }
            if (max < sub.size()) {
                max = sub.size();
            }
        }
        return max;
    }

    /**
     * 滑窗
     *
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring_1(String s) {
        int max = 0;
        List<Character> sub = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            while (sub.contains(s.charAt(i))) {
                sub.remove(0);
            }
            sub.add(s.charAt(i));
            if (max < sub.size()) {
                max = sub.size();
            }
        }
        return max;
    }


    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("pwwkew"));
    }
}
