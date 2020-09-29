/**
 * @author yym
 * @date 2020/09/24
 * @title 563.二叉树的坡度：给定一个二叉树，计算整个树的坡度。一个树的节点的坡度定义即为，该节点左子树的结点之和和右子树结点
 *                         之和的差的绝对值。空结点的的坡度是0。整个树的坡度就是其所有节点的坡度之和。
 * @complexity 时间复杂度O(n)，空间复杂度O(h)
 * @key 1二叉树，后序遍历
 */
public class slopeOfBinaryTree_easy {
    int sum = 0;
    public int findTilt(TreeNode root) {
        if (root == null) {
            return sum;
        }
        nodeCount(root);
        return sum;
    }
    public int nodeCount(TreeNode t) {
        if (t == null) {
            return 0;
        }
        int left = nodeCount(t.left);
        int right = nodeCount(t.right);
        sum += Math.abs(left - right);
        return left + right + t.val;
    }
}
