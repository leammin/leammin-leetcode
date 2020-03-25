package com.leammin.leetcode.medium;

import com.leammin.leetcode.util.AbstractTest;
import com.leammin.leetcode.util.ExpectedTestcase;
import com.leammin.leetcode.util.Testsuite;

/**
 * @author Leammin
 * @date 2020-03-24
 */
class WordSearchTest extends AbstractTest<WordSearch> {
    @Override
    protected Testsuite<WordSearch> testsuite() {
        char[][] board = new char[][]{
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };
        return Testsuite.<WordSearch>builder()
                .add(ExpectedTestcase.of(true, t->t.exist(board, "ABCCED")))
                .add(ExpectedTestcase.of(true, t->t.exist(board, "SEE")))
                .add(ExpectedTestcase.of(false, t->t.exist(board, "ABCB")))
                .build();
    }
}