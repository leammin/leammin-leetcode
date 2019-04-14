package com.leammin.leetcode.easy;

import com.leammin.leetcode.util.AbstractTest;
import com.leammin.leetcode.util.EqualTestcase;
import com.leammin.leetcode.util.Testcase;
import com.leammin.leetcode.util.Testsuite;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class BestTimeToBuyAndSellStockTest extends AbstractTest<BestTimeToBuyAndSellStock> {
    @Override
    protected Testsuite<BestTimeToBuyAndSellStock> testsuite() {
        return Testsuite.<BestTimeToBuyAndSellStock>builder()
                .add(EqualTestcase.of(5, solution -> solution.maxProfit(new int[]{7, 1, 5, 3, 6, 4})))
                .add(EqualTestcase.of(0, solution -> solution.maxProfit(new int[]{7, 6, 4, 3, 1})))
                .add(EqualTestcase.of(8, solution -> solution.maxProfit(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9})))
                .build();
    }
}