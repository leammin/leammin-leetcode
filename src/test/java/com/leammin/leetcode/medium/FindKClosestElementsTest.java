package com.leammin.leetcode.medium;

import com.leammin.leetcode.util.AbstractTest;
import com.leammin.leetcode.util.test.ExpectedTestcase;
import com.leammin.leetcode.util.test.Testsuite;

import java.util.List;

/**
 * @author Leammin
 * @date 2020-06-18
 */
class FindKClosestElementsTest extends AbstractTest<FindKClosestElements> {
    @Override
    protected Testsuite<FindKClosestElements> testsuite() {
        return Testsuite.<FindKClosestElements>builder()
                .add(ExpectedTestcase.of(t -> t.findClosestElements(new int[]{1, 2, 3, 4, 5}, 4, 3), List.of(1, 2, 3, 4)))
                .add(ExpectedTestcase.of(t -> t.findClosestElements(new int[]{1, 2, 3, 4, 5}, 4, -1), List.of(1, 2, 3, 4)))
                .add(ExpectedTestcase.of(t -> t.findClosestElements(new int[]{1,2,5,6}, 1, 4), List.of(5)))
                .add(ExpectedTestcase.of(t -> t.findClosestElements(new int[]{1,2,5,6}, 1, 3), List.of(2)))
                .build();
    }
}