package com.leammin.leetcode.medium;

import com.leammin.leetcode.util.AbstractTest;
import com.leammin.leetcode.util.ExpectedTestcase;
import com.leammin.leetcode.util.Testsuite;

/**
 * @author Leammin
 * @date 2019-05-02
 */
class UniquePathsTest extends AbstractTest<UniquePaths> {

    @Override
    protected Testsuite<UniquePaths> testsuite() {
        return Testsuite.<UniquePaths>builder()
                .add(ExpectedTestcase.of(3, s -> s.uniquePaths(3, 2)))
                .add(ExpectedTestcase.of(28, s -> s.uniquePaths(3, 7)))
                .add(ExpectedTestcase.of(6, s -> s.uniquePaths(3, 3)))
                .add(ExpectedTestcase.of(20, s -> s.uniquePaths(4, 4)))
                .add(ExpectedTestcase.of(70, s -> s.uniquePaths(5, 5)))
                .add(ExpectedTestcase.of(252, s -> s.uniquePaths(6, 6)))
                .build();
    }
}