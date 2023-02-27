package com.leammin.leetcode.easy;

import com.leammin.leetcode.util.AbstractTest;
import com.leammin.leetcode.util.test.Testsuite;

/**
 * @author Leammin
 * @date 2021-05-06
 */
class DecodeXoredArrayTest extends AbstractTest<DecodeXoredArray> {
    @Override
    protected Testsuite<DecodeXoredArray> testsuite() {
        return Testsuite.<DecodeXoredArray>builder()
            .addExpected(t -> t.decode(new int[] {1, 2, 3}, 1), new int[] {1, 0, 2, 1})
            .addExpected(t -> t.decode(new int[] {6, 2, 7, 3}, 4), new int[] {4, 2, 0, 7, 4})
            .build();
    }
}