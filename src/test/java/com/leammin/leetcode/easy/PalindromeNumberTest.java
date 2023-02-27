package com.leammin.leetcode.easy;

import com.leammin.leetcode.util.AbstractTest;
import com.leammin.leetcode.util.test.ExpectedTestcase;
import com.leammin.leetcode.util.test.Testsuite;

/**
 * @author Leammin
 * @date 2019-08-23
 */
class PalindromeNumberTest extends AbstractTest<PalindromeNumber> {
    @Override
    protected Testsuite<PalindromeNumber> testsuite() {
        return Testsuite.<PalindromeNumber>builder()
                .add(ExpectedTestcase.of(t-> t.isPalindrome(101), true))
                .add(ExpectedTestcase.of(t-> t.isPalindrome(1), true))
                .add(ExpectedTestcase.of(t-> t.isPalindrome(10), false))
                .add(ExpectedTestcase.of(t-> t.isPalindrome(1122332211), true))
                .add(ExpectedTestcase.of(t-> t.isPalindrome(-121), false))
                .add(ExpectedTestcase.of(t-> t.isPalindrome(-1), false))
                .build();
    }
}