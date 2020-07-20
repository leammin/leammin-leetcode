package com.leammin.leetcode.undone.hard;

/**
 * 97. 交错字符串
 *
 * <p>给定三个字符串&nbsp;<em>s1</em>, <em>s2</em>, <em>s3</em>, 验证&nbsp;<em>s3</em>&nbsp;是否是由&nbsp;<em>s1</em>&nbsp;和&nbsp;<em>s2 </em>交错组成的。</p>
 *
 * <p><strong>示例 1:</strong></p>
 *
 * <pre><strong>输入:</strong> s1 = &quot;aabcc&quot;, s2 = &quot;dbbca&quot;, <em>s3</em> = &quot;aadbbcbcac&quot;
 * <strong>输出:</strong> true
 * </pre>
 *
 * <p><strong>示例&nbsp;2:</strong></p>
 *
 * <pre><strong>输入:</strong> s1 = &quot;aabcc&quot;, s2 = &quot;dbbca&quot;, <em>s3</em> = &quot;aadbbbaccc&quot;
 * <strong>输出:</strong> false</pre>
 *
 * @author Leammin
 * @date 2020-07-18
 */
public interface InterleavingString {
    boolean isInterleave(String s1, String s2, String s3);

    class Solution implements InterleavingString {

        @Override
        public boolean isInterleave(String s1, String s2, String s3) {
            if (s1.length() + s2.length() != s3.length()) {
                return false;
            }
            return isInterleave(s1, s2, s3, 0, 0);
        }

        private boolean isInterleave(String s1, String s2, String s3, int i, int j) {
            char c1;
            char c2;
            char c3;
            do {
                if (i + j >= s3.length()) {
                    return true;
                }
                c1 = i < s1.length() ? s1.charAt(i) : 0;
                c2 = j < s2.length() ? s2.charAt(j) : 0;
                c3 = s3.charAt(i + j);
                if (c3 != c1 && c3 != c2) {
                    return false;
                }
                if (c1 != c2) {
                    if (c3 == c1) {
                        i++;
                    } else {
                        j++;
                    }
                }
            } while (c1 != c2);
            return isInterleave(s1, s2, s3, i + 1, j) || isInterleave(s1, s2, s3, i, j + 1);
        }
    }

    class Solution2 implements InterleavingString {

        @Override
        public boolean isInterleave(String s1, String s2, String s3) {
            if (s1.length() + s2.length() != s3.length()) {
                return false;
            }
            return isInterleave(s1, s2, s3, 0, 0, new int[s1.length() + 1][s2.length() + 1]);
        }

        private boolean isInterleave(String s1, String s2, String s3, int x, int y, int[][] dp) {
            int i = x;
            int j = y;
            if (dp[i][j] != 0) {
                return dp[i][j] > 0;
            }
            char c1;
            char c2;
            char c3;
            do {
                if (i + j >= s3.length()) {
                    return true;
                }
                c1 = i < s1.length() ? s1.charAt(i) : 0;
                c2 = j < s2.length() ? s2.charAt(j) : 0;
                c3 = s3.charAt(i + j);
                if (c3 != c1 && c3 != c2) {
                    return false;
                }
                if (c1 != c2) {
                    if (c3 == c1) {
                        i++;
                    } else {
                        j++;
                    }
                }
            } while (c1 != c2);
            if (dp[i][j] != 0) {
                return dp[i][j] > 0;
            }
            boolean r = isInterleave(s1, s2, s3, i + 1, j, dp) || isInterleave(s1, s2, s3, i, j + 1, dp);
            dp[i][j] = dp[x][y] = r ? 1 : -1;
            return r;
        }
    }
}
