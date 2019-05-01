package com.leammin.leetcode.easy;

import com.leammin.leetcode.util.AbstractTest;
import com.leammin.leetcode.util.EqualTestcase;
import com.leammin.leetcode.util.Testsuite;

/**
 * @author Leammin
 * @date 2019-05-01
 */
class DivisorGameTest extends AbstractTest<DivisorGame> {

    @Override
    protected Testsuite<DivisorGame> testsuite() {
        return Testsuite.<DivisorGame>builder()
                .add(EqualTestcase.of(true, s -> s.divisorGame(2)))
                .add(EqualTestcase.of(true, s -> s.divisorGame(4)))
                .add(EqualTestcase.of(false, s -> s.divisorGame(5)))
                .add(EqualTestcase.of(false, s -> s.divisorGame(3)))
                .build();
    }
}