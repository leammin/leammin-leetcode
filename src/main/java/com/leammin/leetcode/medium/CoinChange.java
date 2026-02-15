package com.leammin.leetcode.medium;

import java.util.HashMap;
import java.util.Map;

import com.leammin.leetcode.util.test.AbstractTest;
import com.leammin.leetcode.util.test.ExpectedTestcase;
import com.leammin.leetcode.util.test.Testsuite;

/**
 * 322. 零钱兑换
 *
 * <p>给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回&nbsp;<code>-1</code>。</p>
 *
 * <p><strong>示例&nbsp;1:</strong></p>
 *
 * <pre><strong>输入: </strong>coins = <code>[1, 2, 5]</code>, amount = <code>11</code>
 * <strong>输出: </strong><code>3</code>
 * <strong>解释:</strong> 11 = 5 + 5 + 1</pre>
 *
 * <p><strong>示例 2:</strong></p>
 *
 * <pre><strong>输入: </strong>coins = <code>[2]</code>, amount = <code>3</code>
 * <strong>输出: </strong>-1</pre>
 *
 * <p><strong>说明</strong>:<br>
 * 你可以认为每种硬币的数量是无限的。</p>
 *
 * @author Leammin
 * @date 2020-03-08
 */
public interface CoinChange {
    int coinChange(int[] coins, int amount);

    static Testsuite<CoinChange> testsuite() {
        return Testsuite.<CoinChange>builder()
                .add(ExpectedTestcase.of(t -> t.coinChange(new int[]{1, 2, 5}, 11), 3))
                .add(ExpectedTestcase.of(t -> t.coinChange(new int[]{2}, 3), -1))
                .add(ExpectedTestcase.of(t -> t.coinChange(new int[]{2, 5, 10, 1}, 27), 4))
                .add(ExpectedTestcase.of(t -> t.coinChange(new int[]{186,419,83,408}, 6249), 20))
                .build();
    }


    class Solution implements CoinChange {
        Map<Integer, Integer> cache = new HashMap<>();

        @Override
        public int coinChange(int[] coins, int amount) {
            if (amount < 0) {
                return -1;
            }
            if (amount == 0) {
                return 0;
            }
            int result = cache.getOrDefault(amount, -2);
            if (result != -2) {
                return result;
            }
            result = -1;
            for (int coin : coins) {
                int change = coinChange(coins, amount - coin) + 1;
                if (change > 0 && (result == -1 || change < result)) {
                    result = change;
                }
            }
            cache.put(amount, result);
            return result;
        }
    }

    class Solution2 implements CoinChange {

        @Override
        public int coinChange(int[] coins, int amount) {
            int[] dp = new int[amount + 1];
            for (int i = 1; i <= amount; i++) {
                dp[i] = Integer.MAX_VALUE;
                for (int coin : coins) {
                    if (i - coin >= 0 && dp[i-coin] < dp[i]) {
                        dp[i] = dp[i - coin] + 1;
                    }
                }
            }
            return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
        }
    }
}

class CoinChangeTest extends AbstractTest<CoinChange> {
}
