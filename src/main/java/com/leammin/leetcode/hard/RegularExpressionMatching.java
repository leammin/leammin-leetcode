package com.leammin.leetcode.hard;

import com.leammin.leetcode.util.test.AbstractTest;
import com.leammin.leetcode.util.test.ExpectedTestcase;
import com.leammin.leetcode.util.test.Testsuite;

/**
 * 10. 正则表达式匹配
 *
 * <p>给你一个字符串&nbsp;<code>s</code>&nbsp;和一个字符规律&nbsp;<code>p</code>，请你来实现一个支持 <code>&#39;.&#39;</code>&nbsp;和&nbsp;<code>&#39;*&#39;</code>&nbsp;的正则表达式匹配。</p>
 *
 * <pre>&#39;.&#39; 匹配任意单个字符
 * &#39;*&#39; 匹配零个或多个前面的那一个元素
 * </pre>
 *
 * <p>所谓匹配，是要涵盖&nbsp;<strong>整个&nbsp;</strong>字符串&nbsp;<code>s</code>的，而不是部分字符串。</p>
 *
 * <p><strong>说明:</strong></p>
 *
 * <ul>
 * 	<li><code>s</code>&nbsp;可能为空，且只包含从&nbsp;<code>a-z</code>&nbsp;的小写字母。</li>
 * 	<li><code>p</code>&nbsp;可能为空，且只包含从&nbsp;<code>a-z</code>&nbsp;的小写字母，以及字符&nbsp;<code>.</code>&nbsp;和&nbsp;<code>*</code>。</li>
 * </ul>
 *
 * <p><strong>示例 1:</strong></p>
 *
 * <pre><strong>输入:</strong>
 * s = &quot;aa&quot;
 * p = &quot;a&quot;
 * <strong>输出:</strong> false
 * <strong>解释:</strong> &quot;a&quot; 无法匹配 &quot;aa&quot; 整个字符串。
 * </pre>
 *
 * <p><strong>示例 2:</strong></p>
 *
 * <pre><strong>输入:</strong>
 * s = &quot;aa&quot;
 * p = &quot;a*&quot;
 * <strong>输出:</strong> true
 * <strong>解释:</strong>&nbsp;因为 &#39;*&#39; 代表可以匹配零个或多个前面的那一个元素, 在这里前面的元素就是 &#39;a&#39;。因此，字符串 &quot;aa&quot; 可被视为 &#39;a&#39; 重复了一次。
 * </pre>
 *
 * <p><strong>示例&nbsp;3:</strong></p>
 *
 * <pre><strong>输入:</strong>
 * s = &quot;ab&quot;
 * p = &quot;.*&quot;
 * <strong>输出:</strong> true
 * <strong>解释:</strong>&nbsp;&quot;.*&quot; 表示可匹配零个或多个（&#39;*&#39;）任意字符（&#39;.&#39;）。
 * </pre>
 *
 * <p><strong>示例 4:</strong></p>
 *
 * <pre><strong>输入:</strong>
 * s = &quot;aab&quot;
 * p = &quot;c*a*b&quot;
 * <strong>输出:</strong> true
 * <strong>解释:</strong>&nbsp;因为 &#39;*&#39; 表示零个或多个，这里 &#39;c&#39; 为 0 个, &#39;a&#39; 被重复一次。因此可以匹配字符串 &quot;aab&quot;。
 * </pre>
 *
 * <p><strong>示例 5:</strong></p>
 *
 * <pre><strong>输入:</strong>
 * s = &quot;mississippi&quot;
 * p = &quot;mis*is*p*.&quot;
 * <strong>输出:</strong> false</pre>
 *
 * @author Leammin
 * @date 2020-06-20
 */
public interface RegularExpressionMatching {
    boolean isMatch(String s, String p);

    static Testsuite<RegularExpressionMatching> testsuite() {
        return Testsuite.<RegularExpressionMatching>builder()
                .add(ExpectedTestcase.of(t -> t.isMatch("aa", "a"), false))
                .add(ExpectedTestcase.of(t -> t.isMatch("aa", "a*"), true))
                .add(ExpectedTestcase.of(t -> t.isMatch("ab", ".*"), true))
                .add(ExpectedTestcase.of(t -> t.isMatch("aab", "c*a*b"), true))
                .add(ExpectedTestcase.of(t -> t.isMatch("mississippi", "mis*is*p*."), false))
                .add(ExpectedTestcase.of(t -> t.isMatch("a", ".*..a*"), false))
                .add(ExpectedTestcase.of(t -> t.isMatch("bba", "bba*"), true))
                .add(ExpectedTestcase.of(t -> t.isMatch("", "c*c*"), true))
                .add(ExpectedTestcase.of(t -> t.isMatch("abbabaaaaaaacaa", "a*.*b.a.*c*b*a*c*"), true))
                .add(ExpectedTestcase.of(t -> t.isMatch("a", ".*c*"), true))
                .build();
    }


    class Solution implements RegularExpressionMatching {

        @Override
        public boolean isMatch(String s, String p) {
            int[][] cache = new int[s.length() + 1][p.length() + 1];
            return isMatch(s, p, 0, 0, cache);
        }

        private boolean isMatch(String s, String p, int si, int pi, int[][] cache) {
            if (cache[si][pi] != 0) {
                return cache[si][pi] > 0;
            }
            while (si < s.length() && pi < p.length()) {
                char sc = s.charAt(si);
                char pc = p.charAt(pi);
                boolean star = pi < p.length() - 1 && p.charAt(pi + 1) == '*';
                boolean equals = isEquals(sc, pc);
                if (!equals && !star) {
                    cache[si][pi] = -1;
                    return false;
                }
                if (equals && star) {
                    boolean res = matchStar(s, p, si, pi, cache);
                    cache[si][pi] = res ? 1 : -1;
                    return res;
                }
                if (equals) {
                    si++;
                    pi++;
                } else {
                    pi += 2;
                }
            }
            boolean res = si >= s.length() && (pi >= p.length() || afterAllStar(p, pi));
            cache[si][pi] = res ? 1 : -1;
            return res;
        }

        private boolean afterAllStar(String p, int pi) {
            if (((p.length() - pi) & 1) == 0) {
                for (int i = pi + 1; i < p.length(); i += 2) {
                    if (p.charAt(i) != '*') {
                        return false;
                    }
                }
                return true;
            } else {
                return false;
            }
        }

        private boolean matchStar(String s, String p, int si, int pi, int[][] cache) {
            char pc = p.charAt(pi);
            if (pi + 2 >= p.length()) {
                for (int i = si; i < s.length(); i++) {
                    if (!isEquals(s.charAt(i), pc)) {
                        return false;
                    }
                }
                return true;
            } else {
                for (int i = si; i <= s.length() && (i == si || isEquals(s.charAt(i - 1), pc)); i++) {
                    if (isMatch(s, p, i, pi + 2, cache)) {
                        return true;
                    }
                }
                return false;
            }
        }

        private boolean isEquals(char sc, char pc) {
            return pc == '.' || pc == sc;
        }
    }
}

class RegularExpressionMatchingTest extends AbstractTest<RegularExpressionMatching> {
}
