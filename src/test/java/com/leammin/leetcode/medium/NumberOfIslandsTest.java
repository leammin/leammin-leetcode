package com.leammin.leetcode.medium;

import com.leammin.leetcode.undone.medium.NumberOfIslands;
import com.leammin.leetcode.util.AbstractTest;
import com.leammin.leetcode.util.ExpectedTestcase;
import com.leammin.leetcode.util.Testsuite;

/**
 * @author Leammin
 * @date 2020-03-17
 */
class NumberOfIslandsTest extends AbstractTest<NumberOfIslands> {
    @Override
    protected Testsuite<NumberOfIslands> testsuite() {
        return Testsuite.<NumberOfIslands>builder()
                .add(ExpectedTestcase.of(1, t -> t.numIslands(new char[][]{
                        {'1', '1', '1', '1', '0'},
                        {'1', '1', '0', '1', '0'},
                        {'1', '1', '0', '0', '0'},
                        {'0', '0', '0', '0', '0'},
                })))
                .add(ExpectedTestcase.of(3, t -> t.numIslands(new char[][]{
                        {'1', '1', '0', '0', '0'},
                        {'1', '1', '0', '0', '0'},
                        {'0', '0', '1', '0', '0'},
                        {'0', '0', '0', '1', '1'},
                })))
                .build();
    }
}