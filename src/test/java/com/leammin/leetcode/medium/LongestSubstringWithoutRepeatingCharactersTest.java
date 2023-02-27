package com.leammin.leetcode.medium;

import com.leammin.leetcode.util.AbstractTest;
import com.leammin.leetcode.util.test.ExpectedTestcase;
import com.leammin.leetcode.util.test.Testsuite;

/**
 * @author Leammin
 * @date 2020-01-18
 */
class LongestSubstringWithoutRepeatingCharactersTest extends AbstractTest<LongestSubstringWithoutRepeatingCharacters> {
    @Override
    protected Testsuite<LongestSubstringWithoutRepeatingCharacters> testsuite() {
        return Testsuite.<LongestSubstringWithoutRepeatingCharacters>builder()
                .add(ExpectedTestcase.of(s -> s.lengthOfLongestSubstring("abcabcbb"), 3))
                .add(ExpectedTestcase.of(s -> s.lengthOfLongestSubstring("bbbbb"), 1))
                .add(ExpectedTestcase.of(s -> s.lengthOfLongestSubstring("pwwkew"), 3))
                .add(ExpectedTestcase.of(s -> s.lengthOfLongestSubstring("umvejcuuk"), 6))
                .add(ExpectedTestcase.of(s -> s.lengthOfLongestSubstring(" "), 1))
                .build();
    }
}