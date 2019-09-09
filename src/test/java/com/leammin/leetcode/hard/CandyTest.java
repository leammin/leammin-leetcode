package com.leammin.leetcode.hard;

import com.leammin.leetcode.undone.hard.Candy;
import com.leammin.leetcode.util.AbstractTest;
import com.leammin.leetcode.util.ExpectedTestcase;
import com.leammin.leetcode.util.Testsuite;

/**
 * @author Leammin
 * @date 2019-09-04
 */
class CandyTest extends AbstractTest<Candy> {
    @Override
    protected Testsuite<Candy> testsuite() {
        return Testsuite.<Candy>builder()
                .add(ExpectedTestcase.of(5, t -> t.candy(new int[]{1,0,2})))
                .add(ExpectedTestcase.of(4, t -> t.candy(new int[]{1,2,2})))
                .build();
    }
}