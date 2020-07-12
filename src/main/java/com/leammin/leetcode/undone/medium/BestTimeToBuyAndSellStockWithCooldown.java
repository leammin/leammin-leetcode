package com.leammin.leetcode.undone.medium;

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

//    class Solution3 implements BestTimeToBuyAndSellStockWithCooldown {
//
//        @Override
//        public int maxProfit(int[] prices) {
//            int i = 0;
//            while (i < prices.length) {
//                if (prices[i] < prices[i + 1]) {
//                    break;
//                }
//                i++;
//            }
//            return 0;
//        }
//    }
}
