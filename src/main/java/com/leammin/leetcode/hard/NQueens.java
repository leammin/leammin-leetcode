package com.leammin.leetcode.hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 51. N皇后
 * 
 * <p><em>n&nbsp;</em>皇后问题研究的是如何将 <em>n</em>&nbsp;个皇后放置在 <em>n</em>&times;<em>n</em> 的棋盘上，并且使皇后彼此之间不能相互攻击。</p>
 * 
 * <p><img src="https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2018/10/12/8-queens.png"></p>
 * 
 * <p><small>上图为 8 皇后问题的一种解法。</small></p>
 * 
 * <p>给定一个整数 <em>n</em>，返回所有不同的&nbsp;<em>n&nbsp;</em>皇后问题的解决方案。</p>
 * 
 * <p>每一种解法包含一个明确的&nbsp;<em>n</em> 皇后问题的棋子放置方案，该方案中 <code>&#39;Q&#39;</code> 和 <code>&#39;.&#39;</code> 分别代表了皇后和空位。</p>
 * 
 * <p><strong>示例:</strong></p>
 * 
 * <pre><strong>输入:</strong> 4
 * <strong>输出:</strong> [
 *  [&quot;.Q..&quot;,  // 解法 1
 *   &quot;...Q&quot;,
 *   &quot;Q...&quot;,
 *   &quot;..Q.&quot;],
 * 
 *  [&quot;..Q.&quot;,  // 解法 2
 *   &quot;Q...&quot;,
 *   &quot;...Q&quot;,
 *   &quot;.Q..&quot;]
 * ]
 * <strong>解释:</strong> 4 皇后问题存在两个不同的解法。
 * </pre>
 * 
 * 
 * @author Leammin
 * @date 2021-03-16
 */
public interface NQueens {
    List<List<String>> solveNQueens(int n);

    class Solution implements NQueens {
        List<List<String>> res;
        String[] queens;

        @Override
        public List<List<String>> solveNQueens(int n) {
            res = new ArrayList<>();
            queens = new String[n];
            char[] queen = new char[n];
            Arrays.fill(queen, '.');
            for (int i = 0; i < queen.length; i++) {
                queen[i] = 'Q';
                queens[i] = String.valueOf(queen);
                queen[i] = '.';
            }

            int[] chessboard = new int[n];
            Arrays.fill(chessboard, Integer.MIN_VALUE);
            solveNQueens(chessboard, 0);
            return res;
        }

        private void solveNQueens(int[] chessboard, int i) {
            int n = chessboard.length;
            if (i == n) {
                List<String> l = new ArrayList<>(n);
                for (int pos : chessboard) {
                    l.add(queens[pos]);
                }
                res.add(l);
                return;
            }
            for (int j = 0; j < n; j++) {
                if (canPutQueen(chessboard, i, j)) {
                    chessboard[i] = j;
                    solveNQueens(chessboard, i + 1);
                    chessboard[i] = Integer.MIN_VALUE;
                }
            }
        }

        private boolean canPutQueen(int[] chessboard, int i, int j) {
            for (int k = 1; k <= i; k++) {
                if (chessboard[i - k] == j - k || chessboard[i - k] == j + k || chessboard[i - k] == j) {
                    return false;
                }
            }
            return true;
        }
    }
}
