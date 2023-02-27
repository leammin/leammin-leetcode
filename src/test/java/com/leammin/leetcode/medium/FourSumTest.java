package com.leammin.leetcode.medium;

import com.leammin.leetcode.util.AbstractTest;
import com.leammin.leetcode.util.test.Testsuite;

import java.util.List;

/**
 * @author Leammin
 * @date 2021-04-01
 */
class FourSumTest extends AbstractTest<FourSum> {
    @Override
    protected Testsuite<FourSum> testsuite() {
        return Testsuite.<FourSum>builder()
                .addExpected(t -> t.fourSum(new int[]{1, 0, -1, 0, -2, 2}, 0), List.of(
                        List.of(-2, -1, 1, 2),
                        List.of(-2,  0, 0, 2),
                        List.of(-1,  0, 0, 1)
                ))
                .addExpected(t -> t.fourSum(new int[]{-2,-1,-1,1,1,2,2}, 0), List.of(
                        List.of(-2,-1,1,2),
                        List.of(-1,-1,1,1)
                ))
                .build();
    }
}