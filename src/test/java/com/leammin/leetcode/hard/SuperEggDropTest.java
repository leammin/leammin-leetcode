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
                .add(ExpectedTestcase.of(2, t -> t.superEggDrop(1, 2)))
                .add(ExpectedTestcase.of(3, t -> t.superEggDrop(2, 6)))
                .add(ExpectedTestcase.of(4, t -> t.superEggDrop(3, 14)))
                .add(ExpectedTestcase.of(14, t -> t.superEggDrop(8, 10000)))
                .build();
    }
}