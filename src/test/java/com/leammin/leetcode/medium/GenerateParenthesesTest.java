package com.leammin.leetcode.medium;

import com.leammin.leetcode.util.AbstractTest;
import com.leammin.leetcode.util.Testsuite;
import com.leammin.leetcode.util.VerifiableTestcase;
import org.assertj.core.api.Assertions;

/**
 * @author Leammin
 * @date 2020-03-21
 */
class GenerateParenthesesTest extends AbstractTest<GenerateParentheses> {
    @Override
    protected Testsuite<GenerateParentheses> testsuite() {
        return Testsuite.<GenerateParentheses>builder()
                .add(VerifiableTestcase.ofConsumer(t -> t.generateParenthesis(3), res -> Assertions.assertThat(res).containsExactlyInAnyOrder(
                        "((()))", "(()())", "(())()", "()(())", "()()()"
                        )
                ))
                .add(VerifiableTestcase.ofConsumer(t -> t.generateParenthesis(4), res -> Assertions.assertThat(res).containsExactlyInAnyOrder(
                        "(((())))", "((()()))", "((())())", "((()))()", "(()(()))", "(()()())", "(()())()", "(())(())",
                        "(())()()", "()((()))", "()(()())", "()(())()", "()()(())", "()()()()"
                        )
                ))
                .build();
    }
}