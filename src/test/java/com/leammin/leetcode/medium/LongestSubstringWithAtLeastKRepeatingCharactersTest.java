package com.leammin.leetcode.medium;

import com.leammin.leetcode.util.AbstractTest;
import com.leammin.leetcode.util.test.ExpectedTestcase;
import com.leammin.leetcode.util.test.Testsuite;

/**
 * @author Leammin
 * @date 2021-02-27
 */
class LongestSubstringWithAtLeastKRepeatingCharactersTest extends AbstractTest<LongestSubstringWithAtLeastKRepeatingCharacters> {
    @Override
    protected Testsuite<LongestSubstringWithAtLeastKRepeatingCharacters> testsuite() {
        return Testsuite.<LongestSubstringWithAtLeastKRepeatingCharacters>builder()
                .add(ExpectedTestcase.of(t -> t.longestSubstring("aaabb", 3), 3))
                .add(ExpectedTestcase.of(t -> t.longestSubstring("ababbc", 2), 5))
                .add(ExpectedTestcase.of(t -> t.longestSubstring("ayaayxaaaxccycc", 3), 3))
                .build();
    }

}