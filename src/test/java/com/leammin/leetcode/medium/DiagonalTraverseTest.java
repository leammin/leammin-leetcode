package com.leammin.leetcode.medium;

import com.leammin.leetcode.util.AbstractTest;
import com.leammin.leetcode.util.test.ExpectedTestcase;
import com.leammin.leetcode.util.test.Testsuite;

/**
 * @author Leammin
 * @date 2020-06-12
 */
class DiagonalTraverseTest extends AbstractTest<DiagonalTraverse> {
    @Override
    protected Testsuite<DiagonalTraverse> testsuite() {
        return Testsuite.<DiagonalTraverse>builder()
                .add(ExpectedTestcase.of(t -> t.findDiagonalOrder(new int[][]{
                        {1, 2, 3},
                        {4, 5, 6},
                        {7, 8, 9}
                }), new int[]{1, 2, 4, 7, 5, 3, 6, 8, 9}))
                .build();
    }
}