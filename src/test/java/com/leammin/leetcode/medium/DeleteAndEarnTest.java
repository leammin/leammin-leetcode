package com.leammin.leetcode.medium;

import com.leammin.leetcode.util.AbstractTest;
import com.leammin.leetcode.util.test.Testsuite;

/**
 * @author Leammin
 * @date 2021-05-05
 */
class DeleteAndEarnTest extends AbstractTest<DeleteAndEarn> {
    @Override
    protected Testsuite<DeleteAndEarn> testsuite() {
        return Testsuite.<DeleteAndEarn>builder()
            .addExpected(t -> t.deleteAndEarn(new int[]{3, 4, 2}), 6)
            .addExpected(t -> t.deleteAndEarn(new int[]{2, 2, 3, 3, 3, 4}), 9)
                .build();
    }
}