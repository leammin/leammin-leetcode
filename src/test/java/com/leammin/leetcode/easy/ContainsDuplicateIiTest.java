package com.leammin.leetcode.easy;

import com.leammin.leetcode.util.AbstractTest;
import com.leammin.leetcode.util.ExpectedTestcase;
import com.leammin.leetcode.util.Testsuite;

/**
 * @author Leammin
 * @date 2020-06-28
 */
class ContainsDuplicateIiTest extends AbstractTest<ContainsDuplicateIi> {
    @Override
    protected Testsuite<ContainsDuplicateIi> testsuite() {
        return Testsuite.<ContainsDuplicateIi>builder()
                .add(ExpectedTestcase.of(t -> t.containsNearbyDuplicate(new int[]{1,2,3,1}, 3), true))
                .add(ExpectedTestcase.of(t -> t.containsNearbyDuplicate(new int[]{1,0,1,1}, 1), true))
                .add(ExpectedTestcase.of(t -> t.containsNearbyDuplicate(new int[]{1,2,3,1,2,3}, 2), false))
                .build();
    }
}