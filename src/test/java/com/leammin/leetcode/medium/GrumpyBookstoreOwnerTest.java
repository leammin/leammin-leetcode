package com.leammin.leetcode.medium;

import com.leammin.leetcode.util.AbstractTest;
import com.leammin.leetcode.util.test.ExpectedTestcase;
import com.leammin.leetcode.util.test.Testsuite;

/**
 * @author Leammin
 * @date 2021-02-23
 */
class GrumpyBookstoreOwnerTest extends AbstractTest<GrumpyBookstoreOwner> {
    @Override
    protected Testsuite<GrumpyBookstoreOwner> testsuite() {
        return Testsuite.<GrumpyBookstoreOwner>builder()
                .add(ExpectedTestcase.of(t -> t.maxSatisfied(new int[]{1,0,1,2,1,1,7,5}, new int[]{0,1,0,1,0,1,0,1}, 3), 16))
                .build();
    }
}