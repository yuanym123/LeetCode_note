import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author yym
 * @date 2020/09/23
 * @title 107.二叉树的层次遍历2：给定一个二叉树，返回其节点值自底向上的层次遍历。 （即按从叶子节点所在层到根节点所在的层，逐
 *                              层从左向右遍历）
 * @complexity 时间复杂度O(n)，空间复杂度O(n)
 * @key 1二叉树，层次遍历
 */
public class binaryLevelOrder_II_easy {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int count = 1;
        while (!q.isEmpty()) {
            int nextcount = 0;
            ArrayList<Integer> cur = new ArrayList<>();
            while (count > 0) {
                TreeNode t = q.poll();
                cur.add(t.val);
                if (t.left != null) {
                    q.offer(t.left);
                    nextcount++;
                }
                if (t.right != null) {
                    q.offer(t.right);
                    nextcount++;
                }
                count--;
            }
            result.add(0, cur);
            count = nextcount;
        }
        return result;
    }
}
