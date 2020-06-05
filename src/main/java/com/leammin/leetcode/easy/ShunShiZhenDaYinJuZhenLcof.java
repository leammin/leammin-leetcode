package com.leammin.leetcode.easy;

/**
 * 面试题29. 顺时针打印矩阵
 *
 * <p>输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。</p>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>示例 1：</strong></p>
 *
 * <pre><strong>输入：</strong>matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * <strong>输出：</strong>[1,2,3,6,9,8,7,4,5]
 * </pre>
 *
 * <p><strong>示例 2：</strong></p>
 *
 * <pre><strong>输入：</strong>matrix =&nbsp;[[1,2,3,4],[5,6,7,8],[9,10,11,12]]
 * <strong>输出：</strong>[1,2,3,4,8,12,11,10,9,5,6,7]
 * </pre>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>限制：</strong></p>
 *
 * <ul>
 * 	<li><code>0 &lt;= matrix.length &lt;= 100</code></li>
 * 	<li><code>0 &lt;= matrix[i].length&nbsp;&lt;= 100</code></li>
 * </ul>
 *
 * <p>注意：本题与主站 54 题相同：<a href="https://leetcode-cn.com/problems/spiral-matrix/">https://leetcode-cn.com/problems/spiral-matrix/</a></p>
 *
 * @author Leammin
 * @date 2020-06-05
 */
public interface ShunShiZhenDaYinJuZhenLcof {
    int[] spiralOrder(int[][] matrix);

    class Solution implements ShunShiZhenDaYinJuZhenLcof {

        @Override
        public int[] spiralOrder(int[][] matrix) {
            if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
                return new int[0];
            }
            int[] res = new int[matrix.length * matrix[0].length];
            int index = 0;
            for (int offset = 0; offset < (matrix.length + 1) / 2 && offset < (matrix[0].length + 1) / 2; offset++) {
                int i = offset;
                int j = offset;
                if (offset == matrix.length - offset - 1) {
                    for (; j < matrix[0].length - offset; j++) {
                        res[index++] = matrix[i][j];
                    }
                } else if (offset == matrix[0].length - offset - 1) {
                    for (; i < matrix.length - offset; i++) {
                        res[index++] = matrix[i][j];
                    }
                } else {
                    for (; j < matrix[0].length - offset - 1; j++) {
                        res[index++] = matrix[i][j];
                    }
                    for (; i < matrix.length - offset - 1; i++) {
                        res[index++] = matrix[i][j];
                    }
                    for (; j > offset; j--) {
                        res[index++] = matrix[i][j];
                    }
                    for (; i > offset; i--) {
                        res[index++] = matrix[i][j];
                    }
                }
            }
            return res;
        }
    }
}
