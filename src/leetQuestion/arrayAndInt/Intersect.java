package leetQuestion.arrayAndInt;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 给定两个数组，编写一个函数来计算它们的交集。
 *
 * 示例 1:
 *
 * 输入: nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出: [2,2]
 * 示例 2:
 *
 * 输入: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出: [4,9]
 * 说明：
 *
 * 输出结果中每个元素出现的次数，应与元素在两个数组中出现的次数一致。
 * 我们可以不考虑输出结果的顺序。
 * 进阶:
 *
 * @Author: dhcao
 * @Version: 1.0
 */
public class Intersect {

    public int[] intersect(int[] nums1, int[] nums2) {

        if (nums1.length == 0 || nums2.length == 0) {
            return new int[0];
        }

        Map<Integer, Integer> set = new HashMap<>(nums1.length);
        Map<Integer, Integer> map = new HashMap<>(nums1.length);
        int size = 0;

        for (int i = 0; i < nums1.length; i++) {
            set.put(nums1[i],set.getOrDefault(nums1[i], 0) + 1);
        }

        for (int i = 0; i < nums2.length; i++) {
            if (set.containsKey(nums2[i])) {
                size ++;
                map.put(nums2[i], map.getOrDefault(nums2[i], 0) + 1);
            }
        }

        int[] result = new int[size];
        int index = 0;

        for (Integer i : map.keySet()) {

            int num = map.get(i) < set.get(i) ? map.get(i) : set.get(i);
            for (int j = 0; j < num; j++) {
                result[index++] = i;
            }
        }

        return Arrays.copyOfRange(result, 0, index-1);
    }
}
