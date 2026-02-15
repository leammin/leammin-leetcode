package com.leammin.leetcode.easy;

import java.util.LinkedList;
import java.util.Queue;

import com.leammin.leetcode.util.test.AbstractTest;
import com.leammin.leetcode.util.test.ExpectedTestcase;
import com.leammin.leetcode.util.test.Testsuite;

/**
 * 994. 腐烂的橘子
 *
 * <p>在给定的网格中，每个单元格可以有以下三个值之一：</p>
 *
 * <ul>
 * 	<li>值&nbsp;<code>0</code>&nbsp;代表空单元格；</li>
 * 	<li>值&nbsp;<code>1</code>&nbsp;代表新鲜橘子；</li>
 * 	<li>值&nbsp;<code>2</code>&nbsp;代表腐烂的橘子。</li>
 * </ul>
 *
 * <p>每分钟，任何与腐烂的橘子（在 4 个正方向上）相邻的新鲜橘子都会腐烂。</p>
 *
 * <p>返回直到单元格中没有新鲜橘子为止所必须经过的最小分钟数。如果不可能，返回&nbsp;<code>-1</code>。</p>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>示例 1：</strong></p>
 *
 * <p><strong><img alt="" src="https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2019/02/16/oranges.png" style="height: 150px; width: 712px;"></strong></p>
 *
 * <pre><strong>输入：</strong>[[2,1,1],[1,1,0],[0,1,1]]
 * <strong>输出：</strong>4
 * </pre>
 *
 * <p><strong>示例 2：</strong></p>
 *
 * <pre><strong>输入：</strong>[[2,1,1],[0,1,1],[1,0,1]]
 * <strong>输出：</strong>-1
 * <strong>解释：</strong>左下角的橘子（第 2 行， 第 0 列）永远不会腐烂，因为腐烂只会发生在 4 个正向上。
 * </pre>
 *
 * <p><strong>示例 3：</strong></p>
 *
 * <pre><strong>输入：</strong>[[0,2]]
 * <strong>输出：</strong>0
 * <strong>解释：</strong>因为 0 分钟时已经没有新鲜橘子了，所以答案就是 0 。
 * </pre>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>提示：</strong></p>
 *
 * <ol>
 * 	<li><code>1 &lt;= grid.length &lt;= 10</code></li>
 * 	<li><code>1 &lt;= grid[0].length &lt;= 10</code></li>
 * 	<li><code>grid[i][j]</code> 仅为&nbsp;<code>0</code>、<code>1</code>&nbsp;或&nbsp;<code>2</code></li>
 * </ol>
 *
 * @author Leammin
 * @date 2020-03-04
 */
public interface RottingOranges {
    int orangesRotting(int[][] grid);

    /**
     * 深度优先
     */

    static Testsuite<RottingOranges> testsuite() {
        return Testsuite.<RottingOranges>builder()
                .add(ExpectedTestcase.of(t -> t.orangesRotting(new int[][]{{2, 1, 1}, {1, 1, 0}, {0, 1, 1}}), 4))
                .add(ExpectedTestcase.of(t -> t.orangesRotting(new int[][]{{2, 1, 1}, {0, 1, 1}, {1, 0, 1}}), -1))
                .add(ExpectedTestcase.of(t -> t.orangesRotting(new int[][]{{0, 2}}), 0))
                .add(ExpectedTestcase.of(t -> t.orangesRotting(new int[][]{{0}}), 0))
                .add(ExpectedTestcase.of(t -> t.orangesRotting(new int[][]{{0, 0, 0, 0}}), 0))
                .add(ExpectedTestcase.of(t -> t.orangesRotting(new int[][]{{0, 0, 2, 0}}), 0))
                .add(ExpectedTestcase.of(t -> t.orangesRotting(new int[][]{{0, 0, 1, 0}}), -1))
                .add(ExpectedTestcase.of(t -> t.orangesRotting(new int[][]{{2, 0, 1, 0}}), -1))
                .add(ExpectedTestcase.of(t -> t.orangesRotting(new int[][]{{0, 2, 2}}), 0))
                .add(ExpectedTestcase.of(t -> t.orangesRotting(new int[][]{{1, 2, 1, 1, 2, 1, 1}}), 2))
                .build();
    }

    class Solution implements RottingOranges {

        @Override
        public int orangesRotting(int[][] grid) {
            boolean allZero = true;
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[i].length; j++) {
                    if (grid[i][j] == 1
                            && isEmpty(grid, i, j - 1)
                            && isEmpty(grid, i - 1, j)
                            && isEmpty(grid, i + 1, j)
                            && isEmpty(grid, i, j + 1)
                    ) {
                        return -1;
                    }
                    if (grid[i][j] != 0) {
                        allZero = false;
                    }
                }
            }
            if (allZero) {
                return 0;
            }
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[i].length; j++) {
                    if (grid[i][j] == 2) {
                        walk(grid, i, j, 2);
                    }
                }
            }

            int max = 0;
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[i].length; j++) {
                    if (grid[i][j] == 1) {
                        return -1;
                    }
                    if (grid[i][j] > max) {
                        max = grid[i][j];
                    }
                }
            }
            return max - 2;
        }

        private boolean isEmpty(int[][] grid, int x, int y) {
            return x < 0 || y < 0 || x >= grid.length || y >= grid[x].length || grid[x][y] == 0;
        }

        private void walk(int[][] grid, int x, int y, int val) {
//            print(grid);

            if (isEmpty(grid, x, y) || (val != 2 && (grid[x][y] == val || grid[x][y] == 2)) || grid[x][y] + 1 == val) {
                return;
            }
            if (grid[x][y] == 1 || grid[x][y] > val) {
                grid[x][y] = val++;
            } else {
                val = grid[x][y] + 1;
            }
            walk(grid, x, y - 1, val);
            walk(grid, x - 1, y, val);
            walk(grid, x + 1, y, val);
            walk(grid, x, y + 1, val);
        }

        String last = null;
        private void print(int[][] grid) {
            String content = content(grid);
            if (!content.equals(last)) {
                last = content;
                System.out.println(content);
            }
        }

        private String content(int[][] grid) {
            StringBuilder builder = new StringBuilder();
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[i].length; j++) {
                    builder.append(grid[i][j]).append("\t");
                }
                builder.append("\n");
            }
            return builder.toString();
        }
    }

    /**
     * 广度优先遍历
     *
     * DFS（深度优先搜索）和 BFS（广度优先搜索）。它们各有不同的适应场景。
     * BFS 可以看成是层序遍历。从某个结点出发，BFS 首先遍历到距离为 1 的结点，然后是距离为 2、3、4…… 的结点。因此，BFS 可以用来求最短路径问题。BFS 先搜索到的结点，一定是距离最近的结点。
     * 再看看这道题的题目要求：返回直到单元格中没有新鲜橘子为止所必须经过的最小分钟数。翻译一下，实际上就是求腐烂橘子到所有新鲜橘子的最短路径。那么这道题使用 BFS，应该是毫无疑问的了。
     *
     * BFS 需要使用队列，代码框架是这样子的（伪代码）：
     *
     * while queue 非空:
     * 	node = queue.pop()
     *     for node 的所有相邻结点 m:
     *         if m 未访问过:
     *             queue.push(m)
     *
     * 但是用 BFS 来求最短路径的话，这个队列中第 1 层和第 2 层的结点会紧挨在一起，无法区分。因此，我们需要稍微修改一下代码，在每一层遍历开始前，记录队列中的结点数量 nn ，然后一口气处理完这一层的 nn 个结点。代码框架是这样的：
     *
     * depth = 0 # 记录遍历到第几层
     * while queue 非空:
     *     depth++
     *     n = queue 中的元素个数
     *     循环 n 次:
     *         node = queue.pop()
     *         for node 的所有相邻结点 m:
     *             if m 未访问过:
     *                 queue.push(m)
     */
    class Best implements RottingOranges {

        @Override
        public int orangesRotting(int[][] grid) {
            int M = grid.length;
            int N = grid[0].length;
            Queue<int[]> queue = new LinkedList<>();

            int count = 0; // count 表示新鲜橘子的数量
            for (int r = 0; r < M; r++) {
                for (int c = 0; c < N; c++) {
                    if (grid[r][c] == 1) {
                        count++;
                    } else if (grid[r][c] == 2) {
                        queue.add(new int[]{r, c});
                    }
                }
            }

            int round = 0; // round 表示腐烂的轮数，或者分钟数
            while (count > 0 && !queue.isEmpty()) {
                round++;
                int n = queue.size();
                for (int i = 0; i < n; i++) {
                    int[] orange = queue.poll();
                    int r = orange[0];
                    int c = orange[1];
                    if (r-1 >= 0 && grid[r-1][c] == 1) {
                        grid[r-1][c] = 2;
                        count--;
                        queue.add(new int[]{r-1, c});
                    }
                    if (r+1 < M && grid[r+1][c] == 1) {
                        grid[r+1][c] = 2;
                        count--;
                        queue.add(new int[]{r+1, c});
                    }
                    if (c-1 >= 0 && grid[r][c-1] == 1) {
                        grid[r][c-1] = 2;
                        count--;
                        queue.add(new int[]{r, c-1});
                    }
                    if (c+1 < N && grid[r][c+1] == 1) {
                        grid[r][c+1] = 2;
                        count--;
                        queue.add(new int[]{r, c+1});
                    }
                }
            }

            if (count > 0) {
                return -1;
            } else {
                return round;
            }
        }
    }
}

class RottingOrangesTest extends AbstractTest<RottingOranges> {
}
