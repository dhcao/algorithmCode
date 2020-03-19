package leetQuestion.arrayAndInt;

import static java.lang.Math.min;

/**
 * 给定一个含有 n 个正整数的数组和一个正整数 s ，找出该数组中满足其和 ≥ s 的长度最小的连续子数组。如果不存在符合条件的连续子数组，返回 0。
 *
 * 示例: 
 *
 * 输入: s = 7, nums = [2,3,1,2,4,3]
 * 输出: 2
 * 解释: 子数组 [4,3] 是该条件下的长度最小的连续子数组。
 * 进阶:
 *
 * 如果你已经完成了O(n) 时间复杂度的解法, 请尝试 O(n log n) 时间复杂度的解法。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-size-subarray-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @Author: dhcao
 * @Version: 1.0
 */
public class MinSubArray {


    /**
     * 解法1：滑动窗口
     * @param s
     * @param nums
     * @return
     */
    public static int minSubArrayLen(int s, int[] nums){

        // 1. 先构建窗口,初始化时窗口中不含任何元素，所有右边界为-1；
        int l = 0;
        int r = -1;
        int sum = 0;

        // 2. 统计子数组长度，默认给个最大长度，因为我们要取最小长度。每次都将最小的带过来
        int len = nums.length + 1;

        // 3. 开始滑动窗口，左边界能动
        while (l < nums.length){

            // 4. 如果窗口和小于s,滑动右边界；如果窗口和大于s，滑动左边界
            if (r + 1 < nums.length && sum < s) {
                sum += nums[++r];
            }else{
                sum -= nums[l++];
            }

            // 5. 如果当前窗口满足条件，那么看看大小。
            if (sum >= s) {
                len = min(len, r-l+1);
            }

        }


        // 6. 如果没有找到有效窗口，就返回0
        if (len == nums.length + 1) {
            return 0;
        }

        return len;

    }
}
