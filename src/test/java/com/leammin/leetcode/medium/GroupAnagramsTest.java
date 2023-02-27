package com.leammin.leetcode.medium;

import com.leammin.leetcode.util.AbstractTest;
import com.leammin.leetcode.util.test.Testsuite;
import com.leammin.leetcode.util.test.VerifiableTestcase;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Leammin
 * @date 2020-06-28
 */
class GroupAnagramsTest extends AbstractTest<GroupAnagrams> {
    @Override
    protected Testsuite<GroupAnagrams> testsuite() {
        return Testsuite.<GroupAnagrams>builder()
                .add(VerifiableTestcase.of(t -> t.groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}), r -> {
                    Set<Set<String>> exp = new HashSet<>();
                    exp.add(Set.of("ate", "eat", "tea"));
                    exp.add(Set.of("nat", "tan"));
                    exp.add(Set.of("bat"));
                    for (List<String> l : r) {
                        if (!exp.remove(Set.copyOf(l))) {
                            return false;
                        }
                    }
                    return exp.isEmpty();
                }))
                .build();
    }
}