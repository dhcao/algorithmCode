package isPalindrome;

/**
 *
 * 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 *
 * 示例 1:
 *
 * 输入: 121
 * 输出: true
 * 示例 2:
 *
 * 输入: -121
 * 输出: false
 * 解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
 * 示例 3:
 *
 * 输入: 10
 * 输出: false
 * 解释: 从右向左读, 为 01 。因此它不是一个回文数。
 * 进阶:
 *
 * 你能不将整数转为字符串来解决这个问题吗？
 *
 * @Author: dhcao
 * @Version: 1.0
 */
public class Palindrome {

    public static void main(String[] args) {

        System.out.println(ispalindromeInt2(11));
    }

    /**
     * 解法一：如果将数字转为字符串，那就太简单了。
     * @param x
     * @return
     */
    public static boolean ispalindromeInt(int x) {

        if(x < 0) {
            return false;
        }

        if(x < 10){
            return true;
        }

        String xx = x + "";
        for (int i = 0, j = xx.length() - 1 ; i < j; i++,j--) {
            if (xx.charAt(i) != xx.charAt(j)) {
                return false;
            }
        }

        return true;
    }

    /**
     * 如果不转为字符串，我们将如何判断？
     * 解法二：反转一半的数字
     * @param x
     * @return
     */
    public static boolean ispalindromeInt2(int x){

        if(x < 0) {
            return false;
        }

        if(x < 10){
            return true;
        }

        if (x % 10 == 0) {
            return false;
        }

        // 如果是12321
        int res = 0;
        int total = 0;
        do{
            int less = x % 10;
            total = total * 10 + less;
            res ++;
            x = x / 10;

        }while(x > total);

        if (total == x) {
            return true;
        }

        if (total/10 == x) {
            return true;
        }

        return false;
    }
}
