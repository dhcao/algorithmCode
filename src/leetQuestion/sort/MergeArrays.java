package leetQuestion.sort;

import java.util.Arrays;

/**
 * 给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 num1 成为一个有序数组。
 *
 *  
 *
 * 说明:
 *
 * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。
 * 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
 *  
 *
 * 示例:
 *
 * 输入:
 * nums1 = [1,2,3,0,0,0], m = 3
 * nums2 = [2,5,6],       n = 3
 *
 * 输出: [1,2,2,3,5,6]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/merge-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @Author: dhcao
 * @Version: 1.0
 */
public class MergeArrays {


    /**
     * 解法一：如果对归并排序比较了解，可以知道，这就是归并排序的"合并"步骤。
     *
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     * @return
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {

        // 1. 需要三个下标来记录，2个旧数组和一个新数组的位置。将旧的数组拷贝一份
        int[] ints = Arrays.copyOfRange(nums1, 0, m+1);

        int index1 = 0; // 旧数组1的下标
        int index2 = 0; // 旧数组2的下标
        int index3 = 0; // 新数组的下标

        while(index1 < m && index2 < n){
            if (ints[index1] < nums2[index2]) {
                nums1[index3 ++] = ints[index1 ++];
            }else{
                nums1[index3 ++] = nums2[index2 ++];
            }
        }

        // 2. 如果数组1 没有计算结束，那就将数组1 复制到后面
        while (index1 < m){
            nums1[index3 ++] = ints[index1 ++];
        }

        while (index2 < n){
            nums1[index3 ++] = nums2[index2 ++];
        }

    }
}
