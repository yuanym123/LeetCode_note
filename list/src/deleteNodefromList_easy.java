/**
 * @author yym
 * @date 2020/09/29
 * @title 237.删除链表中的节点：请编写一个函数，使其可以删除某个链表中给定的（非末尾）节点。传入函数的唯一参数为 要被删除的
 *                             节点 。
 * @complexity 时间复杂度O(1)，空间复杂度O(1)
 * @key 1链表，特例
 */
public class deleteNodefromList_easy {
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
