import java.util.ArrayList;

/**
 * @author yym
 * @date 2020/09/15
 * @title 1042.不邻接植花：有 N 个花园，按从 1 到 N 标记。在每个花园中，你打算种下四种花之一。paths[i] = [x, y] 描述了
 *        花园 x 到花园 y 的双向路径。另外，没有花园有 3 条以上的路径可以进入或者离开。你需要为每个花园选择一种花，使得
 *        通过路径相连的任何两个花园中的花的种类互不相同。以数组形式返回选择的方案作为答案 answer，其中 answer[i] 为在
 *        第 (i+1) 个花园中种植的花的种类。花的种类用  1, 2, 3, 4 表示。保证存在答案。
 *        其中，1 <= N <= 10000；0 <= paths.size <= 20000；不存在花园有 4 条或者更多路径可以进入或离开；保证存在答案。
 * @complexity 时间复杂度O(N)，空间复杂度O(m)
 */
public class noClosePlant_easy {
    public int[] gardenNoAdj(int N, int[][] paths) {
        int[] result = new int[N];
        ArrayList<Integer>[] adj = (ArrayList<Integer>[]) new ArrayList[N+1];
        for (int i = 0; i <= N; i++) {
            adj[i] = new ArrayList<Integer>();
        }
        for (int i = 0; i < paths.length; i++) {
            adj[paths[i][0]].add(paths[i][1]);
            adj[paths[i][1]].add(paths[i][0]);
        }
        for (int i = 1; i <= N; i++) {
            int[] color = new int[5];
            for (int tmp : adj[i]) {
                color[result[tmp-1]] = 1;
            }
            for (int j = 1; j < 5; j++) {
                if (color[j] == 0) {
                    result[i-1] = j;
                    break;
                }
            }
        }
        return result;
    }
}
