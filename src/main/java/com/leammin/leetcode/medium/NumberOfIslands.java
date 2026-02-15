package com.leammin.leetcode.medium;

import java.util.LinkedList;
import java.util.Queue;

import com.leammin.leetcode.util.test.AbstractTest;
import com.leammin.leetcode.util.test.ExpectedTestcase;
import com.leammin.leetcode.util.test.Testsuite;

/**
 * 200. 岛屿数量
 *
 * <p>给定一个由&nbsp;<code>&#39;1&#39;</code>（陆地）和 <code>&#39;0&#39;</code>（水）组成的的二维网格，计算岛屿的数量。一个岛被水包围，并且它是通过水平方向或垂直方向上相邻的陆地连接而成的。你可以假设网格的四个边均被水包围。</p>
 *
 * <p><strong>示例 1:</strong></p>
 *
 * <pre><strong>输入:</strong>
 * 11110
 * 11010
 * 11000
 * 00000
 *
 * <strong>输出:</strong>&nbsp;1
 * </pre>
 *
 * <p><strong>示例&nbsp;2:</strong></p>
 *
 * <pre><strong>输入:</strong>
 * 11000
 * 11000
 * 00100
 * 00011
 *
 * <strong>输出: </strong>3
 * </pre>
 *
 * @author Leammin
 * @date 2020-03-17
 */
public interface NumberOfIslands {
    int numIslands(char[][] grid);

    static Testsuite<NumberOfIslands> testsuite() {
        return Testsuite.<NumberOfIslands>builder()
                .add(ExpectedTestcase.of(t -> t.numIslands(new char[][]{
                        {'1', '1', '1', '1', '0'},
                        {'1', '1', '0', '1', '0'},
                        {'1', '1', '0', '0', '0'},
                        {'0', '0', '0', '0', '0'},
                }), 1))
                .add(ExpectedTestcase.of(t -> t.numIslands(new char[][]{
                        {'1', '1', '0', '0', '0'},
                        {'1', '1', '0', '0', '0'},
                        {'0', '0', '1', '0', '0'},
                        {'0', '0', '0', '1', '1'},
                }), 3))
                .build();
    }


    class Solution implements NumberOfIslands {

        @Override
        public int numIslands(char[][] grid) {
            int ans = 0;
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[i].length; j++) {
                    if (grid[i][j] == '1') {
                        ans++;
                        Queue<int[]> queue = new LinkedList<>();
                        grid[i][j] = '2';
                        queue.add(new int[]{i, j});
                        while (!queue.isEmpty()) {
                            int[] c = queue.poll();
                            if (c[0] - 1 >= 0 && c[0] - 1 < grid.length && c[1] >= 0 && c[1] < grid[i].length && grid[c[0] - 1][c[1]] == '1') {
                                grid[c[0] - 1][c[1]] = '2';
                                queue.add(new int[]{c[0] - 1, c[1]});
                            }
                            if (c[0] + 1 >= 0 && c[0] + 1 < grid.length && c[1] >= 0 && c[1] < grid[i].length && grid[c[0] + 1][c[1]] == '1') {
                                grid[c[0] + 1][c[1]] = '2';
                                queue.add(new int[]{c[0] + 1, c[1]});
                            }
                            if (c[0] >= 0 && c[0] < grid.length && c[1] - 1 >= 0 && c[1] - 1 < grid[i].length && grid[c[0]][c[1] - 1] == '1') {
                                grid[c[0]][c[1] - 1] = '2';
                                queue.add(new int[]{c[0], c[1] - 1});
                            }
                            if (c[0] >= 0 && c[0] < grid.length && c[1] + 1 >= 0 && c[1] + 1 < grid[i].length && grid[c[0]][c[1] + 1] == '1') {
                                grid[c[0]][c[1] + 1] = '2';
                                queue.add(new int[]{c[0], c[1] + 1});
                            }
                        }
                    }
                }
            }
            return ans;
        }
    }

    class Solution2 implements NumberOfIslands {

        @Override
        public int numIslands(char[][] grid) {
            int ans = 0;
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[i].length; j++) {
                    if (isLand(grid, i, j)) {
                        ans++;
                    }
                }
            }
            return ans;
        }

        private boolean isLand(char[][] grid, int i, int j) {
            if (i < 0 || i >= grid.length || j < 0 || j >= grid[i].length || grid[i][j] != '1') {
                return false;
            }
            grid[i][j] = '2';
            isLand(grid, i - 1, j);
            isLand(grid, i + 1, j);
            isLand(grid, i, j - 1);
            isLand(grid, i, j + 1);
            return true;
        }
    }
}

class NumberOfIslandsTest extends AbstractTest<NumberOfIslands> {
}
