package com.leammin.leetcode.medium;

import java.util.HashMap;
import java.util.Map;

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
}
