package com.leammin.leetcode.medium;

import com.leammin.leetcode.util.AbstractTest;
import com.leammin.leetcode.util.test.ExpectedTestcase;
import com.leammin.leetcode.util.test.Testsuite;

/**
 * @author Leammin
 * @date 2019-09-02
 */
class JumpGameTest extends AbstractTest<JumpGame> {
    @Override
    protected Testsuite<JumpGame> testsuite() {
        return Testsuite.<JumpGame>builder()
                .add(ExpectedTestcase.of(t -> t.canJump(new int[]{2, 3, 1, 1, 4}), true))
                .add(ExpectedTestcase.of(t -> t.canJump(new int[]{3, 2, 1, 0, 4}), false))
                .add(ExpectedTestcase.of(t -> t.canJump(new int[]{0}), true))
                .add(ExpectedTestcase.of(t -> t.canJump(new int[]{2, 0, 0}), true))
                .add(ExpectedTestcase.of(t -> t.canJump(new int[]{3, 0, 0, 0}), true))
                .add(ExpectedTestcase.of(t -> t.canJump(new int[]{10, 0, 0, 2, 0, 0, 0}), true))
                .build();
    }
}