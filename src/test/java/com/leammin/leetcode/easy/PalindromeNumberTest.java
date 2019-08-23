package com.leammin.leetcode.easy;

import com.leammin.leetcode.util.AbstractTest;
import com.leammin.leetcode.util.ExpectedTestcase;
import com.leammin.leetcode.util.Testsuite;

/**
 * @author Leammin
 * @date 2019-08-23
 */
class PalindromeNumberTest extends AbstractTest<PalindromeNumber> {
    @Override
    protected Testsuite<PalindromeNumber> testsuite() {
        return Testsuite.<PalindromeNumber>builder()
                .add(ExpectedTestcase.of(true, t-> t.isPalindrome(101)))
                .add(ExpectedTestcase.of(true, t-> t.isPalindrome(1)))
                .add(ExpectedTestcase.of(false, t-> t.isPalindrome(10)))
                .add(ExpectedTestcase.of(true, t-> t.isPalindrome(1122332211)))
                .add(ExpectedTestcase.of(false, t-> t.isPalindrome(-121)))
                .add(ExpectedTestcase.of(false, t-> t.isPalindrome(-1)))
                .build();
    }
}