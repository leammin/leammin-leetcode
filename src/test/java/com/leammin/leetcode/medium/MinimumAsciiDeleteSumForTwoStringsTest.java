package com.leammin.leetcode.medium;

import com.leammin.leetcode.util.AbstractTest;
import com.leammin.leetcode.util.test.ExpectedTestcase;
import com.leammin.leetcode.util.test.Testsuite;

/**
 * @author Leammin
 * @date 2019-05-01
 */
class MinimumAsciiDeleteSumForTwoStringsTest extends AbstractTest<MinimumAsciiDeleteSumForTwoStrings> {

    @Override
    protected Testsuite<MinimumAsciiDeleteSumForTwoStrings> testsuite() {
        return Testsuite.<MinimumAsciiDeleteSumForTwoStrings>builder()
                .add(ExpectedTestcase.of(s -> s.minimumDeleteSum("sea", "eat"), 231))
                .add(ExpectedTestcase.of(s -> s.minimumDeleteSum("delete", "leet"), 403))
                .add(ExpectedTestcase.of(s -> s.minimumDeleteSum("sjfqkfxqoditw", "fxymelgo"), 1638))
                .build();
    }
}