import java.util.List;

/**
 * @author yym
 * @date 2020/09/24
 * @title 559.N叉树的最大深度：给定一个 N 叉树，找到其最大深度。最大深度是指从根节点到最远叶子节点的最长路径上的节点总数。
 * @complexity 时间复杂度O(n)，空间复杂度O(h)
 * @key N叉树，先序遍历
 */
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
}

public class maxDepthofNTree_easy {
    public int maxDepth(Node root) {
        if (root == null) {
            return 0;
        }
        int cdepth = 0;
        for (Node t: root.children) {
            cdepth = Math.max(cdepth, maxDepth(t));
        }
        return cdepth + 1;
    }
}
