package com.leammin.leetcode.easy;

import com.leammin.leetcode.util.test.AbstractTest;
import com.leammin.leetcode.util.test.ExpectedTestcase;
import com.leammin.leetcode.util.test.Testsuite;

/**
 * 867. 转置矩阵
 * 
 * <p>给定一个矩阵&nbsp;<code>A</code>，&nbsp;返回&nbsp;<code>A</code>&nbsp;的转置矩阵。</p>
 * 
 * <p>矩阵的转置是指将矩阵的主对角线翻转，交换矩阵的行索引与列索引。</p>
 * 
 * <p>&nbsp;</p>
 * 
 * <p><strong>示例 1：</strong></p>
 * 
 * <pre><strong>输入：</strong>[[1,2,3],[4,5,6],[7,8,9]]
 * <strong>输出：</strong>[[1,4,7],[2,5,8],[3,6,9]]
 * </pre>
 * 
 * <p><strong>示例 2：</strong></p>
 * 
 * <pre><strong>输入：</strong>[[1,2,3],[4,5,6]]
 * <strong>输出：</strong>[[1,4],[2,5],[3,6]]
 * </pre>
 * 
 * <p>&nbsp;</p>
 * 
 * <p><strong>提示：</strong></p>
 * 
 * <ol>
 * 	<li><code>1 &lt;= A.length&nbsp;&lt;= 1000</code></li>
 * 	<li><code>1 &lt;= A[0].length&nbsp;&lt;= 1000</code></li>
 * </ol>
 * 
 * 
 * @author Leammin
 * @date 2021-02-25
 */
public interface TransposeMatrix {
    int[][] transpose(int[][] A);

    static Testsuite<TransposeMatrix> testsuite() {
        return Testsuite.<TransposeMatrix>builder()
                .add(ExpectedTestcase.of(t -> t.transpose(new int[][]{
                        {1,2,3},
                        {4,5,6},
                        {7,8,9}
                }), new int[][]{
                        {1,4,7},
                        {2,5,8},
                        {3,6,9}
                }))
                .build();
    }


    class Solution implements TransposeMatrix {

        @Override
        public int[][] transpose(int[][] matrix) {
            if (matrix.length == 0) {
                return matrix;
            }
            int m = matrix.length;
            int n = matrix[0].length;
            int[][] res = new int[n][m];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    res[j][i] = matrix[i][j];
                }
            }
            return res;
        }
    }
}

class TransposeMatrixTest extends AbstractTest<TransposeMatrix> {
}
