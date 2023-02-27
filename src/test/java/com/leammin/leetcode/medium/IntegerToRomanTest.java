package com.leammin.leetcode.medium;

import com.leammin.leetcode.util.AbstractTest;
import com.leammin.leetcode.util.test.ExpectedTestcase;
import com.leammin.leetcode.util.test.Testsuite;

/**
 * @author Leammin
 * @date 2019-08-23
 */
class IntegerToRomanTest extends AbstractTest<IntegerToRoman> {
    @Override
    protected Testsuite<IntegerToRoman> testsuite() {
        return Testsuite.<IntegerToRoman>builder()
                .add(ExpectedTestcase.of(t->t.intToRoman(3), "III"))
                .add(ExpectedTestcase.of(t->t.intToRoman(4), "IV"))
                .add(ExpectedTestcase.of(t->t.intToRoman(58), "LVIII"))
                .add(ExpectedTestcase.of(t->t.intToRoman(1994), "MCMXCIV"))
                .build();
    }
}