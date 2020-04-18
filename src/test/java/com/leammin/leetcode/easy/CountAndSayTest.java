package com.leammin.leetcode.easy;

import com.leammin.leetcode.util.AbstractTest;
import com.leammin.leetcode.util.ExpectedTestcase;
import com.leammin.leetcode.util.Testsuite;

/**
 * @author Leammin
 * @date 2019-08-22
 */
class CountAndSayTest extends AbstractTest<CountAndSay> {
    @Override
    protected Testsuite<CountAndSay> testsuite() {
        return Testsuite.<CountAndSay>builder()
                .add(ExpectedTestcase.of(t->t.countAndSay(1), "1"))
                .add(ExpectedTestcase.of(t->t.countAndSay(2), "11"))
                .add(ExpectedTestcase.of(t->t.countAndSay(3), "21"))
                .add(ExpectedTestcase.of(t->t.countAndSay(4), "1211"))
                .add(ExpectedTestcase.of(t->t.countAndSay(5), "111221"))
                .build();
    }
}