package com.leammin.leetcode.medium;

import com.leammin.leetcode.util.AbstractTest;
import com.leammin.leetcode.util.test.ExpectedTestcase;
import com.leammin.leetcode.util.test.Testsuite;

/**
 * @author Leammin
 * @date 2019-09-04
 */
class GasStationTest extends AbstractTest<GasStation> {
    @Override
    protected Testsuite<GasStation> testsuite() {
        return Testsuite.<GasStation>builder()
                .add(ExpectedTestcase.of(t -> t.canCompleteCircuit(new int[]{1, 2, 3, 4, 5}, new int[]{3, 4, 5, 1, 2}), 3))
                .add(ExpectedTestcase.of(t -> t.canCompleteCircuit(new int[]{2, 3, 4}, new int[]{3, 4, 3}), -1))
                .build();
    }
}