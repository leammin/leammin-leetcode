package com.leammin.leetcode.hard;

import com.leammin.leetcode.util.AbstractTest;
import com.leammin.leetcode.util.test.ExpectedTestcase;
import com.leammin.leetcode.util.test.Testsuite;

/**
 * @author Leammin
 * @date 2020-05-24
 */
class MinimumWindowSubstringTest extends AbstractTest<MinimumWindowSubstring> {
    @Override
    protected Testsuite<MinimumWindowSubstring> testsuite() {
        return Testsuite.<MinimumWindowSubstring>builder()
                .add(ExpectedTestcase.of(t -> t.minWindow("ADOBECODEBANC", "ABC"), "BANC"))
                .build();
    }
}