import java.util.PriorityQueue;

/**
 * @author yym
 * @date 2020/09/30
 * @title 1046.最后一块石头的重量：有一堆石头，每块石头的重量都是正整数。每一回合，从中选出两块 最重的 石头，然后将它们一
 *                                起粉碎。假设石头的重量分别为 x 和 y，且 x <= y。那么粉碎的可能结果如下：如果 x == y，
 *                                那么两块石头都会被完全粉碎；如果 x != y，那么重量为 x 的石头将会完全粉碎，而重量为 y
 *                                的石头新重量为 y-x。最后，最多只会剩下一块石头。返回此石头的重量。如果没有石头剩下，就
 *                                返回 0。
 * @complexity 时间复杂度O(n)，空间复杂度O(n)
 * @key 优先队列排序，取最大的比较
 */
public class lastWeightofStone_easy {
    public int lastStoneWeight(int[] stones) {
        if (stones.length == 0) {
            return 0;
        }
        PriorityQueue<Integer> q = new PriorityQueue<>((a, b) -> (b - a));
        for (int i = 0; i < stones.length; i++) {
            q.offer(stones[i]);
        }
        int count = stones.length;
        while (count > 0) {
            if (count > 1) {
                int t1 = q.poll();
                int t2 = q.poll();
                t1 -= t2;
                if (t1 == 0) {
                    count = count - 2;
                } else {
                    q.offer(t1);
                    count--;
                }
            } else {
                return q.poll();
            }
        }
        return 0;
    }
}
