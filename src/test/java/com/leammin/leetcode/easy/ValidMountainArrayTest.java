package com.leammin.leetcode.easy;

import com.leammin.leetcode.util.AbstractTest;
import com.leammin.leetcode.util.test.ExpectedTestcase;
import com.leammin.leetcode.util.test.Testsuite;

/**
 * @author Leammin
 * @date 2020-11-03
 */
class ValidMountainArrayTest extends AbstractTest<ValidMountainArray> {
    @Override
    protected Testsuite<ValidMountainArray> testsuite() {
        return Testsuite.<ValidMountainArray>builder()
                .add(ExpectedTestcase.of(t -> t.validMountainArray(new int[]{2, 1}), false))
                .add(ExpectedTestcase.of(t -> t.validMountainArray(new int[]{3, 5, 5}), false))
                .add(ExpectedTestcase.of(t -> t.validMountainArray(new int[]{0, 3, 2, 1}), true))
                .build();
    }
}