package com.leammin.leetcode.easy;

import com.leammin.leetcode.util.AbstractTest;
import com.leammin.leetcode.util.ExpectedTestcase;
import com.leammin.leetcode.util.Testsuite;

/**
 * @author Leammin
 * @date 2021-02-13
 */
class PowerOfTwoTest extends AbstractTest<PowerOfTwo> {
    @Override
    protected Testsuite<PowerOfTwo> testsuite() {
        return Testsuite.<PowerOfTwo>builder()
                .add(ExpectedTestcase.of(t -> t.isPowerOfTwo(1), true))
                .add(ExpectedTestcase.of(t -> t.isPowerOfTwo(16), true))
                .add(ExpectedTestcase.of(t -> t.isPowerOfTwo(218), false))
                .build();
    }
}