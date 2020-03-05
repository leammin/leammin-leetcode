package com.leammin.leetcode.easy;

import com.leammin.leetcode.util.AbstractTest;
import com.leammin.leetcode.util.ExpectedTestcase;
import com.leammin.leetcode.util.Testsuite;

/**
 * @author Leammin
 * @date 2020-03-04
 */
class RottingOrangesTest extends AbstractTest<RottingOranges> {
    @Override
    protected Testsuite<RottingOranges> testsuite() {
        return Testsuite.<RottingOranges>builder()
                .add(ExpectedTestcase.of(4, t -> t.orangesRotting(new int[][]{{2, 1, 1}, {1, 1, 0}, {0, 1, 1}})))
                .add(ExpectedTestcase.of(-1, t -> t.orangesRotting(new int[][]{{2, 1, 1}, {0, 1, 1}, {1, 0, 1}})))
                .add(ExpectedTestcase.of(0, t -> t.orangesRotting(new int[][]{{0, 2}})))
                .add(ExpectedTestcase.of(0, t -> t.orangesRotting(new int[][]{{0}})))
                .add(ExpectedTestcase.of(0, t -> t.orangesRotting(new int[][]{{0, 0, 0, 0}})))
                .add(ExpectedTestcase.of(0, t -> t.orangesRotting(new int[][]{{0, 0, 2, 0}})))
                .add(ExpectedTestcase.of(-1, t -> t.orangesRotting(new int[][]{{0, 0, 1, 0}})))
                .add(ExpectedTestcase.of(-1, t -> t.orangesRotting(new int[][]{{2, 0, 1, 0}})))
                .add(ExpectedTestcase.of(0, t -> t.orangesRotting(new int[][]{{0, 2, 2}})))
                .add(ExpectedTestcase.of(2, t -> t.orangesRotting(new int[][]{{1, 2, 1, 1, 2, 1, 1}})))
                .build();
    }
}