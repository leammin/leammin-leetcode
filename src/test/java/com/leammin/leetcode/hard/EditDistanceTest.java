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
                .add(ExpectedTestcase.of(3, t -> t.minDistance("horse", "ros")))
                .add(ExpectedTestcase.of(5, t -> t.minDistance("intention", "execution")))
                .add(ExpectedTestcase.of(3, t -> t.minDistance("mart", "karma")))
                .add(ExpectedTestcase.of(3, t -> t.minDistance("park", "spake")))
                .build();
    }
}