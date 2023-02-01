package com.leammin.leetcode.easy;

import com.leammin.leetcode.util.AbstractTest;
import com.leammin.leetcode.util.Testsuite;

/**
 * @author Leammin
 * @date 2023-01-31
 */
class CheckIfMatrixIsXMatrixTest extends AbstractTest<CheckIfMatrixIsXMatrix> {
    @Override
    protected Testsuite<CheckIfMatrixIsXMatrix> testsuite() {
        return Testsuite.<CheckIfMatrixIsXMatrix>builder()
                .addExpected(t -> t.checkXMatrix(new int[][]{{2,0,0,1},{0,3,1,0},{0,5,2,0},{4,0,0,2}}), true)
                .addExpected(t -> t.checkXMatrix(new int[][]{{5,7,0},{0,3,1},{0,5,0}}), false)
                .build();
    }
}