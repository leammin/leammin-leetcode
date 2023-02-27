package com.leammin.leetcode.easy;

import com.leammin.leetcode.util.AbstractTest;
import com.leammin.leetcode.util.test.ExpectedTestcase;
import com.leammin.leetcode.util.test.Testsuite;

/**
 * @author Leammin
 * @date 2019-08-29
 */
class MaximizeSumOfArrayAfterKNegationsTest extends AbstractTest<MaximizeSumOfArrayAfterKNegations> {
    @Override
    protected Testsuite<MaximizeSumOfArrayAfterKNegations> testsuite() {
        return Testsuite.<MaximizeSumOfArrayAfterKNegations>builder()
                .add(ExpectedTestcase.of(t -> t.largestSumAfterKNegations(new int[]{4, 2, 3}, 1), 5))
                .add(ExpectedTestcase.of(t -> t.largestSumAfterKNegations(new int[]{3, -1, 0, 2}, 3), 6))
                .add(ExpectedTestcase.of(t -> t.largestSumAfterKNegations(new int[]{2, -3, -1, 5, -4}, 2), 13))
                .build();
    }
}