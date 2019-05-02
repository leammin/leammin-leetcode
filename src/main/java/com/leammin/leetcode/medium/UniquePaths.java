package com.leammin.leetcode.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * 62. 不同路径
 *
 * <div><p>一个机器人位于一个 <em>m x n </em>网格的左上角 （起始点在下图中标记为“Start” ）。</p>
 *
 * <p>机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。</p>
 *
 * <p>问总共有多少条不同的路径？</p>
 *
 * <p><img src="https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2018/10/22/robot_maze.png"></p>
 *
 * <p><small>例如，上图是一个7 x 3 的网格。有多少可能的路径？</small></p>
 *
 * <p><strong>说明：</strong><em>m</em>&nbsp;和 <em>n </em>的值均不超过 100。</p>
 *
 * <p><strong>示例&nbsp;1:</strong></p>
 *
 * <pre><strong>输入:</strong> m = 3, n = 2
 * <strong>输出:</strong> 3
 * <strong>解释:</strong>
 * 从左上角开始，总共有 3 条路径可以到达右下角。
 * 1. 向右 -&gt; 向右 -&gt; 向下
 * 2. 向右 -&gt; 向下 -&gt; 向右
 * 3. 向下 -&gt; 向右 -&gt; 向右
 * </pre>
 *
 * <p><strong>示例&nbsp;2:</strong></p>
 *
 * <pre><strong>输入:</strong> m = 7, n = 3
 * <strong>输出:</strong> 28</pre>
 * </div>
 *
 * @author Leammin
 * @date 2019-05-02
 */
public interface UniquePaths {
    int uniquePaths(int m, int n);

    /**
     * 这是一个组合问题，机器人一共要走 m+n-2 步，取出 m-1 步向下走。
     */
    class Best implements UniquePaths {

        @Override
        public int uniquePaths(int m, int n) {
            return c(m + n - 2, Math.min(m - 1, n - 1));
        }

        private int c(int a, int b) {
            // 组合 a中取b个
            double res = 1;
            for (int i = 0; i < b; i++) {
                res *= (a - i);
                res /= (i + 1);
            }
            return (int) (res + 0.5);
        }
    }

    class Solution2 implements UniquePaths {
        @Override
        public int uniquePaths(int m, int n) {
            int[][] dp = new int[m][n];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (i == 0 || j == 0) {
                        dp[i][j] = 1;
                    } else {
                        dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                    }
                }
            }
            return dp[m - 1][n - 1];
        }
    }

    class Solution1 implements UniquePaths {
        @Override
        public int uniquePaths(int m, int n) {
            Map<String, Integer> dp = new HashMap<>();
            return uniquePaths(m, n, dp);
        }

        private int uniquePaths(int x, int y, Map<String, Integer> dp) {
            if (x <= 1 || y <= 1) {
                return 1;
            }
            if (x > y) {
                return uniquePaths(y, x, dp);
            }
            String key = x + "," + y;
            Integer result = dp.get(key);
            if (result != null) {
                return result;
            }
            result = uniquePaths(x - 1, y, dp) + uniquePaths(x, y - 1, dp);
            dp.put(key, result);
            return result;
        }
    }
}
