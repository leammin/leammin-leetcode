package com.leammin.leetcode.medium;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

import com.leammin.leetcode.util.test.AbstractTest;
import com.leammin.leetcode.util.test.Testsuite;

/**
 * 451. 根据字符出现频率排序
 * 
 * <p>给定一个字符串，请将字符串里的字符按照出现的频率降序排列。</p>
 * 
 * <p><strong>示例 1:</strong></p>
 * 
 * <pre>
 * <strong>输入:</strong>
 * &quot;tree&quot;
 * 
 * <strong>输出:</strong>
 * &quot;eert&quot;
 * 
 * <strong>解释:
 * </strong>&#39;e&#39;出现两次，&#39;r&#39;和&#39;t&#39;都只出现一次。
 * 因此&#39;e&#39;必须出现在&#39;r&#39;和&#39;t&#39;之前。此外，&quot;eetr&quot;也是一个有效的答案。
 * </pre>
 * 
 * <p><strong>示例 2:</strong></p>
 * 
 * <pre>
 * <strong>输入:</strong>
 * &quot;cccaaa&quot;
 * 
 * <strong>输出:</strong>
 * &quot;cccaaa&quot;
 * 
 * <strong>解释:
 * </strong>&#39;c&#39;和&#39;a&#39;都出现三次。此外，&quot;aaaccc&quot;也是有效的答案。
 * 注意&quot;cacaca&quot;是不正确的，因为相同的字母必须放在一起。
 * </pre>
 * 
 * <p><strong>示例 3:</strong></p>
 * 
 * <pre>
 * <strong>输入:</strong>
 * &quot;Aabb&quot;
 * 
 * <strong>输出:</strong>
 * &quot;bbAa&quot;
 * 
 * <strong>解释:
 * </strong>此外，&quot;bbaA&quot;也是一个有效的答案，但&quot;Aabb&quot;是不正确的。
 * 注意&#39;A&#39;和&#39;a&#39;被认为是两种不同的字符。
 * </pre>
 * 
 * 
 * @author Leammin
 * @date 2021-04-01
 */
public interface SortCharactersByFrequency {
    String frequencySort(String s);

    static Testsuite<SortCharactersByFrequency> testsuite() {
        return Testsuite.<SortCharactersByFrequency>builder()
                .addExpected(t -> t.frequencySort("baaccc"), "cccaab")
                .build();
    }


    class Solution implements SortCharactersByFrequency {

        @Override
        public String frequencySort(String s) {
            Map<Character, Integer> count = new HashMap<>();
            for (int i = 0; i < s.length(); i++) {
                count.compute(s.charAt(i), (k, v) -> v == null ? 1 : (v + 1));
            }
            ArrayList<Map.Entry<Character, Integer>> entries = new ArrayList<>(count.entrySet());
            entries.sort(Comparator.comparingInt(e -> -e.getValue()));
            char[] res = new char[s.length()];
            int i = 0;
            for (Map.Entry<Character, Integer> entry : entries) {
                char key = entry.getKey();
                int value = entry.getValue();
                for (int j = 0; j < value; j++) {
                    res[i++] = key;
                }
            }
            return new String(res);
        }
    }
}

class SortCharactersByFrequencyTest extends AbstractTest<SortCharactersByFrequency> {
}
