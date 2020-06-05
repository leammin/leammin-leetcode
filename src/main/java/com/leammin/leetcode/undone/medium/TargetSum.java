package com.leammin.leetcode.undone.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * 494. 目标和
 *
 * <p>给定一个非负整数数组，a1, a2, ..., an, 和一个目标数，S。现在你有两个符号&nbsp;<code>+</code>&nbsp;和&nbsp;<code>-</code>。对于数组中的任意一个整数，你都可以从&nbsp;<code>+</code>&nbsp;或&nbsp;<code>-</code>中选择一个符号添加在前面。</p>
 *
 * <p>返回可以使最终数组和为目标数 S 的所有添加符号的方法数。</p>
 *
 * <p><strong>示例 1:</strong></p>
 *
 * <pre><strong>输入:</strong> nums: [1, 1, 1, 1, 1], S: 3
 * <strong>输出:</strong> 5
 * <strong>解释:</strong>
 *
 * -1+1+1+1+1 = 3
 * +1-1+1+1+1 = 3
 * +1+1-1+1+1 = 3
 * +1+1+1-1+1 = 3
 * +1+1+1+1-1 = 3
 *
 * 一共有5种方法让最终目标和为3。
 * </pre>
 *
 * <p><strong>注意:</strong></p>
 *
 * <ol>
 * 	<li>数组非空，且长度不会超过20。</li>
 * 	<li>初始的数组的和不会超过1000。</li>
 * 	<li>保证返回的最终结果能被32位整数存下。</li>
 * </ol>
 *
 * @author Leammin
 * @date 2020-06-04
 */
public interface TargetSum {
    int findTargetSumWays(int[] nums, int S);

    class Solution implements TargetSum {

        @Override
        public int findTargetSumWays(int[] nums, int S) {
            int res = 0;
            int[] stack = new int[nums.length];
            int size = 0;
            stack[size++] = 1;
            int sum = nums[0];
            while (size > 0) {
                while (size < nums.length) {
                    stack[size++] = 1;
                    sum += stack[size - 1] * nums[size - 1];
                }
                if (sum == S) {
                    res++;
                }
                int top;
                while (size > 0 && (top = stack[size - 1]) < 0) {
                    sum -= stack[--size] * nums[size];
                }
                if (size > 0) {
                    top = stack[--size] * nums[size];
                    sum -= top;

                    stack[size++] = -1;
                    sum += (-top);
                }
            }
            return res;
        }
    }

    class Solution2 implements TargetSum {
        @Override
        public int findTargetSumWays(int[] nums, int S) {
            int right = 0;
            for (int num : nums) {
                right += num;
            }
            return dfs(nums, S, 0, 0, new Map[nums.length], right);
        }

        private int dfs(int[] nums, int S, int cur, int sum, Map<Integer, Integer>[] cache, int right) {
            if (cur == nums.length) {
                return S == sum ? 1 : 0;
            }
            if (sum + right < S || sum - right > S) {
                return 0;
            }
            if (cache[cur] == null) {
                cache[cur] = new HashMap<>();
            }
            Integer res;
            if ((res = cache[cur].get(sum)) != null) {
                return res;
            }
            res = dfs(nums, S, cur + 1, sum + nums[cur], cache, right - nums[cur]) +
                    dfs(nums, S, cur + 1, sum - nums[cur], cache, right - nums[cur]);
            cache[cur].put(sum, res);
            return res;
        }
    }


}
