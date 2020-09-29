/**
 * @author yym
 * @date 2020/09/29
 * @title 206.反转链表：反转一个单链表。
 * @complexity 时间复杂度O(n)，空间复杂度O(1)
 * @key 1链表，顺序遍历，指针处理
 */
public class reverseList_easy {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        if (head.next.next == null) {
            ListNode res = head.next;
            res.next = head;
            head.next = null;
            return res;
        }
        ListNode cur = head.next;
        ListNode pre = head;
        ListNode post = cur.next;
        while (cur.next != null) {
            post = cur.next;
            cur.next = pre;
            pre = cur;
            cur = post;
        }
        cur.next = pre;
        head.next = null;
        return cur;
    }
}
