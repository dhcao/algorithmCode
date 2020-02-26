package questions;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 *
 * @Author: dhcao
 * @Version: 1.0
 */
public class Wallet {

    public static void main(String[] args) {

        final BigDecimal[] doubles = getMoney(new BigDecimal("97.02"), 9);

        BigDecimal sum = BigDecimal.ZERO;
        for (int i = 0; i < doubles.length; i++) {
            System.out.println(doubles[i]);
            sum = sum.add(doubles[i]);
        }
        System.out.println("sum:" + sum);
    }

    /**
     * 题目：
     * 给定一定的金额，一定的人数，保证每个人都能随机获得一定的金额。比如100元的红包，10个人抢，每人分得一些金额。
     * 约束条件为，最佳手气金额不能超过最大金额的90%
     *
     * 分析：根据题目，简单理解为n个人分amount。
     * 考虑到抢红包到随机性，并不对随机值作任何处理，不管多少人。
     *
     * 前面获取第红包数量将影响到后面到余额，假设前三个人获取红包共99.99，将导致后面7个人只有0.01可供分配。
     * 为保证每人至少分配0.01。我们先给每人默认分配0.01。
     *
     *
     * 设计：
     * a 对金额的计算处理使用BigDecimal更加准确，构建BigDecimal对象时用字符串作为构造参数而不是浮点数。
     * b 为防止手气最佳超过最大金额对90%。进行如下处理：
     *  1. 实现分配n-1个人对金额。
     *  2. 判断剩余金额是否超过最大金额对90%。如果超过，则扣除10%随机加在前面任意一个人身上
     *
     * @param amount 金额
     * @param n 抢红包人数
     * @return 每个人抢到红包到金额
     */
    public static BigDecimal[] getMoney(BigDecimal amount, int n){

        // 定义个数组用来返回
        BigDecimal[] result = new BigDecimal[n];

        // 红包余额 = 总金额 - n * 0.01
        BigDecimal less = amount.subtract(BigDecimal.valueOf((n*0.01)));
        BigDecimal money ;
        BigDecimal highLimit = amount.multiply(new BigDecimal("0.9")).setScale(2,BigDecimal.ROUND_CEILING);

        // 我们只对前（n-1）个人进行分配
        for (int i = 0; i < n-1; i++) {

            // 直接使用random()来模拟随机值，如果得到0，则丢弃。
            BigDecimal random ;
            do{
                random = BigDecimal.valueOf(Math.random()).setScale(2,RoundingMode.CEILING);
                money = less.multiply(random).setScale(2, RoundingMode.CEILING);
            }while (money.compareTo(highLimit) >= 0);

            result[i] = money.add(new BigDecimal("0.01"));
            less = less.subtract(money).setScale(2, RoundingMode.CEILING);

        }

        // 循环结束，剩余金额还需要分配给最后一个人，此时进行判断，如果大于90%，直接拿出10%给第一个人。
        if (less.compareTo(amount.multiply(new BigDecimal("0.9")).setScale(2, RoundingMode.CEILING)) >=0) {
            money = amount.multiply(new BigDecimal("0.1")).setScale(2, RoundingMode.CEILING);
            result[0] = result[0].add(money).setScale(2, RoundingMode.CEILING);
            less = less.subtract(money);
        }

        result[n-1] = less.add(new BigDecimal("0.01"));

        return result;
    }

}
