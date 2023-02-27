package com.leammin.leetcode.medium;

import com.leammin.leetcode.util.AbstractTest;
import com.leammin.leetcode.util.test.Testsuite;

/**
 * @author Leammin
 * @date 2021-04-03
 */
class KThSymbolInGrammarTest extends AbstractTest<KThSymbolInGrammar> {
    @Override
    protected Testsuite<KThSymbolInGrammar> testsuite() {
        return Testsuite.<KThSymbolInGrammar>builder()
                .addExpected(t -> t.kthGrammar(1, 1), 0)
                .addExpected(t -> t.kthGrammar(2, 1), 0)
                .addExpected(t -> t.kthGrammar(2, 2), 1)
                .addExpected(t -> t.kthGrammar(4, 5), 1)
                .build();
    }
}