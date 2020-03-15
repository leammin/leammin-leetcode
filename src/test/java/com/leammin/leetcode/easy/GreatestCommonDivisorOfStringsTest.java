package com.leammin.leetcode.easy;

import com.leammin.leetcode.util.AbstractTest;
import com.leammin.leetcode.util.ExpectedTestcase;
import com.leammin.leetcode.util.Testsuite;

/**
 * @author Leammin
 * @date 2020-03-12
 */
class GreatestCommonDivisorOfStringsTest extends AbstractTest<GreatestCommonDivisorOfStrings> {
    @Override
    protected Testsuite<GreatestCommonDivisorOfStrings> testsuite() {
        return Testsuite.<GreatestCommonDivisorOfStrings>builder()
                .add(ExpectedTestcase.of("ABC", t -> t.gcdOfStrings("ABCABC", "ABC")))
                .add(ExpectedTestcase.of("AB", t -> t.gcdOfStrings("ABABAB", "ABAB")))
                .add(ExpectedTestcase.of("", t -> t.gcdOfStrings("LEET", "CODE")))
                .build();
    }
}