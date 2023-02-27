package com.leammin.leetcode.medium;

import com.leammin.leetcode.util.AbstractTest;
import com.leammin.leetcode.util.test.ExpectedTestcase;
import com.leammin.leetcode.util.test.Testsuite;

/**
 * @author Leammin
 * @date 2021-02-10
 */
class PermutationInStringTest extends AbstractTest<PermutationInString> {
    @Override
    protected Testsuite<PermutationInString> testsuite() {
        return Testsuite.<PermutationInString>builder()
                .add(ExpectedTestcase.of(t -> t.checkInclusion("ab", "eidbaooo"), true))
                .add(ExpectedTestcase.of(t -> t.checkInclusion("ab", "eidboaoo"), false))
                .build();
    }

}