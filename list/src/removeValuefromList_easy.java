/**
 * @author yym
 * @date 2020/09/29
 * @title 203.移除链表元素：删除链表中等于给定值 val 的所有节点。
 * @complexity 时间复杂度O(n)，空间复杂度O(1)
 * @key 1链表，顺序遍历
 */
public class removeValuefromList_easy {
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return head;
        }
        ListNode res = new ListNode(0);
        res.next = head;
        ListNode cur = res;
        while (cur != null) {
            while (cur.next != null && cur.next.val == val) {
                cur.next = cur.next.next;
            }
            cur = cur.next;
        }
        return res.next;
    }
}
