package com.leammin.leetcode.medium;

/**
 * 36. 有效的数独
 *
 * <div><p>判断一个&nbsp;9x9 的数独是否有效。只需要<strong>根据以下规则</strong>，验证已经填入的数字是否有效即可。</p>
 *
 * <ol>
 * <li>数字&nbsp;<code>1-9</code>&nbsp;在每一行只能出现一次。</li>
 * <li>数字&nbsp;<code>1-9</code>&nbsp;在每一列只能出现一次。</li>
 * <li>数字&nbsp;<code>1-9</code>&nbsp;在每一个以粗实线分隔的&nbsp;<code>3x3</code>&nbsp;宫内只能出现一次。</li>
 * </ol>
 *
 * <p><img src="https://upload.wikimedia.org/wikipedia/commons/thumb/f/ff/Sudoku-by-L2G-20050714.svg/250px-Sudoku-by-L2G-20050714.svg.png" style="height: 250px; width: 250px;"></p>
 *
 * <p><small>上图是一个部分填充的有效的数独。</small></p>
 *
 * <p>数独部分空格内已填入了数字，空白格用&nbsp;<code>'.'</code>&nbsp;表示。</p>
 *
 * <p><strong>示例&nbsp;1:</strong></p>
 *
 * <pre><strong>输入:</strong>
 * [
 *   ["5","3",".",".","7",".",".",".","."],
 *   ["6",".",".","1","9","5",".",".","."],
 *   [".","9","8",".",".",".",".","6","."],
 *   ["8",".",".",".","6",".",".",".","3"],
 *   ["4",".",".","8",".","3",".",".","1"],
 *   ["7",".",".",".","2",".",".",".","6"],
 *   [".","6",".",".",".",".","2","8","."],
 *   [".",".",".","4","1","9",".",".","5"],
 *   [".",".",".",".","8",".",".","7","9"]
 * ]
 * <strong>输出:</strong> true
 * </pre>
 *
 * <p><strong>示例&nbsp;2:</strong></p>
 *
 * <pre><strong>输入:</strong>
 * [
 * &nbsp; ["8","3",".",".","7",".",".",".","."],
 * &nbsp; ["6",".",".","1","9","5",".",".","."],
 * &nbsp; [".","9","8",".",".",".",".","6","."],
 * &nbsp; ["8",".",".",".","6",".",".",".","3"],
 * &nbsp; ["4",".",".","8",".","3",".",".","1"],
 * &nbsp; ["7",".",".",".","2",".",".",".","6"],
 * &nbsp; [".","6",".",".",".",".","2","8","."],
 * &nbsp; [".",".",".","4","1","9",".",".","5"],
 * &nbsp; [".",".",".",".","8",".",".","7","9"]
 * ]
 * <strong>输出:</strong> false
 * <strong>解释:</strong> 除了第一行的第一个数字从<strong> 5</strong> 改为 <strong>8 </strong>以外，空格内其他数字均与 示例1 相同。
 *      但由于位于左上角的 3x3 宫内有两个 8 存在, 因此这个数独是无效的。</pre>
 *
 * <p><strong>说明:</strong></p>
 *
 * <ul>
 * <li>一个有效的数独（部分已被填充）不一定是可解的。</li>
 * <li>只需要根据以上规则，验证已经填入的数字是否有效即可。</li>
 * <li>给定数独序列只包含数字&nbsp;<code>1-9</code>&nbsp;和字符&nbsp;<code>'.'</code>&nbsp;。</li>
 * <li>给定数独永远是&nbsp;<code>9x9</code>&nbsp;形式的。</li>
 * </ul>
 * </div>
 *
 * @author Leammin
 * @date 2018-10-11
 */
public class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        boolean[][] row = new boolean[9][9];
        boolean[][] col = new boolean[9][9];
        boolean[][] box = new boolean[9][9];
        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[r].length; c++) {
                if (board[r][c] != '.') {
                    if (row[r][board[r][c] - '1']) {
                        return false;
                    }
                    row[r][board[r][c] - '1'] = true;
                    if (col[c][board[r][c] - '1']) {
                        return false;
                    }
                    col[c][board[r][c] - '1'] = true;
                    if (box[(c + r / 3 * 9) / 3][board[r][c] - '1']) {
                        return false;
                    }
                    box[(c + r / 3 * 9) / 3][board[r][c] - '1'] = true;
                }
            }
        }
        return true;
    }
}
