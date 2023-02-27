package com.leammin.leetcode.easy;

import com.leammin.leetcode.util.AbstractTest;
import com.leammin.leetcode.util.test.ExpectedTestcase;
import com.leammin.leetcode.util.test.Testsuite;

/**
 * @author Leammin
 * @date 2020-04-10
 */
class SqrtxTest extends AbstractTest<Sqrtx> {
    @Override
    protected Testsuite<Sqrtx> testsuite() {
        return Testsuite.<Sqrtx>builder()
                .add(ExpectedTestcase.of(t -> t.mySqrt(4), 2))
                .add(ExpectedTestcase.of(t -> t.mySqrt(8), 2))
                .add(ExpectedTestcase.of(t -> t.mySqrt(10), 3))
                .add(ExpectedTestcase.of(t -> t.mySqrt(16), 4))
                .add(ExpectedTestcase.of(t -> t.mySqrt(2147395599), 46339))
                .build();
    }
}