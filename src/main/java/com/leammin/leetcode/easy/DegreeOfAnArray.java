package com.leammin.leetcode.easy;

import java.util.HashMap;
import java.util.Map;

import com.leammin.leetcode.util.test.AbstractTest;
import com.leammin.leetcode.util.test.ExpectedTestcase;
import com.leammin.leetcode.util.test.Testsuite;

/**
 * 697. 数组的度
 * 
 * <p>给定一个非空且只包含非负数的整数数组&nbsp;<code>nums</code>, 数组的度的定义是指数组里任一元素出现频数的最大值。</p>
 * 
 * <p>你的任务是找到与&nbsp;<code>nums</code>&nbsp;拥有相同大小的度的最短连续子数组，返回其长度。</p>
 * 
 * <p><strong>示例 1:</strong></p>
 * 
 * <pre>
 * <strong>输入:</strong> [1, 2, 2, 3, 1]
 * <strong>输出:</strong> 2
 * <strong>解释:</strong> 
 * 输入数组的度是2，因为元素1和2的出现频数最大，均为2.
 * 连续子数组里面拥有相同度的有如下所示:
 * [1, 2, 2, 3, 1], [1, 2, 2, 3], [2, 2, 3, 1], [1, 2, 2], [2, 2, 3], [2, 2]
 * 最短连续子数组[2, 2]的长度为2，所以返回2.
 * </pre>
 * 
 * <p><strong>示例 2:</strong></p>
 * 
 * <pre>
 * <strong>输入:</strong> [1,2,2,3,1,4,2]
 * <strong>输出:</strong> 6
 * </pre>
 * 
 * <p><strong>注意:</strong></p>
 * 
 * <ul>
 * 	<li><code>nums.length</code>&nbsp;在1到50,000区间范围内。</li>
 * 	<li><code>nums[i]</code>&nbsp;是一个在0到49,999范围内的整数。</li>
 * </ul>
 * 
 * 
 * @author Leammin
 * @date 2021-02-20
 */
public interface DegreeOfAnArray {
    int findShortestSubArray(int[] nums);

    static Testsuite<DegreeOfAnArray> testsuite() {
        return Testsuite.<DegreeOfAnArray>builder()
                .add(ExpectedTestcase.of(t -> t.findShortestSubArray(new int[]{1, 2, 2, 3, 1}), 2))
                .add(ExpectedTestcase.of(t -> t.findShortestSubArray(new int[]{1,2,2,3,1,4,2}), 6))
                .build();
    }


    class Solution implements DegreeOfAnArray {

        @Override
        public int findShortestSubArray(int[] nums) {
            Map<Integer, Integer> count = new HashMap<>();
            for (int num : nums) {
                count.compute(num, (k, v) -> v == null ? 1 : v + 1);
            }
            int max = 0;
            Map<Integer, int[]> maxPos = new HashMap<>();
            for (Map.Entry<Integer, Integer> entry : count.entrySet()) {
                if (entry.getValue() > max) {
                    maxPos = new HashMap<>();
                    max = entry.getValue();
                }
                if (entry.getValue() >= max) {
                    maxPos.put(entry.getKey(), new int[]{-1, -1});
                }
            }
            for (int i = 0; i < nums.length; i++) {
                int[] pos = maxPos.get(nums[i]);
                if (pos != null) {
                    if (pos[0] < 0) {
                        pos[0] = i;
                    }
                    pos[1] = i;
                }
            }
            int res = Integer.MAX_VALUE;
            for (int[] pos : maxPos.values()) {
                res = Math.min(res, pos[1] - pos[0] + 1);
            }
            return res;
        }
    }
}

class DegreeOfAnArrayTest extends AbstractTest<DegreeOfAnArray> {
}
