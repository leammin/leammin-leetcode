package com.leammin.leetcode.easy;

import com.leammin.leetcode.util.AbstractTest;
import com.leammin.leetcode.util.ExpectedTestcase;
import com.leammin.leetcode.util.Testsuite;

/**
 * @author Leammin
 * @date 2019-04-20
 */
class ClimbingStairsTest extends AbstractTest<ClimbingStairs> {
    @Override
    protected Testsuite<ClimbingStairs> testsuite() {
        return Testsuite.<ClimbingStairs>builder()
                .add(ExpectedTestcase.of(2, solution -> solution.climbStairs(2)))
                .add(ExpectedTestcase.of(3, solution -> solution.climbStairs(3)))
                .add(ExpectedTestcase.of(1836311903, solution -> solution.climbStairs(45)))
                .add(ExpectedTestcase.of(165580141, solution -> solution.climbStairs(40)))
                .build();
    }

}