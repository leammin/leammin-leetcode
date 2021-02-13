package com.leammin.leetcode.easy;

import com.leammin.leetcode.util.AbstractTest;
import com.leammin.leetcode.util.ExpectedTestcase;
import com.leammin.leetcode.util.Testsuite;

import java.util.List;

/**
 * @author Leammin
 * @date 2021-02-13
 */
class FindAllNumbersDisappearedInAnArrayTest extends AbstractTest<FindAllNumbersDisappearedInAnArray> {
    @Override
    protected Testsuite<FindAllNumbersDisappearedInAnArray> testsuite() {
        return Testsuite.<FindAllNumbersDisappearedInAnArray>builder()
                .add(ExpectedTestcase.of(t -> t.findDisappearedNumbers(new int[]{4, 3, 2, 7, 8, 2, 3, 1}), List.of(5, 6)))
                .build();
    }
}