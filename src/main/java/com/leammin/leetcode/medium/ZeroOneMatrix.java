package com.leammin.leetcode.medium;

import com.leammin.leetcode.util.test.AbstractTest;
import com.leammin.leetcode.util.test.ExpectedTestcase;
import com.leammin.leetcode.util.test.Testsuite;

/**
 * 542. 01 矩阵
 * 
 * <p>给定一个由 0 和 1 组成的矩阵，找出每个元素到最近的 0 的距离。</p>
 * 
 * <p>两个相邻元素间的距离为 1 。</p>
 * 
 * <p><strong>示例 1: </strong><br />
 * 输入:</p>
 * 
 * <pre>
 * 0 0 0
 * 0 1 0
 * 0 0 0
 * </pre>
 * 
 * <p>输出:</p>
 * 
 * <pre>
 * 0 0 0
 * 0 1 0
 * 0 0 0
 * </pre>
 * 
 * <p><strong>示例 2: </strong><br />
 * 输入:</p>
 * 
 * <pre>
 * 0 0 0
 * 0 1 0
 * 1 1 1
 * </pre>
 * 
 * <p>输出:</p>
 * 
 * <pre>
 * 0 0 0
 * 0 1 0
 * 1 2 1
 * </pre>
 * 
 * <p><strong>注意:</strong></p>
 * 
 * <ol>
 * 	<li>给定矩阵的元素个数不超过 10000。</li>
 * 	<li>给定矩阵中至少有一个元素是 0。</li>
 * 	<li>矩阵中的元素只在四个方向上相邻: 上、下、左、右。</li>
 * </ol>
 * 
 * 
 * @author Leammin
 * @date 2020-04-16
 */
public interface ZeroOneMatrix {
    int[][] updateMatrix(int[][] matrix);

    static Testsuite<ZeroOneMatrix> testsuite() {
        return Testsuite.<ZeroOneMatrix>builder()
                .add(ExpectedTestcase.of(t -> t.updateMatrix(new int[][]{
                        {0, 0, 0},
                        {0, 1, 0},
                        {0, 0, 0}
                }), new int[][]{
                        {0, 0, 0},
                        {0, 1, 0},
                        {0, 0, 0}
                }))
                .add(ExpectedTestcase.of(t -> t.updateMatrix(new int[][]{
                        {0, 0, 0},
                        {0, 1, 0},
                        {1, 1, 1}
                }), new int[][]{
                        {0, 0, 0},
                        {0, 1, 0},
                        {1, 2, 1}
                }))
                .add(ExpectedTestcase.of(t -> t.updateMatrix(new int[][]{
                        {0},
                        {1}
                }), new int[][]{
                        {0},
                        {1}
                }))
                .build();
    }


    class Solution implements ZeroOneMatrix {

        @Override
        public int[][] updateMatrix(int[][] matrix) {
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[i].length; j++) {
                    if (matrix[i][j] != 0) {
                        int t = Integer.MAX_VALUE;
                        if (i > 0) {
                            t = Math.min(t, matrix[i - 1][j]);
                        }
                        if (j > 0) {
                            t = Math.min(t, matrix[i][j - 1]);
                        }
                        matrix[i][j] = t == Integer.MAX_VALUE ? t : t + 1;
                    }
                }
            }
            for (int i = matrix.length - 1; i >= 0; i--) {
                for (int j = matrix[i].length - 1; j >= 0; j--) {
                    if (matrix[i][j] != 0) {
                        int t = matrix[i][j] - 1;
                        if (i < matrix.length - 1) {
                            t = Math.min(t, matrix[i + 1][j]);
                        }
                        if (j < matrix[i].length - 1) {
                            t = Math.min(t, matrix[i][j + 1]);
                        }
                        matrix[i][j] = t + 1;
                    }
                }
            }
            return matrix;
        }
    }
}

class ZeroOneMatrixTest extends AbstractTest<ZeroOneMatrix> {
}
