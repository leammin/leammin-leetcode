package com.leammin.leetcode.easy;

import com.leammin.leetcode.util.AbstractTest;
import com.leammin.leetcode.util.test.ExpectedTestcase;
import com.leammin.leetcode.util.test.Testsuite;

/**
 * @author Leammin
 * @date 2021-02-25
 */
class NimGameTest extends AbstractTest<NimGame> {
    @Override
    protected Testsuite<NimGame> testsuite() {
        return Testsuite.<NimGame>builder()
                .add(ExpectedTestcase.of(t -> t.canWinNim(4), false))
                .add(ExpectedTestcase.of(t -> t.canWinNim(1), true))
                .add(ExpectedTestcase.of(t -> t.canWinNim(2), true))
                .build();
    }

}