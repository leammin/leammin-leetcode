package com.leammin.leetcode.medium;

import com.leammin.leetcode.undone.medium.LongestContinuousSubarrayWithAbsoluteDiffLessThanOrEqualToLimit;
import com.leammin.leetcode.util.AbstractTest;
import com.leammin.leetcode.util.test.ExpectedTestcase;
import com.leammin.leetcode.util.test.Testsuite;

/**
 * @author Leammin
 * @date 2021-02-21
 */
class LongestContinuousSubarrayWithAbsoluteDiffLessThanOrEqualToLimitTest extends AbstractTest<LongestContinuousSubarrayWithAbsoluteDiffLessThanOrEqualToLimit> {
    @Override
    protected Testsuite<LongestContinuousSubarrayWithAbsoluteDiffLessThanOrEqualToLimit> testsuite() {
        return Testsuite.<LongestContinuousSubarrayWithAbsoluteDiffLessThanOrEqualToLimit>builder()
                .add(ExpectedTestcase.of(t -> t.longestSubarray(new int[]{8,2,4,7}, 4), 2))
                .add(ExpectedTestcase.of(t -> t.longestSubarray(new int[]{10,1,2,4,7,2}, 5), 4))
                .add(ExpectedTestcase.of(t -> t.longestSubarray(new int[]{4,2,2,2,4,4,2,2}, 0), 3))
                .build();
    }
}