package com.leammin.leetcode.easy;

import com.leammin.leetcode.util.AbstractTest;
import com.leammin.leetcode.util.ExpectedTestcase;
import com.leammin.leetcode.util.Testsuite;

/**
 * @author Leammin
 * @date 2020-05-19
 */
class ValidPalindromeIiTest extends AbstractTest<ValidPalindromeIi> {
    @Override
    protected Testsuite<ValidPalindromeIi> testsuite() {
        return Testsuite.<ValidPalindromeIi>builder()
                .add(ExpectedTestcase.of(t -> t.validPalindrome("aba"), true))
                .add(ExpectedTestcase.of(t -> t.validPalindrome("abca"), true))
                .add(ExpectedTestcase.of(t -> t.validPalindrome("abcca"), true))
                .add(ExpectedTestcase.of(t -> t.validPalindrome("abcca"), true))
                .add(ExpectedTestcase.of(t -> t.validPalindrome("abcaca"), true))
                .add(ExpectedTestcase.of(t -> t.validPalindrome("abccaca"), false))
                .build();
    }
}