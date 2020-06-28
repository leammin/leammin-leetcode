package com.leammin.leetcode.medium;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * 347. 前 K 个高频元素
 * 
 * <p>给定一个非空的整数数组，返回其中出现频率前&nbsp;<strong><em>k&nbsp;</em></strong>高的元素。</p>
 * 
 * <p><strong>示例 1:</strong></p>
 * 
 * <pre><strong>输入: </strong>nums = [1,1,1,2,2,3], k = 2
 * <strong>输出: </strong>[1,2]
 * </pre>
 * 
 * <p><strong>示例 2:</strong></p>
 * 
 * <pre><strong>输入: </strong>nums = [1], k = 1
 * <strong>输出: </strong>[1]</pre>
 * 
 * <p><strong>说明：</strong></p>
 * 
 * <ul>
 * 	<li>你可以假设给定的&nbsp;<em>k&nbsp;</em>总是合理的，且 1 &le; k &le; 数组中不相同的元素的个数。</li>
 * 	<li>你的算法的时间复杂度<strong>必须</strong>优于 O(<em>n</em> log <em>n</em>) ,&nbsp;<em>n&nbsp;</em>是数组的大小。</li>
 * </ul>
 * 
 * 
 * @author Leammin
 * @date 2020-03-28
 */
public interface TopKFrequentElements {
    int[] topKFrequent(int[] nums, int k);

    class Solution implements TopKFrequentElements {

        @Override
        public int[] topKFrequent(int[] nums, int k) {
            Map<Integer, Integer> count = new HashMap<>();
            for (int num : nums) {
                count.compute(num, (key, value) -> value == null ? 1 : value + 1);
            }
            PriorityQueue<Integer> queue = new PriorityQueue<>(k, Comparator.comparingInt(o -> count.getOrDefault(o, 0)));
            for (Integer num : count.keySet()) {
                queue.add(num);
                if (queue.size() > k) {
                    queue.poll();
                }
            }
            int[] res = new int[queue.size()];
            int i = 0;
            for (Integer num : queue) {
                res[i++] = num;
            }
            return res;
        }
    }
}
