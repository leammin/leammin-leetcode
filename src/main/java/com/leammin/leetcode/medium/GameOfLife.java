package com.leammin.leetcode.medium;

import com.leammin.leetcode.util.test.AbstractTest;
import com.leammin.leetcode.util.test.ExpectedTestcase;
import com.leammin.leetcode.util.test.Testsuite;

/**
 * 289. 生命游戏
 *
 * <p>根据<a href="https://baike.baidu.com/item/%E7%94%9F%E5%91%BD%E6%B8%B8%E6%88%8F/2926434?fr=aladdin" target="_blank">百度百科</a>，生命游戏，简称为生命，是英国数学家约翰&middot;何顿&middot;康威在1970年发明的细胞自动机。</p>
 *
 * <p>给定一个包含 m &times; n 个格子的面板，每一个格子都可以看成是一个细胞。每个细胞具有一个初始状态 <em>live</em>（1）即为活细胞， 或 <em>dead</em>（0）即为死细胞。每个细胞与其八个相邻位置（水平，垂直，对角线）的细胞都遵循以下四条生存定律：</p>
 *
 * <ol>
 * 	<li>如果活细胞周围八个位置的活细胞数少于两个，则该位置活细胞死亡；</li>
 * 	<li>如果活细胞周围八个位置有两个或三个活细胞，则该位置活细胞仍然存活；</li>
 * 	<li>如果活细胞周围八个位置有超过三个活细胞，则该位置活细胞死亡；</li>
 * 	<li>如果死细胞周围正好有三个活细胞，则该位置死细胞复活；</li>
 * </ol>
 *
 * <p>根据当前状态，写一个函数来计算面板上细胞的下一个（一次更新后的）状态。下一个状态是通过将上述规则同时应用于当前状态下的每个细胞所形成的，其中细胞的出生和死亡是同时发生的。</p>
 *
 * <p><strong>示例:</strong></p>
 *
 * <pre><strong>输入:
 * </strong>[
 * &nbsp; [0,1,0],
 * &nbsp; [0,0,1],
 * &nbsp; [1,1,1],
 * &nbsp; [0,0,0]
 * ]
 * <strong>输出:
 * </strong>[
 * &nbsp; [0,0,0],
 * &nbsp; [1,0,1],
 * &nbsp; [0,1,1],
 * &nbsp; [0,1,0]
 * ]</pre>
 *
 * <p><strong>进阶:</strong></p>
 *
 * <ul>
 * 	<li>你可以使用原地算法解决本题吗？请注意，面板上所有格子需要同时被更新：你不能先更新某些格子，然后使用它们的更新后的值再更新其他格子。</li>
 * 	<li>本题中，我们使用二维数组来表示面板。原则上，面板是无限的，但当活细胞侵占了面板边界时会造成问题。你将如何解决这些问题？</li>
 * </ul>
 *
 * @author Leammin
 * @date 2020-04-02
 */
public interface GameOfLife {
    void gameOfLife(int[][] board);

    static Testsuite<GameOfLife> testsuite() {
        return Testsuite.<GameOfLife>builder()
                .add(ExpectedTestcase.of(t -> {
                    int[][] board = {
                            {0, 1, 0},
                            {0, 0, 1},
                            {1, 1, 1},
                            {0, 0, 0}
                    };
                    t.gameOfLife(board);
                    return board;
                }, new int[][]{
                        {0, 0, 0},
                        {1, 0, 1},
                        {0, 1, 1},
                        {0, 1, 0}
                }))
                .build();
    }


    class Solution implements GameOfLife {

        @Override
        public void gameOfLife(int[][] board) {
            int[][] directions = new int[][]{{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[i].length; j++) {
                    int count = 0;
                    for (int[] direction : directions) {
                        int x = i + direction[0];
                        int y = j + direction[1];
                        if (x >= 0 && x < board.length && y >= 0 && y < board[x].length && board[x][y] > 0) {
                            count++;
                        }
                    }
                    if (board[i][j] == 1 && (count < 2 || count > 3)) {
                        // 活细胞 死亡
                        board[i][j] = 2;
                    } else if (board[i][j] == 0 && count == 3) {
                        // 死细胞复活
                        board[i][j] = -1;
                    }
                }
            }
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[i].length; j++) {
                    if (board[i][j] == 2) {
                        board[i][j] = 0;
                    }
                    if (board[i][j] == -1) {
                        board[i][j] = 1;
                    }
                }
            }
        }
    }
}

class GameOfLifeTest extends AbstractTest<GameOfLife> {
}
