package com.leammin.leetcode.hard;

import com.leammin.leetcode.undone.hard.InterleavingString;
import com.leammin.leetcode.util.AbstractTest;
import com.leammin.leetcode.util.ExpectedTestcase;
import com.leammin.leetcode.util.Testsuite;

/**
 * @author Leammin
 * @date 2020-07-18
 */
class InterleavingStringTest extends AbstractTest<InterleavingString> {
    @Override
    protected Testsuite<InterleavingString> testsuite() {
        return Testsuite.<InterleavingString>builder()
                .add(ExpectedTestcase.of(t -> t.isInterleave("aabcc", "dbbca", "aadbbcbcac"), true))
                .add(ExpectedTestcase.of(t -> t.isInterleave("aabcc", "dbbca", "aadbbbaccc"), false))
                .build();
    }
}