package com.leammin.leetcode.medium;

import com.leammin.leetcode.util.AbstractTest;
import com.leammin.leetcode.util.ExpectedTestcase;
import com.leammin.leetcode.util.Testsuite;

/**
 * @author Leammin
 * @date 2019-05-02
 */
class UniqueBinarySearchTreesTest extends AbstractTest<UniqueBinarySearchTrees> {

    @Override
    protected Testsuite<UniqueBinarySearchTrees> testsuite() {
        return Testsuite.<UniqueBinarySearchTrees>builder()
                .add(ExpectedTestcase.of(1, s -> s.numTrees(1)))
                .add(ExpectedTestcase.of(2, s -> s.numTrees(2)))
                .add(ExpectedTestcase.of(5, s -> s.numTrees(3)))
                .add(ExpectedTestcase.of(14, s -> s.numTrees(4)))
                .add(ExpectedTestcase.of(42, s -> s.numTrees(5)))
                .add(ExpectedTestcase.of(132, s -> s.numTrees(6)))
                .add(ExpectedTestcase.of(429, s -> s.numTrees(7)))
                .add(ExpectedTestcase.of(1430, s -> s.numTrees(8)))
                .add(ExpectedTestcase.of(4862, s -> s.numTrees(9)))
                .add(ExpectedTestcase.of(16796, s -> s.numTrees(10)))
                .add(ExpectedTestcase.of(9694845, s -> s.numTrees(15)))
                .add(ExpectedTestcase.of(35357670, s -> s.numTrees(16)))
                .add(ExpectedTestcase.of(129644790, s -> s.numTrees(17)))
                .add(ExpectedTestcase.of(477638700, s -> s.numTrees(18)))
                .add(ExpectedTestcase.of(1767263190, s -> s.numTrees(19)))
                .build();
    }
}