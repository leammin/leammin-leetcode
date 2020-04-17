package com.leammin.leetcode.medium;

import com.leammin.leetcode.util.AbstractTest;
import com.leammin.leetcode.util.ExpectedTestcase;
import com.leammin.leetcode.util.Testsuite;

/**
 * @author Leammin
 * @date 2020-04-16
 */
class ZeroOneMatrixTest extends AbstractTest<ZeroOneMatrix> {
    @Override
    protected Testsuite<ZeroOneMatrix> testsuite() {
        return Testsuite.<ZeroOneMatrix>builder()
                .add(ExpectedTestcase.of(t -> t.updateMatrix(new int[][]{
                        {0, 0, 0},
                        {0, 1, 0},
                        {0, 0, 0}
                }), new int[][]{
                        {0, 0, 0},
                        {0, 1, 0},
                        {0, 0, 0}
                }))
                .add(ExpectedTestcase.of(t -> t.updateMatrix(new int[][]{
                        {0, 0, 0},
                        {0, 1, 0},
                        {1, 1, 1}
                }), new int[][]{
                        {0, 0, 0},
                        {0, 1, 0},
                        {1, 2, 1}
                }))
                .add(ExpectedTestcase.of(t -> t.updateMatrix(new int[][]{
                        {0},
                        {1}
                }), new int[][]{
                        {0},
                        {1}
                }))
                .build();
    }
}