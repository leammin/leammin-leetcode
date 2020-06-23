package com.leammin.leetcode.undone.hard;

import com.leammin.leetcode.util.Execute;

/**
 * 410. 分割数组的最大值
 *
 * <p>给定一个非负整数数组和一个整数&nbsp;<em>m</em>，你需要将这个数组分成&nbsp;<em>m&nbsp;</em>个非空的连续子数组。设计一个算法使得这&nbsp;<em>m&nbsp;</em>个子数组各自和的最大值最小。</p>
 *
 * <p><strong>注意:</strong><br />
 * 数组长度&nbsp;<em>n&nbsp;</em>满足以下条件:</p>
 *
 * <ul>
 * 	<li>1 &le; <em>n</em> &le; 1000</li>
 * 	<li>1 &le; <em>m</em> &le; min(50, <em>n</em>)</li>
 * </ul>
 *
 * <p><strong>示例: </strong></p>
 *
 * <pre>
 * 输入:
 * <strong>nums</strong> = [7,2,5,10,8]
 * <strong>m</strong> = 2
 *
 * 输出:
 * 18
 *
 * 解释:
 * 一共有四种方法将<strong>nums</strong>分割为2个子数组。
 * 其中最好的方式是将其分为<strong>[7,2,5]</strong> 和 <strong>[10,8]</strong>，
 * 因为此时这两个子数组各自的和的最大值为18，在所有情况中最小。
 * </pre>
 *
 *
 * @author Leammin
 * @date 2020-06-22
 */
public interface SplitArrayLargestSum {
    int splitArray(int[] nums, int m);

    class Solution implements SplitArrayLargestSum {

        @Override
        public int splitArray(int[] nums, int m) {
            int[] sum = new int[nums.length];
            sum[0] = nums[0];
            for (int i = 1; i < nums.length; i++) {
                sum[i] = nums[i] + sum[i - 1];
            }
            return splitArray(sum, m, 0);
        }

        private int splitArray(int[] sum, int m, int from) {
            if (m == 1) {
                return sum[sum.length - 1] - (from == 0 ? 0 : sum[from - 1]);
            }
            int min = Integer.MAX_VALUE;
            for (int end = from; end <= sum.length - m; end++) {
                int fsum = sum[end] - (from == 0 ? 0 : sum[from - 1]);
                int msa = splitArray(sum, m - 1, end + 1);
                min = Math.min(min, Math.max(fsum, msa));
            }
            return min;
        }
    }

    /**
     * dp[m][from] = min(max(dp[m - 1][from + i], sum(from, from +i)))
     */
//    @Execute
    class Solution2 implements SplitArrayLargestSum {

        @Override
        public int splitArray(int[] nums, int m) {
            int sum = 0;
            int[][] dp = new int[m][nums.length];
            for (int j = nums.length - 1; j >= 0; j--) {
                dp[0][j] = (sum += nums[j]);
            }
            for (int i = 1; i < dp.length; i++) {
                for (int j = nums.length - 1 - i; j >= 0; j--) {
                    int min = Integer.MAX_VALUE;
                    for (int k = j + 1; k <= nums.length - i; k++) {
                        min = Math.min(min, Math.max(dp[i - 1][k], dp[0][j] - dp[0][k]));
                    }
                    dp[i][j] = min;
                }
            }
            return dp[m - 1][0];
        }
    }

    @Execute
    class Solution3 implements SplitArrayLargestSum {

        @Override
        public int splitArray(int[] nums, int m) {
            int[] sum = new int[nums.length];
            sum[nums.length - 1] = nums[nums.length - 1];
            for (int i = nums.length - 2; i >= 0; i--) {
                sum[i] = nums[i] + sum[i + 1];
            }
            int[] dp = sum;
            for (int i = 1; i < m; i++) {
                int[] next = new int[nums.length];
                for (int j = nums.length - 1 - i; j >= 0; j--) {
                    int min = Integer.MAX_VALUE;
                    for (int k = j + 1; k <= nums.length - i; k++) {
                        min = Math.min(min, Math.max(dp[k], sum[j] - sum[k]));
                    }
                    next[j] = min;
                }
                dp = next;
            }
            return dp[0];
        }
    }
}
