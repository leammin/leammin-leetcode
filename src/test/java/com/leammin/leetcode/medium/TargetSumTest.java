package com.leammin.leetcode.medium;

import com.leammin.leetcode.undone.medium.TargetSum;
import com.leammin.leetcode.util.AbstractTest;
import com.leammin.leetcode.util.ExpectedTestcase;
import com.leammin.leetcode.util.Testsuite;

/**
 * @author Leammin
 * @date 2020-06-04
 */
class TargetSumTest extends AbstractTest<TargetSum> {
    @Override
    protected Testsuite<TargetSum> testsuite() {
        return Testsuite.<TargetSum>builder()
                .add(ExpectedTestcase.of(t -> t.findTargetSumWays(new int[]{1, 1, 1, 1, 1}, 3), 5))
                .add(ExpectedTestcase.of(t -> t.findTargetSumWays(new int[]{1, 0}, 1), 2))
                .build();
    }
}