import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author yym
 * @date 2020/09/28
 * @title 剑指32-II.从上到下打印二叉树II：从上到下按层打印二叉树，同一层的节点按从左到右的顺序打印，每一层打印到一行。
 * @complexity 时间复杂度O(n)，空间复杂度O(n)
 * @key 1二叉树，层次遍历
 */
public class printBinaryTreefromup2down2_easy {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int count = 1;
        while (!q.isEmpty()) {
            int nextcount = 0;
            List<Integer> cur = new ArrayList<>();
            while (count > 0) {
                count--;
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
            }
            count = nextcount;
            result.add(cur);
        }
        return result;
    }
}
