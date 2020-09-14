import java.util.LinkedList;
import java.util.Queue;

/**
 * @author yym
 * @date 2020/09/14
 * @title 101.对称二叉树：给定一个二叉树，检查它是否是镜像对称的。
 * @complexity 时间复杂度O(n)，空间复杂度O(n)
 */
public class symmetricTree_easy {
    // 递归
    public boolean isSymmetric1(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) {
            return true;
        }
        return recur(root.left, root.right);
    }
    public boolean recur(TreeNode l, TreeNode r) {
        if (l == null && r == null) {
            return true;
        }
        if (l == null || r == null || l.val != r.val) {
            return false;
        }
        return recur(l.left, r.right) && recur(l.right, r.left);
    }
    // 非递归
    public boolean isSymmetric2(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) {
            return true;
        }
        Queue<TreeNode> q1 = new LinkedList<>();
        Queue<TreeNode> q2 = new LinkedList<>();
        q1.offer(root.left);
        q2.offer(root.right);
        while ((!q1.isEmpty()) && (!q2.isEmpty())) {
            TreeNode t1 = q1.poll();
            TreeNode t2 = q2.poll();
            if (t1 == null && t2 == null) {
                continue;
            }
            if (t1 == null || t2 == null || t1.val != t2.val || (t1.left == null ^ t2.right == null) || (t1.right == null ^ t2.left == null)) {
                return false;
            }
            if (t1.left != null) {
                q1.offer(t1.left);
                q2.offer(t2.right);
            }
            if (t1.right != null) {
                q1.offer(t1.right);
                q2.offer(t2.left);
            }
        }
        if (q1.isEmpty() && q2.isEmpty()) {
            return true;
        }
        return false;
    }
}
