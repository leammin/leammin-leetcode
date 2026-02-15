package com.leammin.leetcode.easy;

import com.leammin.leetcode.util.test.AbstractTest;
import com.leammin.leetcode.util.test.ExpectedTestcase;
import com.leammin.leetcode.util.test.Testsuite;

/**
 * 121. 买卖股票的最佳时机
 *
 * <div><p>给定一个数组，它的第&nbsp;<em>i</em> 个元素是一支给定股票第 <em>i</em> 天的价格。</p>
 *
 * <p>如果你最多只允许完成一笔交易（即买入和卖出一支股票），设计一个算法来计算你所能获取的最大利润。</p>
 *
 * <p>注意你不能在买入股票前卖出股票。</p>
 *
 * <p><strong>示例 1:</strong></p>
 *
 * <pre><strong>输入:</strong> [7,1,5,3,6,4]
 * <strong>输出:</strong> 5
 * <strong>解释: </strong>在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
 *      注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格。
 * </pre>
 *
 * <p><strong>示例 2:</strong></p>
 *
 * <pre><strong>输入:</strong> [7,6,4,3,1]
 * <strong>输出:</strong> 0
 * <strong>解释: </strong>在这种情况下, 没有交易完成, 所以最大利润为 0。
 * </pre>
 * </div>
 *
 * @author Leammin
 * @date 2018-09-09
 */
public interface BestTimeToBuyAndSellStock {
    int maxProfit(int[] prices);

    static Testsuite<BestTimeToBuyAndSellStock> testsuite() {
        return Testsuite.<BestTimeToBuyAndSellStock>builder()
                .add(ExpectedTestcase.of(solution -> solution.maxProfit(new int[]{7, 1, 5, 3, 6, 4}), 5))
                .add(ExpectedTestcase.of(solution -> solution.maxProfit(new int[]{7, 6, 4, 3, 1}), 0))
                .add(ExpectedTestcase.of(solution -> solution.maxProfit(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9}), 8))
                .build();
    }


    class Solution implements BestTimeToBuyAndSellStock {

        @Override
        public int maxProfit(int[] prices) {
            if (prices == null || prices.length <= 1) {
                return 0;
            }
            int buyIndex = prices.length - 1;
            int maxStock = prices[buyIndex];
            int maxSpread = 0;
            while (--buyIndex >= 0) {
                if (prices[buyIndex] > maxStock) {
                    maxStock = prices[buyIndex];
                }
                if (maxStock - prices[buyIndex] > maxSpread) {
                    maxSpread = maxStock - prices[buyIndex];
                }
            }
            return maxSpread;
        }
    }
}

class BestTimeToBuyAndSellStockTest extends AbstractTest<BestTimeToBuyAndSellStock> {
}
