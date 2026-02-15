package com.leammin.leetcode.medium;

import com.leammin.leetcode.util.convert.IntMatrixConverter;
import com.leammin.leetcode.util.test.AbstractTest;
import com.leammin.leetcode.util.test.Testsuite;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/maximal-network-rank/">1615. 最大网络秩</a>
 *
 * <p><code>n</code> 座城市和一些连接这些城市的道路 <code>roads</code> 共同组成一个基础设施网络。每个 <code>roads[i] = [a<sub>i</sub>, b<sub>i</sub>]</code> 都表示在城市 <code>a<sub>i</sub></code> 和 <code>b<sub>i</sub></code> 之间有一条双向道路。</p>
 *
 * <p>两座不同城市构成的 <strong>城市对</strong> 的 <strong>网络秩</strong> 定义为：与这两座城市 <strong>直接</strong> 相连的道路总数。如果存在一条道路直接连接这两座城市，则这条道路只计算 <strong>一次</strong> 。</p>
 *
 * <p>整个基础设施网络的 <strong>最大网络秩</strong> 是所有不同城市对中的 <strong>最大网络秩</strong> 。</p>
 *
 * <p>给你整数 <code>n</code> 和数组 <code>roads</code>，返回整个基础设施网络的 <strong>最大网络秩</strong> 。</p>
 *
 * <p> </p>
 *
 * <p><strong>示例 1：</strong></p>
 *
 * <p><strong><img alt="" src="https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2020/10/11/ex1.png" style="width: 292px; height: 172px;" /></strong></p>
 *
 * <pre>
 * <strong>输入：</strong>n = 4, roads = [[0,1],[0,3],[1,2],[1,3]]
 * <strong>输出：</strong>4
 * <strong>解释：</strong>城市 0 和 1 的网络秩是 4，因为共有 4 条道路与城市 0 或 1 相连。位于 0 和 1 之间的道路只计算一次。
 * </pre>
 *
 * <p><strong>示例 2：</strong></p>
 *
 * <p><strong><img alt="" src="https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2020/10/11/ex2.png" style="width: 292px; height: 172px;" /></strong></p>
 *
 * <pre>
 * <strong>输入：</strong>n = 5, roads = [[0,1],[0,3],[1,2],[1,3],[2,3],[2,4]]
 * <strong>输出：</strong>5
 * <strong>解释：</strong>共有 5 条道路与城市 1 或 2 相连。
 * </pre>
 *
 * <p><strong>示例 3：</strong></p>
 *
 * <pre>
 * <strong>输入：</strong>n = 8, roads = [[0,1],[1,2],[2,3],[2,4],[5,6],[5,7]]
 * <strong>输出：</strong>5
 * <strong>解释：</strong>2 和 5 的网络秩为 5，注意并非所有的城市都需要连接起来。
 * </pre>
 *
 * <p> </p>
 *
 * <p><strong>提示：</strong></p>
 *
 * <ul>
 * 	<li><code>2 <= n <= 100</code></li>
 * 	<li><code>0 <= roads.length <= n * (n - 1) / 2</code></li>
 * 	<li><code>roads[i].length == 2</code></li>
 * 	<li><code>0 <= a<sub>i</sub>, b<sub>i</sub> <= n-1</code></li>
 * 	<li><code>a<sub>i</sub> != b<sub>i</sub></code></li>
 * 	<li>每对城市之间 <strong>最多只有一条</strong> 道路相连</li>
 * </ul>
 *
 * @author Leammin
 * @date 2023-03-17
 */
public interface MaximalNetworkRank {
    public int maximalNetworkRank(int n, int[][] roads);

    static Testsuite<MaximalNetworkRank> testsuite() {
        return Testsuite.<MaximalNetworkRank>builder()
                .addExpected(t -> t.maximalNetworkRank(4, new IntMatrixConverter().convert("[[0,1],[0,3],[1,2],[1,3]]")), 4)
                .addExpected(t -> t.maximalNetworkRank(5, new IntMatrixConverter().convert("[[0,1],[0,3],[1,2],[1,3],[2,3],[2,4]]")), 5)
                .addExpected(t -> t.maximalNetworkRank(8, new IntMatrixConverter().convert("[[0,1],[1,2],[2,3],[2,4],[5,6],[5,7]]")), 5)
                .addExpected(t -> t.maximalNetworkRank(2, new IntMatrixConverter().convert("[[1,0]]")), 1)
                .build();
    }

    class Solution implements MaximalNetworkRank {

        @Override
        public int maximalNetworkRank(int n, int[][] roads) {
            int[] c = new int[n];
            boolean[][] net = new boolean[n][n];
            for (int[] road : roads) {
                c[road[0]]++;
                c[road[1]]++;
                net[road[0]][road[1]] = true;
                net[road[1]][road[0]] = true;
            }

            List<Integer> sti = new ArrayList<>();
            List<Integer> ndi = new ArrayList<>();
            int st = 0;
            int nd = 0;
            for (int i = 0; i < c.length; i++) {
                if (c[i] == st) {
                    sti.add(i);
                } else if (c[i] > st) {
                    nd = st;
                    ndi = sti;
                    st = c[i];
                    sti = new ArrayList<>();
                    sti.add(i);
                } else if (c[i] > nd) {
                    nd = c[i];
                    ndi = new ArrayList<>();
                    ndi.add(i);
                } else if (c[i] == nd) {
                    ndi.add(i);
                }
            }

            if (sti.size() > 1) {
                for (int i = 0; i < sti.size(); i++) {
                    for (int j = i + 1; j < sti.size(); j++) {
                        if (!net[sti.get(i)][sti.get(j)]) {
                            return st + st;
                        }
                    }
                }
                return st + st - 1;
            }
            for (Integer i : ndi) {
                if (!net[sti.get(0)][i]) {
                    return st + nd;
                }
            }
            return st + nd - 1;
        }
    }
}

class MaximalNetworkRankTest extends AbstractTest<MaximalNetworkRank> {
}
