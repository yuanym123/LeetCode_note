/**
 * @author yym
 * @date 2020/09/30
 * @title 1518.换酒问题：小区便利店正在促销，用 numExchange 个空酒瓶可以兑换一瓶新酒。你购入了 numBottles 瓶酒。如果喝掉
 *                      了酒瓶中的酒，那么酒瓶就会变成空的。请你计算 最多 能喝到多少瓶酒。
 * @complexity 时间复杂度O(n)，空间复杂度O(1)
 * @key 无贪心思路，正常迭代
 */
public class changBear_easy {
    public int numWaterBottles(int numBottles, int numExchange) {
        if (numBottles == 0) {
            return 0;
        }
        int sum = 0;
        int result = 0;
        while (numBottles > 0) {
            sum += numBottles;
            result += numBottles;
            numBottles = sum / numExchange;
            sum = sum % numExchange;
        }
        return result;
    }
}
