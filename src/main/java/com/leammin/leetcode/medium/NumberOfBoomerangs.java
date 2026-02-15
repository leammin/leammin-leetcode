package com.leammin.leetcode.medium;

import java.util.HashMap;
import java.util.Map;

import com.leammin.leetcode.util.test.AbstractTest;
import com.leammin.leetcode.util.test.Testsuite;

/**
 * 447. 回旋镖的数量
 * 
 * <p>给定平面上<em> </em><code>n</code><em> </em>对 <strong>互不相同</strong> 的点 <code>points</code> ，其中 <code>points[i] = [x<sub>i</sub>, y<sub>i</sub>]</code> 。<strong>回旋镖</strong> 是由点 <code>(i, j, k)</code> 表示的元组 ，其中 <code>i</code> 和 <code>j</code> 之间的距离和 <code>i</code> 和 <code>k</code> 之间的距离相等（<strong>需要考虑元组的顺序</strong>）。</p>
 * 
 * <p>返回平面上所有回旋镖的数量。</p>
 *  
 * 
 * <p><strong>示例 1：</strong></p>
 * 
 * <pre>
 * <strong>输入：</strong>points = [[0,0],[1,0],[2,0]]
 * <strong>输出：</strong>2
 * <strong>解释：</strong>两个回旋镖为 <strong>[[1,0],[0,0],[2,0]]</strong> 和 <strong>[[1,0],[2,0],[0,0]]</strong>
 * </pre>
 * 
 * <p><strong>示例 2：</strong></p>
 * 
 * <pre>
 * <strong>输入：</strong>points = [[1,1],[2,2],[3,3]]
 * <strong>输出：</strong>2
 * </pre>
 * 
 * <p><strong>示例 3：</strong></p>
 * 
 * <pre>
 * <strong>输入：</strong>points = [[1,1]]
 * <strong>输出：</strong>0
 * </pre>
 * 
 * <p> </p>
 * 
 * <p><strong>提示：</strong></p>
 * 
 * <ul>
 * 	<li><code>n == points.length</code></li>
 * 	<li><code>1 <= n <= 500</code></li>
 * 	<li><code>points[i].length == 2</code></li>
 * 	<li><code>-10<sup>4</sup> <= x<sub>i</sub>, y<sub>i</sub> <= 10<sup>4</sup></code></li>
 * 	<li>所有点都 <strong>互不相同</strong></li>
 * </ul>
 * 
 * 
 * @author Leammin
 * @date 2021-04-01
 */
public interface NumberOfBoomerangs {
    int numberOfBoomerangs(int[][] points);

    static Testsuite<NumberOfBoomerangs> testsuite() {
        return Testsuite.<NumberOfBoomerangs>builder()
                .addExpected(t -> t.numberOfBoomerangs(new int[][]{{0,0},{1,0},{2,0}}), 2)
                .addExpected(t -> t.numberOfBoomerangs(new int[][]{{1,1},{2,2},{3,3}}), 2)
                .addExpected(t -> t.numberOfBoomerangs(new int[][]{{1,1}}), 0)
                .build();
    }


    class Solution implements NumberOfBoomerangs {

        @Override
        public int numberOfBoomerangs(int[][] points) {
            int res = 0;
            for (int i = 0; i < points.length; i++) {
                Map<Integer, Integer> disCount = new HashMap<>();
                for (int j = 0; j < points.length; j++) {
                    if (i == j) {
                        continue;
                    }
                    int x = points[i][0] - points[j][0];
                    int y = points[i][1] - points[j][1];
                    int dis = x * x + y * y;
                    int count = disCount.getOrDefault(dis, 0);
                    disCount.put(dis, count + 1);
                    res += count * 2;
                }
            }
            return res;
        }
    }
}

class NumberOfBoomerangsTest extends AbstractTest<NumberOfBoomerangs> {
}
