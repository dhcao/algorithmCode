package leetQuestion.sort;

/**
 *
 * 在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 *
 * 示例 1:
 *
 * 输入: [3,2,1,5,6,4] 和 k = 2
 * 输出: 5
 * 示例 2:
 *
 * 输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
 * 输出: 4
 * 说明:
 *
 * 你可以假设 k 总是有效的，且 1 ≤ k ≤ 数组的长度。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/kth-largest-element-in-an-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 *
 * @Author: dhcao
 * @Version: 1.0
 */
public class FindKthLargest {

    public static void main(String[] args) {
        System.out.println(findKthLargest(new int[]{3,2,1,5,6,4}, 2));
    }

    /**
     * 解法一：理所当然的排序，我们写个插入排序吧，好久没写排序了。
     * 这个放在leetcode上执行下，发现时间效果不太行；
     *
     * 执行用时 :110 ms, 在所有 Java 提交中击败了5.01%的用户
     * 内存消耗 :40.9 MB, 在所有 Java 提交中击败了5.09%的用户
     *
     * @param nums
     * @param k
     * @return
     */
    public static int findKthLargest(int[] nums, int k) {

        if (nums.length == 0) {
            throw new IllegalArgumentException(" the length of array can not be zero");
        }

        if (nums.length == 1) {
            return nums[0];
        }

        // 开始插入排序；；
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j > 0 ; j--) {

                if (nums[j] > nums[j - 1]) {
                    int tmp = nums[j];
                    nums[j] = nums[j-1];
                    nums[j-1] = tmp;
                }
                else{
                    break;
                }
            }
        }

        return nums[k-1];
    }

    /**
     * 我们换个思路，寻找第k大数...在《数据结构与算法》中，告诉你，用堆也可以实现，但是还要组装一个堆；；
     * 虽然堆跟数组的关系密切，但是我还是觉得不好用。这里都分类到排序了，还是优先考虑排序。
     *
     * 解法二：根据我们在快速排序中选择的二分策略。选择一个中值s，s左边的数比他小，右边的数都比他大！
     * 第k大的数字，那么右边必定有k-1个数组比他大。
     *
     * .....好久没写快排序了，先写个快排，再改一改。
     * @param nums
     * @param k
     * @return
     */
    public static int findKthLargest1(int[] nums, int k) {

        return 0;
    }


}
