package com.leammin.leetcode.medium;

import com.leammin.leetcode.util.AbstractTest;
import com.leammin.leetcode.util.test.Testsuite;

/**
 * @author Leammin
 * @date 2021-04-04
 */
class RabbitsInForestTest extends AbstractTest<RabbitsInForest> {
    @Override
    protected Testsuite<RabbitsInForest> testsuite() {
        return Testsuite.<RabbitsInForest>builder()
                .addExpected(t -> t.numRabbits(new int[]{1, 1, 2}), 5)
                .addExpected(t -> t.numRabbits(new int[]{10, 10, 10}), 11)
                .addExpected(t -> t.numRabbits(new int[]{}), 0)
                .build();
    }
}