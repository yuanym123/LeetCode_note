/**
 * @author yym
 * @date 2020/10/06
 * @title 198.打家劫舍：你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相
 *                     邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。给定一个
 *                     代表每个房屋存放金额的非负整数数组，计算你 不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额。
 * @complexity 时间复杂度O(n)，空间复杂度O(1)
 * @key dp[n]，dp[i]表示到第i家最大值，dp[i]=max(dp[i-1], dp[i-2]+num[i])，dp[i]仅与dp[i-1]和dp[i-2]有关，可将空间复杂
 *      度从O(n)降到O(1)
 */
public class daJiaJieShe_easy {
    public int rob(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        int t1 = nums[0];
        int t2 = Math.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
            int cur = Math.max(t1 + nums[i], t2);
            t1 = t2;
            t2 = cur;
        }
        return t2;
    }
}
