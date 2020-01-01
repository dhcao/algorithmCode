package maxSubPalindrome;

/**
 * 最长回文字串
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 *
 * 示例 1：
 *
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 * 示例 2：
 *
 * 输入: "cbbd"
 * 输出: "bb"
 *
 * @Author: dhcao
 * @Version: 1.0
 */
public class Palindrome2 {

    public static void main(String[] args) {
        System.out.println(longestPalindrome("babad"));
    }

    public static String longestPalindrome(String s){

        if (s.length() == 0 || s.length() == 1) {
            return s;
        }

        // 1. 先判断s本身是否是回文，如果是，则校验完成。
        if (isPalindrome(s)) {
            return s;
        }

        // 2. 构建一个固定窗口，窗口从i 到 j，窗口大小是s到长度-1（因为s本身已经校验过了）。
        int len = s.length() - 1;
        int i = 0;
        int j ;
        do{
            j = i + len;
            String subStr = s.substring(i, j);
            if (isPalindrome(subStr)) {
                return subStr;
            }
            else if(j == s.length()){
                len --;
                i = 0;
            }else{
                i ++;
                j ++;
            }

        }while(len > 0);

        return s;
    }

    /**
     * 判断一个字符串是否是回文，考虑到效率，我们自己写这个算法；
     *
     * 如果是商业应用，可以这么做：
     * 1 将字符串倒置，String _str = new StringBuilder(str).reverse().toString();
     * 2 equals比较str和_str,如果相等，则是回文
     * @param str
     * @return
     */
    public static boolean isPalindrome(String str){

        final char[] chars = str.toCharArray();
        for (int i = 0, j = chars.length - 1; i < j; i++,j--) {
            if (chars[i] != chars[j]) {
                return false;
            }
        }

        return true;
    }
}
