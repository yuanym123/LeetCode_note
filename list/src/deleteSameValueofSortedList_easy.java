/**
 * @author yym
 * @date 2020/09/29
 * @title 83.删除排序链表中的重复元素：给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。
 * @complexity 时间复杂度O(n)，空间复杂度O(1)
 * @key 1链表，有序，顺序遍历
 */
public class deleteSameValueofSortedList_easy {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode cur = new ListNode(0);
        cur.next = head;
        ListNode res = cur;
        while (cur != null) {
            while (cur.next != null && cur.next.next != null && cur.next.val == cur.next.next.val) {
                cur.next = cur.next.next;
            }
            if (cur.next.next == null) {
                break;
            }
            cur = cur.next;
        }
        return res.next;
    }
}
