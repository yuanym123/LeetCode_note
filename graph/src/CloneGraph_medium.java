import java.util.*;

/**
 * @author yym
 * @date 2020/09/15
 * @title 133.克隆图：给你无向 连通 图中一个节点的引用，请你返回该图的 深拷贝（克隆）。图中的每个节点都包含它的值 val（int）
 *        和其邻居的列表（list[Node]）
 *        其中，节点数不超过 100；每个节点值 Node.val 都是唯一的，1 <= Node.val <= 100；无向图是一个简单图，这意味着图中没有
 *        重复的边，也没有自环；由于图是无向的，如果节点 p 是节点 q 的邻居，那么节点 q 也必须是节点 p 的邻居；图是连通图，
 *        你可以从给定节点访问到所有节点。
 * @complexity 时间复杂度O(n)，空间复杂度O(n)
 */
// 图结点格式
class Node {
    public int val;
    public List<Node> neighbors;

    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }

    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }

    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}

public class CloneGraph_medium {
    private Map<Node, Node> visited = new HashMap<>();
    // 深度优先
    public Node cloneGraph1(Node node) {
        if (node == null) {
            return node;
        }
        if (visited.containsKey(node)) {
            return visited.get(node);
        }
        Node clone = new Node(node.val, new ArrayList());
        visited.put(node, clone);
        for (Node neighbor: node.neighbors) {
            clone.neighbors.add(cloneGraph1(neighbor));
        }
        return clone;
    }
    // 广度优先
    public Node cloneGraph(Node node) {
        if (node == null) {
            return node;
        }
        Map<Node, Node> visited = new HashMap();
        Queue<Node> q = new LinkedList<>();
        q.offer(node);
        visited.put(node, new Node(node.val, new ArrayList()));
        while (!q.isEmpty()) {
            Node tmp = q.poll();
            for (Node neighbor: tmp.neighbors) {
                if (!visited.containsKey(neighbor)) {
                    visited.put(neighbor, new Node(neighbor.val, new ArrayList()));
                    q.offer(neighbor);
                }
                visited.get(tmp).neighbors.add(visited.get(neighbor));
            }
        }
        return visited.get(node);
    }
}
