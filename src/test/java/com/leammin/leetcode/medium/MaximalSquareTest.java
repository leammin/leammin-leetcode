package com.leammin.leetcode.medium;

import com.leammin.leetcode.util.AbstractTest;
import com.leammin.leetcode.util.ExpectedTestcase;
import com.leammin.leetcode.util.Testsuite;

/**
 * @author Leammin
 * @date 2020-05-08
 */
class MaximalSquareTest extends AbstractTest<MaximalSquare> {
    @Override
    protected Testsuite<MaximalSquare> testsuite() {
        return Testsuite.<MaximalSquare>builder()
                .add(ExpectedTestcase.of(t -> t.maximalSquare(new char[][]{
                        {'1', '0', '1', '0', '0'},
                        {'1', '0', '1', '1', '1'},
                        {'1', '1', '1', '1', '1'},
                        {'1', '0', '0', '1', '0'}
                }), 4))
                .build();
    }
}