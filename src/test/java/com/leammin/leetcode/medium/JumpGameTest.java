package com.leammin.leetcode.medium;

import com.leammin.leetcode.util.AbstractTest;
import com.leammin.leetcode.util.ExpectedTestcase;
import com.leammin.leetcode.util.Testsuite;

/**
 * @author Leammin
 * @date 2019-09-02
 */
class JumpGameTest extends AbstractTest<JumpGame> {
    @Override
    protected Testsuite<JumpGame> testsuite() {
        return Testsuite.<JumpGame>builder()
                .add(ExpectedTestcase.of(true, t -> t.canJump(new int[]{2, 3, 1, 1, 4})))
                .add(ExpectedTestcase.of(false, t -> t.canJump(new int[]{3, 2, 1, 0, 4})))
                .add(ExpectedTestcase.of(true, t -> t.canJump(new int[]{0})))
                .add(ExpectedTestcase.of(true, t -> t.canJump(new int[]{2, 0, 0})))
                .add(ExpectedTestcase.of(true, t -> t.canJump(new int[]{3, 0, 0, 0})))
                .add(ExpectedTestcase.of(true, t -> t.canJump(new int[]{10, 0, 0, 2, 0, 0, 0})))
                .build();
    }
}