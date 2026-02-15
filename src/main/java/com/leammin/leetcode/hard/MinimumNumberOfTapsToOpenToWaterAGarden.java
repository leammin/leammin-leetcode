package com.leammin.leetcode.hard;

import java.util.ArrayList;
import java.util.List;

import com.leammin.leetcode.util.test.AbstractTest;
import com.leammin.leetcode.util.test.Testsuite;

/**
 * 1326. 灌溉花园的最少水龙头数目
 * 
 * <p>在 x 轴上有一个一维的花园。花园长度为&nbsp;<code>n</code>，从点&nbsp;<code>0</code>&nbsp;开始，到点&nbsp;<code>n</code>&nbsp;结束。</p>
 * 
 * <p>花园里总共有&nbsp;<code>n + 1</code> 个水龙头，分别位于&nbsp;<code>[0, 1, ..., n]</code> 。</p>
 * 
 * <p>给你一个整数&nbsp;<code>n</code>&nbsp;和一个长度为&nbsp;<code>n + 1</code> 的整数数组&nbsp;<code>ranges</code>&nbsp;，其中&nbsp;<code>ranges[i]</code> （下标从 0 开始）表示：如果打开点&nbsp;<code>i</code>&nbsp;处的水龙头，可以灌溉的区域为&nbsp;<code>[i -&nbsp; ranges[i], i + ranges[i]]</code>&nbsp;。</p>
 * 
 * <p>请你返回可以灌溉整个花园的&nbsp;<strong>最少水龙头数目</strong>&nbsp;。如果花园始终存在无法灌溉到的地方，请你返回&nbsp;<strong>-1</strong>&nbsp;。</p>
 * 
 * <p>&nbsp;</p>
 * 
 * <p><strong>示例 1：</strong></p>
 * 
 * <p><img alt="" src="https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2020/01/19/1685_example_1.png" style="width: 530px;"></p>
 * 
 * <pre><strong>输入：</strong>n = 5, ranges = [3,4,1,1,0,0]
 * <strong>输出：</strong>1
 * <strong>解释：
 * </strong>点 0 处的水龙头可以灌溉区间 [-3,3]
 * 点 1 处的水龙头可以灌溉区间 [-3,5]
 * 点 2 处的水龙头可以灌溉区间 [1,3]
 * 点 3 处的水龙头可以灌溉区间 [2,4]
 * 点 4 处的水龙头可以灌溉区间 [4,4]
 * 点 5 处的水龙头可以灌溉区间 [5,5]
 * 只需要打开点 1 处的水龙头即可灌溉整个花园 [0,5] 。
 * </pre>
 * 
 * <p><strong>示例 2：</strong></p>
 * 
 * <pre><strong>输入：</strong>n = 3, ranges = [0,0,0,0]
 * <strong>输出：</strong>-1
 * <strong>解释：</strong>即使打开所有水龙头，你也无法灌溉整个花园。
 * </pre>
 * 
 * <p><strong>示例 3：</strong></p>
 * 
 * <pre><strong>输入：</strong>n = 7, ranges = [1,2,1,0,2,1,0,1]
 * <strong>输出：</strong>3
 * </pre>
 * 
 * <p><strong>示例 4：</strong></p>
 * 
 * <pre><strong>输入：</strong>n = 8, ranges = [4,0,0,0,0,0,0,0,4]
 * <strong>输出：</strong>2
 * </pre>
 * 
 * <p><strong>示例 5：</strong></p>
 * 
 * <pre><strong>输入：</strong>n = 8, ranges = [4,0,0,0,4,0,0,0,4]
 * <strong>输出：</strong>1
 * </pre>
 * 
 * <p>&nbsp;</p>
 * 
 * <p><strong>提示：</strong></p>
 * 
 * <ul>
 * 	<li><code>1 &lt;= n &lt;= 10^4</code></li>
 * 	<li><code>ranges.length == n + 1</code></li>
 * 	<li><code>0 &lt;= ranges[i] &lt;= 100</code></li>
 * </ul>
 * 
 * 
 * @author Leammin
 * @date 2023-02-21
 */
public interface MinimumNumberOfTapsToOpenToWaterAGarden {
    int minTaps(int n, int[] ranges);

    static Testsuite<MinimumNumberOfTapsToOpenToWaterAGarden> testsuite() {
        return Testsuite.<MinimumNumberOfTapsToOpenToWaterAGarden>builder()
                .addExpected(t -> t.minTaps(5, new int[]{3,4,1,1,0,0}), 1)
                .addExpected(t -> t.minTaps(3, new int[]{0,0,0,0}), -1)
                .addExpected(t -> t.minTaps(7, new int[]{1,2,1,0,2,1,0,1}), 3)
                .addExpected(t -> t.minTaps(8, new int[]{4,0,0,0,4,0,0,0,4}), 1)
                .build();
    }


    class Solution implements MinimumNumberOfTapsToOpenToWaterAGarden {

        @Override
        public int minTaps(int n, int[] ranges) {
            return minTapsDP(0, n, ranges, new int[n]);
        }

        private int minTapsDP(int start, int n, int[] ranges, int[] dp) {
            if (dp[start] > 0) {
                return dp[start];
            }
            List<Integer> taps = taps(start, ranges);
            if (taps.isEmpty()) {
                return -1;
            }
            int min = Integer.MAX_VALUE;
            for (Integer tap : taps) {
                int next = ranges[tap] + tap;
                if (next >= n) {
                    return 1;
                }
                int nextMinTaps = minTapsDP(next, n, ranges, dp);
                if (nextMinTaps < 0) {
                    return -1;
                }
                if (nextMinTaps < min) {
                    min = nextMinTaps;
                }
            }

            return dp[start] = min + 1;
        }

        private List<Integer> taps(int i, int[] ranges) {
            List<Integer> l = new ArrayList<>();
            for (int j = Math.max(0, i - 100); j <= i + 100 && j < ranges.length; j++) {
                if (ranges[j] == 0) {
                    continue;
                }
                if (i >= j - ranges[j] && i < j + ranges[j]) {
                    l.add(j);
                }
            }
            return l;
        }
    }

    class Solution2 implements MinimumNumberOfTapsToOpenToWaterAGarden {
        @Override
        public int minTaps(int n, int[] ranges) {
            List<Integer>[] taps = new List[n];
            for (int i = 0; i < n + 1; i++) {
                if (ranges[i] == 0) {
                    continue;
                }
                for (int j = Math.max(0, i - ranges[i]); j < i + ranges[i] && j < n; j++) {
                    if (taps[j] == null) {
                        taps[j] = new ArrayList<>();
                    }
                    taps[j].add(i);
                }
            }
            return minTapsDP(0, n, ranges, taps, new int[n]);
        }

        public int minTapsDP(int start, int n, int[] ranges, List<Integer>[] taps, int[] dp) {
            if (dp[start] > 0) {
                return dp[start];
            }
            if (taps[start] == null || taps[start].isEmpty()) {
                return -1;
            }
            int min = Integer.MAX_VALUE;
            for (Integer tap : taps[start]) {
                int next = ranges[tap] + tap;
                if (next >= n) {
                    return 1;
                }
                int nextMinTaps = minTapsDP(next, n, ranges, taps, dp);
                if (nextMinTaps < 0) {
                    return -1;
                }
                if (nextMinTaps < min) {
                    min = nextMinTaps;
                }
            }

            return dp[start] = min + 1;
        }
    }


    class Solution3 implements MinimumNumberOfTapsToOpenToWaterAGarden {
        @Override
        public int minTaps(int n, int[] ranges) {
            int res = 0;
            for (int i = n - 1; i >= 0;) {
                int leftmost = Integer.MAX_VALUE;
                for (int j = Math.max(0, i - 100); j <= i + 100 && j < ranges.length; j++) {
                    if (ranges[j] == 0) {
                        continue;
                    }
                    if (i >= j - ranges[j] && i < j + ranges[j]) {
                        leftmost = Math.min(leftmost, j - ranges[j]);
                    }
                }
                if (leftmost == Integer.MAX_VALUE) {
                    return -1;
                }
                res++;
                i = leftmost - 1;
            }
            return res;
        }

    }
}

class MinimumNumberOfTapsToOpenToWaterAGardenTest extends AbstractTest<MinimumNumberOfTapsToOpenToWaterAGarden> {
}
