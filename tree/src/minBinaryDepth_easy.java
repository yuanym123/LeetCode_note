/**
 * @author yym
 * @date 2020/09/23
 * @title 111.二叉树的最小深度：给定一个二叉树，找出其最小深度。最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
 *                             说明: 叶子节点是指没有子节点的节点。
 * @complexity 时间复杂度O(n)，空间复杂度O(n)
 * @key 1二叉树，先序遍历
 */
public class minBinaryDepth_easy {
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        if (root.left == null) {
            return 1 + minDepth(root.right);
        }
        if (root.right == null) {
            return 1 + minDepth(root.left);
        }
        return 1 + Math.min(minDepth(root.left), minDepth(root.right));
    }
}
