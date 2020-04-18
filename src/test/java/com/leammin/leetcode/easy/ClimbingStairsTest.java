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
                .add(ExpectedTestcase.of(solution -> solution.climbStairs(2), 2))
                .add(ExpectedTestcase.of(solution -> solution.climbStairs(3), 3))
                .add(ExpectedTestcase.of(solution -> solution.climbStairs(45), 1836311903))
                .add(ExpectedTestcase.of(solution -> solution.climbStairs(40), 165580141))
                .build();
    }

}