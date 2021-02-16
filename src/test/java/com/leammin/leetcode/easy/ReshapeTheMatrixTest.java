package com.leammin.leetcode.easy;

import com.leammin.leetcode.util.AbstractTest;
import com.leammin.leetcode.util.ExpectedTestcase;
import com.leammin.leetcode.util.Testsuite;

/**
 * @author Leammin
 * @date 2021-02-17
 */
class ReshapeTheMatrixTest extends AbstractTest<ReshapeTheMatrix> {
    @Override
    protected Testsuite<ReshapeTheMatrix> testsuite() {
        return Testsuite.<ReshapeTheMatrix>builder()
                .add(ExpectedTestcase.of(t -> t.matrixReshape(new int[][]{{1, 2}, {3, 4}}, 1, 4), new int[][]{{1, 2, 3, 4}}))
                .add(ExpectedTestcase.of(t -> t.matrixReshape(new int[][]{{1, 2}, {3, 4}}, 2, 4), new int[][]{{1, 2}, {3, 4}}))
                .build();
    }
}