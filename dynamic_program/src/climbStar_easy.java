/**
 * @author yym
 * @date 2020/10/06
 * @title 70.爬楼梯：假设你正在爬楼梯。需要 n 阶你才能到达楼顶。每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到
 *                   楼顶呢？注意：给定 n 是一个正整数。
 * @complexity 时间复杂度O(n)，空间复杂度O(1)
 * @key dp[n]，dp[i]表示爬i个楼梯所需步数，dp[i]=dp[i-1]+dp[i-2]，dp[i]仅与dp[i-1]和dp[i-2]有关，可将空间复杂度从O(n)降
 *      到O(1)
 */
public class climbStar_easy {
    public int climbStairs(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        int i1 = 1;
        int i2 = 2;
        int result = 3;
        for (int i = 3; i <= n; i++) {
            result = i1 + i2;
            i1 = i2;
            i2 = result;
        }
        return result;
    }
}
