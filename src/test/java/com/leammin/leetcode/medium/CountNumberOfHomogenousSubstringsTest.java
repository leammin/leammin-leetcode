package com.leammin.leetcode.medium;

import com.leammin.leetcode.util.AbstractTest;
import com.leammin.leetcode.util.Testsuite;

/**
 * @author Leammin
 * @date 2022-12-26
 */
class CountNumberOfHomogenousSubstringsTest extends AbstractTest<CountNumberOfHomogenousSubstrings> {
    @Override
    protected Testsuite<CountNumberOfHomogenousSubstrings> testsuite() {
        return Testsuite.<CountNumberOfHomogenousSubstrings>builder()
                .addExpected(t -> t.countHomogenous("abbcccaa"), 13)
                .addExpected(t -> t.countHomogenous("xy"), 2)
                .addExpected(t -> t.countHomogenous("zzzzz"), 15)
                .build();
    }
}