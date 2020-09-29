/**
 * @author yym
 * @date 2020/09/28
 * @title 面试题17.12.BiNode：二叉树数据结构TreeNode可用来表示单向链表（其中left置空，right为下一个链表节点）。实现一个方
 *                            法，把二叉搜索树转换为单向链表，要求依然符合二叉搜索树的性质，转换操作应是原址的，也就是在原
 *                            始的二叉搜索树上直接修改。返回转换后的单向链表的头节点。
 * @complexity 时间复杂度O(n)，空间复杂度O(n)
 * @key 1二叉树，中序遍历
 */
public class tree2list_easy {
    TreeNode pre = null;
    TreeNode head = new TreeNode(-1);
    public TreeNode convertBiNode(TreeNode root) {
        if (root == null) {
            return null;
        }
        inOrder(root);
        return head.right;
    }
    public void inOrder(TreeNode t) {
        if (t == null) {
            return;
        }
        inOrder(t.left);
        if (pre == null) {
            pre = t;
            head.right = t;
        } else {
            pre.right = t;
            pre = t;
        }
        t.left = null;
        inOrder(t.right);
    }
}
