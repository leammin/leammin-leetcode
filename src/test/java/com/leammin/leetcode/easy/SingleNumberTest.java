package com.leammin.leetcode.easy;

import com.leammin.leetcode.util.AbstractTest;
import com.leammin.leetcode.util.ExpectedTestcase;
import com.leammin.leetcode.util.Testsuite;

/**
 * @author Leammin
 * @date 2020-05-14
 */
class SingleNumberTest extends AbstractTest<SingleNumber> {
    @Override
    protected Testsuite<SingleNumber> testsuite() {
        return Testsuite.<SingleNumber>builder()
                .add(ExpectedTestcase.of(t -> t.singleNumber(new int[]{2,2,1}), 1))
                .add(ExpectedTestcase.of(t -> t.singleNumber(new int[]{4,1,2,1,2}), 4))
                .build();
    }
}