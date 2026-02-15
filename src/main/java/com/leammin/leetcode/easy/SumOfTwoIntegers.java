package com.leammin.leetcode.easy;

import com.leammin.leetcode.util.test.AbstractTest;
import com.leammin.leetcode.util.test.ExpectedTestcase;
import com.leammin.leetcode.util.test.Testsuite;

/**
 * 371. 两整数之和
 * 
 * <p><strong>不使用</strong>运算符&nbsp;<code>+</code> 和&nbsp;<code>-</code>&nbsp;​​​​​​​，计算两整数&nbsp;​​​​​​​<code>a</code>&nbsp;、<code>b</code>&nbsp;​​​​​​​之和。</p>
 * 
 * <p><strong>示例 1:</strong></p>
 * 
 * <pre><strong>输入: </strong>a = 1, b = 2
 * <strong>输出: </strong>3
 * </pre>
 * 
 * <p><strong>示例 2:</strong></p>
 * 
 * <pre><strong>输入: </strong>a = -2, b = 3
 * <strong>输出: </strong>1</pre>
 * 
 * 
 * @author Leammin
 * @date 2020-05-14
 */
public interface SumOfTwoIntegers {
    int getSum(int a, int b);

    static Testsuite<SumOfTwoIntegers> testsuite() {
        return Testsuite.<SumOfTwoIntegers>builder()
                .add(ExpectedTestcase.of(t -> t.getSum(1,2), 3))
                .add(ExpectedTestcase.of(t -> t.getSum(-2,3), 1))
                .add(ExpectedTestcase.of(t -> t.getSum(-5,3), -2))
                .build();
    }


    class Solution implements SumOfTwoIntegers {

        @Override
        public int getSum(int a, int b) {
            int res = 0;
            int mask = 1;
            boolean carry = false;
            while (mask != 0) {
                int ta = a & mask;
                int tb = b & mask;
                res |= ta ^ tb ^ (carry ? mask : 0);
                carry = carry && (ta != 0 || tb != 0) || (ta != 0 && tb != 0);
                mask <<= 1;
            }
            return res;
        }
    }
}

class SumOfTwoIntegersTest extends AbstractTest<SumOfTwoIntegers> {
}
