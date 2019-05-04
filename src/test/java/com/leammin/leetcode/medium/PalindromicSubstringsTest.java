package com.leammin.leetcode.medium;

import com.leammin.leetcode.undone.medium.PalindromicSubstrings;
import com.leammin.leetcode.util.AbstractTest;
import com.leammin.leetcode.util.ExpectedTestcase;
import com.leammin.leetcode.util.Testsuite;
import org.junit.jupiter.api.Test;

class PalindromicSubstringsTest extends AbstractTest<PalindromicSubstrings> {

    @Override
    protected Testsuite<PalindromicSubstrings> testsuite() {

        // bcbabcba
        // bcbabcba
        // bcbabcb

        // zabcccba
        // zabccc
        //

        // zabccccba

        // aaa
        //
        // aa
        return Testsuite.<PalindromicSubstrings>builder()
                .add(ExpectedTestcase.of(3, s -> s.countSubstrings("abc")))
                .add(ExpectedTestcase.of(19, s -> s.countSubstrings("bcbcbbbcb")))
                .add(ExpectedTestcase.of(9, s -> s.countSubstrings("bcbcb")))
                .add(ExpectedTestcase.of(15, s -> s.countSubstrings("aaaaa")))
                .add(ExpectedTestcase.of(7, s -> s.countSubstrings("abcba")))
                .add(ExpectedTestcase.of(6, s -> s.countSubstrings("aaa")))
                .add(ExpectedTestcase.of(6, s -> s.countSubstrings("fdsklf")))
                .add(ExpectedTestcase.of(13, s -> s.countSubstrings("zabcccba")))
                .add(ExpectedTestcase.of(17, s -> s.countSubstrings("zabccccba")))
                .add(ExpectedTestcase.of(13, s -> s.countSubstrings("abcdddd")))
                .add(ExpectedTestcase.of(64, s -> s.countSubstrings("bbccaacacdbdbcbcbbbcbadcbdddbabaddbcadb")))
                .build();
    }

    @Test
    void solution() {
//        PalindromicSubstrings.Solution solution = new PalindromicSubstrings.Solution();
//        System.out.println(solution.countSubstrings("aaa"));
    }
}