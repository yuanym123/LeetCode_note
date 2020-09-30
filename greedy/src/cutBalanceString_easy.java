/**
 * @author yym
 * @date 2020/09/30
 * @title 1221.分割平衡字符串：在一个「平衡字符串」中，'L' 和 'R' 字符的数量是相同的。给出一个平衡字符串 s，请你将它分割
 *                            成尽可能多的平衡字符串。返回可以通过分割得到的平衡字符串的最大数量。
 * @complexity 时间复杂度O(n)，空间复杂度O(1)
 * @key 只要L=R就切分
 */
public class cutBalanceString_easy {
    public int balancedStringSplit(String s) {
        if (s.length() == 0 || s == null) {
            return 0;
        }
        int count = 0;
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'L') {
                count++;
            } else {
                count--;
            }
            if (count == 0) {
                result++;
            }
        }
        return result;
    }
}
