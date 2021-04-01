package com.leammin.leetcode.medium;

import com.leammin.leetcode.util.AbstractTest;
import com.leammin.leetcode.util.Testsuite;

/**
 * @author Leammin
 * @date 2021-04-01
 */
class SortCharactersByFrequencyTest extends AbstractTest<SortCharactersByFrequency> {
    @Override
    protected Testsuite<SortCharactersByFrequency> testsuite() {
        return Testsuite.<SortCharactersByFrequency>builder()
                .addExpected(t -> t.frequencySort("baaccc"), "cccaab")
                .build();
    }
}