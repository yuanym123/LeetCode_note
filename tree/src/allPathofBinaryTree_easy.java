import java.util.LinkedList;
import java.util.List;

/**
 * @author yym
 * @date 2020/09/23
 * @title 257.二叉树的所有路径：给定一个二叉树，返回所有从根节点到叶子节点的路径。说明: 叶子节点是指没有子节点的节点。
 * @complexity 时间复杂度O(n)，空间复杂度O(n)
 */
public class allPathofBinaryTree_easy {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new LinkedList<>();
        if (root == null) {
            return result;
        }
        recur(root, "", result);
        return result;
    }
    public void recur(TreeNode t, String s, List<String> l) {
        if (t == null) {
            return;
        }
        if (t.left == null && t.right == null) {
            l.add(s + t.val);
        }
        recur(t.left, s + t.val + "->", l);
        recur(t.right, s + t.val + "->", l);
    }
}
