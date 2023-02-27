package com.leammin.leetcode.easy;

import com.leammin.leetcode.util.AbstractTest;
import com.leammin.leetcode.util.test.ExpectedTestcase;
import com.leammin.leetcode.util.test.Testsuite;

/**
 * @author Leammin
 * @date 2020-03-12
 */
class GreatestCommonDivisorOfStringsTest extends AbstractTest<GreatestCommonDivisorOfStrings> {
    @Override
    protected Testsuite<GreatestCommonDivisorOfStrings> testsuite() {
        return Testsuite.<GreatestCommonDivisorOfStrings>builder()
                .add(ExpectedTestcase.of(t -> t.gcdOfStrings("ABCABC", "ABC"), "ABC"))
                .add(ExpectedTestcase.of(t -> t.gcdOfStrings("ABABAB", "ABAB"), "AB"))
                .add(ExpectedTestcase.of(t -> t.gcdOfStrings("LEET", "CODE"), ""))
                .build();
    }
}