package com.leammin.leetcode.medium;

import com.leammin.leetcode.util.AbstractTest;
import com.leammin.leetcode.util.ExpectedTestcase;
import com.leammin.leetcode.util.Testsuite;

/**
 * @author Leammin
 * @date 2019-05-22
 */
class IntegerBreakTest extends AbstractTest<IntegerBreak> {

    @Override
    protected Testsuite<IntegerBreak> testsuite() {
        return Testsuite.<IntegerBreak>builder()
                .add(ExpectedTestcase.of(s -> s.integerBreak(2), 1))
                .add(ExpectedTestcase.of(s -> s.integerBreak(3), 2))
                .add(ExpectedTestcase.of(s -> s.integerBreak(4), 4))
                .add(ExpectedTestcase.of(s -> s.integerBreak(5), 6))
                .add(ExpectedTestcase.of(s -> s.integerBreak(6), 9))
                .add(ExpectedTestcase.of(s -> s.integerBreak(10), 36))
                .build();
    }

}