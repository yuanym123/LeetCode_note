/**
 * @author yym
 * @date 2020/09/30
 * @title 944.删列造序：给定由 N 个小写字母字符串组成的数组 A，其中每个字符串长度相等。你需要选出一组要删掉的列 D，对 A
 *                     执行删除操作，使 A 中剩余的每一列都是 非降序 排列的，然后请你返回 D.length 的最小可能值。删除 操
 *                     作的定义是：选出一组要删掉的列，删去 A 中对应列中的所有字符，形式上，第 n 列为 [A[0][n], A[1][n]
 *                     , ..., A[A.length-1][n]]）。（可以参见 删除操作范例）
 * @complexity 时间复杂度O(n^2)，空间复杂度O(1)
 * @key
 */
public class deleteColstoMakeSort_easy {
    public int minDeletionSize(String[] A) {
        if (A.length == 0 || A == null) {
            return 0;
        }
        int result = 0;
        for (int i = 0; i < A[0].length(); i++) {
            for (int j = 1; j < A.length; j++) {
                if (A[j].charAt(i) < A[j-1].charAt(i)) {
                    result++;
                    break;
                }
            }
        }
        return result;
    }
}
