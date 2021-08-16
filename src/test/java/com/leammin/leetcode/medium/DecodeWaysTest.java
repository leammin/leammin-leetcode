package com.leammin.leetcode.medium;

import com.leammin.leetcode.undone.medium.DecodeWays;
import com.leammin.leetcode.util.AbstractTest;
import com.leammin.leetcode.util.Testsuite;

/**
 * @author Leammin
 * @date 2021-04-21
 */
class DecodeWaysTest extends AbstractTest<DecodeWays> {
    @Override
    protected Testsuite<DecodeWays> testsuite() {
        return Testsuite.<DecodeWays>builder()
            .addExpected(t -> t.numDecodings("12"), 2)
            .addExpected(t -> t.numDecodings("226"), 3)
            .addExpected(t -> t.numDecodings("0"), 0)
            .addExpected(t -> t.numDecodings("100"), 0)
            .addExpected(t -> t.numDecodings("2101"), 1)
            .build();
    }
}