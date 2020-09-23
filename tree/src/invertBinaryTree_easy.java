/**
 * @author yym
 * @date 2020/09/23
 * @title 226.翻转二叉树：翻转一棵二叉树。
 * @complexity 时间复杂度O(n)，空间复杂度O(n)
 */
public class invertBinaryTree_easy {
    public TreeNode invertTree(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) {
            return root;
        }
        TreeNode tmp = root.left;
        root.left = invertTree(root.right);
        root.right = invertTree(tmp);
        return root;
    }
}
