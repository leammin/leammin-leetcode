package com.leammin.leetcode.medium;

import com.leammin.leetcode.util.AbstractTest;
import com.leammin.leetcode.util.ExpectedTestcase;
import com.leammin.leetcode.util.Testsuite;

/**
 * @author Leammin
 * @date 2020-01-18
 */
class SetMatrixZeroesTest extends AbstractTest<SetMatrixZeroes> {
    @Override
    protected Testsuite<SetMatrixZeroes> testsuite() {
        return Testsuite.<SetMatrixZeroes>builder()
                .add(ExpectedTestcase.of(s -> {
                    int[][] matrix = {new int[]{1, 1, 1}, new int[]{1, 0, 1}, new int[]{1, 1, 1}};
                    s.setZeroes(matrix);
                    return matrix;
                }, new int[][]{new int[]{1, 0, 1}, new int[]{0, 0, 0}, new int[]{1, 0, 1}}
                ))
                .add(ExpectedTestcase.of(s -> {
                    int[][] matrix = {new int[]{0, 1, 2, 0}, new int[]{3, 4, 5, 2}, new int[]{1, 3, 1, 5}};
                    s.setZeroes(matrix);
                    return matrix;
                }, new int[][]{new int[]{0, 0, 0, 0}, new int[]{0, 4, 5, 0}, new int[]{0, 3, 1, 0}}
                ))
                .build();
    }
}