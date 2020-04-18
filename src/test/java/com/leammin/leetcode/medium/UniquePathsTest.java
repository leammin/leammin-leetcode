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
                .add(ExpectedTestcase.of(s -> s.uniquePaths(3, 2), 3))
                .add(ExpectedTestcase.of(s -> s.uniquePaths(3, 7), 28))
                .add(ExpectedTestcase.of(s -> s.uniquePaths(3, 3), 6))
                .add(ExpectedTestcase.of(s -> s.uniquePaths(4, 4), 20))
                .add(ExpectedTestcase.of(s -> s.uniquePaths(5, 5), 70))
                .add(ExpectedTestcase.of(s -> s.uniquePaths(6, 6), 252))
                .build();
    }
}