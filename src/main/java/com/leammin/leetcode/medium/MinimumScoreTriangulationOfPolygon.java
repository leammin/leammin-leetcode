package com.leammin.leetcode.medium;

import com.leammin.leetcode.util.test.AbstractTest;
import com.leammin.leetcode.util.test.Testsuite;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.cn/problems/minimum-score-triangulation-of-polygon/">1039. 多边形三角剖分的最低得分</a>
 *
 * <p>你有一个凸的<meta charset="UTF-8" />&nbsp;<code>n</code>&nbsp;边形，其每个顶点都有一个整数值。给定一个整数数组<meta charset="UTF-8" />&nbsp;<code>values</code>&nbsp;，其中<meta charset="UTF-8" />&nbsp;<code>values[i]</code>&nbsp;是第 <code>i</code> 个顶点的值（即 <strong>顺时针顺序</strong> ）。</p>
 *
 * <p>假设将多边形 <strong>剖分</strong>&nbsp;为 <code>n - 2</code>&nbsp;个三角形。对于每个三角形，该三角形的值是顶点标记的<strong>乘积</strong>，三角剖分的分数是进行三角剖分后所有 <code>n - 2</code>&nbsp;个三角形的值之和。</p>
 *
 * <p>返回 <em>多边形进行三角剖分后可以得到的最低分</em> 。<br />
 * &nbsp;</p>
 *
 * <ol>
 * </ol>
 *
 * <p><strong>示例 1：</strong></p>
 *
 * <p><img alt="" src="https://assets.leetcode.com/uploads/2021/02/25/shape1.jpg" /></p>
 *
 * <pre>
 * <strong>输入：</strong>values = [1,2,3]
 * <strong>输出：</strong>6
 * <strong>解释：</strong>多边形已经三角化，唯一三角形的分数为 6。
 * </pre>
 *
 * <p><strong>示例 2：</strong></p>
 *
 * <p><img alt="" src="https://assets.leetcode.com/uploads/2021/02/25/shape2.jpg" style="height: 163px; width: 446px;" /></p>
 *
 * <pre>
 * <strong>输入：</strong>values = [3,7,4,5]
 * <strong>输出：</strong>144
 * <strong>解释：</strong>有两种三角剖分，可能得分分别为：3*7*5 + 4*5*7 = 245，或 3*4*5 + 3*4*7 = 144。最低分数为 144。
 * </pre>
 *
 * <p><strong>示例 3：</strong></p>
 *
 * <p><img alt="" src="https://assets.leetcode.com/uploads/2021/02/25/shape3.jpg" /></p>
 *
 * <pre>
 * <strong>输入：</strong>values = [1,3,1,4,1,5]
 * <strong>输出：</strong>13
 * <strong>解释：</strong>最低分数三角剖分的得分情况为 1*1*3 + 1*1*4 + 1*1*5 + 1*1*1 = 13。
 * </pre>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>提示：</strong></p>
 *
 * <ul>
 * 	<li><code>n == values.length</code></li>
 * 	<li><code>3 &lt;= n &lt;= 50</code></li>
 * 	<li><code>1 &lt;= values[i] &lt;= 100</code></li>
 * </ul>
 *
 * @author Leammin
 * @date 2023-04-02
 */
public interface MinimumScoreTriangulationOfPolygon {
    int minScoreTriangulation(int[] values);

    static Testsuite<MinimumScoreTriangulationOfPolygon> testsuite() {
        return Testsuite.<MinimumScoreTriangulationOfPolygon>builder()
                .addExpected(t -> t.minScoreTriangulation(new int[]{4, 3, 4, 3, 5}), 132)
                .addExpected(t -> t.minScoreTriangulation(new int[]{1, 2, 3}), 6)
                .addExpected(t -> t.minScoreTriangulation(new int[]{3, 7, 4, 5}), 144)
                .addExpected(t -> t.minScoreTriangulation(new int[]{1, 3, 1, 4, 1, 5}), 13)
                .build();
    }

    class Solution implements MinimumScoreTriangulationOfPolygon {

        @Override
        public int minScoreTriangulation(int[] values) {
            return minScore(values, 0, values.length, new HashMap<>());
        }

        public int minScore(int[] values, long used, int count, Map<Long, Integer> dp) {
            if (dp.containsKey(used)) {
                return dp.get(used);
            }
            if (count < 3) {
                return 0;
            }
            if (count == 3) {
                int res = 1;
                for (int i = 0; i < values.length; i++) {
                    if ((used & (1L << i)) == 0) {
                        res *= values[i];
                    }
                }
                return res;
            }
            int first = -1;
            int sec = -1;
            int lastSec = -1;
            int last = -1;
            int a = -1;
            int b = -1;
            int res = Integer.MAX_VALUE;
            for (int i = 0; i < values.length; i++) {
                if ((used & (1L << i)) != 0) {
                    continue;
                }
                // unused
                if (first < 0) {
                    first = i;
                    a = i;
                    continue;
                }
                if (sec < 0) {
                    sec = i;
                    b = i;
                    continue;
                }
                int next = minScore(values, used | (1L << b), count - 1, dp);
                res = Math.min(res, values[a] * values[b] * values[i] + next);
                a = b;
                b = i;
                lastSec = last;
                last = i;
            }
            int next = minScore(values, used | (1L << last), count - 1, dp);
            res = Math.min(res, values[lastSec] * values[last] * values[first] + next);
            next = minScore(values, used | (1L << first), count - 1, dp);
            res = Math.min(res, values[last] * values[first] * values[sec] + next);
            dp.put(used, res);
            return res;
        }
    }


    class Solution2 implements MinimumScoreTriangulationOfPolygon {

        @Override
        public int minScoreTriangulation(int[] values) {
            return minScore(values, 0, values.length - 1, new int[values.length][values.length]);
        }

        private int minScore(int[] values, int from, int to, int[][] dp) {
            if (to - from < 2) {
                return 0;
            }
            if (dp[from][to] != 0) {
                return dp[from][to];
            }

            int min = Integer.MAX_VALUE;
            for (int i = from + 1; i <= to - 1; i++) {
                min = Math.min(min, values[from] * values[to] * values[i]
                        + minScore(values, from, i, dp)
                        + minScore(values, i, to, dp));
            }
            return dp[from][to] = min;
        }
    }
}

class MinimumScoreTriangulationOfPolygonTest extends AbstractTest<MinimumScoreTriangulationOfPolygon> {
}