package com.leammin.leetcode.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.leammin.leetcode.util.test.AbstractTest;
import com.leammin.leetcode.util.test.Testsuite;
import com.leammin.leetcode.util.test.VerifiableTestcase;
import java.util.HashSet;
import java.util.Set;

/**
 * 49. 字母异位词分组
 *
 * <div><p>给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。</p>
 *
 * <p><strong>示例:</strong></p>
 *
 * <pre><strong>输入:</strong> <code>["eat", "tea", "tan", "ate", "nat", "bat"]</code>,
 * <strong>输出:</strong>
 * [
 *   ["ate","eat","tea"],
 *   ["nat","tan"],
 *   ["bat"]
 * ]</pre>
 *
 * <p><strong>说明：</strong></p>
 *
 * <ul>
 * <li>所有输入均为小写字母。</li>
 * <li>不考虑答案输出的顺序。</li>
 * </ul>
 * </div>
 *
 * @author Leammin
 * @date 2018-10-21
 */
public interface GroupAnagrams {
    List<List<String>> groupAnagrams(String[] strs);

    static Testsuite<GroupAnagrams> testsuite() {
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


    class Solution implements GroupAnagrams {
        @Override
        public List<List<String>> groupAnagrams(String[] strs) {
            HashMap<Long, List<String>> map = new HashMap<>();
            for (String str : strs) {
                char[] chars = str.toCharArray();
                long sum = 0;
                long product = 1;
                for (char aChar : chars) {
                    sum += aChar;
                    product *= aChar;
                }
                map.compute(sum + product, (k, v) -> (v == null ? new ArrayList<>() : v)).add(str);
            }

            return new ArrayList<>(map.values());
        }
    }
}

class GroupAnagramsTest extends AbstractTest<GroupAnagrams> {
}
