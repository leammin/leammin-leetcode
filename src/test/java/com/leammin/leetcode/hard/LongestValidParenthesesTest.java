package com.leammin.leetcode.hard;

import com.leammin.leetcode.util.AbstractTest;
import com.leammin.leetcode.util.test.ExpectedTestcase;
import com.leammin.leetcode.util.test.Testsuite;

/**
 * @author Leammin
 * @date 2020-07-04
 */
class LongestValidParenthesesTest extends AbstractTest<LongestValidParentheses> {
    @Override
    protected Testsuite<LongestValidParentheses> testsuite() {
        return Testsuite.<LongestValidParentheses>builder()
                .add(ExpectedTestcase.of(t -> t.longestValidParentheses("(()"), 2))
                .add(ExpectedTestcase.of(t -> t.longestValidParentheses(")()())"), 4))
                .add(ExpectedTestcase.of(t -> t.longestValidParentheses("(()())"), 6))
                .add(ExpectedTestcase.of(t -> t.longestValidParentheses("(()()"), 4))
                .add(ExpectedTestcase.of(t -> t.longestValidParentheses("()())"), 4))
                .add(ExpectedTestcase.of(t -> t.longestValidParentheses(""), 0))
                .build();
    }
}