/**
 * @author yym
 * @date 2020/09/28
 * @title 剑指54.二叉搜索树的第K大节点：给定一棵二叉搜索树，请找出其中第k大的节点。
 * @complexity 时间复杂度O(n)，空间复杂度O(n)
 * @key 1二叉搜索树，反中序遍历
 */
public class kthLargestNodeofBinarySearchTree_easy {
    int result = 0;
    int i = 1;
    public int kthLargest(TreeNode root, int k) {
        if (root == null || k < 1) {
            return -1;
        }
        reverseInOrder(root, k);
        return result;
    }
    public void reverseInOrder(TreeNode t, int k) {
        if (t == null) {
            return;
        }
        reverseInOrder(t.right, k);
        if (i == k) {
            result = t.val;
        }
        i++;
        reverseInOrder(t.left, k);
    }
}
