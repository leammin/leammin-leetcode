package com.leammin.leetcode.medium;

import com.leammin.leetcode.util.convert.IntMatrixConverter;
import com.leammin.leetcode.util.test.Testsuite;

/**
 * <a href="https://leetcode.cn/problems/li-wu-de-zui-da-jie-zhi-lcof/">剑指 Offer 47. 礼物的最大价值</a>
 * 
 * <p>在一个 m*n 的棋盘的每一格都放有一个礼物，每个礼物都有一定的价值（价值大于 0）。你可以从棋盘的左上角开始拿格子里的礼物，并每次向右或者向下移动一格、直到到达棋盘的右下角。给定一个棋盘及其上面的礼物的价值，请计算你最多能拿到多少价值的礼物？</p>
 * 
 * <p>&nbsp;</p>
 * 
 * <p><strong>示例 1:</strong></p>
 * 
 * <pre><strong>输入:</strong> 
 * <code>[
 * &nbsp; [1,3,1],
 * &nbsp; [1,5,1],
 * &nbsp; [4,2,1]
 * ]</code>
 * <strong>输出:</strong> <code>12
 * </code><strong>解释:</strong> 路径 1&rarr;3&rarr;5&rarr;2&rarr;1 可以拿到最多价值的礼物</pre>
 * 
 * <p>&nbsp;</p>
 * 
 * <p>提示：</p>
 * 
 * <ul>
 * 	<li><code>0 &lt; grid.length &lt;= 200</code></li>
 * 	<li><code>0 &lt; grid[0].length &lt;= 200</code></li>
 * </ul>
 * 
 * 
 * @author Leammin
 * @date 2023-03-08
 */
public interface LiWuDeZuiDaJieZhiLcof {
    int maxValue(int[][] grid);

    static Testsuite<LiWuDeZuiDaJieZhiLcof> testsuite() {
        return Testsuite.<LiWuDeZuiDaJieZhiLcof>builder()
                .addExpected(t -> t.maxValue(new IntMatrixConverter().convert("[[1,3,1],[1,5,1],[4,2,1]]")), 12)
                .build();
    }

    class Solution implements LiWuDeZuiDaJieZhiLcof {

        @Override
        public int maxValue(int[][] grid) {
            int n = grid.length;
            int m = grid[0].length;
            int[][] dp = new int[n+1][m+1];
            for(int i = n - 1; i >= 0; i--) {
                for(int j = m - 1; j >= 0; j--) {
                    dp[i][j] = grid[i][j] + Math.max(dp[i + 1][j], dp[i][j + 1]);
                }
            }
            return dp[0][0];
        }
    }
}
