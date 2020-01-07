package leetQuestion.stringAndSubString.maxSubPalindrome;

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
public class Palindrome {

    public static void main(String[] args) {
        String str = "abb";
        System.out.println(longestPalindrome(str));
    }

    /**
     * 暴力破解是在直接从字符串的第一个开始，遍历所有可能。这种做法显然很慢，如果提交在leetcode上，我就出现了超出时间限制。
     * 但是这个解法是没有问题的，遍历所有子串。
     *
     * 换一种思路：
     *
     * - 还是先定义tmp字符串来存储回文；
     *
     * - 我们先遍历所有的长度为2的子串（长度为1的就是单个字符），在发现第一个回文时停止！，
     *      由于我们正在遍历的所有子串长度均为2，再多的回文串，长度也只是2，所以我们只取第一个。
     *
     * - 然后遍历长度为3的子串，取第一个回文，直接替换tmp，因为tmp之前存储的是长度为2的。
     * - 遍历到最后，长度为n
     * @param s
     * @return
     */
    public static String longestPalindrome(String s){

        if (s.length() == 0 || s.length() == 1) {
            return s;
        }

        // 临时空间存储回文
        String tmp = s.substring(0,1);
        int len = 2;
        int i = 0, j;
        do{
            j = i+ len;
            String subStr = s.substring(i, j);


            if (isPalindrome(subStr)) {
                tmp = subStr;
                i = 0;
                len ++ ;
            }else if(j == s.length()){
                i = 0;
                len ++ ;
            }else{
                i ++;
                j ++;
            }

        }while(j <= s.length() && len <= s.length());

        return tmp;
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
