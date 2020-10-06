/**
 * @author yym
 * @date 2020/10/06
 * @title 303.区域和检索-数组不可变：给定一个整数数组  nums，求出数组从索引 i 到 j  (i ≤ j) 范围内元素的总和，包含 i,
 *                                  j 两点。
 * @complexity 时间复杂度O(n)，空间复杂度O(n)
 * @key
 */
public class partAndSearch_easy {
    int[] sum;
    public partAndSearch_easy (int[] nums) {
        sum = new int[nums.length];
        if (nums.length > 0) {
            sum[0] = nums[0];
            for (int i = 1; i < nums.length; i++) {
                sum[i] = sum[i-1] + nums[i];
            }
        }
    }

    public int sumRange(int i, int j) {
        if (i == 0) {
            return sum[j];
        } else {
            return sum[j] - sum[i-1];
        }
    }
}
