/**
 * @author yym
 * @date 2020/09/28
 * @title 面试题04.02.最小高度树：给定一个有序整数数组，元素各不相同且按升序排列，编写一个算法，创建一棵高度最小的二叉搜索
 *                               树。
 * @complexity 时间复杂度O(n)，空间复杂度O(n)
 */
public class minHeightTree_easy {
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 0) {
            return null;
        }
        return createTree(nums, 0, nums.length - 1);
    }
    public TreeNode createTree(int[] nums, int s, int e) {
        if (s > e) {
            return null;
        }
        if (s == e) {
            return new TreeNode(nums[s]);
        }
        int mid = s + (e - s) / 2;
        TreeNode t = new TreeNode(nums[mid]);
        t.left = createTree(nums, s, mid - 1);
        t.right = createTree(nums, mid + 1, e);
        return t;
    }
}
