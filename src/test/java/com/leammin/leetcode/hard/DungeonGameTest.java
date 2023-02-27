package com.leammin.leetcode.hard;

import com.leammin.leetcode.util.AbstractTest;
import com.leammin.leetcode.util.test.ExpectedTestcase;
import com.leammin.leetcode.util.test.Testsuite;

/**
 * @author Leammin
 * @date 2020-07-12
 */
class DungeonGameTest extends AbstractTest<DungeonGame> {
    @Override
    protected Testsuite<DungeonGame> testsuite() {
        return Testsuite.<DungeonGame>builder()
                .add(ExpectedTestcase.of(t -> t.calculateMinimumHP(new int[][]{
                        {-2, -3, 3},
                        {-5, -10, 1},
                        {10, 30, -5}
                }), 7))
                .add(ExpectedTestcase.of(t -> t.calculateMinimumHP(new int[][]{
                        {-2, -3, 10000},
                        {-5, -10, 1},
                        {10, 30, -5}
                }), 6))
                .add(ExpectedTestcase.of(t -> t.calculateMinimumHP(new int[][]{
                        {2, 3, 10000},
                        {-5, -10, 1},
                        {10, 30, -5}
                }), 1))
                .build();
    }
}