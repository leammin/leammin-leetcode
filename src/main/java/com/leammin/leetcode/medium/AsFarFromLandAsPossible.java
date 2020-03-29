package com.leammin.leetcode.medium;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 1162. 地图分析
 *
 * <p>你现在手里有一份大小为&nbsp;N x N 的『地图』（网格）&nbsp;<code>grid</code>，上面的每个『区域』（单元格）都用&nbsp;<code>0</code>&nbsp;和&nbsp;<code>1</code>&nbsp;标记好了。其中&nbsp;<code>0</code>&nbsp;代表海洋，<code>1</code>&nbsp;代表陆地，你知道距离陆地区域最远的海洋区域是是哪一个吗？请返回该海洋区域到离它最近的陆地区域的距离。</p>
 *
 * <p>我们这里说的距离是『曼哈顿距离』（&nbsp;Manhattan Distance）：<code>(x0, y0)</code> 和&nbsp;<code>(x1, y1)</code>&nbsp;这两个区域之间的距离是&nbsp;<code>|x0 - x1| + |y0 - y1|</code>&nbsp;。</p>
 *
 * <p>如果我们的地图上只有陆地或者海洋，请返回&nbsp;<code>-1</code>。</p>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>示例 1：</strong></p>
 *
 * <p><strong><img alt="" src="https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2019/08/17/1336_ex1.jpeg" style="height: 87px; width: 185px;"></strong></p>
 *
 * <pre><strong>输入：</strong>[[1,0,1],[0,0,0],[1,0,1]]
 * <strong>输出：</strong>2
 * <strong>解释： </strong>
 * 海洋区域 (1, 1) 和所有陆地区域之间的距离都达到最大，最大距离为 2。
 * </pre>
 *
 * <p><strong>示例 2：</strong></p>
 *
 * <p><strong><img alt="" src="https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2019/08/17/1336_ex2.jpeg" style="height: 87px; width: 184px;"></strong></p>
 *
 * <pre><strong>输入：</strong>[[1,0,0],[0,0,0],[0,0,0]]
 * <strong>输出：</strong>4
 * <strong>解释： </strong>
 * 海洋区域 (2, 2) 和所有陆地区域之间的距离都达到最大，最大距离为 4。
 * </pre>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>提示：</strong></p>
 *
 * <ol>
 * 	<li><code>1 &lt;= grid.length == grid[0].length&nbsp;&lt;= 100</code></li>
 * 	<li><code>grid[i][j]</code>&nbsp;不是&nbsp;<code>0</code>&nbsp;就是&nbsp;<code>1</code></li>
 * </ol>
 *
 * @author Leammin
 * @date 2020-03-29
 */
public interface AsFarFromLandAsPossible {
    int maxDistance(int[][] grid);

    class Solution implements AsFarFromLandAsPossible {

        @Override
        public int maxDistance(int[][] grid) {
            int n = grid.length;
            Queue<int[]> queue = new LinkedList<>();
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] == 1) {
                        queue.add(new int[]{i, j});
                    }
                }
            }
            if (queue.size() == 0 || queue.size() == n * n) {
                return -1;
            }
            int max = 0;
            while (!queue.isEmpty()) {
                int[] pos = queue.poll();
                int value = grid[pos[0]][pos[1]];
                max = Math.max(max, value);
                add(queue, grid, pos[0] - 1, pos[1], value);
                add(queue, grid, pos[0] + 1, pos[1], value);
                add(queue, grid, pos[0], pos[1] - 1, value);
                add(queue, grid, pos[0], pos[1] + 1, value);
            }
            return max - 1;
        }

        private void add(Queue<int[]> queue, int[][] grid, int i, int j, int value) {
            if (i >= 0 && i < grid.length && j >= 0 && j < grid[i].length && grid[i][j] == 0) {
                grid[i][j] = value + 1;
                queue.add(new int[]{i, j});
            }
        }
    }

    class Best implements AsFarFromLandAsPossible {

        @Override
        public int maxDistance(int[][] grid) {
            int m = grid.length;
            int n = grid[0].length;
            boolean f = false;

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] == 1) {
                        f = true;
                        continue;
                    }

                    if (grid[i][j] == 0) {
                        grid[i][j] = m + n;
                    }
                    if (i > 0) {
                        grid[i][j] = Math.min(grid[i][j], grid[i - 1][j] + 1);
                    }
                    if (j > 0) {
                        grid[i][j] = Math.min(grid[i][j], grid[i][j - 1] + 1);
                    }
                }
            }

            int res = 0;
            for (int i = m - 1; i >= 0; i--) {
                for (int j = n - 1; j >= 0; j--) {
                    if (grid[i][j] == 1) {
                        continue;
                    }

                    if (i < m - 1) {
                        grid[i][j] = Math.min(grid[i][j], grid[i + 1][j] + 1);
                    }
                    if (j < n - 1) {
                        grid[i][j] = Math.min(grid[i][j], grid[i][j + 1] + 1);
                    }

                    res = Math.max(res, grid[i][j]);
                }
            }

            return f ? res - 1 : -1;
        }
    }
}
