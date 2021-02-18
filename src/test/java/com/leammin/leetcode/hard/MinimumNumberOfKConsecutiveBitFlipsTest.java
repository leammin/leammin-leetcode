package com.leammin.leetcode.hard;

import com.leammin.leetcode.util.AbstractTest;
import com.leammin.leetcode.util.ExpectedTestcase;
import com.leammin.leetcode.util.Testsuite;

/**
 * @author Leammin
 * @date 2021-02-18
 */
class MinimumNumberOfKConsecutiveBitFlipsTest extends AbstractTest<MinimumNumberOfKConsecutiveBitFlips> {
    @Override
    protected Testsuite<MinimumNumberOfKConsecutiveBitFlips> testsuite() {
        return Testsuite.<MinimumNumberOfKConsecutiveBitFlips>builder()
                .add(ExpectedTestcase.of(t -> t.minKBitFlips(new int[]{0,1,0}, 1), 2))
                .add(ExpectedTestcase.of(t -> t.minKBitFlips(new int[]{1,1,0}, 2), -1))
                .add(ExpectedTestcase.of(t -> t.minKBitFlips(new int[]{0,0,0,1,0,1,1,0}, 3), 3))
                .build();
    }
}