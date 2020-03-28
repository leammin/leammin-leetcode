package com.leammin.leetcode.easy;

import com.leammin.leetcode.util.AbstractTest;
import com.leammin.leetcode.util.ExpectedTestcase;
import com.leammin.leetcode.util.Testsuite;

/**
 * @author Leammin
 * @date 2020-03-27
 */
class XOfAKindInADeckOfCardsTest extends AbstractTest<XOfAKindInADeckOfCards> {
    @Override
    protected Testsuite<XOfAKindInADeckOfCards> testsuite() {
        return Testsuite.<XOfAKindInADeckOfCards>builder()
                .add(ExpectedTestcase.of(true, t -> t.hasGroupsSizeX(new int[]{1, 2, 3, 4, 4, 3, 2, 1})))
                .add(ExpectedTestcase.of(false, t -> t.hasGroupsSizeX(new int[]{1, 1, 1, 2, 2, 2, 3, 3})))
                .add(ExpectedTestcase.of(false, t -> t.hasGroupsSizeX(new int[]{1})))
                .add(ExpectedTestcase.of(true, t -> t.hasGroupsSizeX(new int[]{1, 1})))
                .add(ExpectedTestcase.of(true, t -> t.hasGroupsSizeX(new int[]{1, 1, 2, 2, 2, 2})))
                .build();
    }
}