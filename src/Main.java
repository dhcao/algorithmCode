import java.util.Scanner;

/**
 * @Author: dhcao
 * @Version: 1.0
 */
public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()) {

            String str1 = sc.next();
            String str2 = sc.next();

            System.out.println(doGetMult(str1,str2));
        }

    }

    /**
     * 直接模拟乘法运算
     * @param str1
     * @param str2
     * @return
     */
    private static String doGetMult(String str1, String str2) {

        // 如果其中有一个为0，则直接返回为0
        if (str1.length() == 1 && Integer.valueOf(str1) == 0) {
            return "0";
        }
        if (str2.length() == 1 && Integer.valueOf(str2) == 0) {
            return "0";
        }

        // 使用数组来保存结果；
        Integer[] result = new Integer[str1.length() + str2.length()];
        // 位数记号
        int offset = result.length - 1;

        // 乘法运算，逐个计算并相加，注意进位
        for (int i = str2.length() - 1; i >= 0 ; i--) {

            // 每次相乘，都要保留中间结果。
            Integer[] tmp = new Integer[str1.length() + 1];
            Integer num2 = Integer.valueOf(str2.substring(i, i + 1));

            // 进位标记
            int flag1 = 0;

            // 开始相乘
            int t = tmp.length - 1;
            for (int j = str1.length() - 1; j >= 0 ; j--) {

                Integer num1 = Integer.valueOf(str1.substring(j, j + 1));
                int mul = num1 * num2 + flag1;

                flag1 = mul / 10;
                tmp[t--] = mul % 10;
            }

            tmp[t] = flag1;

            // 相加
            int flag2 = 0;
            int h = offset;
            for (int j = tmp.length - 1; j >=0 ; j--,h--) {
                Integer numResult = result[h] == null ? 0 : result[h];
                Integer numTmp = tmp[j];

                int mul = numResult + numTmp + flag2;

                flag2 = mul / 10;
                result[h] = mul % 10;
            }

            offset --;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < result.length; i++) {
            sb.append(result[i]);
        }
        return sb.toString().replaceFirst("^0*", "");
    }
}
