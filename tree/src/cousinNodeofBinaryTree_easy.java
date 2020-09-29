import java.util.LinkedList;
import java.util.Queue;

/**
 * @author yym
 * @date 2020/09/28
 * @title 993.二叉树的堂兄弟节点：在二叉树中，根节点位于深度 0 处，每个深度为 k 的节点的子节点位于深度 k+1 处。如果二叉树的
 *                               两个节点深度相同，但父节点不同，则它们是一对堂兄弟节点。我们给出了具有唯一值的二叉树的根节
 *                               点 root，以及树中两个不同节点的值 x 和 y。只有与值 x 和 y 对应的节点是堂兄弟节点时，才返回
 *                               true。否则，返回 false。
 *                               提示：二叉树的节点数介于 2 到 100 之间。每个节点的值都是唯一的、范围为 1 到 100 的整数。
 * @complexity 时间复杂度O(n)，空间复杂度O(n)
 * @key 1二叉树，层次遍历
 */
public class cousinNodeofBinaryTree_easy {
    public boolean isCousins(TreeNode root, int x, int y) {
        if (root == null || root.val == x || root.val == y) {
            return false;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int count = 1;
        TreeNode xp = null;
        TreeNode yp = null;
        while (!q.isEmpty()) {
            int nextcount = 0;
            while (count > 0) {
                count--;
                TreeNode t = q.poll();
                if (t.left != null) {
                    q.offer(t.left);
                    nextcount++;
                    if (t.left.val == x) {
                        xp = t;
                    }
                    if (t.left.val == y) {
                        yp = t;
                    }
                }
                if (t.right != null) {
                    q.offer(t.right);
                    nextcount++;
                    if (t.right.val == x) {
                        xp = t;
                    }
                    if (t.right.val == y) {
                        yp = t;
                    }
                }
            }
            if (xp != null && yp != null) {
                return xp == yp ? false : true;
            }
            if (xp != null || yp != null) {
                return false;
            }
            count = nextcount;
        }
        return false;
    }
}
