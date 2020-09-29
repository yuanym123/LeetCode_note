/**
 * @author yym
 * @date 2020/09/29
 * @title 1290.二进制链表转整数：给你一个单链表的引用结点 head。链表中每个结点的值不是 0 就是 1。已知此链表是一个整数数字的
 *                              二进制表示形式。请你返回该链表所表示数字的 十进制值 。
 * @complexity 时间复杂度O(n)，空间复杂度O(1)
 * @key 1链表，顺序遍历
 */
public class bit2Int_easy {
    public int getDecimalValue(ListNode head) {
        if (head == null) {
            return 0;
        }
        int result = 0;
        while (head != null) {
            result = result * 2 + head.val;
            head = head.next;
        }
        return result;
    }
}
