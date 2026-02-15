package com.leammin.leetcode.hard;

import com.leammin.leetcode.util.test.AbstractTest;
import com.leammin.leetcode.util.test.ExpectedTestcase;
import com.leammin.leetcode.util.test.Testsuite;

/**
 * 32. 最长有效括号
 * 
 * <p>给定一个只包含 <code>&#39;(&#39;</code>&nbsp;和 <code>&#39;)&#39;</code>&nbsp;的字符串，找出最长的包含有效括号的子串的长度。</p>
 * 
 * <p><strong>示例&nbsp;1:</strong></p>
 * 
 * <pre><strong>输入:</strong> &quot;(()&quot;
 * <strong>输出:</strong> 2
 * <strong>解释:</strong> 最长有效括号子串为 <code>&quot;()&quot;</code>
 * </pre>
 * 
 * <p><strong>示例 2:</strong></p>
 * 
 * <pre><strong>输入:</strong> &quot;<code>)()())</code>&quot;
 * <strong>输出:</strong> 4
 * <strong>解释:</strong> 最长有效括号子串为 <code>&quot;()()&quot;</code>
 * </pre>
 * 
 * 
 * @author Leammin
 * @date 2020-07-04
 */
public interface LongestValidParentheses {
    int longestValidParentheses(String s);

    static Testsuite<LongestValidParentheses> testsuite() {
        return Testsuite.<LongestValidParentheses>builder()
                .add(ExpectedTestcase.of(t -> t.longestValidParentheses("(()"), 2))
                .add(ExpectedTestcase.of(t -> t.longestValidParentheses(")()())"), 4))
                .add(ExpectedTestcase.of(t -> t.longestValidParentheses("(()())"), 6))
                .add(ExpectedTestcase.of(t -> t.longestValidParentheses("(()()"), 4))
                .add(ExpectedTestcase.of(t -> t.longestValidParentheses("()())"), 4))
                .add(ExpectedTestcase.of(t -> t.longestValidParentheses(""), 0))
                .build();
    }


    class Solution implements LongestValidParentheses {

        @Override
        public int longestValidParentheses(String s) {
            int max = 0;
            for (int i = 0; i < s.length() - max; i++) {
                int len = 0;
                int flag = 0;
                for (int j = i; j < s.length(); j++) {
                    flag += s.charAt(j) == '(' ? 1 : -1;
                    len++;
                    if (flag < 0) {
                        break;
                    }
                    if (flag == 0) {
                        max = Math.max(max, len);
                    }
                }
            }
            return max;
        }
    }

    class Solution2 implements LongestValidParentheses {

        @Override
        public int longestValidParentheses(String s) {
            int from = 0, to = 0;
            int p = 0;
            for (int l = 0, r = 0; r < s.length(); r++) {
                if (s.charAt(r) == '(') {
                    p++;
                } else if (p > 0) {
                    p--;
                    if (p == 0 && r - l + 1 > to - from) {
                        from = l;
                        to = r + 1;
                    }
                } else {
                    l = r + 1;
                    p = 0;
                }
            }
            p = 0;
            for (int l = s.length() - 1, r = l; l >= 0; l--) {
                if (s.charAt(l) == ')') {
                    p++;
                } else if (p > 0) {
                    p--;
                    if (p == 0 && r - l + 1 > to - from) {
                        from = l;
                        to = r + 1;
                    }
                } else {
                    r = l - 1;
                    p = 0;
                }
            }
            return to - from;
        }
    }
}

class LongestValidParenthesesTest extends AbstractTest<LongestValidParentheses> {
}
