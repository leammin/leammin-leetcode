package com.leammin.leetcode.medium;

import com.leammin.leetcode.util.AbstractTest;
import com.leammin.leetcode.util.ExpectedTestcase;
import com.leammin.leetcode.util.Testsuite;

class PalindromicSubstringsTest extends AbstractTest<PalindromicSubstrings> {

    @Override
    protected Testsuite<PalindromicSubstrings> testsuite() {
        return Testsuite.<PalindromicSubstrings>builder()
                .add(ExpectedTestcase.of(3, s -> s.countSubstrings("abc")))
                .add(ExpectedTestcase.of(4, s -> s.countSubstrings("aba")))
                .add(ExpectedTestcase.of(7, s -> s.countSubstrings("cabac")))
                .add(ExpectedTestcase.of(5, s -> s.countSubstrings("dcbad")))
                .add(ExpectedTestcase.of(6, s -> s.countSubstrings("aaa")))
                .add(ExpectedTestcase.of(6, s -> s.countSubstrings("cbbc")))
                .add(ExpectedTestcase.of(9, s -> s.countSubstrings("bcbcb")))
                .add(ExpectedTestcase.of(19, s -> s.countSubstrings("bcbcbbbcb")))
                .add(ExpectedTestcase.of(15, s -> s.countSubstrings("aaaaa")))
                .add(ExpectedTestcase.of(7, s -> s.countSubstrings("abcba")))
                .add(ExpectedTestcase.of(6, s -> s.countSubstrings("fdsklf")))
                .add(ExpectedTestcase.of(13, s -> s.countSubstrings("zabcccba")))
                .add(ExpectedTestcase.of(17, s -> s.countSubstrings("zabccccba")))
                .add(ExpectedTestcase.of(13, s -> s.countSubstrings("abcdddd")))
                .add(ExpectedTestcase.of(64, s -> s.countSubstrings("bbccaacacdbdbcbcbbbcbadcbdddbabaddbcadb")))
                .build();
    }
}