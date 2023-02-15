package com.leammin.leetcode.medium;

import com.leammin.leetcode.util.AbstractTest;
import com.leammin.leetcode.util.Testsuite;

/**
 * @author Leammin
 * @date 2023-02-12
 */
class AlphabetBoardPathTest extends AbstractTest<AlphabetBoardPath> {
    @Override
    protected Testsuite<AlphabetBoardPath> testsuite() {
        return Testsuite.<AlphabetBoardPath>builder()
                .addExpected(t -> t.alphabetBoardPath("leet"), "DDR!UURRR!!DDD!")
                .addExpected(t -> t.alphabetBoardPath("code"), "RR!DDRR!UUL!R!")
                .addExpected(t -> t.alphabetBoardPath("zb"), "DDDDD!UUUUUR!")
                .build();
    }
}