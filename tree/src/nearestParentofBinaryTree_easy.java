/**
 * @author yym
 * @date 2020/09/28
 * @title 剑指68-II.二叉树的最近公共祖先：给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。百度百科中最近公共祖先的定义
 *                                       为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q
 *                                       的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 *                                       说明:所有节点的值都是唯一的。p、q 为不同节点且均存在于给定的二叉树中。
 * @complexity 时间复杂度O(n)，空间复杂度O(n)
 * @key 1二叉树，后序遍历
 */
public class nearestParentofBinaryTree_easy {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left == null) {
            return right;
        }
        if (right == null) {
            return left;
        }
        return root;
    }
}
