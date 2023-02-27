package com.leammin.leetcode.easy;

import com.leammin.leetcode.util.AbstractTest;
import com.leammin.leetcode.util.test.ExpectedTestcase;
import com.leammin.leetcode.util.test.Testsuite;

/**
 * @author Leammin
 * @date 2019-04-20
 */
class BestTimeToBuyAndSellStockIITest extends AbstractTest<BestTimeToBuyAndSellStockII> {
    @Override
    protected Testsuite<BestTimeToBuyAndSellStockII> testsuite() {
        return Testsuite.<BestTimeToBuyAndSellStockII>builder()
                .add(ExpectedTestcase.of(solution -> solution.maxProfit(new int[]{7, 1, 5, 3, 6, 4}), 7))
                .add(ExpectedTestcase.of(solution -> solution.maxProfit(new int[]{1, 2, 3, 4, 5}), 4))
                .add(ExpectedTestcase.of(solution -> solution.maxProfit(new int[]{7, 6, 4, 3, 1}), 0))
                .build();
    }
}