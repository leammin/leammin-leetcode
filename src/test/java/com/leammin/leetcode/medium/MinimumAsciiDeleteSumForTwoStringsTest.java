package com.leammin.leetcode.medium;

import com.leammin.leetcode.undone.medium.MinimumAsciiDeleteSumForTwoStrings;
import com.leammin.leetcode.util.AbstractTest;
import com.leammin.leetcode.util.ExpectedTestcase;
import com.leammin.leetcode.util.Testsuite;

/**
 * @author Leammin
 * @date 2019-05-01
 */
class MinimumAsciiDeleteSumForTwoStringsTest extends AbstractTest<MinimumAsciiDeleteSumForTwoStrings> {

    @Override
    protected Testsuite<MinimumAsciiDeleteSumForTwoStrings> testsuite() {
        return Testsuite.<MinimumAsciiDeleteSumForTwoStrings>builder()
                .add(ExpectedTestcase.of(231, s -> s.minimumDeleteSum("sea", "eat")))
                .add(ExpectedTestcase.of(403, s -> s.minimumDeleteSum("delete", "leet")))
                .add(ExpectedTestcase.of(1638, s -> s.minimumDeleteSum("sjfqkfxqoditw", "fxymelgo")))
                .build();
    }
}