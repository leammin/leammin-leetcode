package com.leammin.leetcode.medium;

import com.leammin.leetcode.util.test.AbstractTest;
import com.leammin.leetcode.util.test.ExpectedTestcase;
import com.leammin.leetcode.util.test.Testsuite;

/**
 * 343. 整数拆分
 *
 * <div><p>给定一个正整数&nbsp;<em>n</em>，将其拆分为<strong>至少</strong>两个正整数的和，并使这些整数的乘积最大化。 返回你可以获得的最大乘积。</p>
 *
 * <p><strong>示例 1:</strong></p>
 *
 * <pre><strong>输入: </strong>2
 * <strong>输出: </strong>1
 * <strong>解释: </strong>2 = 1 + 1, 1 × 1 = 1。</pre>
 *
 * <p><strong>示例&nbsp;2:</strong></p>
 *
 * <pre><strong>输入: </strong>10
 * <strong>输出: </strong>36
 * <strong>解释: </strong>10 = 3 + 3 + 4, 3 ×&nbsp;3 ×&nbsp;4 = 36。</pre>
 *
 * <p><strong>说明: </strong>你可以假设&nbsp;<em>n&nbsp;</em>不小于 2 且不大于 58。</p>
 * </div>
 *
 * @author Leammin
 * @date 2019-05-22
 */
public interface IntegerBreak {
    int integerBreak(int n);

    static Testsuite<IntegerBreak> testsuite() {
        return Testsuite.<IntegerBreak>builder()
                .add(ExpectedTestcase.of(s -> s.integerBreak(2), 1 * 1))
                .add(ExpectedTestcase.of(s -> s.integerBreak(3), 1 * 2))
                .add(ExpectedTestcase.of(s -> s.integerBreak(4), 2 * 2))
                .add(ExpectedTestcase.of(s -> s.integerBreak(5), 3 * 2))
                .add(ExpectedTestcase.of(s -> s.integerBreak(6), 3 * 3))
                .add(ExpectedTestcase.of(s -> s.integerBreak(10), 3 * 3 * 4))
                .add(ExpectedTestcase.of(s -> s.integerBreak(12), 3 * 3 * 3 * 3))
                .add(ExpectedTestcase.of(s -> s.integerBreak(15), 3 * 3 * 3 * 3 * 3))
                .add(ExpectedTestcase.of(s -> s.integerBreak(16), 3 * 3 * 3 * 3 * 4))
                .add(ExpectedTestcase.of(s -> s.integerBreak(17), 3 * 3 * 3 * 3 * 3 * 2))
                .add(ExpectedTestcase.of(s -> s.integerBreak(18), 3 * 3 * 3 * 3 * 3 * 3))
                .add(ExpectedTestcase.of(s -> s.integerBreak(26), 3 * 3 * 3 * 3 * 3 * 3 * 3 * 3 * 2))
                .build();
    }


    class Solution implements IntegerBreak {

        @Override
        public int integerBreak(int n) {
            if (n < 2) {
                return 0;
            }
            int[] dp = new int[n + 1];
            dp[0] = dp[1] = 1;
            for (int i = 2; i < n + 1; i++) {
                if (i != n) {
                    dp[i] = i;
                }
                for (int j = 1; j <= i / 2; j++) {
                    dp[i] = Math.max(dp[i], dp[j] * dp[i - j]);
                }
            }

            return dp[n];
        }
    }

    class Solution2 implements IntegerBreak {

        @Override
        public int integerBreak(int n) {
            if (n < 2) {
                return 0;
            }
            if (n < 4) {
                return n - 1;
            }
            int q = n / 3;
            int r = n % 3;
            int i = r == 1 ? q - 1 : q;
            int j = r == 0 ? 1 : r == 1 ? 4 : 2;
            return (int) Math.pow(3, i) * j;
        }
    }
}

class IntegerBreakTest extends AbstractTest<IntegerBreak> {
}
