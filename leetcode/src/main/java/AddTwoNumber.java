import java.util.List;

/**
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 * <p>
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 * <p>
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * <p>
 * 示例：
 * <p>
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 */

public class AddTwoNumber {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode listNode = new ListNode(0);
        ListNode cur = listNode;
        int carry = 0;
        while (null != l1 || null != l2) {
            int i = null != l1 ? l1.val : 0;
            int j = null != l2 ? l2.val : 0;
            int sum = (i + j + carry) % 10;
            cur.next = new ListNode(sum);
            cur = cur.next;
            carry = (i + j + carry) / 10;
            l1 = null != l1 ? l1.next : null;
            l2 = null != l2 ? l2.next : null;
        }
        if (1 == carry) {
            cur.next = new ListNode(1);
        }
        return listNode.next;
    }

    class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }

}
