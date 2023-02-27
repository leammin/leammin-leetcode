package com.leammin.leetcode.medium;

import com.leammin.leetcode.util.AbstractTest;
import com.leammin.leetcode.util.test.ExpectedTestcase;
import com.leammin.leetcode.util.test.Testsuite;

/**
 * @author Leammin
 * @date 2020-04-02
 */
class GameOfLifeTest extends AbstractTest<GameOfLife> {
    @Override
    protected Testsuite<GameOfLife> testsuite() {
        return Testsuite.<GameOfLife>builder()
                .add(ExpectedTestcase.of(t -> {
                    int[][] board = {
                            {0, 1, 0},
                            {0, 0, 1},
                            {1, 1, 1},
                            {0, 0, 0}
                    };
                    t.gameOfLife(board);
                    return board;
                }, new int[][]{
                        {0, 0, 0},
                        {1, 0, 1},
                        {0, 1, 1},
                        {0, 1, 0}
                }))
                .build();
    }
}