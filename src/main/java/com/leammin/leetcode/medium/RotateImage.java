package com.leammin.leetcode.medium;

/**
 * 48. 旋转图像
 *
 * <div><p>给定一个 <em>n&nbsp;</em>×&nbsp;<em>n</em> 的二维矩阵表示一个图像。</p>
 *
 * <p>将图像顺时针旋转 90 度。</p>
 *
 * <p><strong>说明：</strong></p>
 *
 * <p>你必须在<strong><a href="https://baike.baidu.com/item/%E5%8E%9F%E5%9C%B0%E7%AE%97%E6%B3%95" target="_blank">原地</a></strong>旋转图像，这意味着你需要直接修改输入的二维矩阵。<strong>请不要</strong>使用另一个矩阵来旋转图像。</p>
 *
 * <p><strong>示例 1:</strong></p>
 *
 * <pre>给定 <strong>matrix</strong> =
 * [
 *   [1,2,3],
 *   [4,5,6],
 *   [7,8,9]
 * ],
 *
 * <strong>原地</strong>旋转输入矩阵，使其变为:
 * [
 *   [7,4,1],
 *   [8,5,2],
 *   [9,6,3]
 * ]
 * </pre>
 *
 * <p><strong>示例 2:</strong></p>
 *
 * <pre>给定 <strong>matrix</strong> =
 * [
 *   [ 5, 1, 9,11],
 *   [ 2, 4, 8,10],
 *   [13, 3, 6, 7],
 *   [15,14,12,16]
 * ],
 *
 * <strong>原地</strong>旋转输入矩阵，使其变为:
 * [
 *   [15,13, 2, 5],
 *   [14, 3, 4, 1],
 *   [12, 6, 8, 9],
 *   [16, 7,10,11]
 * ]
 * </pre>
 * </div>
 *
 * @author Leammin
 * @date 2018-10-11
 */
public interface RotateImage {
    void rotate(int[][] matrix);

    class Solution implements RotateImage {
        @Override
        public void rotate(int[][] matrix) {
            if (matrix == null || matrix.length < 2) {
                return;
            }
            for (int margin = 0; margin < matrix.length / 2; margin++) {
                rotate(matrix, margin);
            }
        }

        private void rotate(int[][] matrix, int margin) {
            for (int col = margin; col < matrix.length - 1 - margin; col++) {
                rotate(matrix, margin, col);
            }
        }

        /**
         * row, col
         * col, n-1-row
         * n-1-row, n-1-col
         * n-1-col, row
         *
         * @param matrix
         * @param row
         * @param col
         */
        private void rotate(int[][] matrix, int row, int col) {
            int n = matrix.length;
            int tmp = matrix[row][col];
            matrix[row][col] = matrix[n - 1 - col][row];
            matrix[n - 1 - col][row] = matrix[n - 1 - row][n - 1 - col];
            matrix[n - 1 - row][n - 1 - col] = matrix[col][n - 1 - row];
            matrix[col][n - 1 - row] = tmp;
        }
    }
}
