package leetQuestion.addIntFromLinked;

/**
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 *
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 *
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 *
 * 示例：
 *
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-two-numbers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @Author: dhcao
 * @Version: 1.0
 */
public class AddInt {
    public static void main(String[] args) {

    }


    /**
     * 执行用时 :2 ms, 在所有 Java 提交中击败了99.96%的用户
     * 内存消耗 :44.4 MB, 在所有 Java 提交中击败了86.06%的用户
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1 == null ){
            return l2;
        }

        if(l2 == null ){
            return l1;
        }

        // 进位标记
        boolean flag = false;

        int val = 0;
        ListNode result = new ListNode(0);
        ListNode y = result;
        while(l1 != null || l2 != null){

            if(l2 != null && l1 != null){

                val = l1.val + l2.val;
                if(flag){
                    val = val + 1;
                    flag = false;
                }

                if(val >= 10){
                    val = val % 10;
                    flag = true;
                }

                result.next = new ListNode(val);
                l1 = l1.next;
                l2 = l2.next;
                result = result.next;
            }else if(l1 != null){
                val = l1.val;
                if(flag){
                    val = val + 1;
                    flag = false;
                }

                if(val >= 10){
                    val = val % 10;
                    flag = true;
                }

                result.next = new ListNode(val);
                l1 = l1.next;
                result = result.next;
            }else{
                val = l2.val;
                if(flag){
                    val = val + 1;
                    flag = false;
                }

                if(val >= 10){
                    val = val % 10;
                    flag = true;
                }

                result.next = new ListNode(val);
                l2 = l2.next;
                result = result.next;
            }

        }

        if(flag){
            result.next = new ListNode(1);
        }
        return y.next;
    }
}
