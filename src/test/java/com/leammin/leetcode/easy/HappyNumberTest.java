package com.leammin.leetcode.easy;

import com.leammin.leetcode.util.AbstractTest;
import com.leammin.leetcode.util.ExpectedTestcase;
import com.leammin.leetcode.util.Testsuite;

/**
 * @author Leammin
 * @date 2020-04-10
 */
class HappyNumberTest extends AbstractTest<HappyNumber> {
    @Override
    protected Testsuite<HappyNumber> testsuite() {
        return Testsuite.<HappyNumber>builder()
                .add(ExpectedTestcase.of(t->t.isHappy(19), true))
                .add(ExpectedTestcase.of(t->t.isHappy(1), true))
                .add(ExpectedTestcase.of(t->t.isHappy(10), true))
                .add(ExpectedTestcase.of(t->t.isHappy(100), true))
                .build();
    }
}