package com.leammin.leetcode.easy;

import com.leammin.leetcode.util.AbstractTest;
import com.leammin.leetcode.util.ExpectedTestcase;
import com.leammin.leetcode.util.Testsuite;

/**
 * @author Leammin
 * @date 2020-06-15
 */
class ReverseWordsInAStringIiiTest extends AbstractTest<ReverseWordsInAStringIii> {
    @Override
    protected Testsuite<ReverseWordsInAStringIii> testsuite() {
        return Testsuite.<ReverseWordsInAStringIii>builder()
                .add(ExpectedTestcase.of(t -> t.reverseWords("Let's take LeetCode contest"), "s'teL ekat edoCteeL tsetnoc"))
                .build();
    }
}