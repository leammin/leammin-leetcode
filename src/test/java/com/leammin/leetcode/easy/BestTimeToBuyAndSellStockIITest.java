package com.leammin.leetcode.easy;

import com.leammin.leetcode.util.AbstractTest;
import com.leammin.leetcode.util.EqualTestcase;
import com.leammin.leetcode.util.Testsuite;

/**
 * @author Leammin
 * @date 2019-04-20
 */
class BestTimeToBuyAndSellStockIITest extends AbstractTest<BestTimeToBuyAndSellStockII> {

    @Override
    protected Testsuite<BestTimeToBuyAndSellStockII> testsuite() {
        return Testsuite.<BestTimeToBuyAndSellStockII>builder()
                .add(EqualTestcase.of(7, solution -> solution.maxProfit(new int[]{7, 1, 5, 3, 6, 4})))
                .add(EqualTestcase.of(4, solution -> solution.maxProfit(new int[]{1, 2, 3, 4, 5})))
                .add(EqualTestcase.of(0, solution -> solution.maxProfit(new int[]{7, 6, 4, 3, 1})))
                .build();
    }
}