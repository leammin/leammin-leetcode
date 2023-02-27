package com.leammin.leetcode.medium;

import com.leammin.leetcode.util.AbstractTest;
import com.leammin.leetcode.util.test.ExpectedTestcase;
import com.leammin.leetcode.util.test.Testsuite;

/**
 * @author Leammin
 * @date 2020-04-07
 */
class RotateMatrixLcciTest extends AbstractTest<RotateMatrixLcci> {
    @Override
    protected Testsuite<RotateMatrixLcci> testsuite() {
        return Testsuite.<RotateMatrixLcci>builder()
                .add(ExpectedTestcase.of(t -> {
                    int[][] matrix = {
                            {1, 2, 3},
                            {4, 5, 6},
                            {7, 8, 9}
                    };
                    t.rotate(matrix);
                    return matrix;
                }, new int[][]{
                        {7, 4, 1},
                        {8, 5, 2},
                        {9, 6, 3}
                }))
                .add(ExpectedTestcase.of(t -> {
                    int[][] matrix = {
                            {5, 1, 9, 11},
                            {2, 4, 8, 10},
                            {13, 3, 6, 7},
                            {15, 14, 12, 16}
                    };
                    t.rotate(matrix);
                    return matrix;
                }, new int[][]{
                        {15, 13, 2, 5},
                        {14, 3, 4, 1},
                        {12, 6, 8, 9},
                        {16, 7, 10, 11}
                }))
                .build();
    }
}