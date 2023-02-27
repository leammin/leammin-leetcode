package com.leammin.leetcode.easy;

import com.leammin.leetcode.util.AbstractTest;
import com.leammin.leetcode.util.test.ExpectedTestcase;
import com.leammin.leetcode.util.test.Testsuite;

/**
 * @author Leammin
 * @date 2019-08-29
 */
class LemonadeChangeTest extends AbstractTest<LemonadeChange> {
    @Override
    protected Testsuite<LemonadeChange> testsuite() {
        return Testsuite.<LemonadeChange>builder()
                .add(ExpectedTestcase.of(t -> t.lemonadeChange(new int[]{5,5,5,10,20}), true))
                .add(ExpectedTestcase.of(t -> t.lemonadeChange(new int[]{5,5,10}), true))
                .add(ExpectedTestcase.of(t -> t.lemonadeChange(new int[]{10,10}), false))
                .add(ExpectedTestcase.of(t -> t.lemonadeChange(new int[]{5,5,10,10,20}), false))
                .build();
    }
}