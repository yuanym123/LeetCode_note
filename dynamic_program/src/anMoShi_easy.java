/**
 * @author yym
 * @date 2020/10/06
 * @title 面试题17.16. 按摩师：一个有名的按摩师会收到源源不断的预约请求，每个预约都可以选择接或不接。在每次预约服务之间
 *                            要有休息时间，因此她不能接受相邻的预约。给定一个预约请求序列，替按摩师找到最优的预约集合
 *                            （总预约时间最长），返回总的分钟数。
 * @complexity 时间复杂度O(n)，空间复杂度O(1)
 * @key 同打家劫舍
 */
public class anMoShi_easy {
    public int massage(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        int t1 = nums[0];
        int t2 = Math.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
            int cur = Math.max(t1 + nums[i], t2);
            t1 = t2;
            t2 = cur;
        }
        return t2;
    }
}
