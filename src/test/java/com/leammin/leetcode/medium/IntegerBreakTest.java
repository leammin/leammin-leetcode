package com.leammin.leetcode.medium;

import com.google.common.base.Splitter;
import com.leammin.leetcode.util.AbstractTest;
import com.leammin.leetcode.util.ExpectedTestcase;
import com.leammin.leetcode.util.Testsuite;

import java.util.Arrays;

/**
 * @author Leammin
 * @date 2019-05-22
 */
class IntegerBreakTest extends AbstractTest<IntegerBreak> {

    @Override
    protected Testsuite<IntegerBreak> testsuite() {
        return Testsuite.<IntegerBreak>builder()
                .add(ExpectedTestcase.of(1, s -> s.integerBreak(2)))
                .add(ExpectedTestcase.of(2, s -> s.integerBreak(3)))
                .add(ExpectedTestcase.of(4, s -> s.integerBreak(4)))
                .add(ExpectedTestcase.of(6, s -> s.integerBreak(5)))
                .add(ExpectedTestcase.of(9, s -> s.integerBreak(6)))
                .add(ExpectedTestcase.of(36, s -> s.integerBreak(10)))
                .build();
    }

}