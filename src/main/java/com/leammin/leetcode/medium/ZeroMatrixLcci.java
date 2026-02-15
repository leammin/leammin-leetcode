package com.leammin.leetcode.medium;

import com.leammin.leetcode.util.test.AbstractTest;
import com.leammin.leetcode.util.test.ExpectedTestcase;
import com.leammin.leetcode.util.test.Testsuite;

/**
 * 面试题 01.08. 零矩阵
 *
 * <p>编写一种算法，若M × N矩阵中某个元素为0，则将其所在的行与列清零。</p>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>示例 1：</strong></p>
 *
 * <pre><strong>输入：</strong>
 * [
 *   [1,1,1],
 *   [1,0,1],
 *   [1,1,1]
 * ]
 * <strong>输出：</strong>
 * [
 *   [1,0,1],
 *   [0,0,0],
 *   [1,0,1]
 * ]
 * </pre>
 *
 * <p><strong>示例 2：</strong></p>
 *
 * <pre><strong>输入：</strong>
 * [
 *   [0,1,2,0],
 *   [3,4,5,2],
 *   [1,3,1,5]
 * ]
 * <strong>输出：</strong>
 * [
 *   [0,0,0,0],
 *   [0,4,5,0],
 *   [0,3,1,0]
 * ]
 * </pre>
 *
 * @author Leammin
 * @date 2020-06-12
 */
public interface ZeroMatrixLcci {
    void setZeroes(int[][] matrix);

    static Testsuite<ZeroMatrixLcci> testsuite() {
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


    class Solution implements ZeroMatrixLcci {

        @Override
        public void setZeroes(int[][] matrix) {
            boolean i0 = false;
            boolean j0 = false;
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[0][j] == 0) {
                    i0 = true;
                    break;
                }
            }
            for (int i = 0; i < matrix.length; i++) {
                if (matrix[i][0] == 0) {
                    j0 = true;
                    break;
                }
            }
            for (int i = 1; i < matrix.length; i++) {
                for (int j = 1; j < matrix[i].length; j++) {
                    if (matrix[i][j] == 0) {
                        matrix[i][0] = 0;
                        matrix[0][j] = 0;
                    }
                }
            }
            for (int i = 1; i < matrix.length; i++) {
                if (matrix[i][0] == 0) {
                    for (int j = 1; j < matrix[i].length; j++) {
                        matrix[i][j] = 0;
                    }
                }
            }
            for (int j = 1; j < matrix[0].length; j++) {
                if (matrix[0][j] == 0) {
                    for (int i = 1; i < matrix.length; i++) {
                        matrix[i][j] = 0;
                    }
                }
            }
            if (i0) {
                for (int j = 0; j < matrix[0].length; j++) {
                    matrix[0][j] = 0;
                }
            }
            if (j0) {
                for (int i = 0; i < matrix.length; i++) {
                    matrix[i][0] = 0;
                }
            }
        }
    }
}

class ZeroMatrixLcciTest extends AbstractTest<ZeroMatrixLcci> {
}
