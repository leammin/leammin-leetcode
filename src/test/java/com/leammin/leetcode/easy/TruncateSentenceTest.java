package com.leammin.leetcode.easy;

import com.leammin.leetcode.util.AbstractTest;
import com.leammin.leetcode.util.Testsuite;

/**
 * @author Leammin
 * @date 2021-04-04
 */
class TruncateSentenceTest extends AbstractTest<TruncateSentence> {
    @Override
    protected Testsuite<TruncateSentence> testsuite() {
        return Testsuite.<TruncateSentence>builder()
                .addExpected(t -> t.truncateSentence("Hello how are you Contestant", 4), "Hello how are you")
                .addExpected(t -> t.truncateSentence("What is the solution to this problem", 4), "What is the solution")
                .addExpected(t -> t.truncateSentence("chopper is not a tanuki", 5), "chopper is not a tanuki")
                .build();
    }

}