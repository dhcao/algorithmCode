package questions;

import java.util.Scanner;

/**
 *
 * 链接：https://www.nowcoder.com/questionTerminal/0f0badf5f2204a6bb968b0955a82779e?answerType=1&f=discussion
 * 来源：牛客网
 *
 * 有两个用字符串表示的非常大的大整数,算出他们的乘积，也是用字符串表示。不能用系统自带的大整数类型。
 *
 * 输入描述:
 * 空格分隔的两个字符串，代表输入的两个大整数
 *
 *
 * 输出描述:
 * 输入的乘积，用字符串表示
 * 示例1
 * 输入
 * 72106547548473106236 982161082972751393
 * 输出
 * 70820244829634538040848656466105986748
 *
 *
 * @Author: dhcao
 * @Version: 1.0
 */
public class Main {
    public static String getResult(String str1, String str2){

        // 边界1:为“”；
        if(str1 == "" || str2 == ""){
            return null;
        }

        // 边界2:为“0”
        if(str1 == "0" || str2 == "0"){
            return "0";
        }

        // 总结果
        Integer[] result = new Integer[str1.length() + str2.length()];
        int offset = result.length - 1;

        // 以第二个字符串为乘数，直接做乘法
        for (int i = str2.length() - 1; i >=0; i--) {

            Integer num2 = Integer.valueOf(str2.substring(i,i + 1));

            // 中间计算结果
            Integer[] tmp = new Integer[str1.length() +1];
            // 进位标记
            int flag1 = 0;

            int x = tmp.length - 1;
            for (int j = str1.length() - 1; j >=0; j--) {

                Integer num1 = Integer.valueOf(str1.substring(j, j + 1));
                Integer mul = num1 * num2 + flag1;

                flag1 = mul / 10;
                tmp[x--] = mul % 10;
            }

            tmp[x] = flag1;

            // 将总结果于中间结果相加,进位标记flag2
            int flag2 = 0;
            for (int j = tmp.length - 1,h = offset; j >= 0; j--, h--) {
                int numh = result[h] == null? 0:result[h];
                int mul = tmp[j] + numh + flag2;

                flag2 = mul / 10;
                result[h] = mul % 10;
            }

            offset --;
        }

        // 返回
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < result.length; i++) {
            sb.append(result[i]);
        }

        return sb.toString();
    }


    public static void main(String[] args){


        Scanner scanner = new Scanner(System.in);
        final String str1 = scanner.next();
        System.out.println(str1);
        final String str2 = scanner.next();
        System.out.println(str2);


//        String str1 = "72106547548473106236";
//        String str2 = "982161082972751393";

        System.out.print(getResult(str1, str2));
    }
}
