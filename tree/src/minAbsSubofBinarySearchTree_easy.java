/**
 * @author yym
 * @date 2020/09/24
 * @title 530.二叉搜索树的最小绝对差：给你一棵所有节点为非负值的二叉搜索树，请你计算树中任意两节点的差的绝对值的最小值。
 * @complexity 时间复杂度O(n)，空间复杂度O(h)
 */
public class minAbsSubofBinarySearchTree_easy {
    TreeNode pre = null;
    int min = Integer.MAX_VALUE;
    public int getMinimumDifference(TreeNode root) {
        inOrder(root);
        return min;
    }
    public void inOrder(TreeNode t) {
        if (t == null) {
            return;
        }
        inOrder(t.left);
        if (pre != null) {
            int cur = Math.abs(pre.val - t.val);
            min = Math.min(min, cur);
        }
        pre = t;
        inOrder(t.right);
    }
}
