/**
 * @author yym
 * @date 2020/09/23
 * @title 112.路径总和：给定一个二叉树和一个目标和，判断该树中是否存在根节点到叶子节点的路径，这条路径上所有节点值相加等于目
 *                     标和。说明: 叶子节点是指没有子节点的节点。
 * @complexity 时间复杂度O(n)，空间复杂度O(n)
 * @key 1二叉树，路径遍历，先序遍历
 */
public class pathSum_easy {
    boolean flag = false;
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        hasPath(root, sum);
        return flag;
    }
    public void hasPath(TreeNode t, int sum) {
        if (t == null) {
            return;
        }
        sum -= t.val;
        if (t.left == null && t.right == null && sum == 0) {
            flag = true;
            return;
        }
        hasPath(t.left, sum);
        hasPath(t.right, sum);
    }
}
