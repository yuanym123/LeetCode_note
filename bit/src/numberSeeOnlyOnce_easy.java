/**
 * @author yym
 * @date 2020/09/17
 * @title 136.只出现一次的数字：给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次
 *        的元素。说明：你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
 * @complexity 时间复杂度O(n)，空间复杂度O(1)
 */
public class numberSeeOnlyOnce_easy {
    public int singleNumber(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int result = nums[0];
        for (int i = 1; i < nums.length; i++) {
            result = result ^ nums[i];
        }
        return result;
    }
}
