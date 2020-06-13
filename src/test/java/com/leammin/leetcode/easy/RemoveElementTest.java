package com.leammin.leetcode.easy;

import com.leammin.leetcode.util.AbstractTest;
import com.leammin.leetcode.util.ExpectedTestcase;
import com.leammin.leetcode.util.Testsuite;

/**
 * @author Leammin
 * @date 2020-06-13
 */
class RemoveElementTest extends AbstractTest<RemoveElement> {
    @Override
    protected Testsuite<RemoveElement> testsuite() {
        return Testsuite.<RemoveElement>builder()
                .add(ExpectedTestcase.of(t -> t.removeElement(new int[]{3,2,2,3}, 3), 2))
                .add(ExpectedTestcase.of(t -> t.removeElement(new int[]{0,1,2,2,3,0,4,2}, 2), 5))
                .build();
    }
}