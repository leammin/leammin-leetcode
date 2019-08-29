package com.leammin.leetcode.easy;

import com.leammin.leetcode.util.AbstractTest;
import com.leammin.leetcode.util.ExpectedTestcase;
import com.leammin.leetcode.util.Testsuite;

/**
 * @author Leammin
 * @date 2019-08-29
 */
class LemonadeChangeTest extends AbstractTest<LemonadeChange> {
    @Override
    protected Testsuite<LemonadeChange> testsuite() {
        return Testsuite.<LemonadeChange>builder()
                .add(ExpectedTestcase.of(true, t -> t.lemonadeChange(new int[]{5,5,5,10,20})))
                .add(ExpectedTestcase.of(true, t -> t.lemonadeChange(new int[]{5,5,10})))
                .add(ExpectedTestcase.of(false, t -> t.lemonadeChange(new int[]{10,10})))
                .add(ExpectedTestcase.of(false, t -> t.lemonadeChange(new int[]{5,5,10,10,20})))
                .build();
    }
}