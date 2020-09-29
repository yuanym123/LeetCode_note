/**
 * @author yym
 * @date 2020/09/28
 * @title 965.单值二叉树：如果二叉树每个节点都具有相同的值，那么该二叉树就是单值二叉树。只有给定的树是单值二叉树时，才返回
 *                        true；否则返回 false。
 *                        提示：给定树的节点数范围是 [1, 100]。每个节点的值都是整数，范围为 [0, 99] 。
 * @complexity 时间复杂度O(n)，空间复杂度O(n)
 * @key 1二叉树，先序遍历
 */
public class singleValueBinaryTree_easy {
    boolean flag = true;
    public boolean isUnivalTree(TreeNode root) {
        if (root == null) {
            return flag;
        }
        int value = root.val;
        preOrder(root, value);
        return flag;
    }
    public void preOrder(TreeNode t, int v) {
        if (t == null) {
            return;
        }
        if (t.val != v) {
            flag = false;
            return;
        }
        preOrder(t.left, v);
        preOrder(t.right, v);
    }
}
