package com.leammin.leetcode.medium;

import java.util.HashMap;
import java.util.Map;

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
 * @author Leammin
 * @date 2020-04-10
 */
public interface FractionToRecurringDecimal {
    String fractionToDecimal(int numerator, int denominator);

    class Solution implements FractionToRecurringDecimal {

        @Override
        public String fractionToDecimal(int numerator, int denominator) {
            if (numerator == 0) {
                return "0";
            }
            boolean neg = numerator > 0 ^ denominator > 0;
            long num = numerator > 0 ? numerator : -(long) numerator;
            long den = denominator > 0 ? denominator : -(long) denominator;
            long integer = num / den;
            long remainder = num - integer * den;
            if (remainder == 0) {
                return (neg ? "-" : "") + integer;
            }
            Map<Long, Integer> remainders = new HashMap<>();
            StringBuilder builder = new StringBuilder()
                    .append((neg ? "-" : ""))
                    .append(integer)
                    .append(".");
            long tmp = remainder;
            Integer start;
            while ((start = remainders.get(tmp)) == null) {
                remainders.put(tmp, builder.length());
                while ((tmp *= 10) < den) {
                    builder.append(0);
                }
                builder.append(tmp / den);
                if ((tmp %= den) == 0) {
                    return builder.toString();
                }
            }
            return builder.insert(start, "(").append(')').toString();
        }
    }
}
