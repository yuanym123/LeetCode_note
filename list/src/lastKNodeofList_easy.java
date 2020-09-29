/**
 * @author yym
 * @date 2020/09/29
 * @title 剑指22.链表中倒数第k个节点：
 * @complexity 时间复杂度O(n)，空间复杂度O(1)
 * @key 1链表，双指针
 */
public class lastKNodeofList_easy {
    public ListNode getKthFromEnd(ListNode head, int k) {
        if (head == null || k < 1) {
            return null;
        }
        ListNode end = head;
        while (k > 0) {
            end = end.next;
            k--;
        }
        while (end != null) {
            head = head.next;
            end = end.next;
        }
        return head;
    }
}
