package com.leammin.leetcode.medium;

import com.leammin.leetcode.util.AbstractTest;
import com.leammin.leetcode.util.ExpectedTestcase;
import com.leammin.leetcode.util.Testsuite;

/**
 * @author Leammin
 * @date 2020-06-15
 */
class MinimumSizeSubarraySumTest extends AbstractTest<MinimumSizeSubarraySum> {
    @Override
    protected Testsuite<MinimumSizeSubarraySum> testsuite() {
        return Testsuite.<MinimumSizeSubarraySum>builder()
                .add(ExpectedTestcase.of(t -> t.minSubArrayLen(7, new int[]{2,3,1,2,4,3}), 2))
                .add(ExpectedTestcase.of(t -> t.minSubArrayLen(100, new int[]{}), 0))
                .add(ExpectedTestcase.of(t -> t.minSubArrayLen(15, new int[]{5,1,3,5,10,7,4,9,2,8}), 2))
                .add(ExpectedTestcase.of(t -> t.minSubArrayLen(3, new int[]{1, 1}), 0))
                .build();
    }
}