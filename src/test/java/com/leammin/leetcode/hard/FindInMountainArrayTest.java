package com.leammin.leetcode.hard;

import com.leammin.leetcode.util.AbstractTest;
import com.leammin.leetcode.util.test.ExpectedTestcase;
import com.leammin.leetcode.util.test.Testsuite;

/**
 * @author Leammin
 * @date 2020-04-29
 */
class FindInMountainArrayTest extends AbstractTest<FindInMountainArray> {
    @Override
    protected Testsuite<FindInMountainArray> testsuite() {
        return Testsuite.<FindInMountainArray>builder()
                .add(ExpectedTestcase.of(t -> t.findInMountainArray(3, new FindInMountainArray.MountainArray(1,2,3,4,5,3,1)), 2))
                .add(ExpectedTestcase.of(t -> t.findInMountainArray(3, new FindInMountainArray.MountainArray(0,1,2,4,2,1)), -1))
                .add(ExpectedTestcase.of(t -> t.findInMountainArray(1, new FindInMountainArray.MountainArray(1,5,2)), 0))
                .build();
    }
}