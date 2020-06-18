package com.leammin.leetcode.easy;

import com.leammin.leetcode.undone.easy.ValidPerfectSquare;
import com.leammin.leetcode.util.AbstractTest;
import com.leammin.leetcode.util.ExpectedTestcase;
import com.leammin.leetcode.util.Testsuite;

/**
 * @author Leammin
 * @date 2020-06-18
 */
class ValidPerfectSquareTest extends AbstractTest<ValidPerfectSquare> {
    @Override
    protected Testsuite<ValidPerfectSquare> testsuite() {
        return Testsuite.<ValidPerfectSquare>builder()
                .add(ExpectedTestcase.of(t -> t.isPerfectSquare(16), true))
                .add(ExpectedTestcase.of(t -> t.isPerfectSquare(14), false))
                .add(ExpectedTestcase.of(t -> t.isPerfectSquare(2147483647), false))
                .build();
    }
}