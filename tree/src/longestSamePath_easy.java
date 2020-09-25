/**
 * @author yym
 * @date 2020/09/25
 * @title 687.最长同值路径：给定一个二叉树，找到最长的路径，这个路径中的每个节点具有相同值。 这条路径可以经过也可以不经过根
 *                         节点。注意：两个节点之间的路径长度由它们之间的边数表示。
 * @complexity 时间复杂度O(n)，空间复杂度O(n)
 */
public class longestSamePath_easy {
    int max = 0;
    public int longestUnivaluePath(TreeNode root) {
        if (root == null) {
            return 0;
        }
        postOrder(root);
        return max;
    }
    public int postOrder(TreeNode t) {
        if (t == null) {
            return 0;
        }
        int left = postOrder(t.left);
        int right = postOrder(t.right);
        int tl = 0;
        int tr = 0;
        if (t.left != null && t.left.val == t.val) {
            tl = left + 1;
        }
        if (t.right != null && t.right.val == t.val) {
            tr = right + 1;
        }
        max = Math.max(max, tl + tr);
        return Math.max(tl, tr);
    }
}
