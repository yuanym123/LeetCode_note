import java.util.ArrayList;
import java.util.List;

/**
 * @author yym
 * @date 2020/09/28
 * @title 872.叶子相似的树：请考虑一颗二叉树上所有的叶子，这些叶子的值按从左到右的顺序排列形成一个 叶值序列 。如果有两颗二叉
 *                         树的叶值序列是相同，那么我们就认为它们是 叶相似 的。如果给定的两个头结点分别为 root1 和 root2 的
 *                         树是叶相似的，则返回 true；否则返回 false 。
 *                         提示：给定的两颗树可能会有 1 到 200 个结点。给定的两颗树上的值介于 0 到 200 之间。
 * @complexity 时间复杂度O(m+n)，空间复杂度O(m+n)
 * @key 2二叉树，先序遍历
 */
public class similarLeafTree_easy {
    List<Integer> l1 = new ArrayList<>();
    List<Integer> l2 = new ArrayList<>();
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return true;
        }
        if (root1 == null || root2 == null) {
            return false;
        }
        preOrder(root1, l1);
        preOrder(root2, l2);
        if (l1.size() != l2.size()) {
            return false;
        }
        for (int i = 0; i < l1.size(); i++) {
            if (l1.get(i) != l2.get(i)) {
                return false;
            }
        }
        return true;
    }
    public void preOrder(TreeNode t, List<Integer> l) {
        if (t == null) {
            return;
        }
        if (t.left == null && t.right == null) {
            l.add(t.val);
        }
        preOrder(t.left, l);
        preOrder(t.right, l);
    }
}
