package com.leammin.leetcode.medium;

import java.util.LinkedList;
import java.util.Queue;

import com.leammin.leetcode.util.test.AbstractTest;
import com.leammin.leetcode.util.test.ExpectedTestcase;
import com.leammin.leetcode.util.test.Testsuite;

/**
 * 695. 岛屿的最大面积
 *
 * <p>给定一个包含了一些 0 和 1的非空二维数组&nbsp;<code>grid</code>&nbsp;, 一个&nbsp;<strong>岛屿</strong>&nbsp;是由四个方向 (水平或垂直) 的&nbsp;<code>1</code>&nbsp;(代表土地) 构成的组合。你可以假设二维矩阵的四个边缘都被水包围着。</p>
 *
 * <p>找到给定的二维数组中最大的岛屿面积。(如果没有岛屿，则返回面积为0。)</p>
 *
 * <p><strong>示例 1:</strong></p>
 *
 * <pre>
 * [[0,0,1,0,0,0,0,1,0,0,0,0,0],
 *  [0,0,0,0,0,0,0,1,1,1,0,0,0],
 *  [0,1,1,0,1,0,0,0,0,0,0,0,0],
 *  [0,1,0,0,1,1,0,0,<strong>1</strong>,0,<strong>1</strong>,0,0],
 *  [0,1,0,0,1,1,0,0,<strong>1</strong>,<strong>1</strong>,<strong>1</strong>,0,0],
 *  [0,0,0,0,0,0,0,0,0,0,<strong>1</strong>,0,0],
 *  [0,0,0,0,0,0,0,1,1,1,0,0,0],
 *  [0,0,0,0,0,0,0,1,1,0,0,0,0]]
 * </pre>
 *
 * <p>对于上面这个给定矩阵应返回&nbsp;<code>6</code>。注意答案不应该是11，因为岛屿只能包含水平或垂直的四个方向的&lsquo;1&rsquo;。</p>
 *
 * <p><strong>示例 2:</strong></p>
 *
 * <pre>
 * [[0,0,0,0,0,0,0,0]]</pre>
 *
 * <p>对于上面这个给定的矩阵, 返回&nbsp;<code>0</code>。</p>
 *
 * <p><strong>注意:&nbsp;</strong>给定的矩阵<code>grid</code>&nbsp;的长度和宽度都不超过 50。</p>
 *
 *
 * @author Leammin
 * @date 2020-03-15
 */
public interface MaxAreaOfIsland {
    int maxAreaOfIsland(int[][] grid);

    static Testsuite<MaxAreaOfIsland> testsuite() {
        return Testsuite.<MaxAreaOfIsland>builder()
                .add(ExpectedTestcase.of(t -> t.maxAreaOfIsland(new int[][]{
                        {0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                        {0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0},
                        {0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0}
                }), 6))
                .add(ExpectedTestcase.of(t -> t.maxAreaOfIsland(new int[][]{
                        {0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                        {0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0},
                        {0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0}
                }), 6))
                .add(ExpectedTestcase.of(t -> t.maxAreaOfIsland(new int[][]{
                        {0,0,0,0,0,0,0,0},
                }), 0))
                .add(ExpectedTestcase.of(t -> t.maxAreaOfIsland(new int[][]{
                        {1, 1, 0, 0, 0},
                        {1, 1, 0, 0, 0},
                        {0, 0, 0, 1, 1},
                        {0, 0, 0, 1, 1}
                }), 4))
                .build();
    }


    class Solution implements MaxAreaOfIsland {

        @Override
        public int maxAreaOfIsland(int[][] grid) {
            int ans = 0;
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[i].length; j++) {
                    if (grid[i][j] == 1) {
                        int area = 0;
                        Queue<int[]> queue = new LinkedList<>();
                        queue.add(new int[]{i, j});
                        while (!queue.isEmpty()) {
                            int[] land = queue.poll();
                            if (grid[land[0]][land[1]] == 1) {
                                grid[land[0]][land[1]] = 2;
                                area++;
                                if (land[0] + 1 < grid.length && grid[land[0] + 1][land[1]] == 1) {
                                    queue.add(new int[]{land[0] + 1, land[1]});
                                }
                                if (land[0] - 1 >= 0 && grid[land[0] - 1][land[1]] == 1) {
                                    queue.add(new int[]{land[0] - 1, land[1]});
                                }
                                if (land[1] + 1 < grid[i].length && grid[land[0]][land[1] + 1] == 1) {
                                    queue.add(new int[]{land[0], land[1] + 1});
                                }
                                if (land[1] - 1 >= 0 && grid[land[0]][land[1] - 1] == 1) {
                                    queue.add(new int[]{land[0], land[1] - 1});
                                }
                            }
                        }
                        if (area > ans) {
                            ans = area;
                        }
                    }
                }
            }
            return ans;
        }
    }
}

class MaxAreaOfIslandTest extends AbstractTest<MaxAreaOfIsland> {
}
