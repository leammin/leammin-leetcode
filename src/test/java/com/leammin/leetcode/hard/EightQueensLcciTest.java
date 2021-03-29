package com.leammin.leetcode.hard;

import com.leammin.leetcode.util.AbstractTest;
import com.leammin.leetcode.util.ExpectedTestcase;
import com.leammin.leetcode.util.Testsuite;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Leammin
 * @date 2021-03-16
 */
class EightQueensLcciTest extends AbstractTest<EightQueensLcci> {
    @Override
    protected Testsuite<EightQueensLcci> testsuite() {
        return Testsuite.<EightQueensLcci>builder()
                .add(ExpectedTestcase.of(t -> new HashSet<>(t.solveNQueens(4)), Set.of(
                        List.of(".Q..","...Q","Q...","..Q."),
                        List.of("..Q.","Q...","...Q",".Q..")
                )))
                .build();
    }
}