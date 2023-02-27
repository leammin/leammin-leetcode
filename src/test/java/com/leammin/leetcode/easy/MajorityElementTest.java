package com.leammin.leetcode.easy;

import com.leammin.leetcode.util.AbstractTest;
import com.leammin.leetcode.util.test.ExpectedTestcase;
import com.leammin.leetcode.util.test.Testsuite;

/**
 * @author Leammin
 * @date 2020-03-13
 */
class MajorityElementTest extends AbstractTest<MajorityElement> {
    @Override
    protected Testsuite<MajorityElement> testsuite() {
        return Testsuite.<MajorityElement>builder()
                .add(ExpectedTestcase.of(t -> t.majorityElement(new int[]{3, 2, 3}), 3))
                .add(ExpectedTestcase.of(t -> t.majorityElement(new int[]{2,2,1,1,1,2,2}), 2))
                .build();
    }
}