package com.leammin.leetcode.easy;

import com.leammin.leetcode.util.AbstractTest;
import com.leammin.leetcode.util.ExpectedTestcase;
import com.leammin.leetcode.util.Testsuite;

/**
 * @author Leammin
 * @date 2019-08-29
 */
class MaximizeSumOfArrayAfterKNegationsTest extends AbstractTest<MaximizeSumOfArrayAfterKNegations> {
    @Override
    protected Testsuite<MaximizeSumOfArrayAfterKNegations> testsuite() {
        return Testsuite.<MaximizeSumOfArrayAfterKNegations>builder()
                .add(ExpectedTestcase.of(5, t -> t.largestSumAfterKNegations(new int[]{4, 2, 3}, 1)))
                .add(ExpectedTestcase.of(6, t -> t.largestSumAfterKNegations(new int[]{3, -1, 0, 2}, 3)))
                .add(ExpectedTestcase.of(13, t -> t.largestSumAfterKNegations(new int[]{2, -3, -1, 5, -4}, 2)))
                .build();
    }
}