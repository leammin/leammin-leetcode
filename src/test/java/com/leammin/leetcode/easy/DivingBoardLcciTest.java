package com.leammin.leetcode.easy;

import com.leammin.leetcode.util.AbstractTest;
import com.leammin.leetcode.util.test.ExpectedTestcase;
import com.leammin.leetcode.util.test.Testsuite;

/**
 * @author Leammin
 * @date 2020-07-08
 */
class DivingBoardLcciTest extends AbstractTest<DivingBoardLcci> {
    @Override
    protected Testsuite<DivingBoardLcci> testsuite() {
        return Testsuite.<DivingBoardLcci>builder()
                .add(ExpectedTestcase.of(t -> t.divingBoard(1, 2, 3), new int[]{3, 4, 5, 6}))
                .add(ExpectedTestcase.of(t -> t.divingBoard(1, 1, 0), new int[]{}))
                .add(ExpectedTestcase.of(t -> t.divingBoard(1, 1, 100000), new int[]{}))
                .build();
    }
}