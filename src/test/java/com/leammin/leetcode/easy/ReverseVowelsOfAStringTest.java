package com.leammin.leetcode.easy;

import com.leammin.leetcode.util.AbstractTest;
import com.leammin.leetcode.util.ExpectedTestcase;
import com.leammin.leetcode.util.Testsuite;

/**
 * @author Leammin
 * @date 2021-03-31
 */
class ReverseVowelsOfAStringTest extends AbstractTest<ReverseVowelsOfAString> {
    @Override
    protected Testsuite<ReverseVowelsOfAString> testsuite() {
        return Testsuite.<ReverseVowelsOfAString>builder()
                .add(ExpectedTestcase.of(t -> t.reverseVowels("hello"), "holle"))
                .add(ExpectedTestcase.of(t -> t.reverseVowels("leetcode"), "leotcede"))
                .build();
    }
}