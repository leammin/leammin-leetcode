package com.leammin.leetcode.medium;

import com.leammin.leetcode.util.AbstractTest;
import com.leammin.leetcode.util.ExpectedTestcase;
import com.leammin.leetcode.util.Testsuite;

/**
 * @author Leammin
 * @date 2020-06-12
 */
class ZeroMatrixLcciTest extends AbstractTest<ZeroMatrixLcci> {
    @Override
    protected Testsuite<ZeroMatrixLcci> testsuite() {
        return Testsuite.<ZeroMatrixLcci>builder()
                .add(ExpectedTestcase.of(t -> {
                    int[][] matrix = new int[][]{
                            {1, 1, 1},
                            {1, 0, 1},
                            {1, 1, 1}
                    };
                    t.setZeroes(matrix);
                    return matrix;
                }, new int[][]{
                        {1, 0, 1},
                        {0, 0, 0},
                        {1, 0, 1}
                }))
                .add(ExpectedTestcase.of(t -> {
                    int[][] matrix = new int[][]{
                            {0, 1, 2, 0},
                            {3, 4, 5, 2},
                            {1, 3, 1, 5}
                    };
                    t.setZeroes(matrix);
                    return matrix;
                }, new int[][]{
                        {0, 0, 0, 0},
                        {0, 4, 5, 0},
                        {0, 3, 1, 0}
                }))
                .build();
    }
}