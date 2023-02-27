package com.leammin.leetcode.medium;

import com.leammin.leetcode.util.AbstractTest;
import com.leammin.leetcode.util.test.ExpectedTestcase;
import com.leammin.leetcode.util.test.Testsuite;

/**
 * @author Leammin
 * @date 2020-07-06
 */
class UniquePathsIiTest extends AbstractTest<UniquePathsIi> {
    @Override
    protected Testsuite<UniquePathsIi> testsuite() {
        return Testsuite.<UniquePathsIi>builder()
                .add(ExpectedTestcase.of(t -> t.uniquePathsWithObstacles(new int[][]{
                        {0, 0, 0},
                        {0, 1, 0},
                        {0, 0, 0}
                }), 2))
                .add(ExpectedTestcase.of(t -> t.uniquePathsWithObstacles(new int[][]{
                        {0},
                }), 1))
                .add(ExpectedTestcase.of(t -> t.uniquePathsWithObstacles(new int[][]{
                        {1},
                }), 0))
                .add(ExpectedTestcase.of(t -> t.uniquePathsWithObstacles(new int[][]{
                        {0,1},
                }), 0))
                .build();
    }
}