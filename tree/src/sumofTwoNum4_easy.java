import java.util.ArrayList;
import java.util.List;

/**
 * @author yym
 * @date 2020/09/25
 * @title 653.两数之和IV-输入BST：给定一个二叉搜索树和一个目标结果，如果 BST 中存在两个元素且它们的和等于给定的目标结果，
 *                               则返回 true。
 * @complexity 时间复杂度O(n)，空间复杂度O(n)
 */
public class sumofTwoNum4_easy {
    List<Integer> in = new ArrayList<>();
    public boolean findTarget(TreeNode root, int k) {
        if (root == null || (root.left == null && root.right == null)) {
            return false;
        }
        inOrder(root);
        int[] res = new int[in.size()];
        for (int i = 0; i < in.size(); i++) {
            res[i] = in.get(i);
        }
        int left = 0;
        int right = res.length - 1;
        while (left < right) {
            if (res[left] + res[right] == k) {
                return true;
            } else if (res[left] + res[right] > k) {
                right--;
            } else {
                left++;
            }
        }
        return false;
    }
    public void inOrder(TreeNode t) {
        if (t == null) {
            return;
        }
        inOrder(t.left);
        in.add(t.val);
        inOrder(t.right);
    }
}
