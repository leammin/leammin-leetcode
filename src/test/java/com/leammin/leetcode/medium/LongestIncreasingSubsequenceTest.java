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
                .add(ExpectedTestcase.of(4, t -> t.lengthOfLIS(new int[]{10, 9, 2, 5, 3, 7, 101, 18})))
                .add(ExpectedTestcase.of(3, t -> t.lengthOfLIS(new int[]{10, 9, 2, 5, 3, 4})))
                .add(ExpectedTestcase.of(4, t -> t.lengthOfLIS(new int[]{7, 8, 9, 1, 2, 10})))
                .add(ExpectedTestcase.of(5, t -> t.lengthOfLIS(new int[]{6, 7, 8, 9, 1, 2, 10})))
                .add(ExpectedTestcase.of(7, t -> t.lengthOfLIS(new int[]{6, 7, 8, 9, 15, 1, 2, 10, 12, 13})))
                .add(ExpectedTestcase.of(8, t -> t.lengthOfLIS(new int[]{6, 7, 8, 9, 15, 1, 2, 3, 4, 5, 10, 12, 13})))
                .add(ExpectedTestcase.of(9, t -> t.lengthOfLIS(new int[]{0, 7, 8, 9, 15, 1, 2, 3, 4, 5, 10, 12, 13})))
                .build();
    }
}