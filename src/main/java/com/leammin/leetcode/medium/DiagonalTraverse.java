package com.leammin.leetcode.medium;

/**
 * 498. 对角线遍历
 *
 * <p>给定一个含有 M x N 个元素的矩阵（M 行，N 列），请以对角线遍历的顺序返回这个矩阵中的所有元素，对角线遍历如下图所示。</p>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>示例:</strong></p>
 *
 * <pre><strong>输入:</strong>
 * [
 *  [ 1, 2, 3 ],
 *  [ 4, 5, 6 ],
 *  [ 7, 8, 9 ]
 * ]
 *
 * <strong>输出:</strong>  [1,2,4,7,5,3,6,8,9]
 *
 * <strong>解释:</strong>
 * <img src="https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2018/10/12/diagonal_traverse.png" style="width: 220px;">
 * </pre>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>说明:</strong></p>
 *
 * <ol>
 * 	<li>给定矩阵中的元素总数不会超过 100000 。</li>
 * </ol>
 *
 * @author Leammin
 * @date 2020-06-12
 */
public interface DiagonalTraverse {
    int[] findDiagonalOrder(int[][] matrix);

    class Solution implements DiagonalTraverse {

        @Override
        public int[] findDiagonalOrder(int[][] matrix) {
            if (matrix.length == 0 || matrix[0].length == 0) {
                return new int[0];
            }
            int m = matrix.length;
            int n = matrix[0].length;
            int[] res = new int[m * n];
            int index = 0;
            for (int s = 0; s <= m + n - 2; s++) {
                if ((s & 1) == 1) {
                    for (int i = Math.max(0, s - n + 1); i < Math.min(s + 1, m); i++) {
                        res[index++] = matrix[i][s - i];
                    }
                } else {
                    for (int j = Math.max(0, s - m + 1); j < Math.min(s + 1, n); j++) {
                        res[index++] = matrix[s - j][j];
                    }
                }
            }
            return res;
        }
    }
}
