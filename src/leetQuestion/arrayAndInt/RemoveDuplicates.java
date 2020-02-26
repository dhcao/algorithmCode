package leetQuestion.arrayAndInt;

import java.util.Arrays;

/**
 *
 * 给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素最多出现两次，返回移除后数组的新长度。
 *
 * 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
 *
 * 示例 1:
 *
 * 给定 nums = [1,1,1,2,2,3],
 *
 * 函数应返回新长度 length = 5, 并且原数组的前五个元素被修改为 1, 1, 2, 2, 3 。
 *
 * 你不需要考虑数组中超出新长度后面的元素。
 * 示例 2:
 *
 * 给定 nums = [0,0,1,1,1,1,2,3,3],
 *
 * 函数应返回新长度 length = 7, 并且原数组的前五个元素被修改为 0, 0, 1, 1, 2, 3, 3 。
 *
 * 你不需要考虑数组中超出新长度后面的元素。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @Author: dhcao
 * @Version: 1.0
 */
public class RemoveDuplicates {

    /**
     * 执行用时 :1 ms, 在所有 Java 提交中击败了99.67% 的用户
     * 内存消耗 :41.4 MB, 在所有 Java 提交中击败了5.23% 的用户
     * @param nums
     * @return
     */
    public static int removeDuplicates(int[] nums) {

        if (nums.length <= 2) {
            return nums.length;
        }

        int j = 2;
        for (int i = 0; i < nums.length; i++) {

            if (j == nums.length) {
                return j;
            }

            // 如果nums[j]不满足新数组条件，则停止滑动
            if (nums[j] > nums[j - 1] || nums[j] > nums[j - 2]) {
                j ++;
                continue;
            }

            if (nums[i] > nums[j] && nums[i] > nums[j - 2]) {
                int tmp = nums[j];
                nums[j] = nums[i];
                nums[i] = tmp;
                j ++;
            }

        }

        return j;
    }

    public static void main(String[] args) {
//        int[] nums = {0,0,1,1,1,1,2,3,3};
//        int[] nums = {1,1,1,2,2,3};
        int[] nums = {0,0,1,1,1,1,2,2,2,4};

        System.out.println(removeDuplicates(nums));

        Arrays.stream(nums).forEach(num -> System.out.print(" " + num));
    }
}
