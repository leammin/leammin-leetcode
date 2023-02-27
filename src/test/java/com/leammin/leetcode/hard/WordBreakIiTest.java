package com.leammin.leetcode.hard;

import com.leammin.leetcode.undone.hard.WordBreakIi;
import com.leammin.leetcode.util.AbstractTest;
import com.leammin.leetcode.util.test.Testsuite;
import com.leammin.leetcode.util.test.VerifiableTestcase;
import org.assertj.core.api.Assertions;

import java.util.Arrays;

/**
 * @author Leammin
 * @date 2020-11-01
 */
class WordBreakIiTest extends AbstractTest<WordBreakIi> {
    @Override
    protected Testsuite<WordBreakIi> testsuite() {
        return Testsuite.<WordBreakIi>builder()
                .add(VerifiableTestcase.ofConsumer(t -> t.wordBreak("catsanddog", Arrays.asList("cat", "cats", "and", "sand", "dog")),
                        r -> Assertions.assertThat(r).containsExactlyInAnyOrder("cats and dog", "cat sand dog")))
                .add(VerifiableTestcase.ofConsumer(t -> t.wordBreak("pineapplepenapple", Arrays.asList("apple", "pen", "applepen", "pine", "pineapple")),
                        r -> Assertions.assertThat(r).containsExactlyInAnyOrder(
                                "pine apple pen apple",
                                "pineapple pen apple",
                                "pine applepen apple")))
                .add(VerifiableTestcase.ofConsumer(t -> t.wordBreak("catsandog", Arrays.asList("cats", "dog", "sand", "and", "cat")),
                        r -> Assertions.assertThat(r).isEmpty()))
                .add(VerifiableTestcase.ofConsumer(t -> t.wordBreak("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa",
                        Arrays.asList("a", "aa", "aaa", "aaaa", "aaaaa", "aaaaaa", "aaaaaaa", "aaaaaaaa", "aaaaaaaaa", "aaaaaaaaaa")),
                        r -> Assertions.assertThat(r).isEmpty()))
                .build();
    }
}