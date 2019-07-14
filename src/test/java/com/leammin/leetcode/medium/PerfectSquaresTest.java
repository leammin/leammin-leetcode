package com.leammin.leetcode.medium;

import com.leammin.leetcode.util.AbstractTest;
import com.leammin.leetcode.util.ExpectedTestcase;
import com.leammin.leetcode.util.Testsuite;

class PerfectSquaresTest extends AbstractTest<PerfectSquares> {

    @Override
    protected Testsuite<PerfectSquares> testsuite() {
        return Testsuite.<PerfectSquares>builder()
                .add(ExpectedTestcase.of(3, s -> s.numSquares(12)))
                .add(ExpectedTestcase.of(2, s -> s.numSquares(13)))
                .build();
    }
}