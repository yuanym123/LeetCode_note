/**
 * @author yym
 * @date 2020/09/29
 * @title 21.合并两个有序链表：将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的
 * @complexity 时间复杂度O(m+n)，空间复杂度O(1)
 * @key 两个链表，有序，遍历合并
 */
public class mergeTwoSortedLists_easy {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode lr = new ListNode(0);
        ListNode res = lr;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                lr.next = l1;
                l1 = l1.next;
                lr = lr.next;
            } else {
                lr.next = l2;
                l2 = l2.next;
                lr = lr.next;
            }
        }
        if (l1 != null) {
            lr.next = l1;
        }
        if (l2 != null) {
            lr.next = l2;
        }
        return res.next;
    }
}
