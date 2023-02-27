package com.leammin.leetcode.medium;

import com.leammin.leetcode.util.AbstractTest;
import com.leammin.leetcode.util.test.ExpectedTestcase;
import com.leammin.leetcode.util.test.Testsuite;

class PerfectSquaresTest extends AbstractTest<PerfectSquares> {

    @Override
    protected Testsuite<PerfectSquares> testsuite() {
        return Testsuite.<PerfectSquares>builder()
                .add(ExpectedTestcase.of(s -> s.numSquares(12), 3))
                .add(ExpectedTestcase.of(s -> s.numSquares(13), 2))
                .build();
    }
}