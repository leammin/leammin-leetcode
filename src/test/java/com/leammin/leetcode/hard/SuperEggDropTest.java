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
                .build();
    }
}