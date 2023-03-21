package com.leammin.leetcode.undone.hard;

import com.leammin.leetcode.util.Execute;
import com.leammin.leetcode.util.convert.IntMatrixConverter;
import com.leammin.leetcode.util.test.Testsuite;

/**
 * <a href="https://leetcode.cn/problems/count-subtrees-with-max-distance-between-cities/">1617. 统计子树中城市之间最大距离</a>
 *
 * <p>给你 <code>n</code> 个城市，编号为从 <code>1</code> 到 <code>n</code> 。同时给你一个大小为 <code>n-1</code> 的数组 <code>edges</code> ，其中 <code>edges[i] = [u<sub>i</sub>, v<sub>i</sub>]</code> 表示城市 <code>u<sub>i</sub></code> 和 <code>v<sub>i</sub></code><sub> </sub>之间有一条双向边。题目保证任意城市之间只有唯一的一条路径。换句话说，所有城市形成了一棵 <strong>树</strong> 。</p>
 *
 * <p>一棵 <strong>子树</strong> 是城市的一个子集，且子集中任意城市之间可以通过子集中的其他城市和边到达。两个子树被认为不一样的条件是至少有一个城市在其中一棵子树中存在，但在另一棵子树中不存在。</p>
 *
 * <p>对于 <code>d</code> 从 <code>1</code> 到 <code>n-1</code> ，请你找到城市间 <strong>最大距离</strong> 恰好为 <code>d</code> 的所有子树数目。</p>
 *
 * <p>请你返回一个大小为 <code>n-1</code> 的数组，其中第<em> </em><code>d</code><em> </em>个元素（<strong>下标从 1 开始</strong>）是城市间 <strong>最大距离</strong> 恰好等于 <code>d</code> 的子树数目。</p>
 *
 * <p><strong>请注意</strong>，两个城市间距离定义为它们之间需要经过的边的数目。</p>
 *
 * <p> </p>
 *
 * <p><strong>示例 1：</strong></p>
 *
 * <p><strong><img alt="" src="https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2020/10/11/p1.png" style="width: 161px; height: 181px;" /></strong></p>
 *
 * <pre>
 * <b>输入：</b>n = 4, edges = [[1,2],[2,3],[2,4]]
 * <b>输出：</b>[3,4,0]
 * <strong>解释：
 * </strong>子树 {1,2}, {2,3} 和 {2,4} 最大距离都是 1 。
 * 子树 {1,2,3}, {1,2,4}, {2,3,4} 和 {1,2,3,4} 最大距离都为 2 。
 * 不存在城市间最大距离为 3 的子树。
 * </pre>
 *
 * <p><strong>示例 2：</strong></p>
 *
 * <pre>
 * <b>输入：</b>n = 2, edges = [[1,2]]
 * <b>输出：</b>[1]
 * </pre>
 *
 * <p><strong>示例 3：</strong></p>
 *
 * <pre>
 * <b>输入：</b>n = 3, edges = [[1,2],[2,3]]
 * <b>输出：</b>[2,1]
 * </pre>
 *
 * <p> </p>
 *
 * <p><strong>提示：</strong></p>
 *
 * <ul>
 * 	<li><code>2 <= n <= 15</code></li>
 * 	<li><code>edges.length == n-1</code></li>
 * 	<li><code>edges[i].length == 2</code></li>
 * 	<li><code>1 <= u<sub>i</sub>, v<sub>i</sub> <= n</code></li>
 * 	<li>题目保证 <code>(u<sub>i</sub>, v<sub>i</sub>)</code> 所表示的边互不相同。</li>
 * </ul>
 *
 * @author Leammin
 * @date 2023-03-17
 */
public interface CountSubtreesWithMaxDistanceBetweenCities {
    int[] countSubgraphsForEachDiameter(int n, int[][] edges);

    static Testsuite<CountSubtreesWithMaxDistanceBetweenCities> testsuite() {
        return Testsuite.<CountSubtreesWithMaxDistanceBetweenCities>builder()
                .addExpected(t -> t.countSubgraphsForEachDiameter(4, new IntMatrixConverter().convert("[[1,2],[2,3],[2,4]]")), new int[]{3, 4, 0})
                .build();
    }

    class Solution implements CountSubtreesWithMaxDistanceBetweenCities {

        @Override
        public int[] countSubgraphsForEachDiameter(int n, int[][] edges) {
            int[][] dis = new int[n + 1][n + 1];
            for (int i = 0; i < edges.length; i++) {
                dis[edges[i][0]][edges[i][1]] = 1;
                dis[edges[i][1]][edges[i][0]] = 1;
            }
            for (int i = 1; i < dis.length; i++) {
                for (int j = 1; j < dis.length; j++) {
                    if (dis[i][j] > 0 && i != j) {
                        // i -> j 距离是 dis[i][j]
                        // 那么 所有能到i的节点，都能到j，距离是 dis[k][i]+dis[i][j]
                        for (int k = 1; k < dis.length; k++) {
                            if (dis[k][i] > 0 && k != i && k != j) {
                                dis[k][j] = dis[k][j] == 0 ? dis[k][i] + dis[i][j] : Math.min(dis[k][i] + dis[i][j], dis[k][j]);
                            }
                        }
                    }
                }
            }

            int[] res = new int[n - 1];
            for (int i = 0; i < res.length; i++) {
                int d = i + 1;
            }

            return new int[0];
        }
    }
}

