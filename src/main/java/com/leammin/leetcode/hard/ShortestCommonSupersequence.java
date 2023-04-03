package com.leammin.leetcode.hard;

import com.leammin.leetcode.util.test.Testsuite;

import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/shortest-common-supersequence/">1092. 最短公共超序列</a>
 *
 * <p>给出两个字符串&nbsp;<code>str1</code> 和&nbsp;<code>str2</code>，返回同时以&nbsp;<code>str1</code>&nbsp;和&nbsp;<code>str2</code>&nbsp;作为子序列的最短字符串。如果答案不止一个，则可以返回满足条件的任意一个答案。</p>
 *
 * <p>（如果从字符串 T 中删除一些字符（也可能不删除，并且选出的这些字符可以位于 T 中的&nbsp;<strong>任意位置</strong>），可以得到字符串 S，那么&nbsp;S 就是&nbsp;T 的子序列）</p>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>示例：</strong></p>
 *
 * <pre><strong>输入：</strong>str1 = &quot;abac&quot;, str2 = &quot;cab&quot;
 * <strong>输出：</strong>&quot;cabac&quot;
 * <strong>解释：</strong>
 * str1 = &quot;abac&quot; 是 &quot;cabac&quot; 的一个子串，因为我们可以删去 &quot;cabac&quot; 的第一个 &quot;c&quot;得到 &quot;abac&quot;。
 * str2 = &quot;cab&quot; 是 &quot;cabac&quot; 的一个子串，因为我们可以删去 &quot;cabac&quot; 末尾的 &quot;ac&quot; 得到 &quot;cab&quot;。
 * 最终我们给出的答案是满足上述属性的最短字符串。
 * </pre>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>提示：</strong></p>
 *
 * <ol>
 * 	<li><code>1 &lt;= str1.length, str2.length &lt;= 1000</code></li>
 * 	<li><code>str1</code> 和&nbsp;<code>str2</code>&nbsp;都由小写英文字母组成。</li>
 * </ol>
 *
 * @author Leammin
 * @date 2023-03-28
 */
public interface ShortestCommonSupersequence {
    String shortestCommonSupersequence(String str1, String str2);

    static Testsuite<ShortestCommonSupersequence> testsuite() {
        return Testsuite.<ShortestCommonSupersequence>builder()
                .addExpected(t -> t.shortestCommonSupersequence("abcxayzabc", "efghxeyzefgh"), "abcefghxaeyzabcefgh")
                .addExpected(t -> t.shortestCommonSupersequence("abac", "cab"), "cabac")
                .addExpected(t -> t.shortestCommonSupersequence("aaaaaaaa", "aaaaaaaa"), "aaaaaaaa")
                .addAnyExpected(t -> t.shortestCommonSupersequence("bcacaaab", "bbabaccc"), List.of("bcbabacaaabcc", "bbabcacccaaab"))
                .build();
    }

    //    @Execute(cases = -1)
    class Solution implements ShortestCommonSupersequence {

        @Override
        public String shortestCommonSupersequence(String str1, String str2) {
            char[] c1 = str1.toCharArray();
            char[] c2 = str2.toCharArray();
            StringBuilder[] dp = new StringBuilder[c2.length];
            for (int i = 0; i < c2.length; i++) {
                dp[i] = new StringBuilder(0);
            }
            for (int i = 0; i < c1.length; i++) {
                StringBuilder last = new StringBuilder(0);
                for (int j = 0; j < c2.length; j++) {
                    StringBuilder newLast = dp[j];
                    if (j > 0 && dp[j - 1].length() > dp[j].length()) {
                        dp[j] = dp[j - 1];
                    }
                    if (c1[i] == c2[j] && last.length() + 1 > dp[j].length()) {
                        dp[j] = new StringBuilder(last.length() + 1).append(last).append(c1[i]);
                    }
                    last = newLast;
                }
            }
            StringBuilder subStr = dp[c2.length - 1];
            StringBuilder result = new StringBuilder(c1.length + c2.length - subStr.length());
            int i = 0, j = 0;
            for (int x = 0; x < subStr.length(); x++, i++, j++) {
                char c = subStr.charAt(x);
                while (i < c1.length && c1[i] != c) {
                    result.append(c1[i++]);
                }
                while (j < c2.length && c2[j] != c) {
                    result.append(c2[j++]);
                }
                result.append(c);
            }
            while (i < c1.length) {
                result.append(c1[i++]);
            }
            while (j < c2.length) {
                result.append(c2[j++]);
            }
            return result.toString();
        }
    }

    class Solution2 implements ShortestCommonSupersequence {

        @Override
        public String shortestCommonSupersequence(String str1, String str2) {
            char[] c1 = str1.toCharArray();
            char[] c2 = str2.toCharArray();
            int[][] dp = new int[c1.length + 1][c2.length + 1];
            for (int i = c1.length - 1; i >= 0; i--) {
                for (int j = c2.length - 1; j >= 0; j--) {
                    dp[i][j] = c1[i] == c2[j] ? dp[i + 1][j + 1] + 1 : Math.max(dp[i][j + 1], dp[i + 1][j]);
                }
            }
            StringBuilder result = new StringBuilder(c1.length + c2.length - dp[0][0]);
            int i = 0, j = 0;
            while (i < c1.length || j < c2.length) {
                if (i < c1.length && dp[i][j] == dp[i + 1][j]) {
                    result.append(c1[i]);
                    i++;
                } else if (j < c2.length && dp[i][j] == dp[i][j + 1]) {
                    result.append(c2[j]);
                    j++;
                }  else {
                    result.append(c1[i]);
                    i++;
                    j++;
                }
            }
            return result.toString();
        }
    }
}
