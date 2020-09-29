import java.util.Stack;

/**
 * @author yym
 * @date 2020/09/29
 * @title 剑指06.从尾到头打印链表：输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
 * @complexity 时间复杂度O(n)，空间复杂度O(n)
 * @key 1链表，顺序遍历
 */
public class printListfromEnd2Start {
    public int[] reversePrint(ListNode head) {
        if (head == null) {
            return new int[0];
        }
        Stack<Integer> s = new Stack<>();
        int count = 0;
        while (head != null) {
            s.push(head.val);
            head = head.next;
            count++;
        }
        int[] result = new int[count];
        count = 0;
        while (!s.isEmpty()) {
            result[count++] = s.pop();
        }
        return result;
    }
}
