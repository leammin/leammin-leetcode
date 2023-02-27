package com.leammin.leetcode.medium;

import com.leammin.leetcode.util.AbstractTest;
import com.leammin.leetcode.util.test.ExpectedTestcase;
import com.leammin.leetcode.util.test.Testsuite;

/**
 * @author Leammin
 * @date 2020-05-18
 */
class MaximumProductSubarrayTest extends AbstractTest<MaximumProductSubarray> {
    @Override
    protected Testsuite<MaximumProductSubarray> testsuite() {
        return Testsuite.<MaximumProductSubarray>builder()
                .add(ExpectedTestcase.of(t -> t.maxProduct(new int[]{2, 3, -2, 4}), 6))
                .add(ExpectedTestcase.of(t -> t.maxProduct(new int[]{-2, 0, -1}), 0))
                .add(ExpectedTestcase.of(t -> t.maxProduct(new int[]{2, 2, -2, 2, -2, -2}), 32))
                .add(ExpectedTestcase.of(t -> t.maxProduct(new int[]{2, -5, -2, -4, 3}), 24))
                .build();
    }
}