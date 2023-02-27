package com.leammin.leetcode.easy;

import com.leammin.leetcode.util.AbstractTest;
import com.leammin.leetcode.util.test.ExpectedTestcase;
import com.leammin.leetcode.util.test.Testsuite;

/**
 * @author Leammin
 * @date 2020-03-04
 */
class RottingOrangesTest extends AbstractTest<RottingOranges> {
    @Override
    protected Testsuite<RottingOranges> testsuite() {
        return Testsuite.<RottingOranges>builder()
                .add(ExpectedTestcase.of(t -> t.orangesRotting(new int[][]{{2, 1, 1}, {1, 1, 0}, {0, 1, 1}}), 4))
                .add(ExpectedTestcase.of(t -> t.orangesRotting(new int[][]{{2, 1, 1}, {0, 1, 1}, {1, 0, 1}}), -1))
                .add(ExpectedTestcase.of(t -> t.orangesRotting(new int[][]{{0, 2}}), 0))
                .add(ExpectedTestcase.of(t -> t.orangesRotting(new int[][]{{0}}), 0))
                .add(ExpectedTestcase.of(t -> t.orangesRotting(new int[][]{{0, 0, 0, 0}}), 0))
                .add(ExpectedTestcase.of(t -> t.orangesRotting(new int[][]{{0, 0, 2, 0}}), 0))
                .add(ExpectedTestcase.of(t -> t.orangesRotting(new int[][]{{0, 0, 1, 0}}), -1))
                .add(ExpectedTestcase.of(t -> t.orangesRotting(new int[][]{{2, 0, 1, 0}}), -1))
                .add(ExpectedTestcase.of(t -> t.orangesRotting(new int[][]{{0, 2, 2}}), 0))
                .add(ExpectedTestcase.of(t -> t.orangesRotting(new int[][]{{1, 2, 1, 1, 2, 1, 1}}), 2))
                .build();
    }
}