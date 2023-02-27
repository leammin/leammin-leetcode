package com.leammin.leetcode.medium;

import com.leammin.leetcode.util.AbstractTest;
import com.leammin.leetcode.util.test.Testsuite;

/**
 * @author Leammin
 * @date 2023-02-14
 */
class LongestWellPerformingIntervalTest extends AbstractTest<LongestWellPerformingInterval> {
    @Override
    protected Testsuite<LongestWellPerformingInterval> testsuite() {
        return Testsuite.<LongestWellPerformingInterval>builder()
                .addExpected(t -> t.longestWPI(new int[]{9, 9, 6, 0, 6, 6, 9}), 3)
                .addExpected(t -> t.longestWPI(new int[]{6, 6, 6}), 0)
                .addExpected(t -> t.longestWPI(new int[]{6, 6, 9}), 1)
                .build();
    }
}