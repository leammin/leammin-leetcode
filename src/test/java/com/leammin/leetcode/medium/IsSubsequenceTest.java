package com.leammin.leetcode.medium;

import com.leammin.leetcode.util.AbstractTest;
import com.leammin.leetcode.util.ExpectedTestcase;
import com.leammin.leetcode.util.Testsuite;

/**
 * @author Leammin
 * @date 2019-08-29
 */
class IsSubsequenceTest extends AbstractTest<IsSubsequence> {
    @Override
    protected Testsuite<IsSubsequence> testsuite() {
        return Testsuite.<IsSubsequence>builder()
                .add(ExpectedTestcase.of(t -> t.isSubsequence("abc", "ahbgdc"), true))
                .add(ExpectedTestcase.of(t -> t.isSubsequence("axc", "ahbgdc"), false))
                .build();
    }
}