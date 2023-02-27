package com.leammin.leetcode.medium;

import com.leammin.leetcode.util.AbstractTest;
import com.leammin.leetcode.util.test.ExpectedTestcase;
import com.leammin.leetcode.util.test.Testsuite;

class MinimumFallingPathSumTest extends AbstractTest<MinimumFallingPathSum> {

    @Override
    protected Testsuite<MinimumFallingPathSum> testsuite() {
        return Testsuite.<MinimumFallingPathSum>builder()
                .add(ExpectedTestcase.of(s -> s.minFallingPathSum(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}), 12))
                .add(ExpectedTestcase.of(s -> s.minFallingPathSum(new int[][]{{1, -2, 3}, {4, 5, 1}, {7, 1, 9}}), 0))
                .add(ExpectedTestcase.of(s -> s.minFallingPathSum(new int[][]{{1, -2, 3}, {4, 5, 6}, {7, 0, 9}}), 2))
                .build();
    }
}