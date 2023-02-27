package com.leammin.leetcode.medium;

import com.leammin.leetcode.util.AbstractTest;
import com.leammin.leetcode.util.test.ExpectedTestcase;
import com.leammin.leetcode.util.test.Testsuite;

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
                .add(ExpectedTestcase.of(t -> t.findTargetSumWays(new int[]{7,9,3,8,0,2,4,8,3,9}, 0), 0))
                .add(ExpectedTestcase.of(t -> t.findTargetSumWays(new int[]{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}, 0), 1048576))
                .add(ExpectedTestcase.of(t -> t.findTargetSumWays(new int[]{1000}, 1000), 1))
                .build();
    }
}