package com.leammin.leetcode.medium;

import com.leammin.leetcode.util.AbstractTest;
import com.leammin.leetcode.util.ExpectedTestcase;
import com.leammin.leetcode.util.Testsuite;

/**
 * @author Leammin
 * @date 2020-04-10
 */
class FractionToRecurringDecimalTest extends AbstractTest<FractionToRecurringDecimal> {
    @Override
    protected Testsuite<FractionToRecurringDecimal> testsuite() {
        return Testsuite.<FractionToRecurringDecimal>builder()
                .add(ExpectedTestcase.of(t -> t.fractionToDecimal(1, 2), "0.5"))
                .add(ExpectedTestcase.of(t -> t.fractionToDecimal(2, 1), "2"))
                .add(ExpectedTestcase.of(t -> t.fractionToDecimal(2, 3), "0.(6)"))
                .add(ExpectedTestcase.of(t -> t.fractionToDecimal(4, 333), "0.(012)"))
                .add(ExpectedTestcase.of(t -> t.fractionToDecimal(1, 6), "0.1(6)"))
                .add(ExpectedTestcase.of(t -> t.fractionToDecimal(7, -12), "-0.58(3)"))
                .add(ExpectedTestcase.of(t -> t.fractionToDecimal(-1, -2147483648), "0.0000000004656612873077392578125"))
                .build();
    }
}