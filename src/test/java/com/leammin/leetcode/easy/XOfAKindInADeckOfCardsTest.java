package com.leammin.leetcode.easy;

import com.leammin.leetcode.util.AbstractTest;
import com.leammin.leetcode.util.test.ExpectedTestcase;
import com.leammin.leetcode.util.test.Testsuite;

/**
 * @author Leammin
 * @date 2020-03-27
 */
class XOfAKindInADeckOfCardsTest extends AbstractTest<XOfAKindInADeckOfCards> {
    @Override
    protected Testsuite<XOfAKindInADeckOfCards> testsuite() {
        return Testsuite.<XOfAKindInADeckOfCards>builder()
                .add(ExpectedTestcase.of(t -> t.hasGroupsSizeX(new int[]{1, 2, 3, 4, 4, 3, 2, 1}), true))
                .add(ExpectedTestcase.of(t -> t.hasGroupsSizeX(new int[]{1, 1, 1, 2, 2, 2, 3, 3}), false))
                .add(ExpectedTestcase.of(t -> t.hasGroupsSizeX(new int[]{1}), false))
                .add(ExpectedTestcase.of(t -> t.hasGroupsSizeX(new int[]{1, 1}), true))
                .add(ExpectedTestcase.of(t -> t.hasGroupsSizeX(new int[]{1, 1, 2, 2, 2, 2}), true))
                .build();
    }
}