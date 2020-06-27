package com.leammin.leetcode.hard;

import com.leammin.leetcode.util.AbstractTest;
import com.leammin.leetcode.util.ExpectedTestcase;
import com.leammin.leetcode.util.Testsuite;

/**
 * @author Leammin
 * @date 2020-06-27
 */
class FirstMissingPositiveTest extends AbstractTest<FirstMissingPositive> {
    @Override
    protected Testsuite<FirstMissingPositive> testsuite() {
        return Testsuite.<FirstMissingPositive>builder()
                .add(ExpectedTestcase.of(t -> t.firstMissingPositive(new int[]{1,2,0}), 3))
                .add(ExpectedTestcase.of(t -> t.firstMissingPositive(new int[]{1,2,3}), 4))
                .add(ExpectedTestcase.of(t -> t.firstMissingPositive(new int[]{1,2,4}), 3))
                .add(ExpectedTestcase.of(t -> t.firstMissingPositive(new int[]{3,4,-1,1}), 2))
                .add(ExpectedTestcase.of(t -> t.firstMissingPositive(new int[]{7,8,9,11,12}), 1))
                .add(ExpectedTestcase.of(t -> t.firstMissingPositive(new int[]{}), 1))
                .add(ExpectedTestcase.of(t -> t.firstMissingPositive(new int[]{1,1}), 2))
                .build();
    }
}