package com.leammin.leetcode.hard;

import com.leammin.leetcode.util.AbstractTest;
import com.leammin.leetcode.util.test.ExpectedTestcase;
import com.leammin.leetcode.util.test.Testsuite;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Leammin
 * @date 2021-03-16
 */
class NQueensTest extends AbstractTest<NQueens> {
    @Override
    protected Testsuite<NQueens> testsuite() {
        return Testsuite.<NQueens>builder()
                .add(ExpectedTestcase.of(t -> new HashSet<>(t.solveNQueens(4)), Set.of(
                        List.of(".Q..","...Q","Q...","..Q."),
                        List.of("..Q.","Q...","...Q",".Q..")
                )))
                .build();
    }
}