package com.leammin.leetcode.easy;

import com.leammin.leetcode.util.AbstractTest;
import com.leammin.leetcode.util.test.Testsuite;

/**
 * @author Leammin
 * @date 2021-04-10
 */
class UglyNumberTest extends AbstractTest<UglyNumber> {
    @Override
    protected Testsuite<UglyNumber> testsuite() {
        return Testsuite.<UglyNumber>builder()
                .addExpected(t -> t.isUgly(8), true)
                .addExpected(t -> t.isUgly(6), true)
                .addExpected(t -> t.isUgly(1), true)
                .addExpected(t -> t.isUgly(14), false)
                .build();
    }
}