package com.leammin.leetcode.undone.hard;

import com.leammin.leetcode.util.test.AbstractTest;
import com.leammin.leetcode.util.test.ExpectedTestcase;
import com.leammin.leetcode.util.test.Testsuite;

/**
 * 329. 矩阵中的最长递增路径
 *
 * <p>给定一个整数矩阵，找出最长递增路径的长度。</p>
 *
 * <p>对于每个单元格，你可以往上，下，左，右四个方向移动。 你不能在对角线方向上移动或移动到边界外（即不允许环绕）。</p>
 *
 * <p><strong>示例 1:</strong></p>
 *
 * <pre><strong>输入: </strong>nums =
 * [
 *   [<strong>9</strong>,9,4],
 *   [<strong>6</strong>,6,8],
 *   [<strong>2</strong>,<strong>1</strong>,1]
 * ]
 * <strong>输出:</strong> 4
 * <strong>解释:</strong> 最长递增路径为&nbsp;<code>[1, 2, 6, 9]</code>。</pre>
 *
 * <p><strong>示例 2:</strong></p>
 *
 * <pre><strong>输入:</strong> nums =
 * [
 *   [<strong>3</strong>,<strong>4</strong>,<strong>5</strong>],
 *   [3,2,<strong>6</strong>],
 *   [2,2,1]
 * ]
 * <strong>输出: </strong>4
 * <strong>解释: </strong>最长递增路径是&nbsp;<code>[3, 4, 5, 6]</code>。注意不允许在对角线方向上移动。
 * </pre>
 *
 * @author Leammin
 * @date 2020-07-26
 */
public interface LongestIncreasingPathInAMatrix {
    int longestIncreasingPath(int[][] matrix);

    static Testsuite<LongestIncreasingPathInAMatrix> testsuite() {
        return Testsuite.<LongestIncreasingPathInAMatrix>builder()
                .add(ExpectedTestcase.of(t -> t.longestIncreasingPath(new int[][]{
                        {9, 9, 4},
                        {6, 6, 8},
                        {2, 1, 1}
                }), 4))
                .add(ExpectedTestcase.of(t -> t.longestIncreasingPath(new int[][]{
                        {3, 4, 5},
                        {3, 2, 6},
                        {2, 2, 1}
                }), 4))
                .build();
    }


    class Solution implements LongestIncreasingPathInAMatrix {

        @Override
        public int longestIncreasingPath(int[][] matrix) {
            if (matrix.length == 0) {
                return 0;
            }
            int max = 0;
            int[][] dp = new int[matrix.length][matrix[0].length];
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[i].length; j++) {
                    max = Math.max(max, longestIncreasingPath(matrix, i, j, dp));
                }
            }
            return max;
        }

        public int longestIncreasingPath(int[][] matrix, int x, int y, int[][] dp) {
            if (dp[x][y] != 0) {
                return dp[x][y];
            }
            int max = 1;
            if (x > 0 && matrix[x - 1][y] > matrix[x][y]) {
                max = Math.max(max, 1 + longestIncreasingPath(matrix, x - 1, y, dp));
            }
            if (x < matrix.length - 1 && matrix[x + 1][y] > matrix[x][y]) {
                max = Math.max(max, 1 + longestIncreasingPath(matrix, x + 1, y, dp));
            }
            if (y > 0 && matrix[x][y - 1] > matrix[x][y]) {
                max = Math.max(max, 1 + longestIncreasingPath(matrix, x, y - 1, dp));
            }
            if (y < matrix[0].length - 1 && matrix[x][y + 1] > matrix[x][y]) {
                max = Math.max(max, 1 + longestIncreasingPath(matrix, x, y + 1, dp));
            }
            return dp[x][y] = max;
        }
    }
}

class LongestIncreasingPathInAMatrixTest extends AbstractTest<LongestIncreasingPathInAMatrix> {
}
