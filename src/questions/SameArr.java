package questions;

import java.util.HashSet;
import java.util.Set;

public class SameArr {

    public static void main(String[] args) {

        int[] a = new int[]{1,7,9,9,9,9,9};
        int[] b = new int[]{5,6,8,9,10,12};

        final Set<Integer> samepart = samepart(a, b);
        samepart.forEach(integer -> System.out.println(integer));

    }

    /**
     * 解如果两数组相交，则从相交位置开始，统计到数组中长度较短的数组结束。
     * 用set去重
     * @param a
     * @param b
     * @return
     */
    public static Set<Integer> samepart(int[] a, int[] b){

        if (a.length == 0 || b.length == 0) {
            return new HashSet<>();
        }

        // 1. 如果不相交则直接返回
        if (a[0] > b[b.length - 1] || b[0] > a[a.length - 1]) {
            return new HashSet<>();
        }

        // 2. 边界检测
        Set<Integer> resultSet=new HashSet<Integer>();
        for (int i = 0, s = i; i < a.length && s < b.length; i++) {

            // 如果数组a的值比数组b大，则滚动数组b的指针。
            while (a[i] > b[s]) {
                s++;
            }

            // 如果相同就放入set
            if (a[i] == b[s]) {
                resultSet.add(b[s++]);
            }

            // 如果数组a没有达到
            while (i < (a.length - 1) && a[i] == a[i + 1]) {
                i++;
            }
        }

        return resultSet;

    }

}
