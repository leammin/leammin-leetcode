package com.leammin.leetcode.medium;

import com.leammin.leetcode.util.test.AbstractTest;
import com.leammin.leetcode.util.test.ExpectedTestcase;
import com.leammin.leetcode.util.test.Testsuite;

/**
 * 79. 单词搜索
 *
 * <p>给定一个二维网格和一个单词，找出该单词是否存在于网格中。</p>
 *
 * <p>单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中&ldquo;相邻&rdquo;单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。</p>
 *
 * <p><strong>示例:</strong></p>
 *
 * <pre>board =
 * [
 *   [&#39;A&#39;,&#39;B&#39;,&#39;C&#39;,&#39;E&#39;],
 *   [&#39;S&#39;,&#39;F&#39;,&#39;C&#39;,&#39;S&#39;],
 *   [&#39;A&#39;,&#39;D&#39;,&#39;E&#39;,&#39;E&#39;]
 * ]
 *
 * 给定 word = &quot;<strong>ABCCED</strong>&quot;, 返回 <strong>true</strong>.
 * 给定 word = &quot;<strong>SEE</strong>&quot;, 返回 <strong>true</strong>.
 * 给定 word = &quot;<strong>ABCB</strong>&quot;, 返回 <strong>false</strong>.</pre>
 *
 * @author Leammin
 * @date 2020-03-24
 */
public interface WordSearch {
    boolean exist(char[][] board, String word);

    static Testsuite<WordSearch> testsuite() {
        char[][] board = new char[][]{
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };
        return Testsuite.<WordSearch>builder()
                .add(ExpectedTestcase.of(t->t.exist(board, "ABCCED"), true))
                .add(ExpectedTestcase.of(t->t.exist(board, "SEE"), true))
                .add(ExpectedTestcase.of(t->t.exist(board, "ABCB"), false))
                .build();
    }


    class Solution implements WordSearch {

        @Override
        public boolean exist(char[][] board, String word) {
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[i].length; j++) {
                    if (backtrack(board, word, i, j, 0)) {
                        return true;
                    }
                }
            }
            return false;
        }

        private boolean backtrack(char[][] board, String word, int i, int j, int index) {
            if (index >= word.length()) {
                return true;
            }
            if (i < 0 || j < 0 || i >= board.length || j >= board[i].length
                    || board[i][j] < 'A' || board[i][j] != word.charAt(index)) {
                return false;
            }
            board[i][j] -= 'A';
            boolean result = backtrack(board, word, i + 1, j, index + 1)
                    || backtrack(board, word, i - 1, j, index + 1)
                    || backtrack(board, word, i, j + 1, index + 1)
                    || backtrack(board, word, i, j - 1, index + 1);
            board[i][j] += 'A';
            return result;
        }
    }
}

class WordSearchTest extends AbstractTest<WordSearch> {
}
