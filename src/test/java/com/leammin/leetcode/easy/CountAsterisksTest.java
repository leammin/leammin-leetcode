package com.leammin.leetcode.easy;

import com.leammin.leetcode.util.AbstractTest;
import com.leammin.leetcode.util.Testsuite;

/**
 * @author Leammin
 * @date 2023-01-29
 */
class CountAsterisksTest extends AbstractTest<CountAsterisks> {
    @Override
    protected Testsuite<CountAsterisks> testsuite() {
        return Testsuite.<CountAsterisks>builder()
                .addExpected(t -> t.countAsterisks("l|*e*et|c**o|*de|"), 2)
                .addExpected(t -> t.countAsterisks("iamprogrammer"), 0)
                .addExpected(t -> t.countAsterisks("yo|uar|e**|b|e***au|tifu|l"), 5)
                .build();
    }
}