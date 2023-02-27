package com.leammin.leetcode.easy;

import com.leammin.leetcode.util.AbstractTest;
import com.leammin.leetcode.util.test.ExpectedTestcase;
import com.leammin.leetcode.util.test.Testsuite;

/**
 * @author Leammin
 * @date 2020-06-23
 */
class AddBinaryTest extends AbstractTest<AddBinary> {
    @Override
    protected Testsuite<AddBinary> testsuite() {
        return Testsuite.<AddBinary>builder()
                .add(ExpectedTestcase.of(t -> t.addBinary("11", "1"), "100"))
                .add(ExpectedTestcase.of(t -> t.addBinary("1010", "1011"), "10101"))
                .build();
    }

}