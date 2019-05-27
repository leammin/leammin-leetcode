package com.leammin.leetcode.medium;

/**
 * 279. 完全平方数
 *
 * <div><p>给定正整数&nbsp;<em>n</em>，找到若干个完全平方数（比如&nbsp;<code>1, 4, 9, 16, ...</code>）使得它们的和等于<em> n</em>。你需要让组成和的完全平方数的个数最少。</p>
 *
 * <p><strong>示例&nbsp;1:</strong></p>
 *
 * <pre><strong>输入:</strong> <em>n</em> = <code>12</code>
 * <strong>输出:</strong> 3
 * <strong>解释: </strong><code>12 = 4 + 4 + 4.</code></pre>
 *
 * <p><strong>示例 2:</strong></p>
 *
 * <pre><strong>输入:</strong> <em>n</em> = <code>13</code>
 * <strong>输出:</strong> 2
 * <strong>解释: </strong><code>13 = 4 + 9.</code></pre>
 * </div>
 *
 * @author leammin
 * @date 2019-05-23
 */
public interface PerfectSquares {
    int numSquares(int n);

    class Solution1 implements PerfectSquares {

        @Override
        public int numSquares(int n) {
            int[] dp = new int[n + 1];
            int i = 1;
            int square = i * i;
            while (square <= n) {
                if (square == n) {
                    return 1;
                }
                dp[square] = 1;
                i++;
                square = i * i;
            }
            for (int j = 2; j < n + 1; j++) {
                if (dp[j] != 0) {
                    continue;
                }
                dp[j] = j;
                for (int k = 1; k <= j / 2; k++) {
                    dp[j] = Math.min(dp[k] + dp[j - k], dp[j]);
                }
            }
            return dp[n];
        }
    }

    class Solution implements PerfectSquares {

        @Override
        public int numSquares(int n) {
            int[] dp = new int[n + 1];
            for (int i = 1; i < dp.length; i++) {
                dp[i] = i;
                for (int j = 1; j * j <= i; j++) {
                    dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
                }
            }
            return dp[n];
        }
    }

    class Best implements PerfectSquares {
        public boolean isSquare(int n) {
            int num = (int) Math.sqrt(n);
            return num * num == n;
        }

        @Override
        public int numSquares(int n) {
            if (isSquare(n)) {
                return 1;
            }
            while ((n & 3) == 0) {
                //n是4的倍数
                n >>= 2;
            }
            if ((n & 7) == 7) {
                //n是8的倍数
                return 4;
            }
            int num = (int) Math.sqrt(n);
            for (int i = 0; i <= num; i++) {
                if (isSquare(n - i * i)) {
                    return 2;
                }
            }
            return 3;
        }
    }
}
