package com.leammin.leetcode.easy;

import com.leammin.leetcode.util.AbstractTest;
import com.leammin.leetcode.util.Testsuite;

/**
 * @author Leammin
 * @date 2021-05-06
 */
class ReverseIntegerTest extends AbstractTest<ReverseInteger> {
    @Override
    protected Testsuite<ReverseInteger> testsuite() {
        return Testsuite.<ReverseInteger>builder()
            .addExpected(t -> t.reverse(123), 321)
            .addExpected(t -> t.reverse(-123), -321)
            .addExpected(t -> t.reverse(120), 21)
            .build();
    }
}