package com.leammin.leetcode.hard;

import com.leammin.leetcode.util.AbstractTest;
import com.leammin.leetcode.util.test.ExpectedTestcase;
import com.leammin.leetcode.util.test.Testsuite;

/**
 * @author Leammin
 * @date 2021-02-09
 */
class SubarraysWithKDifferentIntegersTest extends AbstractTest<SubarraysWithKDifferentIntegers> {
    @Override
    protected Testsuite<SubarraysWithKDifferentIntegers> testsuite() {
        return Testsuite.<SubarraysWithKDifferentIntegers>builder()
                .add(ExpectedTestcase.of(t -> t.subarraysWithKDistinct(new int[]{1, 2, 1, 2, 3}, 2), 7))
                .add(ExpectedTestcase.of(t -> t.subarraysWithKDistinct(new int[]{1, 2, 1, 3, 4}, 3), 3))
                .add(ExpectedTestcase.of(t -> t.subarraysWithKDistinct(new int[]{1, 1, 2, 2, 3, 3}, 3), 4))
                .add(ExpectedTestcase.of(t -> t.subarraysWithKDistinct(new int[]{1, 1, 3, 3, 2, 2, 3, 3}, 3), 8))
                .add(ExpectedTestcase.of(t -> t.subarraysWithKDistinct(new int[]{1, 1, 3, 3, 2, 2, 1, 3, 3}, 3), 2 * 5 + 2 * 3 + 2 * 2))
                .add(ExpectedTestcase.of(t -> t.subarraysWithKDistinct(new int[]{1, 1, 3, 3, 1, 1, 2, 2, 1, 3, 3}, 3), 2 * 5 + 2 * 5 + 2 * 2 + 2 * 2))
                .add(ExpectedTestcase.of(t -> t.subarraysWithKDistinct(new int[]{1, 1, 1, 1, 1}, 1), (5 + 1) * 5 / 2))
                .add(ExpectedTestcase.of(t -> t.subarraysWithKDistinct(new int[]{
                                48, 18, 15, 17, 35, 33, 3, 22, 14, 52,
                                18, 32, 45, 33, 39, 7, 52, 2, 4, 22,
                                13, 41, 4, 29, 3, 7, 34, 31, 4, 49,
                                3, 8, 20, 42, 12, 11, 35, 42, 3, 21,
                                27, 29, 37, 21, 40, 50, 22, 7, 2, 32,
                                1, 1, 22, 33, 19, 52, 38, 34, 36, 48,
                                40, 28, 47, 8, 7, 46, 17, 7, 2, 21,
                                49, 6, 7, 50, 15, 31, 50, 52, 1, 27,
                                3, 15, 5, 6, 23, 26, 34, 50, 15, 22,
                                26, 39, 28, 25, 25, 21, 37, 28, 45},
                        30), 135))
                .add(ExpectedTestcase.of(t -> t.subarraysWithKDistinct(new int[]{
                                3, 6, 4, 2, 2, 1, 5, 4, 7},
                        5), 6))
                .build();
    }
}