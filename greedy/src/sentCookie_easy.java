import java.util.Arrays;

/**
 * @author yym
 * @date 2020/09/29
 * @title 455.分发饼干：假设你是一位很棒的家长，想要给你的孩子们一些小饼干。但是，每个孩子最多只能给一块饼干。对每个孩子 i
 *                      ，都有一个胃口值 gi ，这是能让孩子们满足胃口的饼干的最小尺寸；并且每块饼干 j ，都有一个尺寸 sj 。
 *                      如果 sj >= gi ，我们可以将这个饼干 j 分配给孩子 i ，这个孩子会得到满足。你的目标是尽可能满足越多数
 *                      量的孩子，并输出这个最大数值。
 *                      注意：你可以假设胃口值为正。一个小朋友最多只能拥有一块饼干。
 * @complexity 时间复杂度O(n)，空间复杂度O(1)
 * @key 数组升序排序，若当前饼干值小于人值，则当前饼干值不能满足之后所有人
 */
public class sentCookie_easy {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int i = 0;
        int j = 0;
        int result = 0;
        while (i < g.length && j < s.length) {
            if (g[i] <= s[j]) {
                i++;
                j++;
                result++;
            } else {
                j++;
            }
        }
        return result;
    }
}
