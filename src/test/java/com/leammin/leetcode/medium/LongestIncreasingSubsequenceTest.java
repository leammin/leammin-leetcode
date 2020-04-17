package com.leammin.leetcode.medium;

import com.leammin.leetcode.util.AbstractTest;
import com.leammin.leetcode.util.ExpectedTestcase;
import com.leammin.leetcode.util.Testsuite;

/**
 * @author Leammin
 * @date 2020-03-14
 */
class LongestIncreasingSubsequenceTest extends AbstractTest<LongestIncreasingSubsequence> {
    @Override
    protected Testsuite<LongestIncreasingSubsequence> testsuite() {
        return Testsuite.<LongestIncreasingSubsequence>builder()
                .add(ExpectedTestcase.of(t -> t.lengthOfLIS(new int[]{10, 9, 2, 5, 3, 7, 101, 18}), 4))
                .add(ExpectedTestcase.of(t -> t.lengthOfLIS(new int[]{10, 9, 2, 5, 3, 4}), 3))
                .add(ExpectedTestcase.of(t -> t.lengthOfLIS(new int[]{7, 8, 9, 1, 2, 10}), 4))
                .add(ExpectedTestcase.of(t -> t.lengthOfLIS(new int[]{6, 7, 8, 9, 1, 2, 10}), 5))
                .add(ExpectedTestcase.of(t -> t.lengthOfLIS(new int[]{6, 7, 8, 9, 15, 1, 2, 10, 12, 13}), 7))
                .add(ExpectedTestcase.of(t -> t.lengthOfLIS(new int[]{6, 7, 8, 9, 15, 1, 2, 3, 4, 5, 10, 12, 13}), 8))
                .add(ExpectedTestcase.of(t -> t.lengthOfLIS(new int[]{0, 7, 8, 9, 15, 1, 2, 3, 4, 5, 10, 12, 13}), 9))
                .build();
    }
}