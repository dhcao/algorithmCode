package compressString;

import java.util.Scanner;

/**
 * 描述：输入一系列字符串S，要求构建他的索引字符串和索引值，索引格式如下：
 *     例如输入words = [“time”,”me”,”bell”]，
 *     得到索引字符串  time#bell#
 *     得到索引值 [0,2,5]。
 * 以索引值为起点，在索引字符串中开始读取直到“#”结束。例如从索引0开始直到#得到time，从索引2开始直到#得到me，从索引5开始直到#得到bell。
 * 求，最小索引字符串长度。
 *
 * 输入：time,me,bell
 * 输出：10
 *
 * @Author: dhcao
 * @Version: 1.0
 */
public class CompressString {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String wordsStr= new String();

        if (sc.hasNext()) {
            wordsStr = wordsStr + sc.next();
        }

        String[] words = wordsStr.split(",");
        System.out.println(ssss(words));

    }

    public static int ssss(String[] strs){

        if (strs.length == 1) {
            return strs[0].length()+1;
        }

        String indexStr = strs[0] + "#";

        for (int i = 1; i < strs.length; i++) {

            boolean flag = false;
            String subStr = strs[i];
            int len = subStr.length();

            if (len == 0) {
                continue;
            }

            String[] index = indexStr.split("#");
            for (int j = 0; j < index.length; j++) {
                String jj = index[j];
                if (len > jj.length()) {
                    continue;
                }

                String sub = jj.substring(jj.length() - len);
                if (sub.equals(subStr)) {
                    flag = true;
                    break;
                }
            }

            if (!flag) {
                indexStr = indexStr + subStr + "#";
            }

        }

        return indexStr.length();
    }
}
