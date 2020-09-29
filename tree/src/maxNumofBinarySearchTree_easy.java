import java.util.ArrayList;
import java.util.List;

/**
 * @author yym
 * @date 2020/09/24
 * @title 501.二叉搜索树中的众数：给定一个有相同值的二叉搜索树（BST），找出 BST 中的所有众数（出现频率最高的元素）。
 *                               假定 BST 有如下定义：结点左子树中所含结点的值小于等于当前结点的值；结点右子树中所含结点
 *                               的值大于等于当前结点的值；左子树和右子树都是二叉搜索树
 * @complexity 时间复杂度O(n)，空间复杂度O(h)
 * @key 1二叉搜索树，中序遍历
 */
public class maxNumofBinarySearchTree_easy {
    List<Integer> res = new ArrayList<>();
    int curnode;
    int count;
    int maxCount;
    public int[] findMode(TreeNode root) {
        if (root == null) {
            return new int[0];
        }
        inOrder(root);
        int[] result = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            result[i] = res.get(i);
        }
        return result;
    }
    public void inOrder(TreeNode t) {
        if (t == null) {
            return;
        }
        inOrder(t.left);
        if (t.val == curnode) {
            count++;
        } else {
            curnode = t.val;
            count = 1;
        }
        if (count == maxCount) {
            res.add(curnode);
        } else if (count > maxCount) {
            res.clear();
            res.add(curnode);
            maxCount = count;
        }
        inOrder(t.right);
    }
}
