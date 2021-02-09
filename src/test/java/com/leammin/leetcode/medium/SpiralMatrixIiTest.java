package com.leammin.leetcode.medium;

import com.leammin.leetcode.util.AbstractTest;
import com.leammin.leetcode.util.ExpectedTestcase;
import com.leammin.leetcode.util.Testsuite;

/**
 * @author Leammin
 * @date 2021-02-09
 */
class SpiralMatrixIiTest extends AbstractTest<SpiralMatrixIi> {
    @Override
    protected Testsuite<SpiralMatrixIi> testsuite() {
        return Testsuite.<SpiralMatrixIi>builder()
                .add(ExpectedTestcase.of(t -> t.generateMatrix(3), new int[][]{
                        {1, 2, 3},
                        {8, 9, 4},
                        {7, 6, 5}
                }))
                .add(ExpectedTestcase.of(t -> t.generateMatrix(1), new int[][]{
                        {1},
                }))
                .add(ExpectedTestcase.of(t -> t.generateMatrix(2), new int[][]{
                        {1, 2},
                        {4, 3},
                }))
                .build();
    }
}