package com.leammin.leetcode.medium;

import com.leammin.leetcode.util.AbstractTest;
import com.leammin.leetcode.util.ExpectedTestcase;
import com.leammin.leetcode.util.Testsuite;

/**
 * @author Leammin
 * @date 2021-08-26
 */
class JianShengZiLcofTest extends AbstractTest<JianShengZiLcof> {
    @Override
    protected Testsuite<JianShengZiLcof> testsuite() {
        return Testsuite.<JianShengZiLcof>builder()
                .addExpected(t -> t.cuttingRope(2), 1)
                .addExpected(t -> t.cuttingRope(10), 36)
                .add(ExpectedTestcase.of(s -> s.cuttingRope(2), 1 * 1))
                .add(ExpectedTestcase.of(s -> s.cuttingRope(3), 1 * 2))
                .add(ExpectedTestcase.of(s -> s.cuttingRope(4), 2 * 2))
                .add(ExpectedTestcase.of(s -> s.cuttingRope(5), 3 * 2))
                .add(ExpectedTestcase.of(s -> s.cuttingRope(6), 3 * 3))
                .add(ExpectedTestcase.of(s -> s.cuttingRope(10), 3 * 3 * 4))
                .add(ExpectedTestcase.of(s -> s.cuttingRope(12), 3 * 3 * 3 * 3))
                .add(ExpectedTestcase.of(s -> s.cuttingRope(15), 3 * 3 * 3 * 3 * 3))
                .add(ExpectedTestcase.of(s -> s.cuttingRope(16), 3 * 3 * 3 * 3 * 4))
                .add(ExpectedTestcase.of(s -> s.cuttingRope(17), 3 * 3 * 3 * 3 * 3 * 2))
                .add(ExpectedTestcase.of(s -> s.cuttingRope(18), 3 * 3 * 3 * 3 * 3 * 3))
                .add(ExpectedTestcase.of(s -> s.cuttingRope(26), 3 * 3 * 3 * 3 * 3 * 3 * 3 * 3 * 2))
                .build();
    }
}