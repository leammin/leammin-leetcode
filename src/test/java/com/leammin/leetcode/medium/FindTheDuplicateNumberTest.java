package com.leammin.leetcode.medium;

import com.leammin.leetcode.util.AbstractTest;
import com.leammin.leetcode.util.test.ExpectedTestcase;
import com.leammin.leetcode.util.test.Testsuite;

/**
 * @author Leammin
 * @date 2020-05-31
 */
class FindTheDuplicateNumberTest extends AbstractTest<FindTheDuplicateNumber> {
    @Override
    protected Testsuite<FindTheDuplicateNumber> testsuite() {
        return Testsuite.<FindTheDuplicateNumber>builder()
                .add(ExpectedTestcase.of(t -> t.findDuplicate(new int[]{1, 3, 4, 2, 2}), 2))
                .add(ExpectedTestcase.of(t -> t.findDuplicate(new int[]{3, 1, 3, 4, 2}), 3))
                .build();
    }
}