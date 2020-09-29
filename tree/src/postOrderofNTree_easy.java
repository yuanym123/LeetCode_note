import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author yym
 * @date 2020/09/24
 * @title 590.N叉树的后序遍历：给定一个 N 叉树，返回其节点值的后序遍历。
 * @complexity 时间复杂度O(n)，空间复杂度O(n)
 * @key N叉树，后序遍历
 */
public class postOrderofNTree_easy {
    public List<Integer> postorder1(Node root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        helper(root, result);
        return result;
    }
    public void helper(Node t, List<Integer> l) {
        if (t == null) {
            return;
        }
        for (Node c : t.children) {
            helper(c, l);
        }
        l.add(t.val);
    }
    public List<Integer> postorder2(Node root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Stack<Node> s = new Stack<>();
        s.push(root);
        while (!s.isEmpty()) {
            Node t = s.pop();
            result.add(0, t.val);
            for (Node c : t.children) {
                s.push(c);
            }
        }
        return result;
    }
}
