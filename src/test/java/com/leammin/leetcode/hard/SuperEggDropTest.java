package com.leammin.leetcode.hard;

import com.leammin.leetcode.undone.hard.SuperEggDrop;
import com.leammin.leetcode.util.AbstractTest;
import com.leammin.leetcode.util.ExpectedTestcase;
import com.leammin.leetcode.util.Testsuite;

/**
 * @author Leammin
 * @date 2020-04-11
 */
class SuperEggDropTest extends AbstractTest<SuperEggDrop> {
    @Override
    protected Testsuite<SuperEggDrop> testsuite() {
        return Testsuite.<SuperEggDrop>builder()
                .add(ExpectedTestcase.of(t -> t.superEggDrop(1, 2), 2))
                .add(ExpectedTestcase.of(t -> t.superEggDrop(2, 6), 3))
                .add(ExpectedTestcase.of(t -> t.superEggDrop(3, 14), 4))
                .add(ExpectedTestcase.of(t -> t.superEggDrop(8, 10000), 14))
                .add(ExpectedTestcase.of(t -> t.superEggDrop(2, 11), 5))
                .add(ExpectedTestcase.of(t -> t.superEggDrop(7, 1250), 11))
                .add(ExpectedTestcase.of(t -> t.superEggDrop(4, 9), 4))
                .add(ExpectedTestcase.of(t -> t.superEggDrop(3, 7), 3))
                .add(ExpectedTestcase.of(t -> t.superEggDrop(1000, 8), 4))
                .add(ExpectedTestcase.of(t -> t.superEggDrop(1000, 10), 4))
                .add(ExpectedTestcase.of(t -> t.superEggDrop(1000, 11), 4))
                .add(ExpectedTestcase.of(t -> t.superEggDrop(1000, 12), 4))
                .add(ExpectedTestcase.of(t -> t.superEggDrop(1000, 14), 4))
                .add(ExpectedTestcase.of(t -> t.superEggDrop(1000, 15), 4))
                .add(ExpectedTestcase.of(t -> t.superEggDrop(1000, 16), 5))
                .add(ExpectedTestcase.of(t -> t.superEggDrop(1000, 32), 6))
                .add(ExpectedTestcase.of(t -> t.superEggDrop(1000, 35), 6))
                .build();
    }
}