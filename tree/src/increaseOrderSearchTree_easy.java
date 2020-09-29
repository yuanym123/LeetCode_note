import java.util.ArrayList;
import java.util.List;

/**
 * @author yym
 * @date 2020/09/28
 * @title 897.递增顺序查找树：给你一个树，请你 按中序遍历 重新排列树，使树中最左边的结点现在是树的根，并且每个结点没有左子结
 *                           点，只有一个右子结点。
 *                           提示：给定树中的结点数介于 1 和 100 之间。每个结点都有一个从 0 到 1000 范围内的唯一整数值。
 * @complexity 时间复杂度O(n)，空间复杂度O(n)
 * @key 1二叉树，中序遍历+先序遍历
 */
public class increaseOrderSearchTree_easy {
    List<Integer> l = new ArrayList<>();
    public TreeNode increasingBST(TreeNode root) {
        if (root == null) {
            return root;
        }
        inOrder(root);
        return create(l, 0);
    }
    public void inOrder(TreeNode t) {
        if (t == null) {
            return;
        }
        inOrder(t.left);
        l.add(t.val);
        inOrder(t.right);
    }
    public TreeNode create(List<Integer> l, int index) {
        if (index >= l.size()) {
            return null;
        }
        TreeNode t = new TreeNode(l.get(index));
        t.right = create(l, index + 1);
        return t;
    }
}
