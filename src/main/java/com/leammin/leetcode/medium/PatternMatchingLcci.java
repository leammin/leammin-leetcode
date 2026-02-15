package com.leammin.leetcode.medium;

import com.leammin.leetcode.util.test.AbstractTest;
import com.leammin.leetcode.util.test.ExpectedTestcase;
import com.leammin.leetcode.util.test.Testsuite;

/**
 * 面试题 16.18. 模式匹配
 *
 * <p>你有两个字符串，即<code>pattern</code>和<code>value</code>。 <code>pattern</code>字符串由字母<code>"a"</code>和<code>"b"</code>组成，用于描述字符串中的模式。例如，字符串<code>"catcatgocatgo"</code>匹配模式<code>"aabab"</code>（其中<code>"cat"</code>是<code>"a"</code>，<code>"go"</code>是<code>"b"</code>），该字符串也匹配像<code>"a"</code>、<code>"ab"</code>和<code>"b"</code>这样的模式。但需注意<code>"a"</code>和<code>"b"</code>不能同时表示相同的字符串。编写一个方法判断<code>value</code>字符串是否匹配<code>pattern</code>字符串。</p>
 * <p><strong>示例 1：</strong></p>
 * <pre><strong>输入：</strong> pattern = "abba", value = "dogcatcatdog"
 * <strong>输出：</strong> true
 * </pre>
 * <p><strong>示例 2：</strong></p>
 * <pre><strong>输入：</strong> pattern = "abba", value = "dogcatcatfish"
 * <strong>输出：</strong> false
 * </pre>
 * <p><strong>示例 3：</strong></p>
 * <pre><strong>输入：</strong> pattern = "aaaa", value = "dogcatcatdog"
 * <strong>输出：</strong> false
 * </pre>
 * <p><strong>示例 4：</strong></p>
 * <pre><strong>输入：</strong> pattern = "abba", value = "dogdogdogdog"
 * <strong>输出：</strong> true
 * <strong>解释：</strong> "a"="dogdog",b=""，反之也符合规则
 * </pre>
 * <p><strong>提示：</strong></p>
 * <ul>
 * <li><code>0 <= len(pattern) <= 1000</code></li>
 * <li><code>0 <= len(value) <= 1000</code></li>
 * <li>你可以假设<code>pattern</code>只包含字母<code>"a"</code>和<code>"b"</code>，<code>value</code>仅包含小写字母。</li>
 * </ul>
 *
 * @author Leammin
 * @date 2020-06-22
 */
public interface PatternMatchingLcci {
    boolean patternMatching(String pattern, String value);

    static Testsuite<PatternMatchingLcci> testsuite() {
        return Testsuite.<PatternMatchingLcci>builder()
                .add(ExpectedTestcase.of(t -> t.patternMatching("abba", "dogcatcatdog"), true))
                .add(ExpectedTestcase.of(t -> t.patternMatching("abba", "dogcatcatfish"), false))
                .add(ExpectedTestcase.of(t -> t.patternMatching("aaaa", "dogcatcatdog"), false))
                .add(ExpectedTestcase.of(t -> t.patternMatching("abba", "dogdogdogdog"), true))
                .add(ExpectedTestcase.of(t -> t.patternMatching("aaaa", "dogdogdogdog"), true))
                .build();
    }


    class Solution implements PatternMatchingLcci {

        @Override
        public boolean patternMatching(String pattern, String value) {
            if (pattern.isEmpty()) {
                return value.isEmpty();
            }
            int xc = 1;
            int yc = 0;
            int yi = -1;
            char xchar = pattern.charAt(0);
            for (int i = 1; i < pattern.length(); i++) {
                if (pattern.charAt(i) == xchar) {
                    xc++;
                } else {
                    yc++;
                    if (yi < 0) {
                        yi = i;
                    }
                }
            }
            if (value.isEmpty()) {
                return yc == 0;
            }
            if (xc == 1 || yc == 1) {
                return true;
            }
            int mxl = value.length() / xc;
            for (int xl = yc == 0 ? mxl : 0; xl <= mxl; xl++) {
                int yl = yc == 0 ? 0 : (value.length() - xc * xl) / yc;
                if (value.length() != yc * yl + xc * xl) {
                    continue;
                }
                int x = 0;
                int y = xl * yi;
                if (xl == yl && equals(value, x, y, xl)) {
                    continue;
                }
                int len = 0;
                for (int i = 0; i < pattern.length(); i++) {
                    if (pattern.charAt(i) == xchar) {
                        if (!equals(value, x, len, xl)) {
                            break;
                        }
                        len += xl;
                    } else {
                        if (!equals(value, y, len, yl)) {
                            break;
                        }
                        len += yl;
                    }
                }
                if (len == value.length()) {
                    return true;
                }
            }
            return false;
        }

        private boolean equals(String s, int i, int j, int l) {
            if (i == j) {
                return true;
            }
            if (i + l > s.length() || j + l > s.length()) {
                return false;
            }
            for (int k = 0; k < l; k++) {
                if (s.charAt(i + k) != s.charAt(j + k)) {
                    return false;
                }
            }
            return true;
        }
    }
}

class PatternMatchingLcciTest extends AbstractTest<PatternMatchingLcci> {
}
