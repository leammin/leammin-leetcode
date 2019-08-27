package com.leammin.leetcode.undone.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 1095. 两地调度
 *
 * <p>公司计划面试 <code>2N</code> 人。第 <code>i</code> 人飞往 <code>A</code> 市的费用为 <code>costs[i][0]</code>，飞往 <code>B</code> 市的费用为 <code>costs[i][1]</code>。</p>
 *
 * <p>返回将每个人都飞到某座城市的最低费用，要求每个城市都有 <code>N</code> 人抵达<strong>。</strong></p>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>示例：</strong></p>
 *
 * <pre><strong>输入：</strong>[[10,20],[30,200],[400,50],[30,20]]
 * <strong>输出：</strong>110
 * <strong>解释：</strong>
 * 第一个人去 A 市，费用为 10。
 * 第二个人去 A 市，费用为 30。
 * 第三个人去 B 市，费用为 50。
 * 第四个人去 B 市，费用为 20。
 *
 * 最低总费用为 10 + 30 + 50 + 20 = 110，每个城市都有一半的人在面试。
 * </pre>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>提示：</strong></p>
 *
 * <ol>
 * 	<li><code>1 &lt;= costs.length &lt;= 100</code></li>
 * 	<li><code>costs.length</code> 为偶数</li>
 * 	<li><code>1 &lt;= costs[i][0], costs[i][1] &lt;= 1000</code></li>
 * </ol>
 *
 * @author Leammin
 * @date 2019-08-27
 */
public interface TwoCityScheduling {
    int twoCitySchedCost(int[][] costs);

    class Solution implements TwoCityScheduling {
        @Override
        public int twoCitySchedCost(int[][] costs) {
            int ab = costs.length;
            int[] diff = new int[ab];
            List<Integer> toA = new ArrayList<>(ab);
            List<Integer> toB = new ArrayList<>(ab);
            for (int i = 0; i < costs.length; i++) {
                diff[i] = costs[i][0] - costs[i][1];
                if (diff[i] < 0) {
                    toA.add(i);
                } else {
                    toB.add(i);
                }
            }
            if (toA.size() != toB.size()) {
                List<Integer> more;
                List<Integer> less;
                if (toA.size() > toB.size()) {
                    more = toA;
                    less = toB;
                } else {
                    more = toB;
                    less = toA;
                }
                // 绝对值倒序
                more.sort((o1, o2) -> Integer.compare(Math.abs(diff[o2]), Math.abs(diff[o1])));
                while (more.size() != ab / 2) {
                    less.add(more.remove(more.size() - 1));
                }
            }
            int res = 0;
            for (Integer i : toA) {
                res += costs[i][0];
            }
            for (Integer i : toB) {
                res += costs[i][1];
            }
            return res;
        }
    }

    class Best implements TwoCityScheduling {
        @Override
        public int twoCitySchedCost(int[][] costs) {
            int res = 0, len = costs.length;
            int[] cz = new int[len];
            for (int i = 0; i < len; i++) {
                res += costs[i][0];
                cz[i] = costs[i][1] - costs[i][0];
            }
            Arrays.sort(cz);
            for (int i = 0; i < len / 2; i++)
                res += cz[i];
            return res;
        }
    }
}
