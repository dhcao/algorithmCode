package leetQuestion.sort;

/**
 * 给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
 *
 * 此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
 *
 * 注意:
 * 不能使用代码库中的排序函数来解决这道题。
 *
 * 示例:
 *
 * 输入: [2,0,2,1,1,0]
 * 输出: [0,0,1,1,2,2]
 * 进阶：
 *
 * 一个直观的解决方案是使用计数排序的两趟扫描算法。
 * 首先，迭代计算出0、1 和 2 元素的个数，然后按照0、1、2的排序，重写当前数组。
 * 你能想出一个仅使用常数空间的一趟扫描算法吗？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sort-colors
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 *
 * @Author: dhcao
 * @Version: 1.0
 */
public class SortColors {

    public static void main(String[] args) {

        final int[] ints = sortColors(new int[]{2, 0, 2, 1, 1, 0});

        for (int i = 0; i < ints.length; i++) {
            System.out.print(ints[i] + " " );
        }
    }


    /**
     * 解法一：统计o的个数，1的个数，2的个数
     * 这就是传说中的计数排序...数组count下标表示被计数的值，下标对应的数组值为计数结果。
     *
     * 这个击败了100%的...
     * @param nums
     */
    public static int[] sortColors(int[] nums) {

        // 下标表示颜色，数量统计
        int[] count = new int[3];

        for(int i = 0; i < nums.length; i ++){
            if (nums[i] == 0) {
                count[0] ++;
            }
            if (nums[i] == 1) {
                count[1] ++;
            }
            if (nums[i] == 2) {
                count[2] ++;
            }
        }

        int index = 0;
        for (int i = 0; i < count.length; i++) {
            int num = count[i];
            for (int j = 0; j < num; j++) {
                nums[index ++] = i;
            }
        }


        return nums;
    }
}
