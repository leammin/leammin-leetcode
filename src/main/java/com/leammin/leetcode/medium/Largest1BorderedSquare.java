package com.leammin.leetcode.medium;

/**
 * 1139. 最大的以 1 为边界的正方形
 *
 * <p>给你一个由若干 <code>0</code> 和 <code>1</code> 组成的二维网格&nbsp;<code>grid</code>，请你找出边界全部由 <code>1</code> 组成的最大 <strong>正方形</strong> 子网格，并返回该子网格中的元素数量。如果不存在，则返回 <code>0</code>。</p>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>示例 1：</strong></p>
 *
 * <pre><strong>输入：</strong>grid = [[1,1,1],[1,0,1],[1,1,1]]
 * <strong>输出：</strong>9
 * </pre>
 *
 * <p><strong>示例 2：</strong></p>
 *
 * <pre><strong>输入：</strong>grid = [[1,1,0,0]]
 * <strong>输出：</strong>1
 * </pre>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>提示：</strong></p>
 *
 * <ul>
 * 	<li><code>1 &lt;= grid.length &lt;= 100</code></li>
 * 	<li><code>1 &lt;= grid[0].length &lt;= 100</code></li>
 * 	<li><code>grid[i][j]</code> 为&nbsp;<code>0</code>&nbsp;或&nbsp;<code>1</code></li>
 * </ul>
 *
 * @author Leammin
 * @date 2023-02-18
 */
public interface Largest1BorderedSquare {
    int largest1BorderedSquare(int[][] grid);

    class Solution implements Largest1BorderedSquare {

        @Override
        public int largest1BorderedSquare(int[][] grid) {
            int n = grid.length;
            int m = grid[0].length;
            int[][][] count = new int[n + 1][m + 1][2];
            int res = 0;
            for (int i = n - 1; i >= 0; i--) {
                for (int j = m - 1; j >= 0; j--) {
                    if (grid[i][j] == 1) {
                        res = 1;
                        int a = count[i][j + 1][0] + 1; // 右边连续1的个数
                        int b = count[i + 1][j][1] + 1; // 下边连续1的个数
                        count[i][j] = new int[]{a, b};
                    }
                }
            }
            if (res == 0) {
                return 0;
            }
            for (int i = 0; i < n - res; i++) {
                for (int j = 0; j < m - res; j++) {
                    for (int b = Math.min(count[i][j][0], count[i][j][1]); b > res; b--) {
                        if (count[i][j + b - 1][1] >= b && count[i + b - 1][j][0] >= b) {
                            res = b;
                            break;
                        }
                    }
                }
            }
            return res * res;
        }
    }
}
