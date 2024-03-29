package com.leammin.leetcode.medium;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 63. 不同路径 II
 *
 * <p>一个机器人位于一个 <em>m x n </em>网格的左上角 （起始点在下图中标记为&ldquo;Start&rdquo; ）。</p>
 *
 * <p>机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为&ldquo;Finish&rdquo;）。</p>
 *
 * <p>现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？</p>
 *
 * <p><img src="https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2018/10/22/robot_maze.png" style="height: 183px; width: 400px;"></p>
 *
 * <p>网格中的障碍物和空位置分别用 <code>1</code> 和 <code>0</code> 来表示。</p>
 *
 * <p><strong>说明：</strong><em>m</em>&nbsp;和 <em>n </em>的值均不超过 100。</p>
 *
 * <p><strong>示例&nbsp;1:</strong></p>
 *
 * <pre><strong>输入:
 * </strong>[
 * &nbsp; [0,0,0],
 * &nbsp; [0,1,0],
 * &nbsp; [0,0,0]
 * ]
 * <strong>输出:</strong> 2
 * <strong>解释:</strong>
 * 3x3 网格的正中间有一个障碍物。
 * 从左上角到右下角一共有 <code>2</code> 条不同的路径：
 * 1. 向右 -&gt; 向右 -&gt; 向下 -&gt; 向下
 * 2. 向下 -&gt; 向下 -&gt; 向右 -&gt; 向右
 * </pre>
 *
 * @author Leammin
 * @date 2020-07-06
 */
public interface UniquePathsIi {
    int uniquePathsWithObstacles(int[][] obstacleGrid);

    class Solution implements UniquePathsIi {

        @Override
        public int uniquePathsWithObstacles(int[][] obstacleGrid) {
            if (obstacleGrid.length == 1 && obstacleGrid[0].length == 1) {
                return obstacleGrid[0][0] == 0 ? 1 : 0;
            }
            if (obstacleGrid[obstacleGrid.length - 1][obstacleGrid[0].length - 1] == 1) {
                return 0;
            }
            int res = 0;
            Queue<int[]> queue = new LinkedList<>();
            add(obstacleGrid, queue, 0, 0);
            while (!queue.isEmpty()) {
                int[] node = queue.poll();
                res += add(obstacleGrid, queue, node[0], node[1] + 1);
                res += add(obstacleGrid, queue, node[0] + 1, node[1]);
            }
            return res;
        }

        private int add(int[][] obstacleGrid, Queue<int[]> queue, int i, int j) {
            int m = obstacleGrid.length;
            int n = obstacleGrid[0].length;
            if (i == m - 1 && j == n - 1) {
                return 1;
            }
            if (i >= 0 && i < m && j >= 0 && j < n && obstacleGrid[i][j] != 1) {
                queue.add(new int[]{i, j});
            }
            return 0;
        }
    }

    class Solution1 implements UniquePathsIi {

        @Override
        public int uniquePathsWithObstacles(int[][] obstacleGrid) {
            int m = obstacleGrid.length;
            int n = obstacleGrid[0].length;
            if (obstacleGrid[m - 1][n - 1] == 1) {
                return 0;
            }
            obstacleGrid[0][0]--;
            for (int i = 0; i < obstacleGrid.length; i++) {
                for (int j = 0; j < obstacleGrid[i].length; j++) {
                    if (obstacleGrid[i][j] != 1) {
                        obstacleGrid[i][j] += get(obstacleGrid, i, j - 1);
                        obstacleGrid[i][j] += get(obstacleGrid, i - 1, j);
                    }
                }
            }
            return -obstacleGrid[m - 1][n - 1];
        }

        private int get(int[][] obstacleGrid, int i, int j) {
            int m = obstacleGrid.length;
            int n = obstacleGrid[0].length;
            if (i >= 0 && i < m && j >= 0 && j < n && obstacleGrid[i][j] < 0) {
                return obstacleGrid[i][j];
            }
            return 0;
        }

    }
}
