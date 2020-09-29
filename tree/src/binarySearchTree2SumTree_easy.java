/**
 * @author yym
 * @date 2020/09/24
 * @title 538.把二叉搜索树转换为累加树：给定一个二叉搜索树（Binary Search Tree），把它转换成为累加树（Greater Tree)，
 *                                     使得每个节点的值是原来的节点值加上所有大于它的节点值之和。
 * @complexity 时间复杂度O(n)，空间复杂度O(h)
 * @key 1二叉搜索树，反中序遍历
 */
public class binarySearchTree2SumTree_easy {
    int pre = 0;
    public TreeNode convertBST(TreeNode root) {
        if (root == null) {
            return null;
        }
        reverseInOrder(root);
        return root;
    }
    public void reverseInOrder(TreeNode t) {
        if (t == null) {
            return;
        }
        reverseInOrder(t.right);
        pre += t.val;
        t.val = pre;
        reverseInOrder(t.left);
    }
}
