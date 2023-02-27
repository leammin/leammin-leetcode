package com.leammin.leetcode.easy;

import com.leammin.leetcode.util.AbstractTest;
import com.leammin.leetcode.util.test.ExpectedTestcase;
import com.leammin.leetcode.util.test.Testsuite;

/**
 * @author Leammin
 * @date 2021-02-25
 */
class TransposeMatrixTest extends AbstractTest<TransposeMatrix> {
    @Override
    protected Testsuite<TransposeMatrix> testsuite() {
        return Testsuite.<TransposeMatrix>builder()
                .add(ExpectedTestcase.of(t -> t.transpose(new int[][]{
                        {1,2,3},
                        {4,5,6},
                        {7,8,9}
                }), new int[][]{
                        {1,4,7},
                        {2,5,8},
                        {3,6,9}
                }))
                .build();
    }
}