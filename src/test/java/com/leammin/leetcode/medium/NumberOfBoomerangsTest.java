package com.leammin.leetcode.medium;

import com.leammin.leetcode.util.AbstractTest;
import com.leammin.leetcode.util.Testsuite;

/**
 * @author Leammin
 * @date 2021-04-01
 */
class NumberOfBoomerangsTest extends AbstractTest<NumberOfBoomerangs> {
    @Override
    protected Testsuite<NumberOfBoomerangs> testsuite() {
        return Testsuite.<NumberOfBoomerangs>builder()
                .addExpected(t -> t.numberOfBoomerangs(new int[][]{{0,0},{1,0},{2,0}}), 2)
                .addExpected(t -> t.numberOfBoomerangs(new int[][]{{1,1},{2,2},{3,3}}), 2)
                .addExpected(t -> t.numberOfBoomerangs(new int[][]{{1,1}}), 0)
                .build();
    }
}