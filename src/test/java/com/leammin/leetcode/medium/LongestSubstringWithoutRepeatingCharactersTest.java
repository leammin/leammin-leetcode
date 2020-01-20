package com.leammin.leetcode.medium;

import com.leammin.leetcode.util.AbstractTest;
import com.leammin.leetcode.util.ExpectedTestcase;
import com.leammin.leetcode.util.Testsuite;

/**
 * @author Leammin
 * @date 2020-01-18
 */
class LongestSubstringWithoutRepeatingCharactersTest extends AbstractTest<LongestSubstringWithoutRepeatingCharacters> {
    @Override
    protected Testsuite<LongestSubstringWithoutRepeatingCharacters> testsuite() {
        return Testsuite.<LongestSubstringWithoutRepeatingCharacters>builder()
                .add(ExpectedTestcase.of(3, s -> s.lengthOfLongestSubstring("abcabcbb")))
                .add(ExpectedTestcase.of(1, s -> s.lengthOfLongestSubstring("bbbbb")))
                .add(ExpectedTestcase.of(3, s -> s.lengthOfLongestSubstring("pwwkew")))
                .add(ExpectedTestcase.of(6, s -> s.lengthOfLongestSubstring("umvejcuuk")))
                .add(ExpectedTestcase.of(1, s -> s.lengthOfLongestSubstring(" ")))
                .build();
    }
}