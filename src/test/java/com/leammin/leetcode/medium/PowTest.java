package com.leammin.leetcode.medium;

import com.leammin.leetcode.util.AbstractTest;
import com.leammin.leetcode.util.test.ExpectedTestcase;
import com.leammin.leetcode.util.test.Testsuite;

/**
 * @author Leammin
 * @date 2019-08-25
 */
class PowTest extends AbstractTest<Pow> {
    @Override
    protected Testsuite<Pow> testsuite() {

        return Testsuite.<Pow>builder()
                .add(ExpectedTestcase.of(t->t.myPow(2.00000, 10), 1024.00))
//                .add(ExpectedTestcase.of(9.26100, t->t.myPow(2.10000, 3)))
                .add(ExpectedTestcase.of(t->t.myPow(1, 2147483647), 1.0))
                .add(ExpectedTestcase.of(t->t.myPow(0.00001, 2147483647), 0.0))
                .build();
    }
}