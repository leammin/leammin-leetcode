package com.leammin.leetcode.easy;

import com.leammin.leetcode.util.AbstractTest;
import com.leammin.leetcode.util.test.ExpectedTestcase;
import com.leammin.leetcode.util.test.Testsuite;

/**
 * @author Leammin
 * @date 2020-03-19
 */
class LongestPalindromeTest extends AbstractTest<LongestPalindrome> {
    @Override
    protected Testsuite<LongestPalindrome> testsuite() {
        return Testsuite.<LongestPalindrome>builder()
                .add(ExpectedTestcase.of(t -> t.longestPalindrome("abccccdd"), 7))
                .build();
    }
}