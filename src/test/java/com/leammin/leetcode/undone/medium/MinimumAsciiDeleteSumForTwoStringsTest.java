package com.leammin.leetcode.undone.medium;

import com.leammin.leetcode.util.AbstractTest;
import com.leammin.leetcode.util.EqualTestcase;
import com.leammin.leetcode.util.Testsuite;

/**
 * @author Leammin
 * @date 2019-05-01
 */
class MinimumAsciiDeleteSumForTwoStringsTest extends AbstractTest<MinimumAsciiDeleteSumForTwoStrings> {

    @Override
    protected Testsuite<MinimumAsciiDeleteSumForTwoStrings> testsuite() {
        return Testsuite.<MinimumAsciiDeleteSumForTwoStrings>builder()
                .add(EqualTestcase.of(231, s -> s.minimumDeleteSum("sea", "eat")))
                .add(EqualTestcase.of(403, s -> s.minimumDeleteSum("delete", "leet")))
                .add(EqualTestcase.of(1638, s -> s.minimumDeleteSum("sjfqkfxqoditw", "fxymelgo")))
                .build();
    }
}