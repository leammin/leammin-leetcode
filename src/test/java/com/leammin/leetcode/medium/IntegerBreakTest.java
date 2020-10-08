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
                .add(ExpectedTestcase.of(s -> s.integerBreak(2), 1 * 1))
                .add(ExpectedTestcase.of(s -> s.integerBreak(3), 1 * 2))
                .add(ExpectedTestcase.of(s -> s.integerBreak(4), 2 * 2))
                .add(ExpectedTestcase.of(s -> s.integerBreak(5), 3 * 2))
                .add(ExpectedTestcase.of(s -> s.integerBreak(6), 3 * 3))
                .add(ExpectedTestcase.of(s -> s.integerBreak(10), 3 * 3 * 4))
                .add(ExpectedTestcase.of(s -> s.integerBreak(12), 3 * 3 * 3 * 3))
                .add(ExpectedTestcase.of(s -> s.integerBreak(15), 3 * 3 * 3 * 3 * 3))
                .add(ExpectedTestcase.of(s -> s.integerBreak(16), 3 * 3 * 3 * 3 * 4))
                .add(ExpectedTestcase.of(s -> s.integerBreak(17), 3 * 3 * 3 * 3 * 3 * 2))
                .add(ExpectedTestcase.of(s -> s.integerBreak(18), 3 * 3 * 3 * 3 * 3 * 3))
                .add(ExpectedTestcase.of(s -> s.integerBreak(26), 3 * 3 * 3 * 3 * 3 * 3 * 3 * 3 * 2))
                .build();
    }

}