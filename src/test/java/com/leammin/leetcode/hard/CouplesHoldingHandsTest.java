package com.leammin.leetcode.hard;

import com.leammin.leetcode.util.AbstractTest;
import com.leammin.leetcode.util.test.ExpectedTestcase;
import com.leammin.leetcode.util.test.Testsuite;

/**
 * @author Leammin
 * @date 2021-02-14
 */
class CouplesHoldingHandsTest extends AbstractTest<CouplesHoldingHands> {
    @Override
    protected Testsuite<CouplesHoldingHands> testsuite() {
        return Testsuite.<CouplesHoldingHands>builder()
                .add(ExpectedTestcase.of(t -> t.minSwapsCouples(new int[]{0, 2, 1, 3}), 1))
                .add(ExpectedTestcase.of(t -> t.minSwapsCouples(new int[]{3, 2, 0, 1}), 0))
                .build();
    }

}