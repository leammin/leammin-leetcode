package com.leammin.leetcode.easy;

import com.leammin.leetcode.util.AbstractTest;
import com.leammin.leetcode.util.Testsuite;

/**
 * @author Leammin
 * @date 2021-09-06
 */
class ErJinZhiZhong1deGeShuLcofTest extends AbstractTest<ErJinZhiZhong1deGeShuLcof> {
    @Override
    protected Testsuite<ErJinZhiZhong1deGeShuLcof> testsuite() {
        return Testsuite.<ErJinZhiZhong1deGeShuLcof>builder()
                .addExpected(t -> t.hammingWeight(0b00000000000000000000000010000000), 1)
                .addExpected(t -> t.hammingWeight(0b00000000000000000000000000001011), 3)
                .addExpected(t -> t.hammingWeight(0b11111111111111111111111111111101), 31)
                .build();
    }
}