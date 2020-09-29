/**
 * @author yym
 * @date 2020/09/23
 * @title 110.平衡二叉树：给定一个二叉树，判断它是否是高度平衡的二叉树。
 * @complexity 时间复杂度O(n)，空间复杂度O(n)
 * @key 1平衡二叉树，全局变量+深度求解，先序遍历
 */
public class balancedBinaryTree_easy {
    boolean flag = true;
    public boolean isBalanced(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) {
            return flag;
        }
        depth(root);
        return flag;
    }
    public int depth(TreeNode t) {
        if (t == null) {
            return 0;
        }
        int left = depth(t.left);
        int right = depth(t.right);
        if (Math.abs(left - right) > 1) {
            flag = false;
        }
        return 1 + Math.max(left, right);
    }
}
