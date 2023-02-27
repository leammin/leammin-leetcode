package com.leammin.leetcode.medium;

import com.leammin.leetcode.util.AbstractTest;
import com.leammin.leetcode.util.test.Testsuite;

/**
 * @author Leammin
 * @date 2021-04-04
 */
class FindingTheUsersActiveMinutesTest extends AbstractTest<FindingTheUsersActiveMinutes> {
    @Override
    protected Testsuite<FindingTheUsersActiveMinutes> testsuite() {
        return Testsuite.<FindingTheUsersActiveMinutes>builder()
                .addExpected(t -> t.findingUsersActiveMinutes(new int[][]{{0,5},{1,2},{0,2},{0,5},{1,3}}, 5), new int[]{0,2,0,0,0})
                .addExpected(t -> t.findingUsersActiveMinutes(new int[][]{{1,1},{2,2},{2,3}}, 4), new int[]{1,1,0,0})
                .build();
    }
}