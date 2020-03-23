package leetQuestion.arrayAndInt;

/**
 * 11:盛最多水容器
 *
 * 给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 *
 * 说明：你不能倾斜容器，且 n 的值至少为 2。
 *

 *
 * 示例：
 *
 * 输入：[1,8,6,2,5,4,8,3,7]
 * 输出：4
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/container-with-most-water
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @Author: dhcao
 * @Version: 1.0
 */
public class MaxArea {

    /**
     * 解法：对撞指针
     *
     * 执行用时 :3 ms, 在所有 Java 提交中击败了92.11%的用户
     * 内存消耗 :41.8 MB, 在所有 Java 提交中击败了5.00%的用户
     *
     * @param height
     * @return
     */
    public int maxArea(int[] height) {

        // 对撞指针完事儿
        int l = 0;
        int r = height.length - 1;
        int s = 0;

        while(l < r){
            int len = r - l;
            int h = height[l] < height[r] ? height[l] : height[r];

            int sc = len * h;
            s = sc > s? sc: s;

            if(h == height[l]){
                l ++;
            }else{
                r--;
            }
        }

        return s;
    }
}
