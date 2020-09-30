import java.util.Arrays;

/**
 * @author yym
 * @date 2020/09/30
 * @title 1005.K次取反后最大化的数组和：给定一个整数数组 A，我们只能用以下方法修改该数组：我们选择某个索引 i 并将 A[i]
 *                                     替换为 -A[i]，然后总共重复这个过程 K 次。（我们可以多次选择同一个索引 i。）
 *                                     以这种方式修改数组后，返回数组可能的最大和。
 * @complexity 时间复杂度O(nlogn)，空间复杂度O(1)
 * @key 优先反转负数，其次多次反转0，其次多次反转最小正数
 */
public class maxSumofArrayafterKReverse_easy {
    public int largestSumAfterKNegations(int[] A, int K) {
        Arrays.sort(A);
        int result = 0;
        int index = 0;
        while (K > 0 && index < A.length && A[index] < 0) {
            A[index] = -A[index];
            index++;
            K--;
        }
        if (A[index] == 0 && K > 0) {
            K = 0;
        }
        if (K % 2 == 1) {
            Arrays.sort(A);
            A[0] = -A[0];
        }
        for (int i = 0; i < A.length; i++) {
            result += A[i];
        }
        return result;
    }
}
