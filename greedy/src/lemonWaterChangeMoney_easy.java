/**
 * @author yym
 * @date 2020/09/29
 * @title 860.柠檬水找零：在柠檬水摊上，每一杯柠檬水的售价为 5 美元。顾客排队购买你的产品，（按账单 bills 支付的顺序）一次
 *                       购买一杯。每位顾客只买一杯柠檬水，然后向你付 5 美元、10 美元或 20 美元。你必须给每个顾客正确找零
 *                       ，也就是说净交易是每位顾客向你支付 5 美元。
 *                       注意，一开始你手头没有任何零钱。如果你能给每位顾客正确找零，返回 true ，否则返回 false 。
 * @complexity 时间复杂度O(n)，空间复杂度O(1)
 * @key 优先找面额大的
 */
public class lemonWaterChangeMoney_easy {
    public boolean lemonadeChange(int[] bills) {
        if (bills.length == 0 || bills == null) {
            return true;
        }
        int c5 = 0;
        int c10 = 0;
        int c20 = 0;
        for (int i = 0; i < bills.length; i++) {
            if (bills[i] == 5) {
                c5++;
            } else if (bills[i] == 10) {
                if (c5 == 0) {
                    return false;
                }
                c5--;
                c10++;
            } else {
                if (c5 == 0) {
                    return false;
                }
                if (c10 > 0) {
                    c10--;
                    c5--;
                } else if (c5 >= 3) {
                    c5 = c5 - 3;
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}
