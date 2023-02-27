package com.leammin.leetcode.hard;

import com.leammin.leetcode.util.AbstractTest;
import com.leammin.leetcode.util.test.Testsuite;

/**
 * @author Leammin
 * @date 2021-04-03
 */
class MaxPointsOnALineTest extends AbstractTest<MaxPointsOnALine> {
    @Override
    protected Testsuite<MaxPointsOnALine> testsuite() {
        return Testsuite.<MaxPointsOnALine>builder()
                .addExpected(t -> t.maxPoints(new int[][]{{1, 1}, {2, 2}, {3, 3}}), 3)
                .addExpected(t -> t.maxPoints(new int[][]{{1, 1}, {3, 2}, {5, 3}, {4, 1}, {2, 3}, {1, 4}}), 4)
                .addExpected(t -> t.maxPoints(new int[][]{{2, 3}, {3, 3}, {-5, 3}}), 3)
                .build();
    }
}