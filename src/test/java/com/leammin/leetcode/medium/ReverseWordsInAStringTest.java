package com.leammin.leetcode.medium;

import com.leammin.leetcode.util.AbstractTest;
import com.leammin.leetcode.util.test.ExpectedTestcase;
import com.leammin.leetcode.util.test.Testsuite;

/**
 * @author Leammin
 * @date 2020-04-10
 */
class ReverseWordsInAStringTest extends AbstractTest<ReverseWordsInAString> {
    @Override
    protected Testsuite<ReverseWordsInAString> testsuite() {
        return Testsuite.<ReverseWordsInAString>builder()
                .add(ExpectedTestcase.of(t->t.reverseWords("the sky is blue"), "blue is sky the"))
                .add(ExpectedTestcase.of(t->t.reverseWords("  hello world!  "), "world! hello"))
                .add(ExpectedTestcase.of(t->t.reverseWords("a good   example"), "example good a"))
                .build();
    }
}