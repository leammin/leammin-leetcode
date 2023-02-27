package com.leammin.leetcode.medium;

import com.leammin.leetcode.util.AbstractTest;
import com.leammin.leetcode.util.test.Testsuite;

/**
 * @author Leammin
 * @date 2021-09-06
 */
class ShuZhiDeZhengShuCiFangLcofTest extends AbstractTest<ShuZhiDeZhengShuCiFangLcof> {
    @Override
    protected Testsuite<ShuZhiDeZhengShuCiFangLcof> testsuite() {
        return Testsuite.<ShuZhiDeZhengShuCiFangLcof>builder()
                .addExpected(t -> t.myPow(2.00000, 10), 1024.00000)
                .addExpected(t -> t.myPow(2.10000, 3), 9.261000000000001)
                .addExpected(t -> t.myPow(2.00000, -2), 0.25000)
                .addExpected(t -> t.myPow(1.00000, -2147483648), 1.0)
                .build();
    }
}