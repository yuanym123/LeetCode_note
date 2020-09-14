import java.util.ArrayList;
import java.util.List;

/**
 * @author yym
 * @date 2020/09/14
 * @title 95.不同的二叉搜索树II：给定一个整数 n，生成所有由 1 ... n 为节点所组成的 二叉搜索树 。
 * @complexity 时间复杂度O({4^n}/{n^{1/2}})，空间复杂度O({4^n}/{n^{1/2}})，一棵树是O(n)，共有卡特兰数个树
 */
public class diffBinarySearchTree_medium {
    public List<TreeNode> generateTrees(int n) {
        List<TreeNode> res = new ArrayList<>();
        if (n == 0) {
            return res;
        }
        return recur(1, n);
    }
    public List<TreeNode> recur(int start, int end) {
        List<TreeNode> res = new ArrayList<>();
        if (start > end) {
            res.add(null);
            return res;
        }
        for (int i = start; i <= end; i++) {
            List<TreeNode> left = recur(start, i-1);
            List<TreeNode> right = recur(i+1, end);
            for (TreeNode l : left) {
                for (TreeNode r : right) {
                    TreeNode t = new TreeNode(i);
                    t.left = l;
                    t.right = r;
                    res.add(t);
                }
            }
        }
        return res;
    }
}
