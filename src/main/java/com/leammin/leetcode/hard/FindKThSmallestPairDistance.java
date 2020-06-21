package com.leammin.leetcode.hard;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 719. 找出第 k 小的距离对
 *
 * <p>给定一个整数数组，返回所有数对之间的第 k 个最小<strong>距离</strong>。一对 (A, B) 的距离被定义为 A 和 B 之间的绝对差值。</p>
 *
 * <p><strong>示例 1:</strong></p>
 *
 * <pre>
 * <strong>输入：</strong>
 * nums = [1,3,1]
 * k = 1
 * <strong>输出：0</strong>
 * <strong>解释：</strong>
 * 所有数对如下：
 * (1,3) -&gt; 2
 * (1,1) -&gt; 0
 * (3,1) -&gt; 2
 * 因此第 1 个最小距离的数对是 (1,1)，它们之间的距离为 0。
 * </pre>
 *
 * <p><strong>提示:</strong></p>
 *
 * <ol>
 * 	<li><code>2 &lt;= len(nums) &lt;= 10000</code>.</li>
 * 	<li><code>0 &lt;= nums[i] &lt; 1000000</code>.</li>
 * 	<li><code>1 &lt;= k &lt;= len(nums) * (len(nums) - 1) / 2</code>.</li>
 * </ol>
 *
 * @author Leammin
 * @date 2020-06-19
 */
public interface FindKThSmallestPairDistance {
    int smallestDistancePair(int[] nums, int k);

    class Solution implements FindKThSmallestPairDistance {

        @Override
        public int smallestDistancePair(int[] nums, int k) {
            PriorityQueue<Integer> queue = new PriorityQueue<>(k, Comparator.reverseOrder());
            for (int i = 0; i < nums.length; i++) {
                for (int j = i + 1; j < nums.length; j++) {
                    int v = Math.abs(nums[i] - nums[j]);
                    if (queue.size() == k) {
                        v = Math.min(v, queue.poll());
                    }
                    queue.add(v);
                }
            }
            return queue.peek();
        }
    }

    class Solution2 implements FindKThSmallestPairDistance {

        @Override
        public int smallestDistancePair(int[] nums, int k) {
            Arrays.sort(nums);
            int hi = nums[nums.length - 1] - nums[0];
            int lo = 0;
            while (true) {
                int mid = lo + (hi - lo) / 2;
                int max = 0;
                int count = 0;
                for (int i = 0; i < nums.length - 1; i++) {
                    int bs = binarySearchIndexDistance(nums, i, mid);
                    max = Math.max(max, nums[bs - 1] - nums[i]);
                    count += bs - i - 1;
                }
                if (count == k || lo >= hi) {
                    return max;
                }
                if (count < k) {
                    lo = mid + 1;
                } else {
                    hi = mid;
                }
            }
        }

        private static int binarySearchIndexDistance(int[] nums, int index, int key) {
            int lo = index + 1;
            int hi = nums.length - 1;
            while (lo <= hi) {
                int mid = lo + (hi - lo) / 2;
                if (nums[mid] - nums[index] <= key) {
                    lo = mid + 1;
                } else {
                    hi = mid - 1;
                }
            }
            return lo;
        }
    }


    class Solution3 implements FindKThSmallestPairDistance {

        @Override
        public int smallestDistancePair(int[] nums, int k) {
            Arrays.sort(nums);
            int hi = nums[nums.length - 1] - nums[0];
            int lo = 0;
            while (true) {
                int mid = lo + (hi - lo) / 2;
                int max = 0;
                int count = 0;
                int left = 0;
                for (int right = 0; right < nums.length; right++) {
                    while (nums[right] - nums[left] > mid) {
                        left++;
                    }
                    max = Math.max(max, nums[right] - nums[left]);
                    count += right - left;
                }
                if (count == k || lo >= hi) {
                    return max;
                }
                if (count < k) {
                    lo = mid + 1;
                } else {
                    hi = mid;
                }
            }
        }
    }
}
