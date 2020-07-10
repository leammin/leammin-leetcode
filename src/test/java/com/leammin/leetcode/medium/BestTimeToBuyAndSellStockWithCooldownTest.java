package com.leammin.leetcode.medium;

import com.leammin.leetcode.undone.medium.BestTimeToBuyAndSellStockWithCooldown;
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
                .build();
    }
}