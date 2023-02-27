package com.leammin.leetcode.medium;

import com.leammin.leetcode.util.AbstractTest;
import com.leammin.leetcode.util.test.ExpectedTestcase;
import com.leammin.leetcode.util.test.Testsuite;

/**
 * @author Leammin
 * @date 2019-08-25
 */
class MultiplyStringsTest extends AbstractTest<MultiplyStrings> {
    @Override
    protected Testsuite<MultiplyStrings> testsuite() {
        return Testsuite.<MultiplyStrings>builder()
                .add(ExpectedTestcase.of(t -> t.multiply("0", "3135"), "0"))
                .add(ExpectedTestcase.of(t -> t.multiply("13561", "3135"), "42513735"))
                .add(ExpectedTestcase.of(t -> t.multiply("216531635165", "13513513513"), "2926103177794213484645"))
                .add(ExpectedTestcase.of(t -> t.multiply("16531635131313546854683165498616143116", "949841368643513165413135461331684686164646131351354"), "15702430939042043834190930974151226312091301977204979233603507711721704324792460544379064"
                ))
                .build();
    }
}