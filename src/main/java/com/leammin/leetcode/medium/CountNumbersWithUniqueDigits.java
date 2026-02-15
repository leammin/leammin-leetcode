package com.leammin.leetcode.medium;

import com.leammin.leetcode.util.test.AbstractTest;
import com.leammin.leetcode.util.test.Testsuite;

/**
 * 357. 计算各个位数不同的数字个数
 * 
 * <p>给定一个<strong>非负</strong>整数 n，计算各位数字都不同的数字 x 的个数，其中 0 &le; x &lt; 10<sup>n&nbsp;</sup>。</p>
 * 
 * <p><strong>示例:</strong></p>
 * 
 * <pre><strong>输入: </strong>2
 * <strong>输出: </strong>91 
 * <strong>解释: </strong>答案应为除去 <code>11,22,33,44,55,66,77,88,99 </code>外，在 [0,100) 区间内的所有数字。
 * </pre>
 * 
 * 
 * @author Leammin
 * @date 2023-02-15
 */
public interface CountNumbersWithUniqueDigits {
    int countNumbersWithUniqueDigits(int n);

    static Testsuite<CountNumbersWithUniqueDigits> testsuite() {
        return Testsuite.<CountNumbersWithUniqueDigits>builder()
                .addExpected(t -> t.countNumbersWithUniqueDigits(2), 91)
                .addExpected(t -> t.countNumbersWithUniqueDigits(0), 1)
                .build();
    }

    class Solution implements CountNumbersWithUniqueDigits {

        @Override
        public int countNumbersWithUniqueDigits(int n) {
            if (n == 0) {
                return 1;
            }
            int res = 10;
            int last = 9;
            for (int i = 0; i < n - 1; i++) {
                last *= (9 - i);
                res += last;
            }
            return res;
        }
    }
}

class CountNumbersWithUniqueDigitsTest extends AbstractTest<CountNumbersWithUniqueDigits> {
}
