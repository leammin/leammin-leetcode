package com.leammin.leetcode.medium;

import com.leammin.leetcode.util.AbstractTest;
import com.leammin.leetcode.util.ExpectedTestcase;
import com.leammin.leetcode.util.Testsuite;

/**
 * @author Leammin
 * @date 2020-05-14
 */
class EvaluateReversePolishNotationTest extends AbstractTest<EvaluateReversePolishNotation> {
    @Override
    protected Testsuite<EvaluateReversePolishNotation> testsuite() {
        return Testsuite.<EvaluateReversePolishNotation>builder()
                .add(ExpectedTestcase.of(t -> t.evalRPN(new String[]{"2", "1", "+", "3", "*"}), 9))
                .add(ExpectedTestcase.of(t -> t.evalRPN(new String[]{"4", "13", "5", "/", "+"}), 6))
                .add(ExpectedTestcase.of(t -> t.evalRPN(new String[]{"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"}), 22))
                .build();
    }
}