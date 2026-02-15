package com.leammin.leetcode.medium;

import java.util.HashMap;
import java.util.Map;

import com.leammin.leetcode.util.test.AbstractTest;
import com.leammin.leetcode.util.test.ExpectedTestcase;
import com.leammin.leetcode.util.test.Testsuite;

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

    static Testsuite<FractionToRecurringDecimal> testsuite() {
        return Testsuite.<FractionToRecurringDecimal>builder()
                .add(ExpectedTestcase.of(t -> t.fractionToDecimal(1, 2), "0.5"))
                .add(ExpectedTestcase.of(t -> t.fractionToDecimal(2, 1), "2"))
                .add(ExpectedTestcase.of(t -> t.fractionToDecimal(2, 3), "0.(6)"))
                .add(ExpectedTestcase.of(t -> t.fractionToDecimal(4, 333), "0.(012)"))
                .add(ExpectedTestcase.of(t -> t.fractionToDecimal(1, 6), "0.1(6)"))
                .add(ExpectedTestcase.of(t -> t.fractionToDecimal(7, -12), "-0.58(3)"))
                .add(ExpectedTestcase.of(t -> t.fractionToDecimal(-1, -2147483648), "0.0000000004656612873077392578125"))
                .build();
    }


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

class FractionToRecurringDecimalTest extends AbstractTest<FractionToRecurringDecimal> {
}
