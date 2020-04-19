package com.leammin.leetcode.undone.medium;

/**
 * 166. 分数到小数
 * 
 * <p>给定两个整数，分别表示分数的分子&nbsp;numerator 和分母 denominator，以字符串形式返回小数。</p>
 * 
 * <p>如果小数部分为循环小数，则将循环的部分括在括号内。</p>
 * 
 * <p><strong>示例 1:</strong></p>
 * 
 * <pre><strong>输入:</strong> numerator = 1, denominator = 2
 * <strong>输出:</strong> &quot;0.5&quot;
 * </pre>
 * 
 * <p><strong>示例&nbsp;2:</strong></p>
 * 
 * <pre><strong>输入:</strong> numerator = 2, denominator = 1
 * <strong>输出:</strong> &quot;2&quot;</pre>
 * 
 * <p><strong>示例&nbsp;3:</strong></p>
 * 
 * <pre><strong>输入:</strong> numerator = 2, denominator = 3
 * <strong>输出: </strong>&quot;0.(6)&quot;
 * </pre>
 * 
 * 
 * @author Leammin
 * @date 2020-04-10
 */
public interface FractionToRecurringDecimal {
    String fractionToDecimal(int numerator, int denominator);

    class Solution implements FractionToRecurringDecimal {

        @Override
        public String fractionToDecimal(int numerator, int denominator) {
            int integer = numerator / denominator;
            int remainder = numerator - integer * denominator;
            if (remainder == 0) {
                return String.valueOf(integer);
            }
            StringBuilder builder = new StringBuilder();
            int tmp = remainder * 10;
            while (true) {
                builder.append(tmp / denominator);
                if (tmp >= denominator) {
                    tmp %= denominator;
                }
                if (tmp == remainder || tmp == 0) {
                    break;
                }
                tmp *= 10;
            }
            if (tmp != 0) {
                return integer + ".(" + builder + ")";
            } else {
                return integer + "." + builder;
            }
        }
    }
}
