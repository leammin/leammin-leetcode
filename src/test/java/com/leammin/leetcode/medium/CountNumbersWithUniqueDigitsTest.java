package com.leammin.leetcode.medium;

import com.leammin.leetcode.util.AbstractTest;
import com.leammin.leetcode.util.Testsuite;

/**
 * @author Leammin
 * @date 2023-02-15
 */
class CountNumbersWithUniqueDigitsTest extends AbstractTest<CountNumbersWithUniqueDigits> {
    @Override
    protected Testsuite<CountNumbersWithUniqueDigits> testsuite() {
        return Testsuite.<CountNumbersWithUniqueDigits>builder()
                .addExpected(t -> t.countNumbersWithUniqueDigits(2), 91)
                .addExpected(t -> t.countNumbersWithUniqueDigits(0), 1)
                .build();
    }
}