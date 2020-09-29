import java.util.LinkedList;
import java.util.Queue;

/**
 * @author yym
 * @date 2020/09/14
 * @title 100.相同的树: 给定两个二叉树，编写一个函数来检验它们是否相同。如果两个树在结构上相同，并且节点具有相同的值，则认为
 *        它们是相同的。
 * @complexity 时间复杂度O(min(m,n))，空间复杂度O(min(m,n))。其中 m和 n分别是两个二叉树的节点数。
 * @key 2二叉树，先序遍历
 */
public class sameTree_easy {
    // 递归，深度优先
    public boolean isSameTree1(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null || p.val != q.val) {
            return false;
        }
        return isSameTree1(p.left, q.left) && isSameTree1(p.right, q.right);
    }
    // 非递归，广度优先
    public boolean isSameTree2(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        Queue<TreeNode> q1 = new LinkedList<>();
        Queue<TreeNode> q2 = new LinkedList<>();
        q1.offer(p);
        q2.offer(q);
        while ((!q1.isEmpty()) && (!q2.isEmpty())) {
            TreeNode t1 = q1.poll();
            TreeNode t2 = q2.poll();
            if (t1.val != t2.val || (t1.left == null ^ t2.left == null) || (t1.right == null ^ t2.right == null)) {
                return false;
            }
            if (t1.left != null) {
                q1.offer(t1.left);
                q2.offer(t2.left);
            }
            if (t1.right != null) {
                q1.offer(t1.right);
                q2.offer(t2.right);
            }
        }
        if (q1.isEmpty() && q2.isEmpty()) {
            return true;
        }
        return false;
    }
}
