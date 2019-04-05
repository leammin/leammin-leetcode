package com.leammin.leetcode.easy;

/**
 * 20. 有效的括号
 *
 * <div><p>给定一个只包括 <code>'('</code>，<code>')'</code>，<code>'{'</code>，<code>'}'</code>，<code>'['</code>，<code>']'</code>&nbsp;的字符串，判断字符串是否有效。</p>
 *
 * <p>有效字符串需满足：</p>
 *
 * <ol>
 * <li>左括号必须用相同类型的右括号闭合。</li>
 * <li>左括号必须以正确的顺序闭合。</li>
 * </ol>
 *
 * <p>注意空字符串可被认为是有效字符串。</p>
 *
 * <p><strong>示例 1:</strong></p>
 *
 * <pre><strong>输入:</strong> "()"
 * <strong>输出:</strong> true
 * </pre>
 *
 * <p><strong>示例&nbsp;2:</strong></p>
 *
 * <pre><strong>输入:</strong> "()[]{}"
 * <strong>输出:</strong> true
 * </pre>
 *
 * <p><strong>示例&nbsp;3:</strong></p>
 *
 * <pre><strong>输入:</strong> "(]"
 * <strong>输出:</strong> false
 * </pre>
 *
 * <p><strong>示例&nbsp;4:</strong></p>
 *
 * <pre><strong>输入:</strong> "([)]"
 * <strong>输出:</strong> false
 * </pre>
 *
 * <p><strong>示例&nbsp;5:</strong></p>
 *
 * <pre><strong>输入:</strong> "{[]}"
 * <strong>输出:</strong> true</pre>
 * </div>
 *
 * @author Leammin
 * @date 2018-10-27
 */
public interface ValidParentheses {
    boolean isValid(String s);

    class Solution implements ValidParentheses {
        @Override
        public boolean isValid(String s) {
            char[] stack = new char[s.length()];
            int stackIndex = 0;

            char[] chars = s.toCharArray();
            for (char p : chars) {
                if (p == '(' || p == '[' || p == '{') {
                    stack[stackIndex++] = p;
                } else {
                    if (stackIndex == 0) {
                        return false;
                    }
                    char stackP = stack[--stackIndex];
                    if (p == ')' && stackP != '(') {
                        return false;
                    }
                    if (p == ']' && stackP != '[') {
                        return false;
                    }
                    if (p == '}' && stackP != '{') {
                        return false;
                    }
                }
            }

            return stackIndex == 0;
        }
    }
}
