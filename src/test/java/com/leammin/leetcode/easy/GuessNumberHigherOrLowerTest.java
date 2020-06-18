package com.leammin.leetcode.easy;

import com.leammin.leetcode.util.AbstractTest;
import com.leammin.leetcode.util.ExpectedTestcase;
import com.leammin.leetcode.util.Testsuite;

/**
 * @author Leammin
 * @date 2020-06-17
 */
class GuessNumberHigherOrLowerTest extends AbstractTest<GuessNumberHigherOrLower> {
    @Override
    protected Testsuite<GuessNumberHigherOrLower> testsuite() {
        return Testsuite.<GuessNumberHigherOrLower>builder()
                .add(ExpectedTestcase.of(t -> t.guessNumber(10), 6))
                .build();
    }
}