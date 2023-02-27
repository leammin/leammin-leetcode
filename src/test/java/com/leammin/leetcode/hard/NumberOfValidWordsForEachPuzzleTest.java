package com.leammin.leetcode.hard;

import com.leammin.leetcode.util.AbstractTest;
import com.leammin.leetcode.util.test.ExpectedTestcase;
import com.leammin.leetcode.util.test.Testsuite;

import java.util.List;

/**
 * @author Leammin
 * @date 2021-02-26
 */
class NumberOfValidWordsForEachPuzzleTest extends AbstractTest<NumberOfValidWordsForEachPuzzle> {
    @Override
    protected Testsuite<NumberOfValidWordsForEachPuzzle> testsuite() {
        return Testsuite.<NumberOfValidWordsForEachPuzzle>builder()
                .add(ExpectedTestcase.of(t -> t.findNumOfValidWords(
                        new String[]{"aaaa", "asas", "able", "ability", "actt", "actor", "access"},
                        new String[]{"aboveyz", "abrodyz", "abslute", "absoryz", "actresz", "gaswxyz"}),
                        List.of(1, 1, 3, 2, 4, 0)))
                .add(ExpectedTestcase.of(t -> t.findNumOfValidWords(
                        new String[]{"apple", "pleas", "please"},
                        new String[]{"aelwxyz", "aelpxyz", "aelpsxy", "saelpxy", "xaelpsy"}),
                        List.of(0, 1, 3, 2, 0)))
                .add(ExpectedTestcase.of(t -> t.findNumOfValidWords(
                        new String[]{"kkaz", "kaaz", "aazk", "aaaz", "abcdefghijklmnopqrstuvwxyz", "kkka", "kkkz", "aaaa", "kkkk", "zzzz"},
                        new String[]{"kazxyuv"}),
                        List.of(6)))
                .build();
    }
}