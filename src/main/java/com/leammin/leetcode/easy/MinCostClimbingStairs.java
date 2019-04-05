package com.leammin.leetcode.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * 746. 使用最小花费爬楼梯
 *
 * <div><p>数组的每个索引做为一个阶梯，第&nbsp;<code>i</code>个阶梯对应着一个非负数的体力花费值&nbsp;<code>cost[i]</code>(索引从0开始)。</p>
 *
 * <p>每当你爬上一个阶梯你都要花费对应的体力花费值，然后你可以选择继续爬一个阶梯或者爬两个阶梯。</p>
 *
 * <p>您需要找到达到楼层顶部的最低花费。在开始时，你可以选择从索引为 0 或 1 的元素作为初始阶梯。</p>
 *
 * <p><strong>示例&nbsp;1:</strong></p>
 *
 * <pre><strong>输入:</strong> cost = [10, 15, 20]
 * <strong>输出:</strong> 15
 * <strong>解释:</strong> 最低花费是从cost[1]开始，然后走两步即可到阶梯顶，一共花费15。
 * </pre>
 *
 * <p><strong>&nbsp;示例 2:</strong></p>
 *
 * <pre><strong>输入:</strong> cost = [1, 100, 1, 1, 1, 100, 1, 1, 100, 1]
 * <strong>输出:</strong> 6
 * <strong>解释:</strong> 最低花费方式是从cost[0]开始，逐个经过那些1，跳过cost[3]，一共花费6。
 * </pre>
 *
 * <p><strong>注意：</strong></p>
 *
 * <ol>
 * <li><code>cost</code>&nbsp;的长度将会在&nbsp;<code>[2, 1000]</code>。</li>
 * <li>每一个&nbsp;<code>cost[i]</code> 将会是一个Integer类型，范围为&nbsp;<code>[0, 999]</code>。</li>
 * </ol>
 * </div>
 *
 * @author Leammin
 * @date 2019-03-17
 */
public interface MinCostClimbingStairs {
    int minCostClimbingStairs(int[] cost);

    class Solution implements MinCostClimbingStairs {
        @Override
        public int minCostClimbingStairs(int[] cost) {
            switch (cost.length) {
                case 0:
                    return 0;
                case 1:
                    return cost[0];
                default:
                    int l = cost[0];
                    int r = cost[1];
                    for (int i = 2; i < cost.length; i++) {
                        int t = (l < r ? l : r) + cost[i];
                        l = r;
                        r = t;
                    }
                    return l < r ? l : r;
            }
        }
    }

    class Solution1 implements MinCostClimbingStairs {
        @Override
        public int minCostClimbingStairs(int[] cost) {
            int n = cost.length;
            switch (n) {
                case 0:
                    return 0;
                case 1:
                    return cost[0];
                case 2:
                    return Math.min(cost[0], cost[1]);
                case 3:
                    return Math.min(cost[0] + cost[2], cost[1]);
                case 4:
                    return Math.min(Math.min(cost[0] + cost[2], cost[1] + cost[2]), cost[1] + cost[3]);
                default:
                    Map<String, Integer> costs = new HashMap<>((int) ((n - 2) * (n - 3) / 1.5F + 1.0F));
                    return Math.min(
                            Math.min(
                                    minCost(cost, 0, n - 1, costs),
                                    minCost(cost, 0, n - 2, costs)
                            ),
                            Math.min(
                                    minCost(cost, 1, n - 1, costs),
                                    minCost(cost, 1, n - 2, costs)
                            )
                    );
            }
        }

        private int minCost(int[] cost, int start, int end, Map<String, Integer> costs) {
            if (start == end) {
                return cost[start];
            }
            if (end - start == 1 || end - start == 2) {
                return cost[start] + cost[end];
            }
            return costs.computeIfAbsent(start + "," + end, s -> cost[start] + Math.min(
                    minCost(cost, start + 1, end, costs),
                    minCost(cost, start + 2, end, costs)));
        }
    }



}
