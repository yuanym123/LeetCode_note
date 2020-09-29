/**
 * @author yym
 * @date 2020/09/29
 * @title 122.买卖股票的最佳时机II：给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。设计一个算法来计算你所能获取
 *                                 的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。注意：你不能同时参与多笔
 *                                 交易（你必须在再次购买前出售掉之前的股票）。
 * @complexity 时间复杂度O(n)，空间复杂度O(1)
 * @key 无限次买卖，则只要当天比前一天价格高，就可以进行一次买卖
 */
public class bestTimetoBuyGupiao2_easy {
    public int maxProfit(int[] prices) {
        if (prices.length == 0 || prices == null) {
            return 0;
        }
        int result = 0;
        for (int i = 1; i < prices.length; i++) {
            result += Math.max(0, prices[i] - prices[i - 1]);
        }
        return result;
    }
}
