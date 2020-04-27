package com.leammin.leetcode.medium;

import com.leammin.leetcode.util.AbstractTest;
import com.leammin.leetcode.util.ExpectedTestcase;
import com.leammin.leetcode.util.Testsuite;

/**
 * @author Leammin
 * @date 2020-04-23
 */
class CoinLcciTest extends AbstractTest<CoinLcci> {
    @Override
    protected Testsuite<CoinLcci> testsuite() {
        return Testsuite.<CoinLcci>builder()
                .add(ExpectedTestcase.of(t -> t.waysToChange(5), 2))
                .add(ExpectedTestcase.of(t -> t.waysToChange(10), 4))
                .add(ExpectedTestcase.of(t -> t.waysToChange(20), 9))
                .add(ExpectedTestcase.of(t -> t.waysToChange(61), 73))
                .add(ExpectedTestcase.of(t -> t.waysToChange(15), 6))
                .add(ExpectedTestcase.of(t -> t.waysToChange(4), 1))
                .add(ExpectedTestcase.of(t -> t.waysToChange(9), 2))
                .add(ExpectedTestcase.of(t -> t.waysToChange(14), 4))
                .add(ExpectedTestcase.of(t -> t.waysToChange(19), 6))
                .add(ExpectedTestcase.of(t -> t.waysToChange(24), 9))
                .add(ExpectedTestcase.of(t -> t.waysToChange(29), 13))
                .add(ExpectedTestcase.of(t -> t.waysToChange(34), 18))
                .add(ExpectedTestcase.of(t -> t.waysToChange(39), 24))
                .add(ExpectedTestcase.of(t -> t.waysToChange(900750), 504188296))
                .build();
    }
}