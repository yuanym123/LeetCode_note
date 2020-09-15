/**
 * @author yym
 * @date 2020/09/15
 * @title 997.找到小镇的法官：在一个小镇里，按从 1 到 N 标记了 N 个人。传言称，这些人中有一个是小镇上的秘密法官。
 *        如果小镇的法官真的存在，那么：小镇的法官不相信任何人。每个人（除了小镇法官外）都信任小镇的法官。只有一个人
 *        同时满足属性 1 和属性 2 。
 *        给定数组 trust，该数组由信任对 trust[i] = [a, b] 组成，表示标记为 a 的人信任标记为 b 的人。
 *        如果小镇存在秘密法官并且可以确定他的身份，请返回该法官的标记。否则，返回 -1。
 *        其中，1 <= N <= 1000；trust.length <= 10000；trust[i] 是完全不同的；trust[i][0] != trust[i][1]；
 *        1 <= trust[i][0], trust[i][1] <= N
 * @complexity
 */
public class findFaGuanoftheTown_easy {
    // 二维数组存储关系，判断未投票且别人都投给他的，时间复杂度O(2m)，空间复杂度O(n^2)
    public int findJudge1(int N, int[][] trust) {
        if (N == 1 && trust.length == 0) {
            return 1;
        }
        if (N < 1 || trust.length == 0 || trust[0].length == 0) {
            return -1;
        }
        int[][] count = new int[N+1][N+1];
        int[] c = new int[N+1];
        for (int i = 0; i <= N; i++) {
            for (int j = 0; j <= N; j++) {
                count[i][j] = -1;
            }
        }
        for (int i = 0; i < trust.length; i++) {
            count[trust[i][0]][trust[i][1]] = 1;
            c[trust[i][0]]++;
        }
        for (int i = 1; i <= N; i++) {
            if (c[i] == 0) {
                int flag = 1;
                for (int j = 1; j <= N; j++) {
                    if (i == j) {
                        continue;
                    } else {
                        if (count[j][i] == -1) {
                            flag = 0;
                            break;
                        }
                    }
                }
                if (flag == 1) {
                    return i;
                }
            }
        }
        return -1;
    }
    // 两个数组分别存储每个人投票和被投票情况，没投且被投n-1的为法官，时间复杂度O(max{m,n})，空间复杂度O(n)
    public int findJudge2(int N, int[][] trust) {
        if (trust.length == 0) {
            return N == 1 ? 1 : -1;
        }
        int[] in = new int[N+1];
        int[] out = new int[N+1];
        for (int i = 0; i < trust.length; i++) {
            in[trust[i][1]]++;
            out[trust[i][0]]++;
        }
        int result = -1;
        for (int i = 1; i <= N; i++) {
            if (in[i] == N - 1 && out[i] == 0) {
                result = i;
                break;
            }
        }
        return result;
    }
    // 两个数组缩减为一个，被投票++，投票--，时间复杂度O(max{m,n})，空间复杂度O(n)
    public int findJudge3(int N, int[][] trust) {
        if (trust.length == 0) {
            return N == 1 ? 1 : -1;
        }
        int[] count = new int[N+1];
        for (int i = 0; i < trust.length; i++) {
            count[trust[i][1]]++;
            count[trust[i][0]]--;
        }
        int result = -1;
        for (int i = 1; i <= N; i++) {
            if (count[i] == N - 1) {
                result = i;
                break;
            }
        }
        return result;
    }
}
