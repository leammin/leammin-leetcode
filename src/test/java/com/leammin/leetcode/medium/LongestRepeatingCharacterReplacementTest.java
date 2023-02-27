package com.leammin.leetcode.medium;

import com.leammin.leetcode.util.AbstractTest;
import com.leammin.leetcode.util.test.ExpectedTestcase;
import com.leammin.leetcode.util.test.Testsuite;

/**
 * @author Leammin
 * @date 2021-02-02
 */
class LongestRepeatingCharacterReplacementTest extends AbstractTest<LongestRepeatingCharacterReplacement> {
    @Override
    protected Testsuite<LongestRepeatingCharacterReplacement> testsuite() {
        return Testsuite.<LongestRepeatingCharacterReplacement>builder()
                .add(ExpectedTestcase.of(t -> t.characterReplacement("ABAB", 2), 4))
                .add(ExpectedTestcase.of(t -> t.characterReplacement("AABABBA", 1), 4))
                .build();
    }
}