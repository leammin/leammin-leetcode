package com.leammin.leetcode.medium;

/**
 * 647. 回文子串
 *
 * <div><p>给定一个字符串，你的任务是计算这个字符串中有多少个回文子串。</p>
 *
 * <p>具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被计为是不同的子串。</p>
 *
 * <p><strong>示例 1:</strong></p>
 *
 * <pre><strong>输入:</strong> "abc"
 * <strong>输出:</strong> 3
 * <strong>解释:</strong> 三个回文子串: "a", "b", "c".
 * </pre>
 *
 * <p><strong>示例 2:</strong></p>
 *
 * <pre><strong>输入:</strong> "aaa"
 * <strong>输出:</strong> 6
 * <strong>说明:</strong> 6个回文子串: "a", "a", "a", "aa", "aa", "aaa".
 * </pre>
 *
 * <p><strong>注意:</strong></p>
 *
 * <ol>
 * <li>输入的字符串长度不会超过1000。</li>
 * </ol>
 * </div>
 *
 * @author Leammin
 * @date 2019-05-03
 */
public interface PalindromicSubstrings {
    int countSubstrings(String s);

    class Solution implements PalindromicSubstrings {
        @Override
        public int countSubstrings(String s) {
            int res = s.length();
            for (int i = 0; i < s.length() - 1; i++) {
                for (int low = i - 1, high = i + 1; low >= 0 && high < s.length() && s.charAt(low) == s.charAt(high); low--, high++) {
                    res++;
                }
                for (int low = i, high = i + 1; low >= 0 && high < s.length() && s.charAt(low) == s.charAt(high); low--, high++) {
                    res++;
                }
            }
            return res;
        }
    }

    class Solution1 implements PalindromicSubstrings {

        @Override
        public int countSubstrings(String s) {
            char[] c = s.toCharArray();
            int res = s.length();
            for (int subLength = 2; subLength <= s.length(); subLength++) {
                for (int i = 0; i < s.length() - subLength + 1; i++) {
                    if (isPalindromic(c, i, i + subLength - 1)) {
                        res++;
                    }
                }
            }
            return res;
        }

        private boolean isPalindromic(char[] c, int start, int end) {
            while (start < end) {
                if (c[start++] != c[end--]) {
                    return false;
                }
            }
            return true;
        }
    }
}
