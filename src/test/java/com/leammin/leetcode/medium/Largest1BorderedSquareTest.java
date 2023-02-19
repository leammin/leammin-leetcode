package com.leammin.leetcode.medium;

import com.leammin.leetcode.util.AbstractTest;
import com.leammin.leetcode.util.Testsuite;

/**
 * @author Leammin
 * @date 2023-02-18
 */
class Largest1BorderedSquareTest extends AbstractTest<Largest1BorderedSquare> {
    @Override
    protected Testsuite<Largest1BorderedSquare> testsuite() {
        return Testsuite.<Largest1BorderedSquare>builder()
                .addExpected(t -> t.largest1BorderedSquare(new int[][]{{1, 1, 1}, {1, 0, 1}, {1, 1, 1}}), 9)
                .addExpected(t -> t.largest1BorderedSquare(new int[][]{{1, 1, 0, 0}}), 1)
                .addExpected(t -> t.largest1BorderedSquare(new int[][]{{0, 0, 0, 0}}), 0)
                .addExpected(t -> t.largest1BorderedSquare(new int[][]{{1, 1, 0}, {1, 1, 1}, {1, 1, 1}, {1, 1, 1}}), 9)
                .build();
    }
}