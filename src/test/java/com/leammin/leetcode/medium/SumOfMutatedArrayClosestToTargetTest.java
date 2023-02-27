package com.leammin.leetcode.medium;

import com.leammin.leetcode.util.AbstractTest;
import com.leammin.leetcode.util.test.ExpectedTestcase;
import com.leammin.leetcode.util.test.Testsuite;

/**
 * @author Leammin
 * @date 2020-06-14
 */
class SumOfMutatedArrayClosestToTargetTest extends AbstractTest<SumOfMutatedArrayClosestToTarget> {
    @Override
    protected Testsuite<SumOfMutatedArrayClosestToTarget> testsuite() {
        return Testsuite.<SumOfMutatedArrayClosestToTarget>builder()
                .add(ExpectedTestcase.of(t -> t.findBestValue(new int[]{4, 9, 3}, 10), 3))
                .add(ExpectedTestcase.of(t -> t.findBestValue(new int[]{2, 3, 5}, 10), 5))
                .add(ExpectedTestcase.of(t -> t.findBestValue(new int[]{60864, 25176, 27249, 21296, 20204}, 56803), 11361))
                .build();
    }
}