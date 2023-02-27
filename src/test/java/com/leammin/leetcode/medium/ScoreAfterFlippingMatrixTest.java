package com.leammin.leetcode.medium;

import com.leammin.leetcode.util.AbstractTest;
import com.leammin.leetcode.util.test.ExpectedTestcase;
import com.leammin.leetcode.util.test.Testsuite;

/**
 * @author Leammin
 * @date 2019-08-30
 */
class ScoreAfterFlippingMatrixTest extends AbstractTest<ScoreAfterFlippingMatrix> {
    @Override
    protected Testsuite<ScoreAfterFlippingMatrix> testsuite() {
        return Testsuite.<ScoreAfterFlippingMatrix>builder()
                .add(ExpectedTestcase.of(t -> t.matrixScore(new int[][]{
                        new int[]{0, 0, 1, 1},
                        new int[]{1, 0, 1, 0},
                        new int[]{1, 1, 0, 0},
                }), 39))
                .build();
    }
}