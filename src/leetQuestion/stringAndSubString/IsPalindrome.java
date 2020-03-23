package leetQuestion.stringAndSubString;

/**
 *
 * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
 *
 * 说明：本题中，我们将空字符串定义为有效的回文串。
 *
 * 示例 1:
 *
 * 输入: "A man, a plan, a canal: Panama"
 * 输出: true
 * 示例 2:
 *
 * 输入: "race a car"
 * 输出: false
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-palindrome
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 *
 * @Author: dhcao
 * @Version: 1.0
 */
public class IsPalindrome {

    public static void main(String[] args) {

    }


    /**
     * 解法：对撞指针
     * 这个解法还挺简单的，就双指针对撞就行了。
     *
     * 执行用时 :2 ms, 在所有 Java 提交中击败了99.90%的用户
     * 内存消耗 :39.1 MB, 在所有 Java 提交中击败了11.29%的用户
     * @param s
     * @return
     */
    public static boolean isPalindrome(String s) {

        if(s.length() == 0 || s.length() == 1){
            return true;
        }

        char[] ca = s.toCharArray();
        int l = 0;
        int r = ca.length-1;

        while(l < r){

            if(!isValid(ca[l])){
                l ++;
                continue;
            }
            if(!isValid(ca[r])){
                r --;
                continue;
            }

            if(ca[l] == ca[r] || (ca[l] - ca[r] == 32 && ca[r] > 58) || (ca[l] - ca[r] == -32 && ca[l] > 58)){
                l++;
                r--;
                continue;
            }else{
                return false;
            }

        }

        return true;
    }

    public static boolean isValid(char c){

        // 数字合法
        if(c > 47 && c < 58){
            return true;
        }

        // 大写字母
        if(c > 64 && c < 91){
            return true;
        }

        // 小写字母
        if(c > 96 && c <123){
            return true;
        }

        return false;
    }

}
