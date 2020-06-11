package com.leammin.leetcode.medium;

import com.leammin.leetcode.util.AbstractTest;
import com.leammin.leetcode.util.ExpectedTestcase;
import com.leammin.leetcode.util.Testsuite;

/**
 * @author Leammin
 * @date 2020-06-08
 */
class SatisfiabilityOfEqualityEquationsTest extends AbstractTest<SatisfiabilityOfEqualityEquations> {
    @Override
    protected Testsuite<SatisfiabilityOfEqualityEquations> testsuite() {
        return Testsuite.<SatisfiabilityOfEqualityEquations>builder()
                .add(ExpectedTestcase.of(t -> t.equationsPossible(new String[]{"a==b", "b!=a"}), false))
                .add(ExpectedTestcase.of(t -> t.equationsPossible(new String[]{"b==a","a==b"}), true))
                .add(ExpectedTestcase.of(t -> t.equationsPossible(new String[]{"a==b","b==c"}), true))
                .add(ExpectedTestcase.of(t -> t.equationsPossible(new String[]{"a==b","b!=c","c==a"}), false))
                .add(ExpectedTestcase.of(t -> t.equationsPossible(new String[]{"c==c","b==d","x!=z"}), true))
                .add(ExpectedTestcase.of(t -> t.equationsPossible(new String[]{"a!=a"}), false))
                .add(ExpectedTestcase.of(t -> t.equationsPossible(new String[]{"a==b","e==c","b==c","a!=e"}), false))
                .build();
    }
}