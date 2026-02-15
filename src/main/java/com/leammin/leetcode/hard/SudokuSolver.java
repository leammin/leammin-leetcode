package com.leammin.leetcode.hard;

import com.leammin.leetcode.util.test.AbstractTest;
import com.leammin.leetcode.util.test.Testsuite;

/**
 * 37. 解数独
 * 
 * <p>编写一个程序，通过已填充的空格来解决数独问题。</p>
 * 
 * <p>一个数独的解法需<strong>遵循如下规则</strong>：</p>
 * 
 * <ol>˚
 * 	<li>数字&nbsp;<code>1-9</code>&nbsp;在每一行只能出现一次。</li>
 * 	<li>数字&nbsp;<code>1-9</code>&nbsp;在每一列只能出现一次。</li>
 * 	<li>数字&nbsp;<code>1-9</code>&nbsp;在每一个以粗实线分隔的&nbsp;<code>3x3</code>&nbsp;宫内只能出现一次。</li>
 * </ol>
 * 
 * <p>空白格用&nbsp;<code>&#39;.&#39;</code>&nbsp;表示。</p>
 * 
 * <p><img src="http://upload.wikimedia.org/wikipedia/commons/thumb/f/ff/Sudoku-by-L2G-20050714.svg/250px-Sudoku-by-L2G-20050714.svg.png"></p>
 * 
 * <p><small>一个数独。</small></p>
 * 
 * <p><img src="http://upload.wikimedia.org/wikipedia/commons/thumb/3/31/Sudoku-by-L2G-20050714_solution.svg/250px-Sudoku-by-L2G-20050714_solution.svg.png"></p>
 * 
 * <p><small>答案被标成红色。</small></p>
 * 
 * <p><strong>Note:</strong></p>
 * 
 * <ul>
 * 	<li>给定的数独序列只包含数字&nbsp;<code>1-9</code>&nbsp;和字符&nbsp;<code>&#39;.&#39;</code>&nbsp;。</li>
 * 	<li>你可以假设给定的数独只有唯一解。</li>
 * 	<li>给定数独永远是&nbsp;<code>9x9</code>&nbsp;形式的。</li>
 * </ul>
 * 
 * 
 * @author Leammin
 * @date 2021-05-29
 */
public interface SudokuSolver {
    void solveSudoku(char[][] board);

    static Testsuite<SudokuSolver> testsuite() {
        return Testsuite.<SudokuSolver>builder()
            .addExpected(t -> {
                char[][] board = new char[][]{
                    {'5','3','4','6','7','8','9','1','.'},
                    {'6','.','.','1','9','5','.','.','.'},
                    {'.','9','8','.','.','.','.','6','.'},
                    {'8','.','.','.','6','.','.','.','3'},
                    {'4','.','.','8','.','3','.','.','1'},
                    {'7','.','.','.','2','.','.','.','6'},
                    {'.','6','.','.','.','.','2','8','.'},
                    {'.','.','.','4','1','9','.','.','5'},
                    {'.','.','.','.','8','.','.','7','9'}
                };
                t.solveSudoku(board);
                return board;
            }, new char[][]{
                {'5','3','4','6','7','8','9','1','2'},
                {'6','7','2','1','9','5','3','4','8'},
                {'1','9','8','3','4','2','5','6','7'},
                {'8','5','9','7','6','1','4','2','3'},
                {'4','2','6','8','5','3','7','9','1'},
                {'7','1','3','9','2','4','8','5','6'},
                {'9','6','1','5','3','7','2','8','4'},
                {'2','8','7','4','1','9','6','3','5'},
                {'3','4','5','2','8','6','1','7','9'}
            }).build();
    }


    class Solution implements SudokuSolver {

        @Override
        public void solveSudoku(char[][] board) {
            solveSudoku(board, 0, 0);
        }

        private boolean solveSudoku(char[][] board, int i, int j) {
            for (int a = i; a < board.length; a++) {
                for (int b = (a == i ? j : 0); b < board[i].length; b++) {
                    if (board[a][b] == '.') {
                        for (char v = '1'; v <= '9'; v++) {
                            if (check(board, a, b, v)) {
                                board[a][b] = v;
                                if (solveSudoku(board, a, b + 1)) {
                                    return true;
                                }
                                board[a][b] = '.';
                            }
                        }
                    }
                    if (board[a][b] == '.') {
                        return false;
                    }
                }
            }
            return true;
        }

        private boolean check(char[][] board, int i, int j, char v) {
            for (int a = 0; a < board.length; a++) {
                if (a != i && board[a][j] == v) {
                    return false;
                }
            }
            for (int b = 0; b < board[i].length; b++) {
                if (b != j && board[i][b] == v) {
                    return false;
                }
            }
            int x = i / 3 * 3;
            int y = j / 3 * 3;
            for (int a = x; a < x + 3; a++) {
                for (int b = y; b < y + 3; b++) {
                    if (a != i && b != j && board[a][b] == v) {
                        return false;
                    }
                }
            }
            return true;
        }
    }

    class Solution2 implements SudokuSolver {

        @Override
        public void solveSudoku(char[][] board) {
            int[] row = new int[9];
            int[] col = new int[9];
            int[] block = new int[9];
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[i].length; j++) {
                    if (board[i][j] != '.') {
                        set(row, col, block, i, j, board[i][j] - '0');
                    }
                }
            }
            solveSudoku(board, row, col, block, 0, 0);
        }

        private void set(int[] row, int[] col, int[] block, int i, int j, int v) {
            int t = 1 << v;
            row[i] |= t;
            col[j] |= t;
            block[blockIndex(i, j)] |= t;
        }

        private void clear(int[] row, int[] col, int[] block, int i, int j, int v) {
            int t = ~(1 << v);
            row[i] &= t;
            col[j] &= t;
            block[blockIndex(i, j)] &= t;
        }

        private int blockIndex(int i, int j) {
            return i / 3 * 3 + (j / 3);
        }

        private boolean solveSudoku(char[][] board, int[] row, int[] col, int[] block, int i, int j) {
            for (int a = i; a < board.length; a++) {
                for (int b = (a == i ? j : 0); b < board[i].length; b++) {
                    if (board[a][b] == '.') {
                        for (int v = 1; v <= 9; v++) {
                            if (check(row, col, block, a, b, v)) {
                                board[a][b] = (char)(v + '0');
                                set(row, col, block, a, b, v);
                                if (solveSudoku(board, row, col, block, a, b + 1)) {
                                    return true;
                                }
                                board[a][b] = '.';
                                clear(row, col, block, a, b, v);
                            }
                        }
                    }
                    if (board[a][b] == '.') {
                        return false;
                    }
                }
            }
            return true;
        }

        private boolean check(int[] row,int[] col,int[] block, int i, int j, int v) {
            int t = 1 << v;
            return (row[i] & t) == 0 && (col[j] & t) == 0 && (block[blockIndex(i,j)] & t) == 0;
        }
    }

    class Solution3 implements SudokuSolver {

        @Override
        public void solveSudoku(char[][] board) {
            int[] row = new int[9];
            int[] col = new int[9];
            int[] block = new int[9];
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[i].length; j++) {
                    if (board[i][j] != '.') {
                        set(row, col, block, i, j, board[i][j] - '0');
                    }
                }
            }
            while (greedy(board, row, col, block)) {
            }
            solveSudoku(board, row, col, block, 0, 0);
        }

        private boolean greedy(char[][] board, int[] row, int[] col, int[] block) {
            for (int i = 0; i < row.length; i++) {
                int last = last(row[i]);
                if (last > 0) {
                    for (int j = 0; j < board[i].length; j++) {
                        if (board[i][j] == '.') {
                            board[i][j] = (char)('0' + last);
                            set(row, col, block, i, j, last);
                            return true;
                        }
                    }
                }
            }
            for (int j = 0; j < col.length; j++) {
                int last = last(col[j]);
                if (last > 0) {
                    for (int i = 0; i < board.length; i++) {
                        if (board[i][j] == '.') {
                            board[i][j] = (char)('0' + last);
                            set(row, col, block, i, j, last);
                            return true;
                        }
                    }
                }
            }
            for (int b = 0; b < block.length; b++) {
                int last = last(block[b]);
                if (last > 0) {
                    int x = b / 3 * 3;
                    int y = (b % 3) * 3;
                    for (int i = x; i < x + 3; i++) {
                        for (int j = y; j < y + 3; j++) {
                            if (board[i][j] == '.') {
                                board[i][j] = (char)('0' + last);
                                set(row, col, block, i, j, last);
                                return true;
                            }
                        }
                    }
                }
            }
            return false;
        }

        private int last(int t) {
            int x = t ^ 0x3fe;
            return x > 0 && (x & (x - 1)) == 0 ? Integer.bitCount(x - 1) : 0;
        }

        private void set(int[] row, int[] col, int[] block, int i, int j, int v) {
            int t = 1 << v;
            row[i] |= t;
            col[j] |= t;
            block[blockIndex(i, j)] |= t;
        }

        private void clear(int[] row, int[] col, int[] block, int i, int j, int v) {
            int t = ~(1 << v);
            row[i] &= t;
            col[j] &= t;
            block[blockIndex(i, j)] &= t;
        }

        private int blockIndex(int i, int j) {
            return i / 3 * 3 + (j / 3);
        }

        private boolean solveSudoku(char[][] board, int[] row, int[] col, int[] block, int i, int j) {
            for (int a = i; a < board.length; a++) {
                for (int b = (a == i ? j : 0); b < board[i].length; b++) {
                    if (board[a][b] == '.') {
                        for (int v = 1; v <= 9; v++) {
                            if (check(row, col, block, a, b, v)) {
                                board[a][b] = (char)(v + '0');
                                set(row, col, block, a, b, v);
                                if (solveSudoku(board, row, col, block, a, b + 1)) {
                                    return true;
                                }
                                board[a][b] = '.';
                                clear(row, col, block, a, b, v);
                            }
                        }
                    }
                    if (board[a][b] == '.') {
                        return false;
                    }
                }
            }
            return true;
        }

        private boolean check(int[] row,int[] col,int[] block, int i, int j, int v) {
            int t = 1 << v;
            return (row[i] & t) == 0 && (col[j] & t) == 0 && (block[blockIndex(i,j)] & t) == 0;
        }
    }

}

class SudokuSolverTest extends AbstractTest<SudokuSolver> {
}
