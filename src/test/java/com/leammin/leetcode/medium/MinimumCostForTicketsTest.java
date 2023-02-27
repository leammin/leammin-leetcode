package com.leammin.leetcode.medium;

import com.leammin.leetcode.util.AbstractTest;
import com.leammin.leetcode.util.test.ExpectedTestcase;
import com.leammin.leetcode.util.test.Testsuite;

/**
 * @author Leammin
 * @date 2020-05-07
 */
class MinimumCostForTicketsTest extends AbstractTest<MinimumCostForTickets> {
    @Override
    protected Testsuite<MinimumCostForTickets> testsuite() {
        return Testsuite.<MinimumCostForTickets>builder()
                .add(ExpectedTestcase.of(t ->t.mincostTickets(new int[]{1,4,6,7,8,20}, new int[]{2,7,15}), 11))
                .add(ExpectedTestcase.of(t ->t.mincostTickets(new int[]{1,2,3,4,5,6,7,8,9,10,30,31}, new int[]{2,7,15}), 17))
                .build();
    }
}