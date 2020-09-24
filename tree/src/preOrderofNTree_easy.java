import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author yym
 * @date 2020/09/24
 * @title 589.N叉树的前序遍历：给定一个 N 叉树，返回其节点值的前序遍历。
 * @complexity 时间复杂度O(n)，空间复杂度O(h)
 */
public class preOrderofNTree_easy {
    public List<Integer> preorder1(Node root) {
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
        l.add(t.val);
        for (Node c: t.children) {
            helper(c, l);
        }
    }
    public List<Integer> preorder2(Node root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Stack<Node> s = new Stack<>();
        s.push(root);
        while (!s.isEmpty()) {
            Node t = s.pop();
            result.add(t.val);
            List<Node> child = t.children;
            for (int i = child.size() - 1; i >= 0; i--) {
                s.push(child.get(i));
            }
        }
        return result;
    }
}
