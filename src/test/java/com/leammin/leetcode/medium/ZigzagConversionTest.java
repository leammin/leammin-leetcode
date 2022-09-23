package com.leammin.leetcode.medium;

import com.leammin.leetcode.undone.medium.ZigzagConversion;
import com.leammin.leetcode.util.AbstractTest;
import com.leammin.leetcode.util.Testsuite;

/**
 * @author Leammin
 * @date 2022-09-23
 */
class ZigzagConversionTest extends AbstractTest<ZigzagConversion> {
    @Override
    protected Testsuite<ZigzagConversion> testsuite() {
        return Testsuite.<ZigzagConversion>builder()
                .addExpected(t -> t.convert("PAYPALISHIRING", 3), "PAHNAPLSIIGYIR")
                .addExpected(t -> t.convert("PAYPALISHIRING", 4), "PINALSIGYAHRPI")
                .addExpected(t -> t.convert("ABC", 1), "ABC")
                .addExpected(t -> t.convert("ABC", 2), "ACB")
                .build();
    }
}