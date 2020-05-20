package com.leammin.leetcode.medium;

import com.leammin.leetcode.undone.medium.FindTheLongestSubstringContainingVowelsInEvenCounts;
import com.leammin.leetcode.util.AbstractTest;
import com.leammin.leetcode.util.ExpectedTestcase;
import com.leammin.leetcode.util.Testsuite;

/**
 * @author Leammin
 * @date 2020-05-20
 */
class FindTheLongestSubstringContainingVowelsInEvenCountsTest extends AbstractTest<FindTheLongestSubstringContainingVowelsInEvenCounts> {
    @Override
    protected Testsuite<FindTheLongestSubstringContainingVowelsInEvenCounts> testsuite() {
        return Testsuite.<FindTheLongestSubstringContainingVowelsInEvenCounts>builder()
                .add(ExpectedTestcase.of(t -> t.findTheLongestSubstring("ee"), 2))
                .add(ExpectedTestcase.of(t -> t.findTheLongestSubstring("eleetminicoworoep"), 13))
                .add(ExpectedTestcase.of(t -> t.findTheLongestSubstring("leetcodeisgreat"), 5))
                .add(ExpectedTestcase.of(t -> t.findTheLongestSubstring("bcbcbc"), 6))
                .build();
    }
}