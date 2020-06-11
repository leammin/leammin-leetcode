package com.leammin.leetcode.easy;

import com.leammin.leetcode.util.AbstractTest;
import com.leammin.leetcode.util.ExpectedTestcase;
import com.leammin.leetcode.util.Testsuite;

/**
 * @author Leammin
 * @date 2020-06-11
 */
class FloodFillTest extends AbstractTest<FloodFill> {
    @Override
    protected Testsuite<FloodFill> testsuite() {
        return Testsuite.<FloodFill>builder()
                .add(ExpectedTestcase.of(t -> t.floodFill(new int[][]{
                        {1, 1, 1},
                        {1, 1, 0},
                        {1, 0, 1},
                }, 1, 1, 2), new int[][]{
                        {2, 2, 2},
                        {2, 2, 0},
                        {2, 0, 1},
                }))
                .build();
    }
}