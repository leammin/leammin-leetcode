package com.leammin.leetcode.medium;

import com.leammin.leetcode.util.test.AbstractTest;
import com.leammin.leetcode.util.test.ExpectedTestcase;
import com.leammin.leetcode.util.test.Testsuite;

/**
 * 73. 矩阵置零
 *
 * <div><p>给定一个&nbsp;<em>m</em> x <em>n</em> 的矩阵，如果一个元素为 0，则将其所在行和列的所有元素都设为 0。请使用<strong><a href="http://baike.baidu.com/item/%E5%8E%9F%E5%9C%B0%E7%AE%97%E6%B3%95" target="_blank">原地</a></strong>算法<strong>。</strong></p>
 *
 * <p><strong>示例&nbsp;1:</strong></p>
 *
 * <pre><strong>输入:</strong>
 * [
 * &nbsp; [1,1,1],
 * &nbsp; [1,0,1],
 * &nbsp; [1,1,1]
 * ]
 * <strong>输出:</strong>
 * [
 * &nbsp; [1,0,1],
 * &nbsp; [0,0,0],
 * &nbsp; [1,0,1]
 * ]
 * </pre>
 *
 * <p><strong>示例&nbsp;2:</strong></p>
 *
 * <pre><strong>输入:</strong>
 * [
 * &nbsp; [0,1,2,0],
 * &nbsp; [3,4,5,2],
 * &nbsp; [1,3,1,5]
 * ]
 * <strong>输出:</strong>
 * [
 * &nbsp; [0,0,0,0],
 * &nbsp; [0,4,5,0],
 * &nbsp; [0,3,1,0]
 * ]</pre>
 *
 * <p><strong>进阶:</strong></p>
 *
 * <ul>
 * <li>一个直接的解决方案是使用 &nbsp;O(<em>m</em><em>n</em>)&nbsp;的额外空间，但这并不是一个好的解决方案。</li>
 * <li>一个简单的改进方案是使用 O(<em>m</em>&nbsp;+&nbsp;<em>n</em>) 的额外空间，但这仍然不是最好的解决方案。</li>
 * <li>你能想出一个常数空间的解决方案吗？</li>
 * </ul>
 * </div>
 *
 * @author Leammin
 * @date 2018-11-04
 */
public interface SetMatrixZeroes {
    void setZeroes(int[][] matrix);

    static Testsuite<SetMatrixZeroes> testsuite() {
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


    class Solution implements SetMatrixZeroes {
        @Override
        public void setZeroes(int[][] matrix) {
            if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) {
                return;
            }
            boolean[] row = new boolean[matrix.length];
            boolean[] col = new boolean[matrix[0].length];
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[i].length; j++) {
                    if (matrix[i][j] == 0) {
                        row[i] = true;
                        col[j] = true;
                    }
                }
            }
            for (int i = 0; i < row.length; i++) {
                if (row[i]) {
                    for (int j = 0; j < matrix[i].length; j++) {
                        matrix[i][j] = 0;
                    }
                }
            }
            for (int j = 0; j < col.length; j++) {
                if (col[j]) {
                    for (int i = 0; i < matrix.length; i++) {
                        matrix[i][j] = 0;
                    }
                }
            }

        }
    }

    class Best implements SetMatrixZeroes {
        @Override
        public void setZeroes(int[][] matrix) {
            boolean row0 = false;
            boolean col0 = false;
            for (int i = 0; i < matrix[0].length; i++) {
                if (matrix[0][i] == 0) {
                    row0 = true;
                }
            }
            for (int i = 0; i < matrix.length; i++) {
                if (matrix[i][0] == 0) {
                    col0 = true;
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
                for (int j = 1; j < matrix[i].length; j++) {
                    if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                        matrix[i][j] = 0;
                    }
                }
            }
            if (row0) {
                for (int i = 0; i < matrix[0].length; i++) {
                    matrix[0][i] = 0;
                }
            }
            if (col0) {
                for (int i = 0; i < matrix.length; i++) {
                    matrix[i][0] = 0;
                }
            }
        }
    }
}

class SetMatrixZeroesTest extends AbstractTest<SetMatrixZeroes> {
}
