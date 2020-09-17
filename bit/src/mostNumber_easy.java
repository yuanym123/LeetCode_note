/**
 * @author yym
 * @date 2020/09/17
 * @title 169.多数元素：给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
 *        你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 * @complexity 时间复杂度O(n)，空间复杂度O(1)
 */
public class mostNumber_easy {
    // 投票机制
    public int majorityElement1(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int result = nums[0];
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == result) {
                count++;
            } else {
                count--;
            }
            if (count == 0) {
                result = nums[i];
                count++;
            }
        }
        return result;
    }
    // 位运算，统计各个位上1的个数，若超过n/2，则此位为1
    public int majorityElement2(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int result = 0;
        for (int i = 0; i < 32; i++) {
            int count = 0;
            for (int j = 0; j < nums.length; j++) {
                count += nums[j] >> i & 1; // 取当前位
                if (count > nums.length / 2) {
                    result += 1 << i; // 当前位赋值为1
                    break;
                }
            }
        }
        return result;
    }
}
