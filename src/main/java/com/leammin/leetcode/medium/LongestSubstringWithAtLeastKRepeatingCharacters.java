package com.leammin.leetcode.medium;

import com.leammin.leetcode.util.test.AbstractTest;
import com.leammin.leetcode.util.test.ExpectedTestcase;
import com.leammin.leetcode.util.test.Testsuite;

/**
 * 395. 至少有K个重复字符的最长子串
 * 
 * <p>找到给定字符串（由小写字符组成）中的最长子串 <strong><em>T</em></strong> ，&nbsp;要求&nbsp;<strong><em>T</em></strong>&nbsp;中的每一字符出现次数都不少于 <em>k</em> 。输出 <strong><em>T&nbsp;</em></strong>的长度。</p>
 * 
 * <p><strong>示例 1:</strong></p>
 * 
 * <pre>
 * 输入:
 * s = &quot;aaabb&quot;, k = 3
 * 
 * 输出:
 * 3
 * 
 * 最长子串为 &quot;aaa&quot; ，其中 &#39;a&#39; 重复了 3 次。
 * </pre>
 * 
 * <p><strong>示例 2:</strong></p>
 * 
 * <pre>
 * 输入:
 * s = &quot;ababbc&quot;, k = 2
 * 
 * 输出:
 * 5
 * 
 * 最长子串为 &quot;ababb&quot; ，其中 &#39;a&#39; 重复了 2 次， &#39;b&#39; 重复了 3 次。
 * </pre>
 * 
 * 
 * @author Leammin
 * @date 2021-02-27
 */
public interface LongestSubstringWithAtLeastKRepeatingCharacters {
    int longestSubstring(String s, int k);

    static Testsuite<LongestSubstringWithAtLeastKRepeatingCharacters> testsuite() {
        return Testsuite.<LongestSubstringWithAtLeastKRepeatingCharacters>builder()
                .add(ExpectedTestcase.of(t -> t.longestSubstring("aaabb", 3), 3))
                .add(ExpectedTestcase.of(t -> t.longestSubstring("ababbc", 2), 5))
                .add(ExpectedTestcase.of(t -> t.longestSubstring("ayaayxaaaxccycc", 3), 3))
                .build();
    }


    class Solution implements LongestSubstringWithAtLeastKRepeatingCharacters {

        @Override
        public int longestSubstring(String s, int k) {
            int n = s.length();
            if (k <= 1) {
                return n;
            }
            char[] chars = s.toCharArray();
            if (splitChars(chars, 0, n, k)) {
                return n;
            }
            int max = 0;
            int l = 0;
            while (l < n) {
                int r = l;
                while (r < n && chars[r] > 0) {
                    r++;
                }
                if (r - l <= max) {
                    l = r + 1;
                } else {
                    if (splitChars(chars, l, r, k)) {
                        max = Math.max(max, r - l);
                    }
                }
            }
            return max;
        }

        private boolean splitChars(char[] chars, int l, int r, int k) {
            if (l == r) {
                return false;
            }
            int[] count = new int[26];
            for (int i = l; i < r; i++) {
                count[chars[i] - 'a']++;
            }
            boolean s = true;
            for (int i = l; i < r; i++) {
                if (count[chars[i] - 'a'] < k) {
                    chars[i] = 0;
                    s = false;
                }
            }
            return s;
        }
    }
}

class LongestSubstringWithAtLeastKRepeatingCharactersTest extends AbstractTest<LongestSubstringWithAtLeastKRepeatingCharacters> {
}
