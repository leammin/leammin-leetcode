package com.leammin.leetcode.medium;

/**
 * 64. 最小路径和
 *
 * <div><p>给定一个包含非负整数的 <em>m</em>&nbsp;x&nbsp;<em>n</em>&nbsp;网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。</p>
 *
 * <p><strong>说明：</strong>每次只能向下或者向右移动一步。</p>
 *
 * <p><strong>示例:</strong></p>
 *
 * <pre><strong>输入:</strong>
 * [
 * &nbsp; [1,3,1],
 *   [1,5,1],
 *   [4,2,1]
 * ]
 * <strong>输出:</strong> 7
 * <strong>解释:</strong> 因为路径 1→3→1→1→1 的总和最小。
 * </pre>
 * </div>
 *
 * @author Leammin
 * @date 2019-03-24
 */
public interface MinimumPathSum {
    int minPathSum(int[][] grid);

    class Solution implements MinimumPathSum {
        @Override
        public int minPathSum(int[][] grid) {

            return minPathSum(grid, 0, 0, new int[grid.length][grid[0].length]);
        }

        private int minPathSum(int[][] grid, int row, int col, int[][] cache) {
            if (cache[row][col] != 0) {
                return cache[row][col];
            }
            if (row == grid.length - 1 && col == grid[0].length - 1) {
                return grid[row][col];
            }
            if (row == grid.length - 1) {
                return cache[row][col] = grid[row][col] + minPathSum(grid, row, col + 1, cache);
            }
            if (col == grid[0].length - 1) {
                return cache[row][col] = grid[row][col] + minPathSum(grid, row + 1, col, cache);
            }
            return cache[row][col] = grid[row][col] + Math.min(
                    minPathSum(grid, row + 1, col, cache),
                    minPathSum(grid, row, col + 1, cache));
        }
    }
}
