package com.leammin.leetcode.medium;

import com.leammin.leetcode.util.AbstractTest;
import com.leammin.leetcode.util.ExpectedTestcase;
import com.leammin.leetcode.util.Testsuite;

import static org.junit.jupiter.api.Assertions.*;

class MinimumFallingPathSumTest extends AbstractTest<MinimumFallingPathSum> {

    @Override
    protected Testsuite<MinimumFallingPathSum> testsuite() {
        return Testsuite.<MinimumFallingPathSum>builder()
                .add(ExpectedTestcase.of(12, s -> s.minFallingPathSum(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}})))
                .add(ExpectedTestcase.of(0, s -> s.minFallingPathSum(new int[][]{{1, -2, 3}, {4, 5, 1}, {7, 1, 9}})))
                .add(ExpectedTestcase.of(2, s -> s.minFallingPathSum(new int[][]{{1, -2, 3}, {4, 5, 6}, {7, 0, 9}})))
                .build();
    }
}