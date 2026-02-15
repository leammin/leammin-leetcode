package com.leammin.leetcode.hard;

import com.leammin.leetcode.util.test.AbstractTest;
import com.leammin.leetcode.util.test.ExpectedTestcase;
import com.leammin.leetcode.util.test.Testsuite;

/**
 * 76. 最小覆盖子串
 * 
 * <p>给你一个字符串 S、一个字符串 T，请在字符串 S 里面找出：包含 T 所有字母的最小子串。</p>
 * 
 * <p><strong>示例：</strong></p>
 * 
 * <pre><strong>输入: S</strong> = &quot;ADOBECODEBANC&quot;, <strong>T</strong> = &quot;ABC&quot;
 * <strong>输出:</strong> &quot;BANC&quot;</pre>
 * 
 * <p><strong>说明：</strong></p>
 * 
 * <ul>
 * 	<li>如果 S 中不存这样的子串，则返回空字符串 <code>&quot;&quot;</code>。</li>
 * 	<li>如果 S 中存在这样的子串，我们保证它是唯一的答案。</li>
 * </ul>
 * 
 * 
 * @author Leammin
 * @date 2020-05-24
 */
public interface MinimumWindowSubstring {
    String minWindow(String s, String t);

    static Testsuite<MinimumWindowSubstring> testsuite() {
        return Testsuite.<MinimumWindowSubstring>builder()
                .add(ExpectedTestcase.of(t -> t.minWindow("ADOBECODEBANC", "ABC"), "BANC"))
                .build();
    }


    class Solution implements MinimumWindowSubstring {

        @Override
        public String minWindow(String s, String t) {
            if (t == null || t.isEmpty()) {
                return "";
            }
            int[] tc = new int[52];
            for (int i = 0; i < t.length(); i++) {
                tc[getIndex(t.charAt(i))]++;
            }
            int resFrom = 0;
            int resTo = Integer.MAX_VALUE;
            int[] sc = new int[52];
            int x = t.length();
            for (int l = 0, r = 0; r < s.length(); r++) {
                int ri = getIndex(s.charAt(r));
                if (sc[ri] < tc[ri]) {
                    x--;
                }
                sc[ri]++;
                while (x == 0) {
                    if (r - l + 1 < resTo - resFrom) {
                        resFrom = l;
                        resTo = r + 1;
                    }
                    int li = getIndex(s.charAt(l));
                    sc[li]--;
                    if (sc[li] < tc[li]) {
                        x++;
                    }
                    l++;
                }
            }
            return resTo == Integer.MAX_VALUE ? "" : s.substring(resFrom, resTo);
        }

        private int getIndex(char c) {
            return c >= 'a' && c <= 'z' ? c - 'a' : c - 'A' + 26;
        }
    }
}

class MinimumWindowSubstringTest extends AbstractTest<MinimumWindowSubstring> {
}
