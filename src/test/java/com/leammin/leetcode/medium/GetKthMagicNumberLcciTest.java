package com.leammin.leetcode.medium;

import com.leammin.leetcode.util.AbstractTest;
import com.leammin.leetcode.util.Testsuite;

/**
 * @author Leammin
 * @date 2022-09-28
 */
class GetKthMagicNumberLcciTest extends AbstractTest<GetKthMagicNumberLcci> {
    @Override
    protected Testsuite<GetKthMagicNumberLcci> testsuite() {
        return Testsuite.<GetKthMagicNumberLcci>builder()
                .addExpected(t -> t.getKthMagicNumber(5), 9)
                .addExpected(t -> t.getKthMagicNumber(9), 27)
                .build();
    }
}