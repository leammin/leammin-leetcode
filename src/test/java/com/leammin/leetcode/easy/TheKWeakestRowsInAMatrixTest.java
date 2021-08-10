package com.leammin.leetcode.easy;

import com.leammin.leetcode.util.AbstractTest;
import com.leammin.leetcode.util.Testsuite;

/**
 * @author Leammin
 * @date 2021-08-01
 */
class TheKWeakestRowsInAMatrixTest extends AbstractTest<TheKWeakestRowsInAMatrix> {
    @Override
    protected Testsuite<TheKWeakestRowsInAMatrix> testsuite() {
        return Testsuite.<TheKWeakestRowsInAMatrix>builder()
                .addExpected(t -> t.kWeakestRows(
                        new int[][]{
                                {1, 1, 0, 0, 0},
                                {1, 1, 1, 1, 0},
                                {1, 0, 0, 0, 0},
                                {1, 1, 0, 0, 0},
                                {1, 1, 1, 1, 1}
                        }, 3), new int[]{2, 0, 3})
                .addExpected(t -> t.kWeakestRows(
                        new int[][]{
                                {1, 0, 0, 0},
                                {1, 1, 1, 1},
                                {1, 0, 0, 0},
                                {1, 0, 0, 0}
                        }, 2), new int[]{0,2})
                .build();
    }

}