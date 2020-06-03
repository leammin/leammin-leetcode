package com.leammin.leetcode.medium;

import com.leammin.leetcode.util.AbstractTest;
import com.leammin.leetcode.util.ExpectedTestcase;
import com.leammin.leetcode.util.Testsuite;

/**
 * @author Leammin
 * @date 2020-06-02
 */
class DailyTemperaturesTest extends AbstractTest<DailyTemperatures> {
    @Override
    protected Testsuite<DailyTemperatures> testsuite() {
        return Testsuite.<DailyTemperatures>builder()
                .add(ExpectedTestcase.of(t -> t.dailyTemperatures(new int[]{73, 74, 75, 71, 69, 72, 76, 73}), new int[]{1, 1, 4, 2, 1, 1, 0, 0}))
                .build();
    }

}