import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
 * <p>
 * 示例:
 * <p>
 * 输入: ["eat", "tea", "tan", "ate", "nat", "bat"]
 * 输出:
 * [
 * ["ate","eat","tea"],
 * ["nat","tan"],
 * ["bat"]
 * ]
 * 说明：
 * <p>
 * 所有输入均为小写字母。
 * 不考虑答案输出的顺序。
 */

public class CharacterSort {

    // 使用质数（素数），注意不能使用1，另外，构造质数的时候，需要注意不能取错了
    Map<String, Integer> characterMap = new HashMap<String, Integer>() {{
        put("a", 97);
        put("b", 2);
        put("c", 3);
        put("d", 5);
        put("e", 7);
        put("f", 11);
        put("g", 13);
        put("h", 17);
        put("i", 19);
        put("j", 23);
        put("k", 29);
        put("l", 31);
        put("m", 37);
        put("n", 41);
        put("o", 43);
        put("p", 47);
        put("q", 51);
        put("r", 53);
        put("s", 89);
        put("t", 59);
        put("u", 61);
        put("v", 67);
        put("w", 71);
        put("x", 73);
        put("y", 79);
        put("z", 83);
    }};


    public List<List<String>> groupAnagrams(String[] strs) {
        Map<Long, List<String>> result = new HashMap<>();
        for (String str : strs) {
            long value = 1;
            for (int i = 0; i < str.length(); i++) {
                value = value * characterMap.get(str.substring(i, i + 1));
            }
            List<String> list = result.get(value);
            if (null == list) {
                list = new ArrayList<>();
                result.put(value, list);
            }
            list.add(str);
        }

        return new ArrayList<>(result.values());
    }

}
