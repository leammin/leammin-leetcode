package com.leammin.leetcode.easy;

import com.leammin.leetcode.undone.easy.HappyNumber;
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
                .add(ExpectedTestcase.of(true, t->t.isHappy(19)))
                .add(ExpectedTestcase.of(true, t->t.isHappy(1)))
                .add(ExpectedTestcase.of(true, t->t.isHappy(10)))
                .add(ExpectedTestcase.of(true, t->t.isHappy(100)))
                .build();
    }
}