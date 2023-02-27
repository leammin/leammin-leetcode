package com.leammin.leetcode.hard;

import com.leammin.leetcode.undone.hard.CountOfSmallerNumbersAfterSelf;
import com.leammin.leetcode.util.AbstractTest;
import com.leammin.leetcode.util.test.ExpectedTestcase;
import com.leammin.leetcode.util.test.Testsuite;

import java.util.Arrays;
import java.util.Collections;

/**
 * @author Leammin
 * @date 2020-07-11
 */
class CountOfSmallerNumbersAfterSelfTest extends AbstractTest<CountOfSmallerNumbersAfterSelf> {
    @Override
    protected Testsuite<CountOfSmallerNumbersAfterSelf> testsuite() {
        return Testsuite.<CountOfSmallerNumbersAfterSelf>builder()
                .add(ExpectedTestcase.of(t -> t.countSmaller(new int[]{5, 2, 6, 1}), Arrays.asList(2, 1, 1, 0)))
                .add(ExpectedTestcase.of(t -> t.countSmaller(new int[]{}), Collections.emptyList()))
                .add(ExpectedTestcase.of(t -> t.countSmaller(new int[]{26, 78, 27, 100, 33, 67, 90, 23, 66, 5, 38, 7, 35,
                        23, 52, 22, 83, 51, 98, 69, 81, 32, 78, 28, 94, 13, 2, 97, 3, 76, 99, 51, 9, 21, 84, 66, 65, 36,
                        100, 41}), Arrays.asList(10, 27, 10, 35, 12, 22, 28, 8, 19, 2, 12, 2, 9, 6, 12, 5, 17, 9, 19,
                        12, 14, 6, 12, 5, 12, 3, 0, 10, 0, 7, 8, 4, 0, 0, 4, 3, 2, 0, 1, 0)))
                .build();
    }
}