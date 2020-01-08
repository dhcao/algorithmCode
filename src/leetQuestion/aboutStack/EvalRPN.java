package leetQuestion.aboutStack;

import java.util.Stack;

/**
 * 逆波兰表达式：
 * 题目描述
 * 根据逆波兰表示法，求表达式的值。
 *
 * 有效的运算符包括 +, -, *, / 。每个运算对象可以是整数，也可以是另一个逆波兰表达式。
 *
 * 说明：
 *
 * 整数除法只保留整数部分。
 * 给定逆波兰表达式总是有效的。换句话说，表达式总会得出有效数值且不存在除数为 0 的情况。
 * 示例 1：
 *
 * 输入: ["2", "1", "+", "3", "*"]
 * 输出: 9
 * 解释: ((2 + 1) * 3) = 9
 * 示例 2：
 *
 * 输入: ["4", "13", "5", "/", "+"]
 * 输出: 6
 * 解释: (4 + (13 / 5)) = 6
 * 示例 3：
 *
 * 输入: ["10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"]
 * 输出: 22
 * 解释:
 *   ((10 * (6 / ((9 + 3) * -11))) + 17) + 5
 * = ((10 * (6 / (12 * -11))) + 17) + 5
 * = ((10 * (6 / -132)) + 17) + 5
 * = ((10 * 0) + 17) + 5
 * = (0 + 17) + 5
 * = 17 + 5
 * = 22
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/evaluate-reverse-polish-notation
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author caodahuan
 * @version 2020/1/8
 */
public class EvalRPN {
    public static void main(String[] args) {

        String[] strs = {"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"};
        System.out.println(evalRPN2(strs));
    }

    /**
     * 逆波兰是一种数据处理方式；本题核心在2点
     * 1. 逆波兰表达式是啥
     * 2. 栈（Stack）的用法
     *
     * 使用栈来处理逆波兰：
     * 当遇到数字时，将数字入栈，遇到运算符号时，出栈2个数字并使用运算符，将结果入栈。
     * 直到最后，栈中数据为结果。
     *
     *
     * result：
     * 执行用时 :9 ms, 在所有 Java 提交中击败了68.37%的用户
     * 内存消耗 :37.1 MB, 在所有 Java 提交中击败了88.10%的用户
     * @param  tokens 字符串数组
     * @author caodahuan
     * @date 2020/1/8 
     * @return int 
     */
    public static int evalRPN(String[] tokens){

        // 先处理特殊
        if (tokens.length == 0) {
            return 0;
        }

        Stack<Integer> stack = new Stack<>();
        // 使用栈来处理逆波兰表达式，由于只有4个运算符，我们简单粗暴就可以处理
        for (String str : tokens) {
            if ("+".equals(str)) {
                stack.push(stack.pop() + stack.pop());
            }else if("-".equals(str)){
                // 减法时，被减数是后出栈的
                Integer subtraction = stack.pop();
                Integer subtracted = stack.pop();
                stack.push(subtracted - subtraction);
            }else if("*".equals(str)){
                stack.push(stack.pop() * stack.pop());
            }else if("/".equals(str)){
                // 除法时，被减数是后出栈的
                Integer dividor = stack.pop();
                Integer dividend = stack.pop();
                stack.push(dividend / dividor);
            }else{
                stack.push(Integer.valueOf(str));
            }
        }

        return stack.pop();
    }

    /**
     * 上面的解法，虽然简单并且有效，但是效率并不能让我满意，算法的意义在于效率。
     * 为了效率，而且不引入其他复杂类，我们自己来用数组做一个栈。
     *
     * result：
     * 执行用时 :5 ms, 在所有 Java 提交中击败了95.10%的用户
     * 内存消耗 :35.8 MB, 在所有 Java 提交中击败了94.13%的用户
     * @param tokens 
     * @author caodahuan
     * @date 2020/1/8
     * @return int 
     */
    public static int evalRPN1(String[] tokens){

        // 使用数组构建我们的栈，好处是根据下标访问贼快！
        Integer[] array = new Integer[tokens.length];
        int index = 0;

        for (int i = 0; i < tokens.length; i++) {
            String curStr = tokens[i];
            if ("+".equals(curStr)) {
                Integer value = (array[-- index] + array[-- index]);
                array[index ++] = value;
            }else if("-".equals(curStr)){
                // 减法时，被减数是后出栈的
                Integer subtraction = array[-- index];
                Integer subtracted = array[-- index];
                array[index ++] = subtracted - subtraction;
            }else if("*".equals(curStr)){
                Integer value = (array[-- index] * array[-- index]);
                array[index ++] = value;
            }else if("/".equals(curStr)){
                // 除法时，被减数是后出栈的
                Integer dividor = array[-- index];
                Integer dividend = array[-- index];
                array[index ++] = (dividend / dividor);
            }else{
                array[index ++] = Integer.valueOf(curStr);
            }
        }

        return array[-- index];
    }

    /**
     * 上面的方法已经达到了我们的目的；那么简单思路没问题，但是效率可以更加优化。
     * 算法的复杂度是固定的O(N)，所以具体的优化，是针对代码。
     *
     * result：
     * 执行用时 :3 ms, 在所有 Java 提交中击败了99.75%的用户
     * 内存消耗 :36 MB, 在所有 Java 提交中击败了92.62%的用户
     * @param tokens
     * @author caodahuan
     * @date 2020/1/8
     * @return int
     */
    public static int evalRPN2(String[] tokens){

        // 使用数组构建我们的栈，好处是根据下标访问贼快！
        int[] array = new int[tokens.length];
        int index = 0;

        for (int i = 0; i < tokens.length; i++) {
            String curStr = tokens[i];
            switch (curStr){
                case "+": array[index -2] += array[index - 1];index --;break;
                case "-": array[index -2] -= array[index - 1];index --;break;
                case "*": array[index -2] *= array[index - 1];index --;break;
                case "/": array[index -2] /= array[index - 1];index --;break;
                default: array[index++] = Integer.valueOf(curStr);
            }
        }

        return array[index - 1];
    }
}
