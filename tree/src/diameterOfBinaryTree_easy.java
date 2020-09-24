/**
 * @author yym
 * @date 2020/09/24
 * @title 543.二叉树的直径：给定一棵二叉树，你需要计算它的直径长度。一棵二叉树的直径长度是任意两个结点路径长度中的最大值。
 *                         这条路径可能穿过也可能不穿过根结点。
 * @complexity 时间复杂度O(n)，空间复杂度O(h)
 */
public class diameterOfBinaryTree_easy {
    int max = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) {
            return max;
        }
        depth(root);
        return max;
    }
    public int depth(TreeNode t) {
        if (t == null) {
            return 0;
        }
        int left = depth(t.left);
        int right = depth(t.right);
        max = Math.max(max, left + right);
        return Math.max(left, right) + 1;
    }
}
