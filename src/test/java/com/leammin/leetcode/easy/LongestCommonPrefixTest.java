package com.leammin.leetcode.easy;

import com.leammin.leetcode.util.AbstractTest;
import com.leammin.leetcode.util.test.ExpectedTestcase;
import com.leammin.leetcode.util.test.Testsuite;

/**
 * @author Leammin
 * @date 2020-06-12
 */
class LongestCommonPrefixTest extends AbstractTest<LongestCommonPrefix> {
    @Override
    protected Testsuite<LongestCommonPrefix> testsuite() {
        return Testsuite.<LongestCommonPrefix>builder()
                .add(ExpectedTestcase.of(t -> t.longestCommonPrefix(new String[]{"flower","flow","flight"}), "fl"))
                .add(ExpectedTestcase.of(t -> t.longestCommonPrefix(new String[]{"dog","racecar","car"}), ""))
                .build();
    }
}