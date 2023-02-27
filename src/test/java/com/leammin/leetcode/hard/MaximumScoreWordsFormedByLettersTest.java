package com.leammin.leetcode.hard;

import com.leammin.leetcode.util.AbstractTest;
import com.leammin.leetcode.util.Testsuite;

/**
 * @author Leammin
 * @date 2023-02-26
 */
class MaximumScoreWordsFormedByLettersTest extends AbstractTest<MaximumScoreWordsFormedByLetters> {
    @Override
    protected Testsuite<MaximumScoreWordsFormedByLetters> testsuite() {
        return Testsuite.<MaximumScoreWordsFormedByLetters>builder()
                .addExpected(t -> t.maxScoreWords(new String[]{"dog","cat","dad","good"}, new char[]{'a','a','c','d','d','d','g','o','o'}, new int[]{1,0,9,5,0,0,3,0,0,0,0,0,0,0,2,0,0,0,0,0,0,0,0,0,0,0}), 23)
                .addExpected(t -> t.maxScoreWords(new String[]{"xxxz","ax","bx","cx"}, new char[]{'z','a','b','c','x','x','x'}, new int[]{4,4,4,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,5,0,1}), 27)
                .addExpected(t -> t.maxScoreWords(new String[]{"leetcode"}, new char[]{'l','e','t','c','o','d'}, new int[]{0,0,1,1,1,0,0,0,0,0,0,1,0,0,1,0,0,0,0,1,0,0,0,0,0,0}), 0)
                .build();
    }
}