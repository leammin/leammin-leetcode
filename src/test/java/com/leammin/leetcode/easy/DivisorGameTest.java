package com.leammin.leetcode.easy;

import com.leammin.leetcode.util.AbstractTest;
import com.leammin.leetcode.util.test.ExpectedTestcase;
import com.leammin.leetcode.util.test.Testsuite;

/**
 * @author Leammin
 * @date 2019-05-01
 */
class DivisorGameTest extends AbstractTest<DivisorGame> {

    @Override
    protected Testsuite<DivisorGame> testsuite() {
        return Testsuite.<DivisorGame>builder()
                .add(ExpectedTestcase.of(s -> s.divisorGame(2), true))
                .add(ExpectedTestcase.of(s -> s.divisorGame(4), true))
                .add(ExpectedTestcase.of(s -> s.divisorGame(5), false))
                .add(ExpectedTestcase.of(s -> s.divisorGame(3), false))
                .build();
    }
}