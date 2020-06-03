package com.leammin.leetcode.easy;

import com.google.common.primitives.Booleans;
import com.leammin.leetcode.util.AbstractTest;
import com.leammin.leetcode.util.ExpectedTestcase;
import com.leammin.leetcode.util.Testsuite;

/**
 * @author Leammin
 * @date 2020-06-01
 */
class KidsWithTheGreatestNumberOfCandiesTest extends AbstractTest<KidsWithTheGreatestNumberOfCandies> {
    @Override
    protected Testsuite<KidsWithTheGreatestNumberOfCandies> testsuite() {
        return Testsuite.<KidsWithTheGreatestNumberOfCandies>builder()
                .add(ExpectedTestcase.of(t->t.kidsWithCandies(new int[]{2,3,5,1,3}, 3),
                        Booleans.asList(true,true,true,false,true)))
                .build();
    }
}