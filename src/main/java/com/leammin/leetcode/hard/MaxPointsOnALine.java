package com.leammin.leetcode.hard;

import java.util.HashMap;
import java.util.Map;

import com.leammin.leetcode.util.test.AbstractTest;
import com.leammin.leetcode.util.test.Testsuite;

/**
 * 149. 直线上最多的点数
 * 
 * <p>给定一个二维平面，平面上有&nbsp;<em>n&nbsp;</em>个点，求最多有多少个点在同一条直线上。</p>
 * 
 * <p><strong>示例 1:</strong></p>
 * 
 * <pre><strong>输入:</strong> [[1,1],[2,2],[3,3]]
 * <strong>输出:</strong> 3
 * <strong>解释:</strong>
 * ^
 * |
 * | &nbsp; &nbsp; &nbsp; &nbsp;o
 * | &nbsp; &nbsp; o
 * | &nbsp;o &nbsp;
 * +-------------&gt;
 * 0 &nbsp;1 &nbsp;2 &nbsp;3  4
 * </pre>
 * 
 * <p><strong>示例&nbsp;2:</strong></p>
 * 
 * <pre><strong>输入:</strong> [[1,1],[3,2],[5,3],[4,1],[2,3],[1,4]]
 * <strong>输出:</strong> 4
 * <strong>解释:</strong>
 * ^
 * |
 * |  o
 * | &nbsp;&nbsp;&nbsp;&nbsp;o&nbsp;&nbsp;      o
 * | &nbsp;&nbsp;&nbsp;&nbsp;   o
 * | &nbsp;o &nbsp;      o
 * +-------------------&gt;
 * 0 &nbsp;1 &nbsp;2 &nbsp;3 &nbsp;4 &nbsp;5 &nbsp;6</pre>
 * 
 * 
 * @author Leammin
 * @date 2021-04-03
 */
public interface MaxPointsOnALine {
    int maxPoints(int[][] points);

    static Testsuite<MaxPointsOnALine> testsuite() {
        return Testsuite.<MaxPointsOnALine>builder()
                .addExpected(t -> t.maxPoints(new int[][]{{1, 1}, {2, 2}, {3, 3}}), 3)
                .addExpected(t -> t.maxPoints(new int[][]{{1, 1}, {3, 2}, {5, 3}, {4, 1}, {2, 3}, {1, 4}}), 4)
                .addExpected(t -> t.maxPoints(new int[][]{{2, 3}, {3, 3}, {-5, 3}}), 3)
                .build();
    }


    class Solution implements MaxPointsOnALine {

        @Override
        public int maxPoints(int[][] points) {
            int max = 1;
            for (int i = 0; i < points.length; i++) {
                int x0 = points[i][0], y0 = points[i][1];
                Map<Double, Integer> countSlope = new HashMap<>();
                int noSlope = 1;
                for (int j = i + 1; j < points.length; j++) {
                    int x1 = points[j][0], y1 = points[j][1];
                    if (x1 == x0) {
                        noSlope++;
                    } else {
                        double k = (y1 - y0) / (double) (x1 - x0) + 0.0;
                        int count = countSlope.compute(k, (key, value) -> value == null ? 2 : (value + 1));
                        max = Math.max(max, count);
                    }
                }
                max = Math.max(max, noSlope);
            }
            return max;
        }
    }
}

class MaxPointsOnALineTest extends AbstractTest<MaxPointsOnALine> {
}
