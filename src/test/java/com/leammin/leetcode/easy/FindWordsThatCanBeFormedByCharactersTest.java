package com.leammin.leetcode.easy;

import com.leammin.leetcode.util.AbstractTest;
import com.leammin.leetcode.util.test.ExpectedTestcase;
import com.leammin.leetcode.util.test.Testsuite;

/**
 * @author Leammin
 * @date 2020-03-17
 */
class FindWordsThatCanBeFormedByCharactersTest extends AbstractTest<FindWordsThatCanBeFormedByCharacters> {
    @Override
    protected Testsuite<FindWordsThatCanBeFormedByCharacters> testsuite() {
        return Testsuite.<FindWordsThatCanBeFormedByCharacters>builder()
                .add(ExpectedTestcase.of(t -> t.countCharacters(new String[]{"cat", "bt", "hat", "tree"}, "atach"), 6))
                .add(ExpectedTestcase.of(t -> t.countCharacters(new String[]{"hello", "world", "leetcode"}, "welldonehoneyr"), 10))
                .build();
    }
}