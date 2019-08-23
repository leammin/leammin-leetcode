package com.leammin.leetcode.easy;

import com.leammin.leetcode.util.AbstractTest;
import com.leammin.leetcode.util.ExpectedTestcase;
import com.leammin.leetcode.util.Testsuite;

/**
 * @author Leammin
 * @date 2019-08-23
 */
class RomanToIntegerTest extends AbstractTest<RomanToInteger> {
    @Override
    protected Testsuite<RomanToInteger> testsuite() {
        return Testsuite.<RomanToInteger>builder()
                .add(ExpectedTestcase.of(3, t -> t.romanToInt("III")))
                .add(ExpectedTestcase.of(4, t -> t.romanToInt("IV")))
                .add(ExpectedTestcase.of(58, t -> t.romanToInt("LVIII")))
                .add(ExpectedTestcase.of(1994, t -> t.romanToInt("MCMXCIV")))
                .build();
    }
}