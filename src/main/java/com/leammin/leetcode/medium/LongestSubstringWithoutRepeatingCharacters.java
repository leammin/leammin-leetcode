package com.leammin.leetcode.medium;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import com.leammin.leetcode.util.test.AbstractTest;
import com.leammin.leetcode.util.test.ExpectedTestcase;
import com.leammin.leetcode.util.test.Testsuite;

/**
 * 3. 无重复字符的最长子串
 *
 * <p>给定一个字符串，请你找出其中不含有重复字符的&nbsp;<strong>最长子串&nbsp;</strong>的长度。</p>
 *
 * <p><strong>示例&nbsp;1:</strong></p>
 *
 * <pre><strong>输入: </strong>&quot;abcabcbb&quot;
 * <strong>输出: </strong>3
 * <strong>解释:</strong> 因为无重复字符的最长子串是 <code>&quot;abc&quot;，所以其</code>长度为 3。
 * </pre>
 *
 * <p><strong>示例 2:</strong></p>
 *
 * <pre><strong>输入: </strong>&quot;bbbbb&quot;
 * <strong>输出: </strong>1
 * <strong>解释: </strong>因为无重复字符的最长子串是 <code>&quot;b&quot;</code>，所以其长度为 1。
 * </pre>
 *
 * <p><strong>示例 3:</strong></p>
 *
 * <pre><strong>输入: </strong>&quot;pwwkew&quot;
 * <strong>输出: </strong>3
 * <strong>解释: </strong>因为无重复字符的最长子串是&nbsp;<code>&quot;wke&quot;</code>，所以其长度为 3。
 * &nbsp;    请注意，你的答案必须是 <strong>子串 </strong>的长度，<code>&quot;pwke&quot;</code>&nbsp;是一个<em>子序列，</em>不是子串。
 * </pre>
 *
 * @author Leammin
 * @date 2020-01-18
 */
public interface LongestSubstringWithoutRepeatingCharacters {
    int lengthOfLongestSubstring(String s);

    /**
     * 接近标准答案，但仍有缺陷
     * 可以将set和map结合起来，而且没必要删掉元素，直接通过map拿到下标，然后比较下标就ok了。
     */

    static Testsuite<LongestSubstringWithoutRepeatingCharacters> testsuite() {
        return Testsuite.<LongestSubstringWithoutRepeatingCharacters>builder()
                .add(ExpectedTestcase.of(s -> s.lengthOfLongestSubstring("abcabcbb"), 3))
                .add(ExpectedTestcase.of(s -> s.lengthOfLongestSubstring("bbbbb"), 1))
                .add(ExpectedTestcase.of(s -> s.lengthOfLongestSubstring("pwwkew"), 3))
                .add(ExpectedTestcase.of(s -> s.lengthOfLongestSubstring("umvejcuuk"), 6))
                .add(ExpectedTestcase.of(s -> s.lengthOfLongestSubstring(" "), 1))
                .build();
    }

    class Solution implements LongestSubstringWithoutRepeatingCharacters {

        @Override
        public int lengthOfLongestSubstring(String s) {
            char[] chars = s.toCharArray();
            Map<Character, Integer> lastIndexMap = new HashMap<>();
            Set<Character> set = new HashSet<>();
            int max = 0;
            int startIndex = 0;
            int index = 0;
            while (index < chars.length) {
                if (set.contains(chars[index])) {
                    if (set.size() > max) {
                        max = set.size();
                    }
                    int lastIndex = lastIndexMap.get(chars[index]);
                    if (chars.length - lastIndex - 1 <= max) {
                        return max;
                    }
                    for (int i = startIndex; i < lastIndex; i++) {
                        set.remove(chars[i]);
                    }
                    startIndex = lastIndex + 1;
                } else {
                    set.add(chars[index]);
                }
                lastIndexMap.put(chars[index], index);
                index++;
            }
            return Math.max(max, set.size());
        }
    }

    class Best implements LongestSubstringWithoutRepeatingCharacters {
        @Override
        public int lengthOfLongestSubstring(String s) {
            int[] indexMap = new int[128];
            int n = s.length();
            int max = 0;
            for (int i = 0, j = 0; j < n; j++) {
                char c = s.charAt(j);
                i = Math.max(i, indexMap[c]);
                max = Math.max(max, j - i + 1);
                indexMap[c] = j + 1;
            }
            return max;
        }
    }

}

class LongestSubstringWithoutRepeatingCharactersTest extends AbstractTest<LongestSubstringWithoutRepeatingCharacters> {
}
