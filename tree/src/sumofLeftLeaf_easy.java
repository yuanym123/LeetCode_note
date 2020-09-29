/**
 * @author yym
 * @date 2020/09/24
 * @title 404.左叶子之和：计算给定二叉树的所有左叶子之和。
 * @complexity 时间复杂度O(n)，空间复杂度O(h)
 * @key 1二叉树，先序遍历
 */
public class sumofLeftLeaf_easy {
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int result = 0;
        if (root.left != null && root.left.left == null && root.left.right == null) {
            result += root.left.val;
        }
        result += sumOfLeftLeaves(root.left);
        result += sumOfLeftLeaves(root.right);
        return result;
    }
}
