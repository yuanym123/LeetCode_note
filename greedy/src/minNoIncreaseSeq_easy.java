import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author yym
 * @date 2020/09/30
 * @title 1403.非递增顺序的最小子序列：给你一个数组 nums，请你从中抽取一个子序列，满足该子序列的元素之和 严格 大于未包含在
 *                                    该子序列中的各元素之和。如果存在多个解决方案，只需返回 长度最小 的子序列。如果仍然
 *                                    有多个解决方案，则返回 元素之和最大 的子序列。与子数组不同的地方在于，「数组的子序
 *                                    列」不强调元素在原数组中的连续性，也就是说，它可以通过从数组中分离一些（也可能不分
 *                                    离）元素得到。注意，题目数据保证满足所有约束条件的解决方案是 唯一 的。同时，返回的
 *                                    答案应当按 非递增顺序 排列。
 * @complexity 时间复杂度O(nlogn)，空间复杂度O(n)
 * @key 尽量取最大的值
 */
public class minNoIncreaseSeq_easy {
    public List<Integer> minSubsequence(int[] nums) {
        List<Integer> result = new ArrayList<>();
        if (nums.length == 0) {
            return result;
        }
        if (nums.length == 1) {
            result.add(nums[0]);
            return result;
        }
        Arrays.sort(nums);
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        sum = sum / 2;
        int index = nums.length - 1;
        int c = 0;
        while (index >= 0) {
            c += nums[index];
            result.add(nums[index]);
            if (c > sum) {
                break;
            }
            index--;
        }
        return result;
    }
}
