package com.leammin.leetcode.hard;

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

    class Solution4 implements SplitArrayLargestSum {

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
                    next[j] = getMin(sum, dp, j, nums.length - i);
                }
                dp = next;
            }
            return dp[0];
        }

        private static int getMin(int[] sum, int[] dp, int j, int end) {
            int lo = j + 1;
            int hi = end;
            while (lo < hi - 1) {
                int mid = lo + (hi - lo) / 2;
                if (dp[mid] > sum[j] - sum[mid]) {
                    lo = mid;
                } else if (dp[mid] < sum[j] - sum[mid]) {
                    hi = mid;
                } else {
                    return dp[mid];
                }
            }
            return Math.min(Math.max(dp[lo], sum[j] - sum[lo]), Math.max(dp[hi], sum[j] - sum[hi]));
        }
    }

    class Solution5 implements SplitArrayLargestSum {

        @Override
        public int splitArray(int[] nums, int m) {
            long[] sums = new long[nums.length];
            long sum = 0;
            int max = 0;
            for (int i = 0; i < nums.length; i++) {
                sums[i] = (sum += nums[i]);
                max = Math.max(max, nums[i]);
            }
            if (m == 1) {
                return (int) sum;
            }
            long lo = max;
            long hi = sum;
            int res = 0;
            while (lo <= hi) {
                long mid = lo + (hi - lo) / 2;
                int[] split = splitSizeAndSplitMax(sums, mid);
                int splitSize = split[0];
                if (splitSize > m) {
                    lo = mid + 1;
                } else {
                    hi = mid - 1;
                    res = split[1];
                }
            }
            return res;
        }

        private int[] splitSizeAndSplitMax(long[] sums, long target) {
            int max = 0;
            int size = 0;
            int i = 0;
            while (i < sums.length) {
                long t = target + (i == 0 ? 0 : sums[i - 1]);
                int bs = bs(sums, i, sums.length, t);
                if (bs == i) {
                    return new int[]{Integer.MAX_VALUE, Integer.MAX_VALUE};
                }
                max = (int) Math.max(max, sums[bs - 1] - (i == 0 ? 0 : sums[i - 1]));
                i = bs;
                size++;
            }
            return new int[]{size, max};
        }

        private int bs(long[] sums, int from, int to, long key) {
            int low = from;
            int high = to - 1;

            while (low <= high) {
                int mid = (low + high) >>> 1;
                long midVal = sums[mid];

                if (midVal < key)
                    low = mid + 1;
                else if (midVal > key)
                    high = mid - 1;
                else
                    return mid; // key found
            }

            return low;
        }
    }
}
