package com.leammin.leetcode.hard;

import com.leammin.leetcode.util.AbstractTest;
import com.leammin.leetcode.util.test.ExpectedTestcase;
import com.leammin.leetcode.util.test.Testsuite;

/**
 * @author Leammin
 * @date 2019-09-04
 */
class CandyTest extends AbstractTest<Candy> {

    @Override
    protected Testsuite<Candy> testsuite() {
        return Testsuite.<Candy>builder()
                .add(ExpectedTestcase.of(t -> t.candy(new int[]{1,0,2}), 5))
                .add(ExpectedTestcase.of(t -> t.candy(new int[]{1,2,2}), 4))
                .add(ExpectedTestcase.of(t -> t.candy(new int[]{1,3,2,2,1}), 7))
                .add(ExpectedTestcase.of(t -> t.candy(new int[]{1,6,10,8,7,3,2}), 18))
                .build();
    }
}