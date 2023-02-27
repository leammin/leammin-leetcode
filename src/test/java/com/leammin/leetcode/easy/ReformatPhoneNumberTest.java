package com.leammin.leetcode.easy;

import com.leammin.leetcode.util.AbstractTest;
import com.leammin.leetcode.util.test.Testsuite;

/**
 * @author Leammin
 * @date 2022-10-01
 */
class ReformatPhoneNumberTest extends AbstractTest<ReformatPhoneNumber> {
    @Override
    protected Testsuite<ReformatPhoneNumber> testsuite() {
        return Testsuite.<ReformatPhoneNumber>builder()
                .addExpected(t -> t.reformatNumber("1-23-45 6"), "123-456")
                .addExpected(t -> t.reformatNumber("123 4-567"), "123-45-67")
                .addExpected(t -> t.reformatNumber("123 4-5678"), "123-456-78")
                .build();
    }
}