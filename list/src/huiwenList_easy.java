/**
 * @author yym
 * @date 2020/09/29
 * @title 234.回文链表：请判断一个链表是否为回文链表。
 * @complexity 时间复杂度O(n)，空间复杂度O(1)
 * @key 1链表，顺序遍历，反转一半
 */
public class huiwenList_easy {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        int count = 0;
        ListNode cur = head;
        while (cur != null) {
            count++;
            cur = cur.next;
        }
        int flag = 1;
        if (count % 2 == 0) {
            flag = 0;
        }
        count = count / 2;
        ListNode pre = head;
        cur = head.next;
        ListNode post = cur.next;
        while (count > 1) {
            post = cur.next;
            cur.next = pre;
            pre = cur;
            cur = post;
            count--;
        }
        head.next = null;
        if (flag == 1) {
            cur = cur.next;
        }
        while (cur != null && pre != null) {
            if (cur.val != pre.val) {
                return false;
            }
            cur = cur.next;
            pre = pre.next;
        }
        return true;
    }
}
