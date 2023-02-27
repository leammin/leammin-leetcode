package com.leammin.leetcode.medium;

import com.leammin.leetcode.util.AbstractTest;
import com.leammin.leetcode.util.test.ExpectedTestcase;
import com.leammin.leetcode.util.test.Testsuite;

/**
 * @author Leammin
 * @date 2019-05-02
 */
class UniqueBinarySearchTreesTest extends AbstractTest<UniqueBinarySearchTrees> {

    @Override
    protected Testsuite<UniqueBinarySearchTrees> testsuite() {
        return Testsuite.<UniqueBinarySearchTrees>builder()
                .add(ExpectedTestcase.of(s -> s.numTrees(1), 1))
                .add(ExpectedTestcase.of(s -> s.numTrees(2), 2))
                .add(ExpectedTestcase.of(s -> s.numTrees(3), 5))
                .add(ExpectedTestcase.of(s -> s.numTrees(4), 14))
                .add(ExpectedTestcase.of(s -> s.numTrees(5), 42))
                .add(ExpectedTestcase.of(s -> s.numTrees(6), 132))
                .add(ExpectedTestcase.of(s -> s.numTrees(7), 429))
                .add(ExpectedTestcase.of(s -> s.numTrees(8), 1430))
                .add(ExpectedTestcase.of(s -> s.numTrees(9), 4862))
                .add(ExpectedTestcase.of(s -> s.numTrees(10), 16796))
                .add(ExpectedTestcase.of(s -> s.numTrees(15), 9694845))
                .add(ExpectedTestcase.of(s -> s.numTrees(16), 35357670))
                .add(ExpectedTestcase.of(s -> s.numTrees(17), 129644790))
                .add(ExpectedTestcase.of(s -> s.numTrees(18), 477638700))
                .add(ExpectedTestcase.of(s -> s.numTrees(19), 1767263190))
                .build();
    }
}