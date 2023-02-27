package com.leammin.leetcode.easy;

import com.leammin.leetcode.util.AbstractTest;
import com.leammin.leetcode.util.test.ExpectedTestcase;
import com.leammin.leetcode.util.test.Testsuite;

/**
 * @author Leammin
 * @date 2019-08-27
 */
class TwoCitySchedulingTest extends AbstractTest<TwoCityScheduling> {
    @Override
    protected Testsuite<TwoCityScheduling> testsuite() {
        return Testsuite.<TwoCityScheduling>builder()
                .add(ExpectedTestcase.of(t -> t.twoCitySchedCost(new int[][]{
                        new int[]{10, 20},
                        new int[]{30, 200},
                        new int[]{400, 50},
                        new int[]{30, 20}}), 10 + 30 + 50 + 20))
                .add(ExpectedTestcase.of(t -> t.twoCitySchedCost(new int[][]{
                        new int[]{10, 100},
                        new int[]{15, 150},
                        new int[]{399, 400},
                        new int[]{499, 500}}), 10 + 15 + 400 + 500))
                .add(ExpectedTestcase.of(t -> t.twoCitySchedCost(new int[][]{
                        new int[]{10, 20},
                        new int[]{30, 200},
                        new int[]{400, 50},
                        new int[]{30, 40}}), 10 + 30 + 50 + 40))
                .build();
    }
}