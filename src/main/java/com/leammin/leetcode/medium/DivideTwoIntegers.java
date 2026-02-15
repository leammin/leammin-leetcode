package com.leammin.leetcode.medium;

import com.leammin.leetcode.util.test.AbstractTest;
import com.leammin.leetcode.util.test.ExpectedTestcase;
import com.leammin.leetcode.util.test.Testsuite;

/**
 * 29. 两数相除
 *
 * <p>给定两个整数，被除数&nbsp;<code>dividend</code>&nbsp;和除数&nbsp;<code>divisor</code>。将两数相除，要求不使用乘法、除法和 mod 运算符。</p>
 *
 * <p>返回被除数&nbsp;<code>dividend</code>&nbsp;除以除数&nbsp;<code>divisor</code>&nbsp;得到的商。</p>
 *
 * <p><strong>示例&nbsp;1:</strong></p>
 *
 * <pre><strong>输入:</strong> dividend = 10, divisor = 3
 * <strong>输出:</strong> 3</pre>
 *
 * <p><strong>示例&nbsp;2:</strong></p>
 *
 * <pre><strong>输入:</strong> dividend = 7, divisor = -3
 * <strong>输出:</strong> -2</pre>
 *
 * <p><strong>说明:</strong></p>
 *
 * <ul>
 * 	<li>被除数和除数均为 32 位有符号整数。</li>
 * 	<li>除数不为&nbsp;0。</li>
 * 	<li>假设我们的环境只能存储 32 位有符号整数，其数值范围是 [&minus;2<sup>31</sup>,&nbsp; 2<sup>31&nbsp;</sup>&minus; 1]。本题中，如果除法结果溢出，则返回 2<sup>31&nbsp;</sup>&minus; 1。</li>
 * </ul>
 *
 * @author Leammin
 * @date 2019-08-24
 */
public interface DivideTwoIntegers {
    int divide(int dividend, int divisor);

    static Testsuite<DivideTwoIntegers> testsuite() {
        return Testsuite.<DivideTwoIntegers>builder()
                .add(ExpectedTestcase.of(t -> t.divide(10, 3), 3))
                .add(ExpectedTestcase.of(t -> t.divide(24, 8), 3))
                .add(ExpectedTestcase.of(t -> t.divide(Integer.MAX_VALUE, 13), 165191049))
                .add(ExpectedTestcase.of(t -> t.divide(Integer.MAX_VALUE, 1), Integer.MAX_VALUE))
                .add(ExpectedTestcase.of(t -> t.divide(1351, 11), 122))
                .add(ExpectedTestcase.of(t -> t.divide(-11, 2), -5))
                .add(ExpectedTestcase.of(t -> t.divide(-11, 0), Integer.MAX_VALUE))
                .add(ExpectedTestcase.of(t -> t.divide(255, 16), 15))
                .add(ExpectedTestcase.of(t -> t.divide(15, 16), 0))
                .add(ExpectedTestcase.of(t -> t.divide(15, 15), 1))
                .add(ExpectedTestcase.of(t -> t.divide(15, -15), -1))
                .add(ExpectedTestcase.of(t -> t.divide(-15, 15), -1))
                .add(ExpectedTestcase.of(t -> t.divide(15, 1), 15))
                .add(ExpectedTestcase.of(t -> t.divide(3, 12), 0))
                .add(ExpectedTestcase.of(t -> t.divide(Integer.MAX_VALUE, Integer.MIN_VALUE), 0))
                .add(ExpectedTestcase.of(t -> t.divide(Integer.MIN_VALUE, -2), 1073741824))
                .add(ExpectedTestcase.of(t -> t.divide(Integer.MIN_VALUE, 2), -1073741824))
                .add(ExpectedTestcase.of(t -> t.divide(Integer.MIN_VALUE + 2, 2), -1073741823))
                .add(ExpectedTestcase.of(t -> t.divide(Integer.MIN_VALUE, 65536), -32768))
                .add(ExpectedTestcase.of(t -> t.divide(Integer.MIN_VALUE, 4860461), -441))
                .add(ExpectedTestcase.of(t -> t.divide(Integer.MIN_VALUE, 1), Integer.MIN_VALUE))
                .add(ExpectedTestcase.of(t -> t.divide(Integer.MIN_VALUE, -1), Integer.MAX_VALUE))
                .add(ExpectedTestcase.of(t -> t.divide(Integer.MIN_VALUE, 2147473647), -1))
                .add(ExpectedTestcase.of(t -> t.divide(Integer.MIN_VALUE, Integer.MAX_VALUE), -1))
                .add(ExpectedTestcase.of(t -> t.divide(1631631, Integer.MAX_VALUE), 0))
                .add(ExpectedTestcase.of(t -> t.divide(-Integer.MAX_VALUE, Integer.MAX_VALUE), -1))
                .add(ExpectedTestcase.of(t -> t.divide(Integer.MIN_VALUE, Integer.MIN_VALUE), 1))
                .add(ExpectedTestcase.of(t -> t.divide(Integer.MIN_VALUE, 1073741823), -2))
                .add(ExpectedTestcase.of(t -> t.divide(Integer.MIN_VALUE, -1073741823), 2))
                .add(ExpectedTestcase.of(t -> t.divide(Integer.MIN_VALUE, 1073741824), -2))
                .add(ExpectedTestcase.of(t -> t.divide(Integer.MIN_VALUE, -1073741824), 2))
                .add(ExpectedTestcase.of(t -> t.divide(Integer.MIN_VALUE, 1073741825), -1))
                .add(ExpectedTestcase.of(t -> t.divide(Integer.MIN_VALUE, -1073741825), 1))

                .build();
    }


    class Solution implements DivideTwoIntegers {
        @Override
        public int divide(int dividend, int divisor) {
            if (divisor == 0) {
                return Integer.MAX_VALUE;
            }
            if (dividend == divisor) {
                return 1;
            }
            if (dividend == 0 || divisor == Integer.MIN_VALUE) {
                return 0;
            }
            if (dividend == -divisor) {
                return -1;
            }
            if (divisor == 1) {
                return dividend;
            }
            if (divisor == -1) {
                return dividend == Integer.MIN_VALUE ? Integer.MAX_VALUE : -dividend;
            }
            boolean neg  = false;
            if (divisor < 0) {
                divisor = -divisor;
                neg = true;
            }
            if (dividend == Integer.MIN_VALUE) {
                // 被除数是 Integer.MIN_VALUE，直接取相反数会溢出
                // 先让被除数加个被除数的绝对值，再计算除法，最后结果再加/减 1
                return divide(dividend + divisor, neg ? -divisor : divisor) + (neg ? 1 : -1);
            }
            if (dividend < 0) {
                dividend = -dividend;
                neg = !neg;
            }
            if (dividend < divisor) {
                return 0;
            }
            if ((divisor & (divisor - 1)) == 0) {
                // 除数是 2 的次幂
                while ((divisor >>= 1) != 0) {
                    dividend >>= 1;
                }
                return neg ? -dividend : dividend;
            }
            int res = 1;
            int a = divisor;
            for (int t = divisor << 1; t > 0 && dividend > t; t <<= 1) {
                a = t;
                res <<= 1;
            }
            res += divide(dividend - a, divisor);
            return neg ? -res : res;
        }
    }

}

class DivideTwoIntegersTest extends AbstractTest<DivideTwoIntegers> {
}
