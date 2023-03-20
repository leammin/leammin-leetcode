package com.leammin.leetcode.medium;

import com.leammin.leetcode.util.test.Testsuite;

import java.util.*;

/**
 * <a href="https://leetcode.cn/problems/lexicographically-smallest-string-after-applying-operations/">1625. 执行操作后字典序最小的字符串</a>
 *
 * <p>给你一个字符串 <code>s</code> 以及两个整数 <code>a</code> 和 <code>b</code> 。其中，字符串 <code>s</code> 的长度为偶数，且仅由数字 <code>0</code> 到 <code>9</code> 组成。</p>
 *
 * <p>你可以在 <code>s</code> 上按任意顺序多次执行下面两个操作之一：</p>
 *
 * <ul>
 * 	<li>累加：将  <code>a</code> 加到 <code>s</code> 中所有下标为奇数的元素上（<strong>下标从 0 开始</strong>）。数字一旦超过 <code>9</code> 就会变成 <code>0</code>，如此循环往复。例如，<code>s = "3456"</code> 且 <code>a = 5</code>，则执行此操作后 <code>s</code> 变成 <code>"3951"</code>。</li>
 * 	<li>轮转：将 <code>s</code> 向右轮转 <code>b</code> 位。例如，<code>s = "3456"</code> 且 <code>b = 1</code>，则执行此操作后 <code>s</code> 变成 <code>"6345"</code>。</li>
 * </ul>
 *
 * <p>请你返回在 <code>s</code> 上执行上述操作任意次后可以得到的 <strong>字典序最小</strong> 的字符串。</p>
 *
 * <p>如果两个字符串长度相同，那么字符串 <code>a</code> 字典序比字符串 <code>b</code> 小可以这样定义：在 <code>a</code> 和 <code>b</code> 出现不同的第一个位置上，字符串 <code>a</code> 中的字符出现在字母表中的时间早于 <code>b</code> 中的对应字符。例如，<code>"0158”</code> 字典序比 <code>"0190"</code> 小，因为不同的第一个位置是在第三个字符，显然 <code>'5'</code> 出现在 <code>'9'</code> 之前。</p>
 *
 * <p> </p>
 *
 * <p><strong>示例 1：</strong></p>
 *
 * <pre>
 * <strong>输入：</strong>s = "5525", a = 9, b = 2
 * <strong>输出：</strong>"2050"
 * <strong>解释：</strong>执行操作如下：
 * 初态："5525"
 * 轮转："2555"
 * 累加："2454"
 * 累加："2353"
 * 轮转："5323"
 * 累加："5222"
 * 累加："5121"
 * 轮转："2151"
 * 累加："2050"​​​​​​​​​​​​
 * 无法获得字典序小于 "2050" 的字符串。
 * </pre>
 *
 * <p><strong>示例 2：</strong></p>
 *
 * <pre>
 * <strong>输入：</strong>s = "74", a = 5, b = 1
 * <strong>输出：</strong>"24"
 * <strong>解释：</strong>执行操作如下：
 * 初态："74"
 * 轮转："47"
 * 累加："42"
 * 轮转："24"​​​​​​​​​​​​
 * 无法获得字典序小于 "24" 的字符串。
 * </pre>
 *
 * <p><strong>示例 3：</strong></p>
 *
 * <pre>
 * <strong>输入：</strong>s = "0011", a = 4, b = 2
 * <strong>输出：</strong>"0011"
 * <strong>解释：</strong>无法获得字典序小于 "0011" 的字符串。
 * </pre>
 *
 * <p><strong>示例 4：</strong></p>
 *
 * <pre>
 * <strong>输入：</strong>s = "43987654", a = 7, b = 3
 * <strong>输出：</strong>"00553311"
 * </pre>
 *
 * <p> </p>
 *
 * <p><strong>提示：</strong></p>
 *
 * <ul>
 * 	<li><code>2 <= s.length <= 100</code></li>
 * 	<li><code>s.length</code> 是偶数</li>
 * 	<li><code>s</code> 仅由数字 <code>0</code> 到 <code>9</code> 组成</li>
 * 	<li><code>1 <= a <= 9</code></li>
 * 	<li><code>1 <= b <= s.length - 1</code></li>
 * </ul>
 *
 * @author Leammin
 * @date 2023-03-19
 */
public interface LexicographicallySmallestStringAfterApplyingOperations {
    String findLexSmallestString(String s, int a, int b);

    static Testsuite<LexicographicallySmallestStringAfterApplyingOperations> testsuite() {
        return Testsuite.<LexicographicallySmallestStringAfterApplyingOperations>builder()
                .addExpected(t -> t.findLexSmallestString("5525", 9, 2), "2050")
                .addExpected(t -> t.findLexSmallestString("74", 5, 1), "24")
                .addExpected(t -> t.findLexSmallestString("0011", 4, 2), "0011")
                .addExpected(t -> t.findLexSmallestString("43987654", 7, 3), "00553311")
                .addExpected(t -> t.findLexSmallestString("247303203266", 3, 1), "000273963217")
                .build();
    }

    class Solution implements LexicographicallySmallestStringAfterApplyingOperations {

        @Override
        public String findLexSmallestString(String s, int a, int b) {
            int[] as;
            if (a % 2 == 0) {
                as = new int[]{0, 2, 2, 2, 2};
            } else if (a == 5) {
                as = new int[]{0, 5};
            } else {
                as = new int[]{0, 1, 1, 1, 1, 1, 1, 1, 1, 1};
            }

            int n = s.length();
            int[] si = new int[n];
            for (int i = 0; i < n; i++) {
                si[i] = s.charAt(i) - '0';
            }
            int[] minSi = null;
            int minI = 0;
            for (int i = 0, evenAdd = (b & 1) == 0 ? 1 : as.length; i < evenAdd; i++) {
                add(si, as[i], true);
                for (int j = 0; j < as.length; j++) {
                    add(si, as[j], false);
                    int siMinI = minIndex(si, b);
                    if (minSi == null || compare(si, siMinI, minSi, minI) < 0) {
                        minSi = Arrays.copyOf(si, n);
                        minI = siMinI;
                    }
                }
            }
            StringBuilder sb = new StringBuilder(n);
            for (int i = 0; i < n; i++) {
                sb.append(minSi[(i + minI) % n]);
            }
            return sb.toString();
        }

        private void add(int[] array, int add, boolean even) {
            if (add == 0) {
                return;
            }
            for (int i = even ? 0 : 1; i < array.length; i += 2) {
                array[i] = (array[i] + add) % 10;
            }
        }

        private int compare(int[] a1, int s1, int[] a2, int s2) {
            int n = a1.length;
            for (int i = 0; i < n; i++) {
                int i1 = (s1 + i) % n;
                int i2 = (s2 + i) % n;
                if (a1[i1] > a2[i2]) {
                    return 1;
                } else if (a1[i1] < a2[i2]) {
                    return -1;
                }
            }
            return 0;
        }

        private int minIndex(int[] array, int b) {
            int min = 0;
            for (int i = b; i != 0; i = (i + b) % array.length) {
                if (compare(array, i, array, min) < 0) {
                    min = i;
                }
            }
            return min;
        }
    }
}

