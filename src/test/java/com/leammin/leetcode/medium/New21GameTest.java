package com.leammin.leetcode.medium;

import com.leammin.leetcode.undone.medium.New21Game;
import com.leammin.leetcode.util.AbstractTest;
import com.leammin.leetcode.util.test.ExpectedTestcase;
import com.leammin.leetcode.util.test.Testsuite;

/**
 * @author Leammin
 * @date 2020-06-03
 */
class New21GameTest extends AbstractTest<New21Game> {
    @Override
    protected Testsuite<New21Game> testsuite() {
        return Testsuite.<New21Game>builder()
                .add(ExpectedTestcase.of(t -> t.new21Game(10, 1, 10), 1.0))
                .add(ExpectedTestcase.of(t -> t.new21Game(6, 1, 10), 0.6))
                .add(ExpectedTestcase.of(t -> t.new21Game(21, 17, 10), 0.73278))
                .build();
    }
}