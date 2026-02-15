package com.leammin.leetcode.medium;

import com.leammin.leetcode.util.test.AbstractTest;
import com.leammin.leetcode.util.test.Testsuite;

/**
 * 1124. 表现良好的最长时间段
 *
 * <p>给你一份工作时间表&nbsp;<code>hours</code>，上面记录着某一位员工每天的工作小时数。</p>
 *
 * <p>我们认为当员工一天中的工作小时数大于&nbsp;<code>8</code> 小时的时候，那么这一天就是「<strong>劳累的一天</strong>」。</p>
 *
 * <p>所谓「表现良好的时间段」，意味在这段时间内，「劳累的天数」是严格<strong> 大于</strong>「不劳累的天数」。</p>
 *
 * <p>请你返回「表现良好时间段」的最大长度。</p>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>示例 1：</strong></p>
 *
 * <pre><strong>输入：</strong>hours = [9,9,6,0,6,6,9]
 * <strong>输出：</strong>3
 * <strong>解释：</strong>最长的表现良好时间段是 [9,9,6]。</pre>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>提示：</strong></p>
 *
 * <ul>
 * 	<li><code>1 &lt;= hours.length &lt;= 10000</code></li>
 * 	<li><code>0 &lt;= hours[i] &lt;= 16</code></li>
 * </ul>
 *
 * @author Leammin
 * @date 2023-02-14
 */
public interface LongestWellPerformingInterval {
    int longestWPI(int[] hours);

    static Testsuite<LongestWellPerformingInterval> testsuite() {
        return Testsuite.<LongestWellPerformingInterval>builder()
                .addExpected(t -> t.longestWPI(new int[]{9, 9, 6, 0, 6, 6, 9}), 3)
                .addExpected(t -> t.longestWPI(new int[]{6, 6, 6}), 0)
                .addExpected(t -> t.longestWPI(new int[]{6, 6, 9}), 1)
                .build();
    }


    class Solution implements LongestWellPerformingInterval {

        @Override
        public int longestWPI(int[] hours) {
            int n = hours.length;
            int[] sum = new int[n]; // index -> sum
            int[] sumMap = new int[20001]; // sum值 -> 此sum值的index最小值+1
            for (int i = 0; i < n; i++) {
                sum[i] = (i == 0 ? 0 : sum[i - 1]) + (hours[i] > 8 ? 1 : -1);
                int smi = 10000 + sum[i];
                if (sumMap[smi] == 0) {
                    sumMap[smi] = i + 1;
                }
            }
            if (sum[n - 1] == n) {
                return n;
            }
            if (sum[n - 1] == -n) {
                return 0;
            }
            int res = 0;
            for (int r = sum.length - 1; r >= 0; r--) {
                if (sum[r] > 0 && r + 1 > res) {
                    return r + 1;
                }
                int l = sumMap[10000 + sum[r] - 1] - 1;
                if (l >= 0) {
                    res = Math.max(res, r - l);
                }
            }
            return res;
        }
    }
}

class LongestWellPerformingIntervalTest extends AbstractTest<LongestWellPerformingInterval> {
}
