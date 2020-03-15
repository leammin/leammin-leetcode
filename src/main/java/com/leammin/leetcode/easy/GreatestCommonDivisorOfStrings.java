package com.leammin.leetcode.easy;

/**
 * 1071. 字符串的最大公因子
 *
 * <p>对于字符串&nbsp;<code>S</code> 和&nbsp;<code>T</code>，只有在 <code>S = T + ... + T</code>（<code>T</code>&nbsp;与自身连接 1 次或多次）时，我们才认定&nbsp;&ldquo;<code>T</code> 能除尽 <code>S</code>&rdquo;。</p>
 *
 * <p>返回字符串&nbsp;<code>X</code>，要求满足&nbsp;<code>X</code> 能除尽 <code>str1</code> 且&nbsp;<code>X</code> 能除尽 <code>str2</code>。</p>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>示例 1：</strong></p>
 *
 * <pre><strong>输入：</strong>str1 = &quot;ABCABC&quot;, str2 = &quot;ABC&quot;
 * <strong>输出：</strong>&quot;ABC&quot;
 * </pre>
 *
 * <p><strong>示例 2：</strong></p>
 *
 * <pre><strong>输入：</strong>str1 = &quot;ABABAB&quot;, str2 = &quot;ABAB&quot;
 * <strong>输出：</strong>&quot;AB&quot;
 * </pre>
 *
 * <p><strong>示例 3：</strong></p>
 *
 * <pre><strong>输入：</strong>str1 = &quot;LEET&quot;, str2 = &quot;CODE&quot;
 * <strong>输出：</strong>&quot;&quot;
 * </pre>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>提示：</strong></p>
 *
 * <ol>
 * 	<li><code>1 &lt;= str1.length &lt;= 1000</code></li>
 * 	<li><code>1 &lt;= str2.length &lt;= 1000</code></li>
 * 	<li><code>str1[i]</code> 和&nbsp;<code>str2[i]</code> 为大写英文字母</li>
 * </ol>
 *
 * @author Leammin
 * @date 2020-03-12
 */
public interface GreatestCommonDivisorOfStrings {
    String gcdOfStrings(String str1, String str2);

    class Solution implements GreatestCommonDivisorOfStrings {

        @Override
        public String gcdOfStrings(String str1, String str2) {
            int gcd = gcd(str1.length(), str2.length());
            for (int i = 0, j = 0; i < str1.length() || j < str2.length(); i++, j++) {
                char c = str1.charAt(i % gcd);
                if (i < str1.length() && str1.charAt(i) != c || j < str2.length() && str2.charAt(j) != c) {
                    return "";
                }
            }
            return str1.substring(0, gcd);
        }

        private int gcd(int m, int n) {
            if (n == 0) {
                return m;
            }
            return gcd(n, m % n);
        }
    }

    class Best implements GreatestCommonDivisorOfStrings {

        @Override
        public String gcdOfStrings(String str1, String str2) {
            if (!(str1 + str2).equals(str2 + str1)) {
                return "";
            }
            int gcd = gcd(str1.length(), str2.length());
            return str1.substring(0, gcd);
        }

        private int gcd(int m, int n) {
            if (n == 0) {
                return m;
            }
            return gcd(n, m % n);
        }
    }
}
