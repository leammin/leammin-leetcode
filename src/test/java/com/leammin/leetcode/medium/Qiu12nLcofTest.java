package com.leammin.leetcode.medium;

import com.leammin.leetcode.util.AbstractTest;
import com.leammin.leetcode.util.ExpectedTestcase;
import com.leammin.leetcode.util.Testsuite;

/**
 * @author Leammin
 * @date 2020-06-02
 */
class Qiu12nLcofTest extends AbstractTest<Qiu12nLcof> {
    @Override
    protected Testsuite<Qiu12nLcof> testsuite() {
        return Testsuite.<Qiu12nLcof>builder()
                .add(ExpectedTestcase.of(t -> t.sumNums(3), 6))
                .add(ExpectedTestcase.of(t -> t.sumNums(9), 45))
                .build();
    }
}