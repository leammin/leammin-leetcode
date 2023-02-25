package com.leammin.leetcode.medium;

import com.leammin.leetcode.util.AbstractTest;
import com.leammin.leetcode.util.ExpectedTestcase;
import com.leammin.leetcode.util.Testsuite;

/**
 * @author Leammin
 * @date 2020-07-10
 */
class BestTimeToBuyAndSellStockWithCooldownTest extends AbstractTest<BestTimeToBuyAndSellStockWithCooldown> {
    @Override
    protected Testsuite<BestTimeToBuyAndSellStockWithCooldown> testsuite() {
        return Testsuite.<BestTimeToBuyAndSellStockWithCooldown>builder()
                .add(ExpectedTestcase.of(t -> t.maxProfit(new int[]{1, 2, 3, 0, 2}), 3))
                .add(ExpectedTestcase.of(t -> t.maxProfit(new int[]{}), 0))
                .add(ExpectedTestcase.of(t -> t.maxProfit(new int[]{1, 2, 4}), 3))
                .add(ExpectedTestcase.of(t -> t.maxProfit(new int[]{2,6,8,7,8,7,9,4,1,2,4,5,8}), 15))
                .add(ExpectedTestcase.of(t -> t.maxProfit(new int[]{8,6,4,3,3,2,3,5,8,3,8,2,6}), 10))
                .build();
    }
}