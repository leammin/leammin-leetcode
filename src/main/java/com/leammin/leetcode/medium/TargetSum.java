package com.leammin.leetcode.medium;

import java.util.Arrays;

import com.leammin.leetcode.util.test.AbstractTest;
import com.leammin.leetcode.util.test.ExpectedTestcase;
import com.leammin.leetcode.util.test.Testsuite;

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

    static Testsuite<TargetSum> testsuite() {
        return Testsuite.<TargetSum>builder()
                .add(ExpectedTestcase.of(t -> t.findTargetSumWays(new int[]{1, 1, 1, 1, 1}, 3), 5))
                .add(ExpectedTestcase.of(t -> t.findTargetSumWays(new int[]{1, 0}, 1), 2))
                .add(ExpectedTestcase.of(t -> t.findTargetSumWays(new int[]{7,9,3,8,0,2,4,8,3,9}, 0), 0))
                .add(ExpectedTestcase.of(t -> t.findTargetSumWays(new int[]{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}, 0), 1048576))
                .add(ExpectedTestcase.of(t -> t.findTargetSumWays(new int[]{1000}, 1000), 1))
                .build();
    }


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
            int zero = 0;
            int right = 0;
            for (int i = 0; i < nums.length; i++) {
                right += nums[i];
                if (nums[i] == 0) {
                    nums[i] = nums[zero];
                    nums[zero++] = 0;
                }
            }
            if (zero == nums.length) {
                return S == 0 ? (int) Math.pow(2, zero) : 0;
            }
            int[][] cache = new int[nums.length - zero][2 * right + 1];
            for (int[] ints : cache) {
                Arrays.fill(ints, Integer.MIN_VALUE);
            }
            return (int) Math.pow(2, zero) * dfs(nums, S, zero, 0, cache, right, zero);
        }

        private int dfs(int[] nums, int S, int cur, int sum, int[][] cache, int right, int zero) {
            if (cur == nums.length) {
                return S == sum ? 1 : 0;
            }
            if (sum + right == S || sum - right == S) {
                return 1;
            }
            if (sum + right < S || sum - right > S) {
                return 0;
            }
            int j = sum + cache[0].length / 2;
            int res;
            if ((res = cache[cur - zero][j]) != Integer.MIN_VALUE) {
                return res;
            }
            if (nums[cur] == 0) {
                return cache[cur - zero][j] = 2 * dfs(nums, S, cur + 1, sum, cache, right, zero - 1);
            } else {
                return cache[cur - zero][j] = dfs(nums, S, cur + 1, sum + nums[cur], cache, right - nums[cur], zero) +
                        dfs(nums, S, cur + 1, sum - nums[cur], cache, right - nums[cur], zero);
            }
        }
    }

    class Solution3 implements TargetSum {

        @Override
        public int findTargetSumWays(int[] nums, int S) {
            if (S > 1000 || S < -1000) {
                return 0;
            }
            int[] sum = new int[2001];
            sum[1000] = 1;
            for (int i = 0; i < nums.length; i++) {
                int[] newSum = new int[2001];
                for (int j = 0; j < sum.length; j++) {
                    if (sum[j] > 0) {
                        newSum[j + nums[i]] += sum[j];
                        newSum[j - nums[i]] += sum[j];
                    }
                }
                sum = newSum;
            }
            return sum[S + 1000];
        }
    }

}

class TargetSumTest extends AbstractTest<TargetSum> {
}
