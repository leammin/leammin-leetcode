package com.leammin.leetcode.hard;

import com.leammin.leetcode.util.AbstractTest;
import com.leammin.leetcode.util.ExpectedTestcase;
import com.leammin.leetcode.util.Testsuite;

/**
 * @author Leammin
 * @date 2020-04-06
 */
class EditDistanceTest extends AbstractTest<EditDistance> {
    @Override
    protected Testsuite<EditDistance> testsuite() {
        return Testsuite.<EditDistance>builder()
                .add(ExpectedTestcase.of(t -> t.minDistance("horse", "ros"), 3))
                .add(ExpectedTestcase.of(t -> t.minDistance("intention", "execution"), 5))
                .add(ExpectedTestcase.of(t -> t.minDistance("mart", "karma"), 3))
                .add(ExpectedTestcase.of(t -> t.minDistance("park", "spake"), 3))
                .build();
    }
}