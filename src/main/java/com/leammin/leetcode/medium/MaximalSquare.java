package com.leammin.leetcode.medium;

/**
 * 221. 最大正方形
 * 
 * <p>在一个由 0 和 1 组成的二维矩阵内，找到只包含 1 的最大正方形，并返回其面积。</p>
 * 
 * <p><strong>示例:</strong></p>
 * 
 * <pre><strong>输入: 
 * </strong>
 * 1 0 1 0 0
 * 1 0 <strong>1 1</strong> 1
 * 1 1 <strong>1 1 </strong>1
 * 1 0 0 1 0
 * 
 * <strong>输出: </strong>4</pre>
 * 
 * 
 * @author Leammin
 * @date 2020-05-08
 */
public interface MaximalSquare {
    int maximalSquare(char[][] matrix);

    class Solution implements MaximalSquare {

        @Override
        public int maximalSquare(char[][] matrix) {
            int res = 0;
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[i].length; j++) {
                    int x = 0;
                    while (isOne(matrix, i, j, x)) {
                        x++;
                    }
                    res = Math.max(res, x);
                }
            }
            return res * res;
        }

        private boolean isOne(char[][] matrix, int i, int j, int x) {
            if (i + x >= matrix.length || j + x >= matrix[i].length) {
                return false;
            }
            for (int m = i; m <= i + x; m++) {
                if (matrix[m][j + x] != '1') {
                    return false;
                }
            }
            for (int m = j; m <= j + x; m++) {
                if (matrix[i + x][m] != '1') {
                    return false;
                }
            }
            return true;
        }
    }
}
