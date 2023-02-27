package com.leammin.leetcode.medium;

import com.leammin.leetcode.util.AbstractTest;
import com.leammin.leetcode.util.test.ExpectedTestcase;
import com.leammin.leetcode.util.test.Testsuite;

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
                .add(ExpectedTestcase.of(t->t.exist(board, "ABCCED"), true))
                .add(ExpectedTestcase.of(t->t.exist(board, "SEE"), true))
                .add(ExpectedTestcase.of(t->t.exist(board, "ABCB"), false))
                .build();
    }
}