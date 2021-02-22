package com.leammin.leetcode.easy;

import com.leammin.leetcode.util.AbstractTest;
import com.leammin.leetcode.util.ExpectedTestcase;
import com.leammin.leetcode.util.Testsuite;

/**
 * @author Leammin
 * @date 2021-02-22
 */
class ToeplitzMatrixTest extends AbstractTest<ToeplitzMatrix> {
    @Override
    protected Testsuite<ToeplitzMatrix> testsuite() {
        return Testsuite.<ToeplitzMatrix>builder()
                .add(ExpectedTestcase.of(t -> t.isToeplitzMatrix(new int[][]{
                        {1, 2, 3, 4},
                        {5, 1, 2, 3},
                        {9, 5, 1, 2}
                }), true))
                .build();
    }
}