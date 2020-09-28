/**
 * @author yym
 * @date 2020/09/28
 * @title 1022.从根到叶的二进制数之和：给出一棵二叉树，其上每个结点的值都是 0 或 1 。每一条从根到叶的路径都代表一个从最高有
 *                                    效位开始的二进制数。例如，如果路径为 0 -> 1 -> 1 -> 0 -> 1，那么它表示二进制数 01101
 *                                    ，也就是 13 。对树上的每一片叶子，我们都要找出从根到该叶子的路径所表示的数字。
 *                                    提示：树中的结点数介于 1 和 1000 之间。node.val 为 0 或 1 。
 * @complexity 时间复杂度O(n)，空间复杂度O(n)
 */
public class bitSumFromRoot2Leaf_easy {
    int result = 0;
    public int sumRootToLeaf(TreeNode root) {
        if (root == null) {
            return 0;
        }
        preOrder(root, 0);
        return result;
    }
    public void preOrder(TreeNode t, int v) {
        if (t == null) {
            return;
        }
        v = v * 2 + t.val;
        if (t.left == null && t.right == null) {
            result += v;
        }
        preOrder(t.left, v);
        preOrder(t.right, v);
    }
}
