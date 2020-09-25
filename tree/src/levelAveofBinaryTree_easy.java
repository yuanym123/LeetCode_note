import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author yym
 * @date 2020/09/25
 * @title 637.二叉树的层平均值：给定一个非空二叉树, 返回一个由每层节点平均值组成的数组。
 * @complexity 时间复杂度O(n)，空间复杂度O(level)
 */
public class levelAveofBinaryTree_easy {
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int count = 1;
        while (!q.isEmpty()) {
            int nextcount = 0;
            double sum = 0.0;
            int tmp = count;
            while (count > 0) {
                TreeNode t = q.poll();
                sum += t.val;
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
            result.add(sum / tmp);
            count = nextcount;
        }
        return result;
    }
}
