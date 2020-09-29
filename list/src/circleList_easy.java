/**
 * @author yym
 * @date 2020/09/29
 * @title 141.环形链表：给定一个链表，判断链表中是否有环。如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表
 *                     中存在环。 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）
 *                     。 如果 pos 是 -1，则在该链表中没有环。注意：pos 不作为参数进行传递，仅仅是为了标识链表的实际情况。
 *                     如果链表中存在环，则返回 true 。 否则，返回 false 。
 * @complexity 时间复杂度O(n)，空间复杂度O(1)
 * @key 1链表，环形判断，快慢指针
 */
public class circleList_easy {
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode low = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            low = low.next;
            fast = fast.next.next;
            if (low == fast) {
                break;
            }
        }
        if (fast == null || fast.next == null) {
            return false;
        }
        return true;
    }
}
