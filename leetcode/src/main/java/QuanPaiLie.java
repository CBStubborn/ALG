import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个 没有重复 数字的序列，返回其所有可能的全排列。
 * <p>
 * 示例:
 * <p>
 * 输入: [1,2,3]
 * 输出:
 * [
 * [1,2,3],
 * [1,3,2],
 * [2,1,3],
 * [2,3,1],
 * [3,1,2],
 * [3,2,1]
 * ]
 */

public class QuanPaiLie {

    List<List<Integer>> result = new ArrayList<>();

    public void generate(List<Integer> cur, int[] numbers, int index) {
        if (index == numbers.length) {
            result.add(cur);
        } else {
            int size = cur.size();
            int newIndex = index + 1;
            for (int i = 0; i <= size; i++) {
                List<Integer> tmp = new ArrayList<>(cur);
                tmp.add(i, numbers[index]);
                generate(tmp, numbers, newIndex);
            }
        }

    }

    public List<List<Integer>> permute(int[] nums) {
        if (nums.length == 0) {
            return null;
        }
        generate(new ArrayList<Integer>(), nums, 0);
        return result;

    }


    public static void main(String[] args) {

    }


}
