package leetQuestion.arrayAndInt;

/**
 * 给定一个整数，将其转化为7进制，并以字符串形式输出。
 *
 * 示例 1:
 *
 * 输入: 100
 * 输出: "202"
 * 示例 2:
 *
 * 输入: -7
 * 输出: "-10"
 * 注意: 输入范围是 [-1e7, 1e7]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/base-7
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 *
 * @Author: dhcao
 * @Version: 1.0
 */
public class ConvertToBase7 {

    public static void main(String[] args) {

        System.out.println(convertToBase7(100));
    }

    public static String convertToBase7(int num) {

        // 不需要转换的情况
        if (-7 < num  && num < 7) {
            return num + "";
        }

        int _num = num;
        if (num < 0){
            _num = -1 * num;
        }

        // 被除数、余数和除数
        int sqrt;
        int calResult;

        StringBuilder result = new StringBuilder();

        do{
            calResult = _num/7;
            sqrt = _num % 7;
            _num = calResult;
            result = result.append(sqrt);
        }while(calResult != 0);

        // 反转字符结果，并配上符号
        result = result.reverse();

        if (num < 0) {
            return "-" + result.toString();
        }

        return result.toString();
    }
}
