package com.leammin.leetcode.medium;

import com.leammin.leetcode.util.AbstractTest;
import com.leammin.leetcode.util.ExpectedTestcase;
import com.leammin.leetcode.util.Testsuite;

/**
 * @author Leammin
 * @date 2020-04-10
 */
class ReverseWordsInAStringTest extends AbstractTest<ReverseWordsInAString> {
    @Override
    protected Testsuite<ReverseWordsInAString> testsuite() {
        return Testsuite.<ReverseWordsInAString>builder()
                .add(ExpectedTestcase.of("blue is sky the", t->t.reverseWords("the sky is blue")))
                .add(ExpectedTestcase.of("world! hello", t->t.reverseWords("  hello world!  ")))
                .add(ExpectedTestcase.of("example good a", t->t.reverseWords("a good   example")))
                .build();
    }
}