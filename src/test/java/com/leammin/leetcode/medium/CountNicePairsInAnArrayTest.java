package com.leammin.leetcode.medium;

import com.leammin.leetcode.util.AbstractTest;
import com.leammin.leetcode.util.test.Testsuite;

/**
 * @author Leammin
 * @date 2023-01-18
 */
class CountNicePairsInAnArrayTest extends AbstractTest<CountNicePairsInAnArray> {
    @Override
    protected Testsuite<CountNicePairsInAnArray> testsuite() {
        return Testsuite.<CountNicePairsInAnArray>builder()
                .addExpected(t -> t.countNicePairs(new int[]{42,11,1,97}), 2)
                .addExpected(t -> t.countNicePairs(new int[]{13,10,35,24,76}), 4)
                .build();
    }
}