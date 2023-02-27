package com.leammin.leetcode.hard;

import com.leammin.leetcode.util.AbstractTest;
import com.leammin.leetcode.util.test.ExpectedTestcase;
import com.leammin.leetcode.util.test.Testsuite;

/**
 * @author Leammin
 * @date 2020-06-20
 */
class RegularExpressionMatchingTest extends AbstractTest<RegularExpressionMatching> {
    @Override
    protected Testsuite<RegularExpressionMatching> testsuite() {
        return Testsuite.<RegularExpressionMatching>builder()
                .add(ExpectedTestcase.of(t -> t.isMatch("aa", "a"), false))
                .add(ExpectedTestcase.of(t -> t.isMatch("aa", "a*"), true))
                .add(ExpectedTestcase.of(t -> t.isMatch("ab", ".*"), true))
                .add(ExpectedTestcase.of(t -> t.isMatch("aab", "c*a*b"), true))
                .add(ExpectedTestcase.of(t -> t.isMatch("mississippi", "mis*is*p*."), false))
                .add(ExpectedTestcase.of(t -> t.isMatch("a", ".*..a*"), false))
                .add(ExpectedTestcase.of(t -> t.isMatch("bba", "bba*"), true))
                .add(ExpectedTestcase.of(t -> t.isMatch("", "c*c*"), true))
                .add(ExpectedTestcase.of(t -> t.isMatch("abbabaaaaaaacaa", "a*.*b.a.*c*b*a*c*"), true))
                .add(ExpectedTestcase.of(t -> t.isMatch("a", ".*c*"), true))
                .build();
    }
}