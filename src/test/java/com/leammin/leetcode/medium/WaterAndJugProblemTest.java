package com.leammin.leetcode.medium;

import com.leammin.leetcode.util.AbstractTest;
import com.leammin.leetcode.util.ExpectedTestcase;
import com.leammin.leetcode.util.Testsuite;

/**
 * @author Leammin
 * @date 2020-03-21
 */
class WaterAndJugProblemTest extends AbstractTest<WaterAndJugProblem> {
    @Override
    protected Testsuite<WaterAndJugProblem> testsuite() {
        return Testsuite.<WaterAndJugProblem>builder()
                .add(ExpectedTestcase.of(true, t -> t.canMeasureWater(3, 5, 4)))
                .add(ExpectedTestcase.of(false, t -> t.canMeasureWater(2, 6, 5)))
                .add(ExpectedTestcase.of(true, t -> t.canMeasureWater(22003, 31237, 1)))
                .build();
    }
}