package com.leammin.leetcode.medium;

import com.leammin.leetcode.undone.medium.LongestPalindromicSubstring;
import com.leammin.leetcode.util.AbstractTest;
import com.leammin.leetcode.util.ExpectedTestcase;
import com.leammin.leetcode.util.Testsuite;

/**
 * @author Leammin
 * @date 2020-01-25
 */
class LongestPalindromicSubstringTest extends AbstractTest<LongestPalindromicSubstring> {
    @Override
    protected Testsuite<LongestPalindromicSubstring> testsuite() {
        return Testsuite.<LongestPalindromicSubstring>builder()
                .add(ExpectedTestcase.of(3, t -> t.longestPalindrome("babad").length()))
                .add(ExpectedTestcase.of(2, t -> t.longestPalindrome("cbbd").length()))
                .build();
    }
}