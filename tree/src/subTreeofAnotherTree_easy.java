/**
 * @author yym
 * @date 2020/09/24
 * @title 572.另一个树的子树：给定两个非空二叉树 s 和 t，检验 s 中是否包含和 t 具有相同结构和节点值的子树。s 的一个子树包括
 *                            s 的一个节点和这个节点的所有子孙。s 也可以看做它自身的一棵子树。
 * @complexity 时间复杂度O(mn)，空间复杂度O(h)
 * @key 2二叉树，先序遍历
 */
public class subTreeofAnotherTree_easy {
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (t == null) {
            return true;
        }
        if (s == null) {
            return false;
        }
        return check(s, t) || isSubtree(s.left, t) || isSubtree(s.right, t);
    }
    public boolean check(TreeNode s, TreeNode t) {
        if (s == null && t == null) {
            return true;
        }
        if (s == null || t == null || s.val != t.val) {
            return false;
        }
        return check(s.left, t.left) && check(s.right, t.right);
    }
}
