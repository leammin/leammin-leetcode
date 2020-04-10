package com.leammin.leetcode.easy;

import com.leammin.leetcode.util.AbstractTest;
import com.leammin.leetcode.util.ExpectedTestcase;
import com.leammin.leetcode.util.Testsuite;

/**
 * @author Leammin
 * @date 2020-04-10
 */
class SqrtxTest extends AbstractTest<Sqrtx> {
    @Override
    protected Testsuite<Sqrtx> testsuite() {
        return Testsuite.<Sqrtx>builder()
                .add(ExpectedTestcase.of(2, t -> t.mySqrt(4)))
                .add(ExpectedTestcase.of(2, t -> t.mySqrt(8)))
                .add(ExpectedTestcase.of(3, t -> t.mySqrt(10)))
                .add(ExpectedTestcase.of(4, t -> t.mySqrt(16)))
                .add(ExpectedTestcase.of(46339, t -> t.mySqrt(2147395599)))
                .build();
    }
}