/**
 * @author yym
 * @date 2020/10/06
 * @title 746.使用最小花费爬楼梯：数组的每个索引作为一个阶梯，第 i个阶梯对应着一个非负数的体力花费值 cost[i](索引从0开始
 *                               )。每当你爬上一个阶梯你都要花费对应的体力花费值，然后你可以选择继续爬一个阶梯或者爬两个
 *                               阶梯。您需要找到达到楼层顶部的最低花费。在开始时，你可以选择从索引为 0 或 1 的元素作为
 *                               初始阶梯。
 * @complexity 时间复杂度O(n)，空间复杂度O(1)
 * @key f[i] = cost[i] + min(f[i+1], f[i+2])
 */
public class minCosttoClimbStar_easy {
    public int minCostClimbingStairs(int[] cost) {
        int f1 = 0, f2 = 0;
        for (int i = cost.length - 1; i >= 0; --i) {
            int f0 = cost[i] + Math.min(f1, f2);
            f2 = f1;
            f1 = f0;
        }
        return Math.min(f1, f2);
    }
}
