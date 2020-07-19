package com.leammin.leetcode.hard;

import com.leammin.leetcode.undone.hard.BurstBalloons;
import com.leammin.leetcode.util.AbstractTest;
import com.leammin.leetcode.util.ExpectedTestcase;
import com.leammin.leetcode.util.Testsuite;

/**
 * @author Leammin
 * @date 2020-07-19
 */
class BurstBalloonsTest extends AbstractTest<BurstBalloons> {
    @Override
    protected Testsuite<BurstBalloons> testsuite() {
        return Testsuite.<BurstBalloons>builder()
                .add(ExpectedTestcase.of(t -> t.maxCoins(new int[]{3, 1, 5, 8}), 167))
                .add(ExpectedTestcase.of(t -> t.maxCoins(new int[]{7, 9, 8, 0, 7, 1, 3, 5, 5, 2, 3, 3}), 1717))
                .add(ExpectedTestcase.of(t -> t.maxCoins(new int[]{8, 3, 4, 3, 5, 0, 5, 6, 6, 2, 8, 5, 6, 2, 3, 8, 3, 5, 1, 0, 2}), 3394))
                .build();
    }
}