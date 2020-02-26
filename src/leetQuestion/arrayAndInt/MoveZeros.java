package leetQuestion.arrayAndInt;

import java.util.Arrays;

/**
 *
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 *
 * 示例:
 *
 * 输入: [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 * 说明:
 *
 * 必须在原数组上操作，不能拷贝额外的数组。
 * 尽量减少操作次数。
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/move-zeroes
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @Author: dhcao
 * @Version: 1.0
 */
public class MoveZeros {

    /**
     * 运行结果：（都这样了才击败5.00%的用户，是搞笑么？？？）
     * 执行用时 : 0 ms, 在所有 Java 提交中击败了 100.00% 的用户
     * 内存消耗 : 41.9 MB , 在所有 Java 提交中击败了 5.00% 的用户
     * @param nums
     */
    public static void moveZeroes(int[] nums){

        for (int i = 0,j = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                if (i != j) {
                    nums[j] = nums[i];
                    nums[i] = 0;
                }
                j ++;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {0,1,0,3,12};
        moveZeroes(nums);
        Arrays.stream(nums).forEach(num -> System.out.println(num));
    }
}
