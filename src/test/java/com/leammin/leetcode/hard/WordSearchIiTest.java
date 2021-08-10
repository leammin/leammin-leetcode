package com.leammin.leetcode.hard;

import com.leammin.leetcode.util.AbstractTest;
import com.leammin.leetcode.util.Testsuite;
import org.assertj.core.api.Assertions;

/**
 * @author Leammin
 * @date 2021-05-06
 */
class WordSearchIiTest extends AbstractTest<WordSearchIi> {
    @Override
    protected Testsuite<WordSearchIi> testsuite() {
        return Testsuite.<WordSearchIi>builder()
            .addConsumer(t -> t.findWords(
                new char[][] {{'o', 'a', 'a', 'n'}, {'e', 't', 'a', 'e'}, {'i', 'h', 'k', 'r'}, {'i', 'f', 'l', 'v'}},
                new String[] {"oath", "pea", "eat", "rain"}),
                out -> Assertions.assertThat(out).containsExactlyInAnyOrder("oath", "eat"))
            .build();
    }
}