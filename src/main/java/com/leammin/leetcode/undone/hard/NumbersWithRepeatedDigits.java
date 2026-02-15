package com.leammin.leetcode.undone.hard;

import com.leammin.leetcode.util.test.AbstractTest;
import com.leammin.leetcode.util.test.Testsuite;

import java.util.Arrays;

/**
 * <a href="https://leetcode.cn/problems/numbers-with-repeated-digits/">1012. 至少有 1 位重复的数字</a>
 *
 * <p>给定正整数&nbsp;<code>n</code>，返回在<em>&nbsp;</em><code>[1, n]</code><em>&nbsp;</em>范围内具有 <strong>至少 1 位</strong> 重复数字的正整数的个数。</p>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>示例 1：</strong></p>
 *
 * <pre>
 * <strong>输入：</strong>n = 20
 * <strong>输出：</strong>1
 * <strong>解释：</strong>具有至少 1 位重复数字的正数（&lt;= 20）只有 11 。
 * </pre>
 *
 * <p><strong>示例 2：</strong></p>
 *
 * <pre>
 * <strong>输入：</strong>n = 100
 * <strong>输出：</strong>10
 * <strong>解释：</strong>具有至少 1 位重复数字的正数（&lt;= 100）有 11，22，33，44，55，66，77，88，99 和 100 。
 * </pre>
 *
 * <p><strong>示例 3：</strong></p>
 *
 * <pre>
 * <strong>输入：</strong>n = 1000
 * <strong>输出：</strong>262
 * </pre>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>提示：</strong></p>
 *
 * <ul>
 * 	<li><code>1 &lt;= n &lt;= 10<sup>9</sup></code></li>
 * </ul>
 *
 * @author Leammin
 * @date 2023-03-20
 */
public interface NumbersWithRepeatedDigits {
    int numDupDigitsAtMostN(int n);

    static Testsuite<NumbersWithRepeatedDigits> testsuite() {
        return Testsuite.<NumbersWithRepeatedDigits>builder()
                .addExpected(t -> t.numDupDigitsAtMostN(999), 261)
                .addExpected(t -> t.numDupDigitsAtMostN(1000), 262)
                .addExpected(t -> t.numDupDigitsAtMostN(1000_000_000), 1)
                .addExpected(t -> t.numDupDigitsAtMostN(20), 1)
                .addExpected(t -> t.numDupDigitsAtMostN(100), 10)
                .build();
    }

    class Solution implements NumbersWithRepeatedDigits {

        @Override
        public int numDupDigitsAtMostN(int n) {
            // 10
            // 9 9
            // 9 9 8
            int[] ns = split(n);
            int[] nonrepeats = new int[10]; // i-1位数中不重复的数字
            nonrepeats[0] = 10;
            nonrepeats[1] = 9 * 9;
            for (int i = 2; i < ns.length; i++) {
                nonrepeats[i] = nonrepeats[i - 1] * (10 - i);
            }

            int nr = 0;
            for (int i = 0; i < ns.length - 1; i++) {
                nr += nonrepeats[i];
            }

            for (int i = ns.length - 1; i >= 0; i--) {
                int ni = ns[i];

            }

            return 0;
        }

        private int[] split(int n) {
            int[] res = new int[10];
            int len = 0;
            while (n > 0) {
                res[len++] = n % 10;
                n /= 10;
            }
            return Arrays.copyOf(res, len);
        }
    }
}

class NumbersWithRepeatedDigitsTest extends AbstractTest<NumbersWithRepeatedDigits> {
}
