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
                .add(ExpectedTestcase.of(t -> t.romanToInt("III"), 3))
                .add(ExpectedTestcase.of(t -> t.romanToInt("IV"), 4))
                .add(ExpectedTestcase.of(t -> t.romanToInt("LVIII"), 58))
                .add(ExpectedTestcase.of(t -> t.romanToInt("MCMXCIV"), 1994))
                .build();
    }
}