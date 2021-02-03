package com.leammin.leetcode.medium;

/**
 * 424. 替换后的最长重复字符
 *
 * <p>给你一个仅由大写英文字母组成的字符串，你可以将任意位置上的字符替换成另外的字符，总共可最多替换&nbsp;<em>k&nbsp;</em>次。在执行上述操作后，找到包含重复字母的最长子串的长度。</p>
 *
 * <p><strong>注意:</strong><br>
 * 字符串长度 和 <em>k </em>不会超过&nbsp;10<sup>4</sup>。</p>
 *
 * <p><strong>示例 1:</strong></p>
 *
 * <pre><strong>输入:</strong>
 * s = &quot;ABAB&quot;, k = 2
 *
 * <strong>输出:</strong>
 * 4
 *
 * <strong>解释:</strong>
 * 用两个&#39;A&#39;替换为两个&#39;B&#39;,反之亦然。
 * </pre>
 *
 * <p><strong>示例 2:</strong></p>
 *
 * <pre><strong>输入:</strong>
 * s = &quot;AABABBA&quot;, k = 1
 *
 * <strong>输出:</strong>
 * 4
 *
 * <strong>解释:</strong>
 * 将中间的一个&#39;A&#39;替换为&#39;B&#39;,字符串变为 &quot;AABBBBA&quot;。
 * 子串 &quot;BBBB&quot; 有最长重复字母, 答案为 4。
 * </pre>
 *
 *
 * @author Leammin
 * @date 2021-02-02
 */
public interface LongestRepeatingCharacterReplacement {
    int characterReplacement(String s, int k);

    class Solution implements LongestRepeatingCharacterReplacement {

        @Override
        public int characterReplacement(String s, int k) {
            int result = 0;
            for (int i = 0; i < 26; i++) {
                char c = (char) ('A' + i);
                int d = 0, h = 0, t = 0;
                while (t < s.length()) {
                    if (c != s.charAt(t)) {
                        if (d < k) {
                            d++;
                        } else {
                            while (c == s.charAt(h++)) {
                            }
                        }
                    }
                    t++;
                    result = Math.max(result, t - h);
                }
            }
            return result;
        }
    }

    class Solution2 implements LongestRepeatingCharacterReplacement {

        @Override
        public int characterReplacement(String s, int k) {
            int[] num = new int[26];
            int m = 0, l = 0, r = 0;
            while (r < s.length()) {
                int ri = s.charAt(r) - 'A';
                num[ri]++;
                m = Math.max(m, num[ri]);
                if (r - l + 1 - m > k) {
                    num[s.charAt(l) - 'A']--;
                    l++;
                }
                r++;
            }
            return r - l;
        }
    }
}
