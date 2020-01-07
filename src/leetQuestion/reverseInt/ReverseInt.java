package leetQuestion.reverseInt;

/**
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 *
 * 示例 1:
 *
 * 输入: 123
 * 输出: 321
 *  示例 2:
 *
 * 输入: -123
 * 输出: -321
 * 示例 3:
 *
 * 输入: 120
 * 输出: 21
 * 注意:
 *
 * 假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−231,  231 − 1]。请根据这个假设，如果反转后整数溢出那么就返回 0。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-integer
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 *
 * @Author: dhcao
 * @Version: 1.0
 */
public class ReverseInt {

    public static void main(String[] args) {
        System.out.println(reverse(1463847412));
    }

    /**
     * 执行用时 : 1 ms , 在所有 Java 提交中击败了100.00%的用户
     * 内存消耗 :33.7 MB, 在所有 Java 提交中击败了79.52%的用户
     * @param x
     * @return
     */
    public static int reverse(int x) {

        if(-10 < x && x < 10){
            return x;
        }

        int result = 0;
        do{
            if(x > 0 && result > Integer.MAX_VALUE/10){
                return 0;
            }
            if(x < 0 && result < Integer.MIN_VALUE/10 ){
                return 0;
            }
            int y = x%10;
            x = x/10;
            result = result * 10 + y;
        }while(x != 0);

        return result;
    }
}
