/**
 * @author yym
 * @date 2020/09/29
 * @title 876.链表的中间节点：给定一个带有头结点 head 的非空单链表，返回链表的中间结点。如果有两个中间结点，则返回第二个中
 *                           间结点。
 * @complexity 时间复杂度O(n)，空间复杂度O(1)
 * @key 1链表，快慢指针
 */
public class middleNodeofList_easy {
    public ListNode middleNode(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode low = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            low = low.next;
            fast = fast.next.next;
        }
        return low;
    }
}
