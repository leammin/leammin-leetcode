package com.leammin.leetcode.medium;

import com.leammin.leetcode.util.AbstractTest;
import com.leammin.leetcode.util.ExpectedTestcase;
import com.leammin.leetcode.util.Testsuite;

/**
 * @author Leammin
 * @date 2020-06-01
 */
class OpenTheLockTest extends AbstractTest<OpenTheLock> {
    @Override
    protected Testsuite<OpenTheLock> testsuite() {
        return Testsuite.<OpenTheLock>builder()
                .add(ExpectedTestcase.of(t -> t.openLock(new String[]{"0201","0101","0102","1212","2002"}, "0202"), 6))
                .add(ExpectedTestcase.of(t -> t.openLock(new String[]{"8888"}, "0009"), 1))
                .add(ExpectedTestcase.of(t -> t.openLock(new String[]{"8887","8889","8878","8898","8788","8988","7888","9888"}, "8888"), -1))
                .add(ExpectedTestcase.of(t -> t.openLock(new String[]{"0000"}, "8888"), -1))
                .build();
    }
}