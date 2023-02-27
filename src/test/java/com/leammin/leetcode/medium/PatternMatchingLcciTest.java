package com.leammin.leetcode.medium;

import com.leammin.leetcode.util.AbstractTest;
import com.leammin.leetcode.util.test.ExpectedTestcase;
import com.leammin.leetcode.util.test.Testsuite;

/**
 * @author Leammin
 * @date 2020-06-22
 */
class PatternMatchingLcciTest extends AbstractTest<PatternMatchingLcci> {
    @Override
    protected Testsuite<PatternMatchingLcci> testsuite() {
        return Testsuite.<PatternMatchingLcci>builder()
                .add(ExpectedTestcase.of(t -> t.patternMatching("abba", "dogcatcatdog"), true))
                .add(ExpectedTestcase.of(t -> t.patternMatching("abba", "dogcatcatfish"), false))
                .add(ExpectedTestcase.of(t -> t.patternMatching("aaaa", "dogcatcatdog"), false))
                .add(ExpectedTestcase.of(t -> t.patternMatching("abba", "dogdogdogdog"), true))
                .add(ExpectedTestcase.of(t -> t.patternMatching("aaaa", "dogdogdogdog"), true))
                .build();
    }
}