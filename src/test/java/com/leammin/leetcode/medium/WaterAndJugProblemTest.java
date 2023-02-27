package com.leammin.leetcode.medium;

import com.leammin.leetcode.util.AbstractTest;
import com.leammin.leetcode.util.test.ExpectedTestcase;
import com.leammin.leetcode.util.test.Testsuite;

/**
 * @author Leammin
 * @date 2020-03-21
 */
class WaterAndJugProblemTest extends AbstractTest<WaterAndJugProblem> {
    @Override
    protected Testsuite<WaterAndJugProblem> testsuite() {
        return Testsuite.<WaterAndJugProblem>builder()
                .add(ExpectedTestcase.of(t -> t.canMeasureWater(3, 5, 4), true))
                .add(ExpectedTestcase.of(t -> t.canMeasureWater(2, 6, 5), false))
                .add(ExpectedTestcase.of(t -> t.canMeasureWater(22003, 31237, 1), true))
                .build();
    }
}