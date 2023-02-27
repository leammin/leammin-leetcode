package com.leammin.leetcode.medium;

import com.leammin.leetcode.util.AbstractTest;
import com.leammin.leetcode.util.test.Testsuite;

/**
 * @author Leammin
 * @date 2022-09-27
 */
class RemoveKDigitsTest extends AbstractTest<RemoveKDigits> {
    @Override
    protected Testsuite<RemoveKDigits> testsuite() {
        return Testsuite.<RemoveKDigits>builder()
                .addExpected(t -> t.removeKdigits("1432219", 3), "1219")
                .addExpected(t -> t.removeKdigits("10200", 1), "200")
                .addExpected(t -> t.removeKdigits("10200", 2), "0")
                .addExpected(t -> t.removeKdigits("10", 2), "0")
                .addExpected(t -> t.removeKdigits("112", 1), "11")
                .build();
    }
}