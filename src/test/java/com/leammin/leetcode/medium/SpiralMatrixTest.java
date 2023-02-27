package com.leammin.leetcode.medium;

import com.leammin.leetcode.util.AbstractTest;
import com.leammin.leetcode.util.test.ExpectedTestcase;
import com.leammin.leetcode.util.test.Testsuite;

import java.util.Arrays;

/**
 * @author Leammin
 * @date 2020-06-05
 */
class SpiralMatrixTest extends AbstractTest<SpiralMatrix> {
    @Override
    protected Testsuite<SpiralMatrix> testsuite() {
        return Testsuite.<SpiralMatrix>builder()
                .add(ExpectedTestcase.of(t -> t.spiralOrder(new int[][]{
                        {1, 2, 3},
                        {4, 5, 6},
                        {7, 8, 9}
                }), Arrays.asList(1, 2, 3, 6, 9, 8, 7, 4, 5)))
                .add(ExpectedTestcase.of(t -> t.spiralOrder(new int[][]{
                        {1, 2, 3, 4},
                        {5, 6, 7, 8},
                        {9, 10, 11, 12}
                }), Arrays.asList(1, 2, 3, 4, 8, 12, 11, 10, 9, 5, 6, 7)))
                .add(ExpectedTestcase.of(t -> t.spiralOrder(new int[][]{
                        {1, 2, 3, 4, 13},
                        {5, 6, 7, 8, 14},
                        {9, 10, 11, 12, 15}
                }), Arrays.asList(1, 2, 3, 4, 13, 14, 15, 12, 11, 10, 9, 5, 6, 7, 8)))
                .build();
    }
}