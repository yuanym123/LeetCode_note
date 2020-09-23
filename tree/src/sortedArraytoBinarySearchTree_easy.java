/**
 * @author yym
 * @date 2020/09/23
 * @title 108.将有序数组转换为二叉搜索树：将一个按照升序排列的有序数组，转换为一棵高度平衡二叉搜索树。本题中，一个高度平衡二
 *                                      叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。
 * @complexity 时间复杂度O(n)，空间复杂度O(n)
 */
public class sortedArraytoBinarySearchTree_easy {
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 0) {
            return null;
        }
        return generate(nums, 0, nums.length - 1);
    }
    public TreeNode generate(int[] nums, int start, int end) {
        if (start > end) {
            return null;
        }
        int mid = start + (end - start) / 2;
        TreeNode t = new TreeNode(nums[mid]);
        t.left = generate(nums, start, mid - 1);
        t.right = generate(nums, mid + 1, end);
        return t;
    }
}
