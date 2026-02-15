package com.leammin.leetcode.hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.leammin.leetcode.util.test.AbstractTest;
import com.leammin.leetcode.util.test.ExpectedTestcase;
import com.leammin.leetcode.util.test.Testsuite;
import java.util.HashSet;
import java.util.Set;

/**
 * 面试题 08.12. 八皇后
 *
 * <p>设计一种算法，打印 N 皇后在 N &times; N 棋盘上的各种摆法，其中每个皇后都不同行、不同列，也不在对角线上。这里的&ldquo;对角线&rdquo;指的是所有的对角线，不只是平分整个棋盘的那两条对角线。</p>
 *
 * <p><strong>注意：</strong>本题相对原题做了扩展</p>
 *
 * <p><strong>示例:</strong></p>
 *
 * <pre><strong> 输入</strong>：4
 * <strong> 输出</strong>：[[&quot;.Q..&quot;,&quot;...Q&quot;,&quot;Q...&quot;,&quot;..Q.&quot;],[&quot;..Q.&quot;,&quot;Q...&quot;,&quot;...Q&quot;,&quot;.Q..&quot;]]
 * <strong> 解释</strong>: 4 皇后问题存在如下两个不同的解法。
 * [
 * &nbsp;[&quot;.Q..&quot;, &nbsp;// 解法 1
 * &nbsp; &quot;...Q&quot;,
 * &nbsp; &quot;Q...&quot;,
 * &nbsp; &quot;..Q.&quot;],
 *
 * &nbsp;[&quot;..Q.&quot;, &nbsp;// 解法 2
 * &nbsp; &quot;Q...&quot;,
 * &nbsp; &quot;...Q&quot;,
 * &nbsp; &quot;.Q..&quot;]
 * ]
 * </pre>
 *
 * @author Leammin
 * @date 2021-03-16
 */
public interface EightQueensLcci {
    List<List<String>> solveNQueens(int n);

    static Testsuite<EightQueensLcci> testsuite() {
        return Testsuite.<EightQueensLcci>builder()
                .add(ExpectedTestcase.of(t -> new HashSet<>(t.solveNQueens(4)), Set.of(
                        List.of(".Q..","...Q","Q...","..Q."),
                        List.of("..Q.","Q...","...Q",".Q..")
                )))
                .build();
    }


    class Solution implements EightQueensLcci {
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

class EightQueensLcciTest extends AbstractTest<EightQueensLcci> {
}
