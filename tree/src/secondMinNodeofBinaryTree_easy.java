/**
 * @author yym
 * @date 2020/09/25
 * @title 671.二叉树中第二小的节点：给定一个非空特殊的二叉树，每个节点都是正数，并且每个节点的子节点数量只能为 2 或 0。如果
 *                                 一个节点有两个子节点的话，那么该节点的值等于两个子节点中较小的一个。给出这样的一个二叉
 *                                 树，你需要输出所有节点中的第二小的值。如果第二小的值不存在的话，输出 -1 。
 * @complexity 时间复杂度O(n)，空间复杂度O(n)
 * @key 1二叉树，先序遍历
 */
public class secondMinNodeofBinaryTree_easy {
    int result = -1;
    public int findSecondMinimumValue(TreeNode root) {
        if (root == null) {
            return result;
        }
        if (root.left != null && root.left.val != root.right.val) {
            int max = Math.max(root.left.val, root.right.val);
            result = result == -1 ? max : Math.min(max, result);
            findSecondMinimumValue(root.left.val > root.right.val ? root.right : root.left);
        } else {
            findSecondMinimumValue(root.left);
            findSecondMinimumValue(root.right);
        }
        return result;
    }
}
