package com.leammin.leetcode.medium;

import com.leammin.leetcode.undone.medium.DiceRollSimulation;
import com.leammin.leetcode.util.AbstractTest;
import com.leammin.leetcode.util.test.Testsuite;

/**
 * @author Leammin
 * @date 2023-02-12
 */
class DiceRollSimulationTest extends AbstractTest<DiceRollSimulation> {
    @Override
    protected Testsuite<DiceRollSimulation> testsuite() {
        return Testsuite.<DiceRollSimulation>builder()
                .addExpected(t -> t.dieSimulator(2, new int[]{1, 1, 2, 2, 2, 3}), 34)
                .addExpected(t -> t.dieSimulator(2, new int[]{1, 1, 1, 1, 1, 1}), 30)
                .addExpected(t -> t.dieSimulator(3, new int[]{1, 1, 1, 2, 2, 3}), 181)
                .build();
    }
}