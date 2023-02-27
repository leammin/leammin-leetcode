package com.leammin.leetcode.medium;

import com.leammin.leetcode.util.AbstractTest;
import com.leammin.leetcode.util.test.ExpectedTestcase;
import com.leammin.leetcode.util.test.Testsuite;

/**
 * @author Leammin
 * @date 2020-01-25
 */
class LongestPalindromicSubstringTest extends AbstractTest<LongestPalindromicSubstring> {
    @Override
    protected Testsuite<LongestPalindromicSubstring> testsuite() {
        return Testsuite.<LongestPalindromicSubstring>builder()
                .add(ExpectedTestcase.of(t -> t.longestPalindrome("babad").length(), 3))
                .add(ExpectedTestcase.of(t -> t.longestPalindrome("cbbd").length(), 2))
                .build();
    }
}