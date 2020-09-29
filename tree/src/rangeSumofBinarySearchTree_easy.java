/**
 * @author yym
 * @date 2020/09/28
 * @title 938.二叉搜索树的范围和：给定二叉搜索树的根结点 root，返回 L 和 R（含）之间的所有结点的值的和。二叉搜索树保证具有唯
 *                               一的值。
 *                               提示：树中的结点数量最多为 10000 个。最终的答案保证小于 2^31。
 * @complexity 时间复杂度O(n)，空间复杂度O(n)
 * @key 1二叉搜索树，先序遍历
 */
public class rangeSumofBinarySearchTree_easy {
    public int rangeSumBST(TreeNode root, int L, int R) {
        if (root == null) {
            return 0;
        }
        int result = 0;
        if (root.val >= L && root.val <= R) {
            result += root.val;
            result += rangeSumBST(root.left, L, R);
            result += rangeSumBST(root.right, L, R);
        } else if (root.val < L) {
            result += rangeSumBST(root.right, L, R);
        } else {
            result += rangeSumBST(root.left, L, R);
        }
        return result;
    }
}
