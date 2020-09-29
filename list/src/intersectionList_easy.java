/**
 * @author yym
 * @date 2020/09/29
 * @title 160.相交链表：编写一个程序，找到两个单链表相交的起始节点。
 * @complexity 时间复杂度O(m+n)，空间复杂度O(1)
 * @key 2链表，顺序遍历查找
 */
public class intersectionList_easy {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode ha = headA;
        ListNode hb = headB;
        int counta = 0;
        int countb = 0;
        while (ha != null) {
            counta++;
            ha = ha.next;
        }
        while (hb != null) {
            countb++;
            hb = hb.next;
        }
        ha = headA;
        hb = headB;
        while (counta > countb) {
            ha = ha.next;
            counta--;
        }
        while (countb > counta) {
            hb = hb.next;
            countb--;
        }
        while (ha != null && hb != null && ha != hb) {
            ha = ha.next;
            hb = hb.next;
        }
        return ha;
    }
}
