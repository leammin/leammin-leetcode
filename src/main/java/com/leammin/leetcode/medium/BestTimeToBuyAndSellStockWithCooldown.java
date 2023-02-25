package com.leammin.leetcode.medium;

import com.leammin.leetcode.util.Execute;

import java.util.Arrays;

/**
 * 309. 最佳买卖股票时机含冷冻期
 *
 * <p>给定一个整数数组，其中第<em>&nbsp;i</em>&nbsp;个元素代表了第&nbsp;<em>i</em>&nbsp;天的股票价格 。​</p>
 *
 * <p>设计一个算法计算出最大利润。在满足以下约束条件下，你可以尽可能地完成更多的交易（多次买卖一支股票）:</p>
 *
 * <ul>
 * 	<li>你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。</li>
 * 	<li>卖出股票后，你无法在第二天买入股票 (即冷冻期为 1 天)。</li>
 * </ul>
 *
 * <p><strong>示例:</strong></p>
 *
 * <pre><strong>输入:</strong> [1,2,3,0,2]
 * <strong>输出: </strong>3
 * <strong>解释:</strong> 对应的交易状态为: [买入, 卖出, 冷冻期, 买入, 卖出]</pre>
 *
 * @author Leammin
 * @date 2020-07-10
 */
public interface BestTimeToBuyAndSellStockWithCooldown {
    int maxProfit(int[] prices);

    class Solution implements BestTimeToBuyAndSellStockWithCooldown {

        @Override
        public int maxProfit(int[] prices) {
            MaxProfit[][] dp = new MaxProfit[prices.length][prices.length];
            for (int diff = 0; diff < prices.length; diff++) {
                for (int i = 0; i + diff < prices.length; i++) {
                    int j = i + diff;
                    if (diff == 0) {
                        dp[i][j] = new MaxProfit(0, false);
                    } else if (diff == 1) {
                        int profit = prices[j] - prices[i];
                        dp[i][j] = new MaxProfit(Math.max(0, profit), profit > 0);
                    } else {
                        int max = prices[j] - prices[i];
                        boolean freeze = true;
                        for (int k = i; k < j; k++) {
                            MaxProfit left = dp[i][k];
                            MaxProfit right;
                            if (left.freeze) {
                                right = k + 2 > j ? new MaxProfit(0, false) : dp[k + 2][j];
                            } else {
                                right = dp[k + 1][j];
                            }
                            int profit = left.profit + right.profit;
                            if (profit > max) {
                                max = profit;
                                freeze = right.freeze;
                            }
                        }
                        dp[i][j] = new MaxProfit(max, freeze);
                    }
                }
            }
            return prices.length == 0 ? 0 : dp[0][prices.length - 1].profit;
        }

        static class MaxProfit {
            int profit;
            boolean freeze;

            public MaxProfit(int profit, boolean freeze) {
                this.profit = profit;
                this.freeze = freeze;
            }
        }
    }


    class Solution2 implements BestTimeToBuyAndSellStockWithCooldown {

        @Override
        public int maxProfit(int[] prices) {
            return maxProfit(prices, 0, prices.length - 1, new MaxProfit[prices.length][prices.length]).profit;
        }

        public MaxProfit maxProfit(int[] prices, int i, int j, MaxProfit[][] dp) {
            if (i >= j) {
                return new MaxProfit(0, false);
            }
            if (dp[i][j] != null) {
                return dp[i][j];
            }
            if (j - i == 1) {
                int profit = prices[j] - prices[i];
                return dp[i][j] = new MaxProfit(Math.max(0, profit), profit > 0);
            }
            if (prices[i] >= prices[i + 1]) {
                int ni = i;
                while (ni < prices.length - 1 && prices[ni] >= prices[ni + 1]) {
                    ni++;
                }
                MaxProfit maxProfit = maxProfit(prices, ni, j, dp);
                for (int k = i; k < ni; k++) {
                    dp[k][j] = maxProfit;
                }
                return maxProfit;
            }
            if (prices[j - 1] >= prices[j]) {
                int nj = j;
                while (nj > 0 && prices[nj - 1] >= prices[nj]) {
                    nj--;
                }
                MaxProfit maxProfit = new MaxProfit(maxProfit(prices, i, nj, dp).profit, false);
                for (int k = nj + 1; k <= j; k++) {
                    dp[i][k] = maxProfit;
                }
                return maxProfit;
            }
            for (int k = i + 1; k <= j - 2; k++) {
                if (prices[k] > prices[k - 1] && prices[k] >= prices[k + 1] && prices[k + 1] >= prices[k + 2]) {
                    MaxProfit left = maxProfit(prices, i, k, dp);
                    MaxProfit right = left.freeze ? maxProfit(prices, k + 2, j, dp) : maxProfit(prices, k + 1, j, dp);
                    return dp[i][j] = new MaxProfit(left.profit + right.profit, right.freeze);
                }
            }
            int max = Math.max(0, prices[j] - prices[i]);
            boolean freeze = max != 0;
            for (int k = i; k < j; k++) {
                if (prices[k] > prices[k + 1] || (k < j - 1 && prices[k + 1] > prices[k + 2])) {
                    MaxProfit left = maxProfit(prices, i, k, dp);
                    MaxProfit right = left.freeze ? maxProfit(prices, k + 2, j, dp) : maxProfit(prices, k + 1, j, dp);
                    int profit = left.profit + right.profit;
                    if (profit > max) {
                        max = profit;
                        freeze = right.freeze;
                    }
                }
            }
            return dp[i][j] = new MaxProfit(max, freeze);
        }

        static class MaxProfit {
            int profit;
            boolean freeze;

            public MaxProfit(int profit, boolean freeze) {
                this.profit = profit;
                this.freeze = freeze;
            }
        }
    }

    class Solution3 implements BestTimeToBuyAndSellStockWithCooldown {
        public int maxProfit(int[] prices) {
            return max(0, prices, new int[prices.length]);
        }
        // 8,6,4,3,3,2,3,5,8,3,8,2,6

        private int max(int start, int[] prices, int[] dp) {
            if (start >= prices.length - 1) {
                return 0;
            }
            if (dp[start] != 0) {
                return Math.max(dp[start], 0);
            }
            int max = -1;
            for (int i = start; i < prices.length - 1; i++) {
                for (int j = i + 1; j < prices.length; j++) {
                    if (prices[j] > prices[i]) {
                        int next = prices[j] - prices[i] + max(j + 2, prices, dp);
                        max = Math.max(max, next);
                    }
                }
            }
            return Math.max(dp[start] = max, 0);
        }
    }

    class Solution4 implements BestTimeToBuyAndSellStockWithCooldown {

        @Override
        public int maxProfit(int[] prices) {
            int[] dp = new int[prices.length]; // 从i开始但不是必须在i买入时的最大利润（dp[0]即问题的解）
            for (int s = prices.length - 2; s >= 0; s--) {
                for (int i = s; i < prices.length - 1; i++) {
                    for (int j = i + 1; j < prices.length; j++) {
                        if (prices[j] > prices[i]) {
                            int next = prices[j] - prices[i] + (j + 2 < prices.length ? dp[j + 2] : 0);
                            dp[s] = Math.max(dp[s], next);
                        }
                    }
                }
            }
            return dp.length == 0 ? 0 : dp[0];
        }
    }

    class Solution5 implements BestTimeToBuyAndSellStockWithCooldown {

        @Override
        public int maxProfit(int[] prices) {
            int[] dp = new int[prices.length]; // 从i开始但不是必须在i买入时的最大利润（dp[0]即问题的解）
            int[] dpi = new int[prices.length]; // 必须在i买入时最大利润
            Arrays.fill(dpi, -1);
            for (int s = prices.length - 2; s >= 0; s--) {
                for (int i = s; i < prices.length - 1; i++) {
                    if (dpi[i] < 0) {
                        dpi[i] = 0;
                        for (int j = i + 1; j < prices.length; j++) {
                            if (prices[j] > prices[i]) {
                                int next = prices[j] - prices[i] + (j + 2 < prices.length ? dp[j + 2] : 0);
                                dp[s] = Math.max(dp[s], next);
                                dpi[i] = Math.max(dpi[i], next);
                            }
                        }
                    }
                    dp[s] = Math.max(dp[s], dpi[i]);
                }
            }
            return dp.length == 0 ? 0 : dp[0];
        }
    }


    class Solution6 implements BestTimeToBuyAndSellStockWithCooldown {

        @Override
        public int maxProfit(int[] prices) {
            int[] dp = new int[prices.length]; // 从i开始但不是必须在i买入时的最大利润（dp[0]即问题的解）
            int[] dpi = new int[prices.length]; // 必须在i买入时最大利润
            for (int s = prices.length - 2; s >= 0; s--) {
                for (int j = s + 1; j < prices.length; j++) {
                    if (prices[j] > prices[s]) {
                        int next = prices[j] - prices[s] + (j + 2 < prices.length ? dp[j + 2] : 0);
                        dpi[s] = Math.max(dpi[s], next);
                    }
                }
                dp[s] = Math.max(dp[s + 1], dpi[s]);
            }
            return dp.length == 0 ? 0 : dp[0];
        }
    }

    class Solution7 implements BestTimeToBuyAndSellStockWithCooldown {

        @Override
        public int maxProfit(int[] prices) {
            int[] dp = new int[prices.length]; // 从i开始但不是必须在i买入时的最大利润（dp[0]即问题的解）
            int[] dpi = new int[prices.length]; // 必须在i买入时最大利润
            for (int s = prices.length - 2; s >= 0; s--) {
                if (prices[s] >= prices[s + 1]) {
                    dpi[s] = dpi[s + 1] + prices[s + 1] - prices[s];
                } else {
                    for (int j = s + 1; j < prices.length; j++) {
                        if (prices[j] > prices[s]) {
                            int next = prices[j] - prices[s] + (j + 2 < prices.length ? dp[j + 2] : 0);
                            dpi[s] = Math.max(dpi[s], next);
                        }
                    }
                }
                dp[s] = Math.max(dp[s + 1], dpi[s]);
            }
            return dp.length == 0 ? 0 : dp[0];
        }
    }

    @Execute(value = false)
    class Solution8 implements BestTimeToBuyAndSellStockWithCooldown {
        // 错误解法，无法通过纯贪心完成
        // 用例：8,6,4,3,3,2,3,5,8,3,8,2,6
        // 期望：10
        // 输出：8

        @Override
        public int maxProfit(int[] prices) {
            int profit = 0;
            int l = 0;
            int r = 0;
            while (r < prices.length - 1) {
                if (prices[r] < prices[r + 1]) {
                    // 递增，不卖
                    r++;
                    continue;
                }
                if (r == l) {
                    // 递减，不买
                    l = ++r;
                    continue;
                }
                if (prices[r] == prices[r + 1]) {
                    r++;
                    continue;
                }
                if (r + 2 >= prices.length || prices[r + 2] <= prices[r + 1]) {
                    // 后续两天都在跌，在r处卖收益最大
                    profit += prices[r] - prices[l];
                    r = r + 2;
                    l = r;
                    continue;
                }
                // r处是极值
                if (r + 2 < prices.length && prices[r + 2] > prices[r + 1]) {
                    int a = prices[r] - prices[r - 1];
                    int b = prices[r + 2] - prices[r + 1];
                    int c = prices[r + 2] - prices[r - 1];
                    int max = Math.max(Math.max(a, b), c);
                    if (max == b) {
                        // 在r-1处卖收益可能较大
                        if (r - 2 > l && prices[r - 2] >= prices[r - 1]) {
                            // r-2比r-1大，r-2也是个极值，且此极值处没卖
                            // 此时在r-2处卖收益最大，而后再r+1处买入
                            profit += prices[r - 2] - prices[l];
                            r = r + 1;
                            l = r;
                        } else {
                            profit += prices[r - 1] - prices[l];
                            r = r + 1;
                            l = r;
                        }

                    } else if (max == a) {
                        // 在r处卖收益最大
                        profit += prices[r] - prices[l];
                        r = r + 2;
                        l = r;
                    } else {
                        // 不卖收益最大
                        r = r + 2;
                    }
                }
            }
            if (r == prices.length - 1 && prices[r] > prices[l]) {
                profit += prices[r] - prices[l];
            }
            return profit;
        }
    }

    class Solution9 implements BestTimeToBuyAndSellStockWithCooldown {

        @Override
        public int maxProfit(int[] prices) {
            int[] dp = new int[prices.length]; // 从i开始但不是必须在i买入时的最大利润（dp[0]即问题的解）
            int[] dpi = new int[prices.length]; // 必须在i买入时最大利润
            for (int s = prices.length - 2; s >= 0; s--) {
                int a = prices[s + 1] - prices[s] + dpi[s + 1]; // s处买
                int b = prices[s + 1] - prices[s] + (s + 3 < prices.length ? dp[s + 3] : 0); // s处买 s+1处卖
                dpi[s] = Math.max(a, b);
                dp[s] = Math.max(dp[s + 1], dpi[s]);
            }
            return dp.length == 0 ? 0 : dp[0];
        }
    }

    class Solution10 implements BestTimeToBuyAndSellStockWithCooldown {

        @Override
        public int maxProfit(int[] prices) {
            int dp0 = 0, dp1 = 0, dp2 = 0, dp3 = 0;
            int dpi0 = 0, dpi1 = 0;
            for (int s = prices.length - 2; s >= 0; s--) {
                int a = prices[s + 1] - prices[s] + dpi1; // s处买
                int b = prices[s + 1] - prices[s] + (s + 3 < prices.length ? dp3 : 0); // s处买 s+1处卖
                dpi0 = Math.max(a, b);
                dp0 = Math.max(dp1, dpi0);
                dpi1 = dpi0;
                dp3 = dp2;
                dp2 = dp1;
                dp1 = dp0;
            }
            return dp0;
        }
    }
}
