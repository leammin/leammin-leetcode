package com.leammin.leetcode.medium;

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
}
