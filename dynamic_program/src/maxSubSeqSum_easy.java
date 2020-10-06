/**
 * @author yym
 * @date 2020/10/06
 * @title 53.最大子序和：给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * @complexity 时间复杂度O(n)，空间复杂度O(1)
 * @key dp[n]，dp[i]表示以i结尾的最大子序和，dp[i]=dp[i-1]+nim[i] (if dp[i-1]>0) | num[i] (if dp[i-1]<0)，dp[i]仅
 *      与dp[i-1]有关，可将空间复杂度由O(n)降为O(1)
 */
public class maxSubSeqSum_easy {
    public int maxSubArray(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int result = Integer.MIN_VALUE;
        int cur = 0;
        for (int i = 0; i < nums.length; i++) {
            cur = Math.max(cur + nums[i], nums[i]);
            result = Math.max(cur, result);
        }
        return result;
    }
}
