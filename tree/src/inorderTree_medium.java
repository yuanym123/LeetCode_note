import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author yym
 * @date 2020/09/14
 * @title 94.二叉树的中序遍历：给定一个二叉树，返回它的中序 遍历。
 * @complexity 时间复杂度O(n)，空间复杂度O(n)-O(n)-O(1)
 */
public class inorderTree_medium {
    // 递归方法
    public List<Integer> inorderTraversal1(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        inorder(root, res);
        return res;
    }
    public void inorder(TreeNode t, List<Integer> l) {
        if (t == null) {
            return;
        }
        inorder(t.left, l);
        l.add(t.val);
        inorder(t.right, l);
    }
    // 非递归方法
    public List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Stack<TreeNode> s = new Stack<>();
        while (!s.isEmpty() || root != null) {
            if (root != null) {
                s.push(root);
                root = root.left;
            } else {
                root = s.pop();
                res.add(root.val);
                root = root.right;
            }
        }
        return res;
    }
    // Morris方法
    public List<Integer> inorderTraversal3(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        TreeNode c1 = root;
        TreeNode c2 = null;
        while (c1 != null) {
            c2 = c1.left;
            if (c2 != null) {
                while (c2.right != null && c2.right != c1) {
                    c2 = c2.right;
                }
                if (c2.right == null) {
                    c2.right = c1;
                    c1 = c1.left;
                    continue;
                } else {
                    c2.right = null;
                }
            }
            res.add(c1.val);
            c1 = c1.right;
        }
        return res;
    }
}
