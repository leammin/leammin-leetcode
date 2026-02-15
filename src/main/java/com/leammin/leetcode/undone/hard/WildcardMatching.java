package com.leammin.leetcode.undone.hard;

import java.util.HashMap;
import java.util.Map;

import com.leammin.leetcode.util.test.AbstractTest;
import com.leammin.leetcode.util.test.ExpectedTestcase;
import com.leammin.leetcode.util.test.Testsuite;

/**
 * 44. 通配符匹配
 *
 * <p>给定一个字符串&nbsp;(<code>s</code>) 和一个字符模式&nbsp;(<code>p</code>) ，实现一个支持&nbsp;<code>&#39;?&#39;</code>&nbsp;和&nbsp;<code>&#39;*&#39;</code>&nbsp;的通配符匹配。</p>
 *
 * <pre>&#39;?&#39; 可以匹配任何单个字符。
 * &#39;*&#39; 可以匹配任意字符串（包括空字符串）。
 * </pre>
 *
 * <p>两个字符串<strong>完全匹配</strong>才算匹配成功。</p>
 *
 * <p><strong>说明:</strong></p>
 *
 * <ul>
 * 	<li><code>s</code>&nbsp;可能为空，且只包含从&nbsp;<code>a-z</code>&nbsp;的小写字母。</li>
 * 	<li><code>p</code>&nbsp;可能为空，且只包含从&nbsp;<code>a-z</code>&nbsp;的小写字母，以及字符&nbsp;<code>?</code>&nbsp;和&nbsp;<code>*</code>。</li>
 * </ul>
 *
 * <p><strong>示例&nbsp;1:</strong></p>
 *
 * <pre><strong>输入:</strong>
 * s = &quot;aa&quot;
 * p = &quot;a&quot;
 * <strong>输出:</strong> false
 * <strong>解释:</strong> &quot;a&quot; 无法匹配 &quot;aa&quot; 整个字符串。</pre>
 *
 * <p><strong>示例&nbsp;2:</strong></p>
 *
 * <pre><strong>输入:</strong>
 * s = &quot;aa&quot;
 * p = &quot;*&quot;
 * <strong>输出:</strong> true
 * <strong>解释:</strong>&nbsp;&#39;*&#39; 可以匹配任意字符串。
 * </pre>
 *
 * <p><strong>示例&nbsp;3:</strong></p>
 *
 * <pre><strong>输入:</strong>
 * s = &quot;cb&quot;
 * p = &quot;?a&quot;
 * <strong>输出:</strong> false
 * <strong>解释:</strong>&nbsp;&#39;?&#39; 可以匹配 &#39;c&#39;, 但第二个 &#39;a&#39; 无法匹配 &#39;b&#39;。
 * </pre>
 *
 * <p><strong>示例&nbsp;4:</strong></p>
 *
 * <pre><strong>输入:</strong>
 * s = &quot;adceb&quot;
 * p = &quot;*a*b&quot;
 * <strong>输出:</strong> true
 * <strong>解释:</strong>&nbsp;第一个 &#39;*&#39; 可以匹配空字符串, 第二个 &#39;*&#39; 可以匹配字符串 &quot;dce&quot;.
 * </pre>
 *
 * <p><strong>示例&nbsp;5:</strong></p>
 *
 * <pre><strong>输入:</strong>
 * s = &quot;acdcb&quot;
 * p = &quot;a*c?b&quot;
 * <strong>输入:</strong> false</pre>
 *
 * @author Leammin
 * @date 2019-08-31
 */
public interface WildcardMatching {
    boolean isMatch(String s, String p);

    static Testsuite<WildcardMatching> testsuite() {
        return Testsuite.<WildcardMatching>builder()
                .add(ExpectedTestcase.of(t -> t.isMatch("aa", "a"), false))
                .add(ExpectedTestcase.of(t -> t.isMatch("cb", "?a"), false))
                .add(ExpectedTestcase.of(t -> t.isMatch("acdcb", "a*c?b"), false))
                .add(ExpectedTestcase.of(t -> t.isMatch("aa", "*"), true))
                .add(ExpectedTestcase.of(t -> t.isMatch("adceb", "*a*b"), true))
                .add(ExpectedTestcase.of(t -> t.isMatch("adcasdeb", "*a*d*"), true))
                .add(ExpectedTestcase.of(t -> t.isMatch("aaaa", "***a"), true))
                .add(ExpectedTestcase.of(t -> t.isMatch("", "*"), true))
                .add(ExpectedTestcase.of(t -> t.isMatch("c", "*?*"), true))
                .add(ExpectedTestcase.of(t -> t.isMatch("ho", "ho**"), true))
                .add(ExpectedTestcase.of(t -> t.isMatch("mississippi", "m??*ss*?i*pi"), false))
                .add(ExpectedTestcase.of(t -> t.isMatch("abbabaaabbabbaababbabbbbbabbbabbbabaaaaababababbbabababaabbababaabbbbbbaaaabababbbaabbbbaabbbbababababbaabbaababaabbbabababa", "**aa*****ba*a*bb**aa*ab****a*aaaaaa***a*aaaa**bbabb*b*b*"), false))
                .add(ExpectedTestcase.of(t -> t.isMatch("abbabaaabbabbaababbabbbbbabbbabbbabaaaaababababbbabababaabbababaabbbbbbaaaabababbbaabbbbaabbbbababababbaabbaababaabbbababababbbbaaabbbbbabaaaabbababbbbaababaabbababbbbbababbbabaaaaaaaabbbbbaabaaababaaaabb", "**aa*****ba*a*bb**aa*ab****a*aaaaaa***a*aaaa**bbabb*b*b**aaaaaaaaa*a********ba*bbb***a*ba*bb*bb**a*b*bb"), false))
                .build();
    }


    class Solution implements WildcardMatching {
        @Override
        public boolean isMatch(String s, String p) {
            return isMatch(new HashMap<>(), s, 0, p, 0);
        }

        private boolean isMatch(Map<String, Boolean> caches, String s, int sf, String p, int pf) {
            String key = sf + "," + pf;
            Boolean cache = caches.get(key);
            if (cache != null) {
                return cache;
            }
            if (pf >= p.length()) {
                return sf >= s.length();
            }
            char pc = p.charAt(pf);
            if (pc != '*') {
                boolean res = sf < s.length() && (pc == '?' || pc == s.charAt(sf)) && isMatch(caches, s, sf + 1, p, pf + 1);
                caches.put(key, res);
                return res;
            }
            if (pf == p.length() - 1) {
                return true;
            }
            while (p.charAt(++pf) == '*') {
                // 跳过连续的 *
                if (pf == p.length() - 1) {
                    return true;
                }
            }
            String newKey = sf + "," + pf;
            for (int i = sf; i < s.length(); i++) {
                if (isMatch(caches, s, i, p, pf)) {
                    caches.put(key, true);
                    caches.put(newKey, true);
                    return true;
                }
            }
            caches.put(key, false);
            caches.put(newKey, false);
            return false;
        }
    }
}

class WildcardMatchingTest extends AbstractTest<WildcardMatching> {
}
