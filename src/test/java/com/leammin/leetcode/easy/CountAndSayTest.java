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
                .add(ExpectedTestcase.of("1", t->t.countAndSay(1)))
                .add(ExpectedTestcase.of("11", t->t.countAndSay(2)))
                .add(ExpectedTestcase.of("21", t->t.countAndSay(3)))
                .add(ExpectedTestcase.of("1211", t->t.countAndSay(4)))
                .add(ExpectedTestcase.of("111221", t->t.countAndSay(5)))
                .build();
    }
}