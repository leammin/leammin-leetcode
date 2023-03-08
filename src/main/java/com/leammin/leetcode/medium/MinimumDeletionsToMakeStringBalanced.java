package com.leammin.leetcode.medium;

import com.leammin.leetcode.util.test.Testsuite;

/**
 * <a href="https://leetcode.cn/problems/minimum-deletions-to-make-string-balanced/">1653. 使字符串平衡的最少删除次数</a>
 *
 * <p>给你一个字符串&nbsp;<code>s</code>&nbsp;，它仅包含字符&nbsp;<code>'a'</code> 和&nbsp;<code>'b'</code>​​​​ 。</p>
 *
 * <p>你可以删除&nbsp;<code>s</code>&nbsp;中任意数目的字符，使得&nbsp;<code>s</code> <strong>平衡</strong>&nbsp;。当不存在下标对&nbsp;<code>(i,j)</code>&nbsp;满足&nbsp;<code>i &lt; j</code> ，且&nbsp;<code>s[i] = 'b'</code> 的同时&nbsp;<code>s[j]= 'a'</code> ，此时认为 <code>s</code> 是 <strong>平衡 </strong>的。</p>
 *
 * <p>请你返回使 <code>s</code>&nbsp;<strong>平衡</strong>&nbsp;的 <strong>最少</strong>&nbsp;删除次数。</p>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>示例 1：</strong></p>
 *
 * <pre>
 * <b>输入：</b>s = "aababbab"
 * <b>输出：</b>2
 * <b>解释：</b>你可以选择以下任意一种方案：
 * 下标从 0 开始，删除第 2 和第 6 个字符（"aa<strong>b</strong>abb<strong>a</strong>b" -&gt; "aaabbb"），
 * 下标从 0 开始，删除第 3 和第 6 个字符（"aab<strong>a</strong>bb<strong>a</strong>b" -&gt; "aabbbb"）。
 * </pre>
 *
 * <p><strong>示例 2：</strong></p>
 *
 * <pre>
 * <b>输入：</b>s = "bbaaaaabb"
 * <b>输出：</b>2
 * <b>解释：</b>唯一的最优解是删除最前面两个字符。
 * </pre>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>提示：</strong></p>
 *
 * <ul>
 * 	<li><code>1 &lt;= s.length &lt;= 10<sup>5</sup></code></li>
 * 	<li><code>s[i]</code>&nbsp;要么是&nbsp;<code>'a'</code> 要么是&nbsp;<code>'b'</code>​<strong>&nbsp;</strong>。​</li>
 * </ul>
 *
 * @author Leammin
 * @date 2023-03-06
 */
public interface MinimumDeletionsToMakeStringBalanced {
    int minimumDeletions(String s);

    static Testsuite<MinimumDeletionsToMakeStringBalanced> testsuite() {
        return Testsuite.<MinimumDeletionsToMakeStringBalanced>builder()
                .addExpected(t -> t.minimumDeletions("aababbab"), 2)
                .addExpected(t -> t.minimumDeletions("bbaaaaabb"), 2)
                .addExpected(t -> t.minimumDeletions("aababb"), 1)
                .build();
    }

    class Solution implements MinimumDeletionsToMakeStringBalanced {
        @Override
        public int minimumDeletions(String s) {
            int n = s.length();
            char[] chars = s.toCharArray();
            int lb = 0, ra = 0;
            for (int i = 0; i < n; i++) {
                if (chars[i] == 'a') {
                    ra++;
                }
            }
            int res = Math.min(ra, n - ra);
            for (int i = 0; i < n; i++) {
                if (chars[i] == 'a') {
                    ra--;
                } else {
                    lb++;
                }
                res = Math.min(res, lb + ra);
            }
            return res;
        }
    }


    class Solution2 implements MinimumDeletionsToMakeStringBalanced {
        /*
        f(x, y) {
            if(y == 'b' && s[x] == 'b') {
                return f(x + 1, 'b')
            }
            if(y == 'b' && s[x] == 'a') {
                return f(x + 1, 'b') + 1
            }
            if(y == 'a' && s[x] == 'a') {
                return f(x + 1, 'a')
            }
            if(y == 'a' && s[x] == 'b') {
                return min(f(x + 1, 'a') + 1, f(x + 1, 'b'))
            }
        }
         */
        @Override
        public int minimumDeletions(String s) {
            int la = 0;
            int lb = 0;
            for (int i = s.length() - 1; i >= 0; i--) {
                char c = s.charAt(i);
                if (c == 'a') {
                    lb++;
                } else {
                    la = Math.min(la + 1, lb);
                }
            }
            return la;
        }
    }

    class MinXuan implements MinimumDeletionsToMakeStringBalanced {
        public int minimumDeletions(String s) {
            int count = 0;
            int a = 0;
            int b = 0;
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (c == 'b') {
                    b++;
                }
                if (c == 'a' && b != 0) {
                    a++;
                }
                if (a >= b) {
                    count += b;
                    a = 0;
                    b = 0;
                }
            }
            return count + a;
        }
    }

}