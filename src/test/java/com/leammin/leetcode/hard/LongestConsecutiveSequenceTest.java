package com.leammin.leetcode.hard;

import com.leammin.leetcode.util.AbstractTest;
import com.leammin.leetcode.util.test.ExpectedTestcase;
import com.leammin.leetcode.util.test.Testsuite;

/**
 * @author Leammin
 * @date 2020-06-06
 */
class LongestConsecutiveSequenceTest extends AbstractTest<LongestConsecutiveSequence> {
    @Override
    protected Testsuite<LongestConsecutiveSequence> testsuite() {
        return Testsuite.<LongestConsecutiveSequence>builder()
                .add(ExpectedTestcase.of(t -> t.longestConsecutive(new int[]{100, 4, 200, 1, 3, 2}), 4))
                .add(ExpectedTestcase.of(t -> t.longestConsecutive(new int[]{1, 2, 0, 1}), 3))
                .add(ExpectedTestcase.of(t -> t.longestConsecutive(new int[]{-7, -1, 3, -9, -4, 7, -3, 2, 4, 9, 4, -9, 8, -7, 5, -1, -7}), 4))
                .build();
    }
}