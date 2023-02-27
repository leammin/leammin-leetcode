package com.leammin.leetcode.hard;

import com.leammin.leetcode.undone.hard.ShuZuZhongDeNiXuDuiLcof;
import com.leammin.leetcode.util.AbstractTest;
import com.leammin.leetcode.util.test.ExpectedTestcase;
import com.leammin.leetcode.util.test.Testsuite;

/**
 * @author Leammin
 * @date 2020-05-28
 */
class ShuZuZhongDeNiXuDuiLcofTest extends AbstractTest<ShuZuZhongDeNiXuDuiLcof> {
    @Override
    protected Testsuite<ShuZuZhongDeNiXuDuiLcof> testsuite() {
        return Testsuite.<ShuZuZhongDeNiXuDuiLcof>builder()
                .add(ExpectedTestcase.of(t -> t.reversePairs(new int[]{7,5,6,4}), 5))
                .build();
    }
}