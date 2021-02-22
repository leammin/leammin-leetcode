package com.leammin.leetcode.medium;

import com.leammin.leetcode.undone.medium.GrayCode;
import com.leammin.leetcode.util.AbstractTest;
import com.leammin.leetcode.util.ExpectedTestcase;
import com.leammin.leetcode.util.Testsuite;

import java.util.List;

/**
 * @author Leammin
 * @date 2021-02-19
 */
class GrayCodeTest extends AbstractTest<GrayCode> {
    @Override
    protected Testsuite<GrayCode> testsuite() {
        return Testsuite.<GrayCode>builder()
                .add(ExpectedTestcase.of(t -> t.grayCode(2), List.of(0, 1, 3, 2)))
                .add(ExpectedTestcase.of(t -> t.grayCode(3), List.of(0, 1, 3, 2, 6, 7, 5, 4)))
                .build();
    }
}