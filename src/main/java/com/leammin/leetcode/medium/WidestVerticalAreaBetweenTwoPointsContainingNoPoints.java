package com.leammin.leetcode.medium;

import com.leammin.leetcode.util.test.AbstractTest;
import com.leammin.leetcode.util.test.Testsuite;

import java.util.Arrays;
import java.util.Comparator;

/**
 * <a href="https://leetcode.cn/problems/widest-vertical-area-between-two-points-containing-no-points/">1637. 两点之间不包含任何点的最宽垂直面积</a>
 * 
 * <p>给你 <code>n</code> 个二维平面上的点 <code>points</code> ，其中 <code>points[i] = [x<sub>i</sub>, y<sub>i</sub>]</code> ，请你返回两点之间内部不包含任何点的 <strong>最宽垂直面积</strong> 的宽度。</p>
 * 
 * <p><strong>垂直面积</strong> 的定义是固定宽度，而 y 轴上无限延伸的一块区域（也就是高度为无穷大）。 <strong>最宽垂直面积</strong> 为宽度最大的一个垂直面积。</p>
 * 
 * <p>请注意，垂直区域 <strong>边上</strong> 的点 <strong>不在</strong> 区域内。</p>
 * 
 * <p> </p>
 * 
 * <p><strong>示例 1：</strong></p>
 * <img alt="" src="https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2020/10/31/points3.png" style="width: 276px; height: 371px;" />​
 * <pre>
 * <b>输入：</b>points = [[8,7],[9,9],[7,4],[9,7]]
 * <b>输出：</b>1
 * <b>解释：</b>红色区域和蓝色区域都是最优区域。
 * </pre>
 * 
 * <p><strong>示例 2：</strong></p>
 * 
 * <pre>
 * <b>输入：</b>points = [[3,1],[9,0],[1,0],[1,4],[5,3],[8,8]]
 * <b>输出：</b>3
 * </pre>
 * 
 * <p> </p>
 * 
 * <p><strong>提示：</strong></p>
 * 
 * <ul>
 * 	<li><code>n == points.length</code></li>
 * 	<li><code>2 <= n <= 10<sup>5</sup></code></li>
 * 	<li><code>points[i].length == 2</code></li>
 * 	<li><code>0 <= x<sub>i</sub>, y<sub>i</sub> <= 10<sup>9</sup></code></li>
 * </ul>
 * 
 * 
 * @author Leammin
 * @date 2023-03-30
 */
public interface WidestVerticalAreaBetweenTwoPointsContainingNoPoints {
    int maxWidthOfVerticalArea(int[][] points);
    static Testsuite<WidestVerticalAreaBetweenTwoPointsContainingNoPoints> testsuite() {
        return Testsuite.<WidestVerticalAreaBetweenTwoPointsContainingNoPoints>builder()
                .build();
    }

    class Solution implements WidestVerticalAreaBetweenTwoPointsContainingNoPoints {

        public int maxWidthOfVerticalArea(int[][] points) {
            Arrays.sort(points, Comparator.comparingInt(p -> p[0]));
            int max = 0;
            for (int i = 1; i < points.length; i++) {
                max = Math.max(max, points[i][0] - points[i - 1][0]);
            }
            return max;
        }
    }
}

class WidestVerticalAreaBetweenTwoPointsContainingNoPointsTest extends AbstractTest<WidestVerticalAreaBetweenTwoPointsContainingNoPoints> {
}
