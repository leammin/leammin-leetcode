package com.leammin.leetcode.medium;

import com.leammin.leetcode.util.AbstractTest;
import com.leammin.leetcode.util.test.Testsuite;

/**
 * @author Leammin
 * @date 2023-01-28
 */
class WaysToMakeAFairArrayTest extends AbstractTest<WaysToMakeAFairArray> {
    @Override
    protected Testsuite<WaysToMakeAFairArray> testsuite() {
        return Testsuite.<WaysToMakeAFairArray>builder()
                .addExpected(t -> t.waysToMakeFair(new int[]{2,1,6,4}), 1)
                .addExpected(t -> t.waysToMakeFair(new int[]{1,1,1}), 3)
                .addExpected(t -> t.waysToMakeFair(new int[]{1,2,3}), 0)
                .build();
    }
}