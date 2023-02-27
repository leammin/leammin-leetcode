package com.leammin.leetcode.medium;

import com.leammin.leetcode.util.AbstractTest;
import com.leammin.leetcode.util.test.ExpectedTestcase;
import com.leammin.leetcode.util.test.Testsuite;

class PalindromicSubstringsTest extends AbstractTest<PalindromicSubstrings> {

    @Override
    protected Testsuite<PalindromicSubstrings> testsuite() {
        return Testsuite.<PalindromicSubstrings>builder()
                .add(ExpectedTestcase.of(s -> s.countSubstrings("abc"), 3))
                .add(ExpectedTestcase.of(s -> s.countSubstrings("aba"), 4))
                .add(ExpectedTestcase.of(s -> s.countSubstrings("cabac"), 7))
                .add(ExpectedTestcase.of(s -> s.countSubstrings("dcbad"), 5))
                .add(ExpectedTestcase.of(s -> s.countSubstrings("aaa"), 6))
                .add(ExpectedTestcase.of(s -> s.countSubstrings("cbbc"), 6))
                .add(ExpectedTestcase.of(s -> s.countSubstrings("bcbcb"), 9))
                .add(ExpectedTestcase.of(s -> s.countSubstrings("bcbcbbbcb"), 19))
                .add(ExpectedTestcase.of(s -> s.countSubstrings("aaaaa"), 15))
                .add(ExpectedTestcase.of(s -> s.countSubstrings("abcba"), 7))
                .add(ExpectedTestcase.of(s -> s.countSubstrings("fdsklf"), 6))
                .add(ExpectedTestcase.of(s -> s.countSubstrings("zabcccba"), 13))
                .add(ExpectedTestcase.of(s -> s.countSubstrings("zabccccba"), 17))
                .add(ExpectedTestcase.of(s -> s.countSubstrings("abcdddd"), 13))
                .add(ExpectedTestcase.of(s -> s.countSubstrings("bbccaacacdbdbcbcbbbcbadcbdddbabaddbcadb"), 64))
                .build();
    }
}