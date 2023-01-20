package com.leammin.leetcode.medium;

import com.leammin.leetcode.util.AbstractTest;
import com.leammin.leetcode.util.Testsuite;

/**
 * @author Leammin
 * @date 2023-01-20
 */
class SentenceSimilarityIiiTest extends AbstractTest<SentenceSimilarityIii> {
    @Override
    protected Testsuite<SentenceSimilarityIii> testsuite() {
        return Testsuite.<SentenceSimilarityIii>builder()
                .addExpected(t -> t.areSentencesSimilar("My name is Haley", "My Haley"), true)
                .addExpected(t -> t.areSentencesSimilar("of", "A lot of words"), false)
                .addExpected(t -> t.areSentencesSimilar("Eating right now", "Eating"), true)
                .addExpected(t -> t.areSentencesSimilar("Luky", "Lucccky"), false)
                .build();
    }
}