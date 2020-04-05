package com.leammin.leetcode.medium;

/**
 * 74. 搜索二维矩阵
 *
 * <p>编写一个高效的算法来判断&nbsp;<em>m</em> x <em>n</em>&nbsp;矩阵中，是否存在一个目标值。该矩阵具有如下特性：</p>
 *
 * <ul>
 * 	<li>每行中的整数从左到右按升序排列。</li>
 * 	<li>每行的第一个整数大于前一行的最后一个整数。</li>
 * </ul>
 *
 * <p><strong>示例&nbsp;1:</strong></p>
 *
 * <pre><strong>输入:</strong>
 * matrix = [
 *   [1,   3,  5,  7],
 *   [10, 11, 16, 20],
 *   [23, 30, 34, 50]
 * ]
 * target = 3
 * <strong>输出:</strong> true
 * </pre>
 *
 * <p><strong>示例&nbsp;2:</strong></p>
 *
 * <pre><strong>输入:</strong>
 * matrix = [
 *   [1,   3,  5,  7],
 *   [10, 11, 16, 20],
 *   [23, 30, 34, 50]
 * ]
 * target = 13
 * <strong>输出:</strong> false</pre>
 *
 * @author Leammin
 * @date 2020-04-03
 */
public interface SearchA2dMatrix {
    boolean searchMatrix(int[][] matrix, int target);

    class Solution implements SearchA2dMatrix {

        @Override
        public boolean searchMatrix(int[][] matrix, int target) {
            if (matrix == null || matrix.length == 0) {
                return false;
            }
            return searchMatrix(matrix, target, 0, matrix.length, 0, matrix[0].length);
        }

        private boolean searchMatrix(int[][] matrix, int target, int ilo, int ihi, int jlo, int jhi) {
            if (ilo >= ihi || jlo >= jhi) {
                return false;
            }
            int imid = (ilo + ihi) / 2;
            int jmid = (jlo + jhi) / 2;
            if (target == matrix[imid][jmid]) {
                return true;
            }
            if (target < matrix[imid][jmid]) {
                return searchMatrix(matrix, target, ilo, ihi, jlo, jmid)
                        || searchMatrix(matrix, target, ilo, imid, jmid, jhi);
            } else {
                return searchMatrix(matrix, target, ilo, ihi, jmid + 1, jhi)
                        || searchMatrix(matrix, target, imid + 1, ihi, jlo, jmid + 1);
            }
        }
    }

    class Solution2 implements SearchA2dMatrix {

        @Override
        public boolean searchMatrix(int[][] matrix, int target) {
            int i = matrix.length - 1;
            int j = 0;
            while (i >= 0 && j < matrix[i].length) {
                if (matrix[i][j] > target) {
                    i--;
                } else if (matrix[i][j] < target) {
                    j++;
                } else {
                    return true;
                }
            }
            return false;
        }
    }
}
