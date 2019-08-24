package com.leammin.leetcode.medium;

import com.leammin.leetcode.util.AbstractTest;
import com.leammin.leetcode.util.ExpectedTestcase;
import com.leammin.leetcode.util.Testsuite;

/**
 * @author Leammin
 * @date 2019-08-23
 */
class IntegerToRomanTest extends AbstractTest<IntegerToRoman> {
    @Override
    protected Testsuite<IntegerToRoman> testsuite() {
        return Testsuite.<IntegerToRoman>builder()
                .add(ExpectedTestcase.of("III", t->t.intToRoman(3)))
                .add(ExpectedTestcase.of("IV", t->t.intToRoman(4)))
                .add(ExpectedTestcase.of("LVIII", t->t.intToRoman(58)))
                .add(ExpectedTestcase.of("MCMXCIV", t->t.intToRoman(1994)))
                .build();
    }
}