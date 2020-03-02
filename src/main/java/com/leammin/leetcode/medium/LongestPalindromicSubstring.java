package com.leammin.leetcode.medium;

/**
 * 5. 最长回文子串
 *
 * <p>给定一个字符串 <code>s</code>，找到 <code>s</code> 中最长的回文子串。你可以假设&nbsp;<code>s</code> 的最大长度为 1000。</p>
 *
 * <p><strong>示例 1：</strong></p>
 *
 * <pre><strong>输入:</strong> &quot;babad&quot;
 * <strong>输出:</strong> &quot;bab&quot;
 * <strong>注意:</strong> &quot;aba&quot; 也是一个有效答案。
 * </pre>
 *
 * <p><strong>示例 2：</strong></p>
 *
 * <pre><strong>输入:</strong> &quot;cbbd&quot;
 * <strong>输出:</strong> &quot;bb&quot;
 * </pre>
 *
 * @author Leammin
 * @date 2020-01-25
 */
public interface LongestPalindromicSubstring {
    String longestPalindrome(String s);

    class Solution implements LongestPalindromicSubstring {
        // 0 unknown 1 true -1 false
        int[][] cache;
        int x, y, l;

        @Override
        public String longestPalindrome(String s) {
            if (s.length() <= 1) {
                return s;
            }
            int n = s.length();
            cache = new int[n - 1][n + 1];
            for (int length = n; length > 1; length--) {
                if (l == length) {
                    return s.substring(x, y);
                }
                for (int i = 0; i < n - length + 1; i++) {
                    if (isPalindrome(s, i, i + length)) {
                        return s.substring(i, i + length);
                    }
                }
            }
            return s.substring(0, 1);
        }

        private boolean isPalindrome(String s, int start, int end) {
            if (start >= end - 1) {
                return true;
            }
            if (cache[start][end] != 0) {
                return cache[start][end] > 0;
            }
            if (s.charAt(start) != s.charAt(end - 1)) {
                cache[start][end] = -1;
                return false;
            }
            boolean isPalindrome = isPalindrome(s, start + 1, end - 1);
            int len = end - start;
            if (len > l) {
                x = start;
                y = end;
                l = len;
            }
            cache[start][end] = isPalindrome ? 1 : -1;
            return isPalindrome;
        }
    }

    class Solution2 implements LongestPalindromicSubstring {
        int x = 0, y = 0, len = 1;

        @Override
        public String longestPalindrome(String s) {
            if (s.length() <= 1) {
                return s;
            }
            int n = s.length();
            for (int i = 1; i < n; i++) {
                palindrome(s, i - 1, i + 1);
                palindrome(s, i - 1, i);

            }
            return s.substring(x, y + 1);
        }

        private void palindrome(String s, int l, int r) {
            if (l < 0 || r >= s.length()) {
                return;
            }
            if (s.charAt(l) == s.charAt(r)) {
                if (r - l + 1 > len) {
                    len = r - l + 1;
                    x = l;
                    y = r;
                }
                palindrome(s, l - 1, r + 1);
            }
        }
    }

    /**
     * https://segmentfault.com/a/1190000008484167?utm_source=tag-newest
     */
//    class Manacher implements LongestPalindromicSubstring {
//
//        @Override
//        public String longestPalindrome(String s) {
//            return null;
//        }
//    }
}
