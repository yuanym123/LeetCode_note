/**
 * @author yym
 * @date 2020/10/06
 * @title 121.买卖股票的最佳时机：给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。如果你最多只允许完成一笔交易
 *                               （即买入和卖出一支股票一次），设计一个算法来计算你所能获取的最大利润。注意：你不能在买
 *                               入股票前卖出股票。
 * @complexity 时间复杂度O(n)，空间复杂度O(1)
 * @key 动态更新最小值以及收入
 */
public class bestTimetoBuyGupiao_easy {
    public int maxProfit(int[] prices) {
        if (prices.length == 0) {
            return 0;
        }
        int min = prices[0];
        int result = 0;
        for (int i = 1; i < prices.length; i++) {
            min = Math.min(min, prices[i]);
            result = Math.max(result, prices[i] - min);
        }
        return result;
    }
}
