package com.leammin.leetcode.hard;

import com.leammin.leetcode.util.AbstractTest;
import com.leammin.leetcode.util.ExpectedTestcase;
import com.leammin.leetcode.util.Testsuite;

/**
 * @author Leammin
 * @date 2019-09-02
 */
class JumpGameIITest extends AbstractTest<JumpGameII> {
    @Override
    protected Testsuite<JumpGameII> testsuite() {
        return Testsuite.<JumpGameII>builder()
                .add(ExpectedTestcase.of(2, t -> t.jump(new int[]{2, 3, 1, 1, 4})))
                .add(ExpectedTestcase.of(0, t -> t.jump(new int[]{0})))
                .add(ExpectedTestcase.of(1, t -> t.jump(new int[]{1,2})))
                .add(ExpectedTestcase.of(1, t -> t.jump(new int[]{3,2,1,0})))
                .build();
    }
}