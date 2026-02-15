package com.leammin.leetcode.hard;

import com.leammin.leetcode.util.test.AbstractTest;
import com.leammin.leetcode.util.test.Testsuite;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.cn/problems/count-subarrays-with-median-k/">2488. 统计中位数为 K 的子数组</a>
 *
 * <p>给你一个长度为 <code>n</code> 的数组 <code>nums</code> ，该数组由从 <code>1</code> 到 <code>n</code> 的 <strong>不同</strong> 整数组成。另给你一个正整数 <code>k</code> 。</p>
 *
 * <p>统计并返回 <code>nums</code> 中的 <strong>中位数</strong> 等于 <code>k</code> 的非空子数组的数目。</p>
 *
 * <p><strong>注意：</strong></p>
 *
 * <ul>
 * 	<li>数组的中位数是按 <strong>递增</strong> 顺序排列后位于 <strong>中间</strong> 的那个元素，如果数组长度为偶数，则中位数是位于中间靠 <strong>左</strong> 的那个元素。
 *
 * 	<ul>
 * 		<li>例如，<code>[2,3,1,4]</code> 的中位数是 <code>2</code> ，<code>[8,4,3,5,1]</code> 的中位数是 <code>4</code> 。</li>
 * 	</ul>
 * 	</li>
 * 	<li>子数组是数组中的一个连续部分。</li>
 * </ul>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>示例 1：</strong></p>
 *
 * <pre>
 * <strong>输入：</strong>nums = [3,2,1,4,5], k = 4
 * <strong>输出：</strong>3
 * <strong>解释：</strong>中位数等于 4 的子数组有：[4]、[4,5] 和 [1,4,5] 。
 * </pre>
 *
 * <p><strong>示例 2：</strong></p>
 *
 * <pre>
 * <strong>输入：</strong>nums = [2,3,1], k = 3
 * <strong>输出：</strong>1
 * <strong>解释：</strong>[3] 是唯一一个中位数等于 3 的子数组。
 * </pre>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>提示：</strong></p>
 *
 * <ul>
 * 	<li><code>n == nums.length</code></li>
 * 	<li><code>1 &lt;= n &lt;= 10<sup>5</sup></code></li>
 * 	<li><code>1 &lt;= nums[i], k &lt;= n</code></li>
 * 	<li><code>nums</code> 中的整数互不相同</li>
 * </ul>
 *
 * @author Leammin
 * @date 2023-03-16
 */
public interface CountSubarraysWithMedianK {
    int countSubarrays(int[] nums, int k);

    static Testsuite<CountSubarraysWithMedianK> testsuite() {
        return Testsuite.<CountSubarraysWithMedianK>builder()
                .addExpected(t -> t.countSubarrays(new int[]{3,2,1,4,5}, 4), 3)
                .addExpected(t -> t.countSubarrays(new int[]{2,3,1}, 3), 1)
                .build();
    }

    class Solution implements CountSubarraysWithMedianK {

        @Override
        public int countSubarrays(int[] nums, int k) {
            int ki = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == k) {
                    ki = i;
                }
            }

            Map<Integer, Integer> count = new HashMap<>();
            count.put(0, 1);
            int res = 1;
            int small = 0;
            int large = 0;
            for (int i = ki - 1; i >= 0; i--) {
                if (nums[i] < k) {
                    small++;
                } else {
                    large++;
                }
                if (small == large || small + 1 == large) {
                    res++;
                }
                count.compute(large - small, (key, v) -> v == null ? 1 : v + 1);
            }

            small = 0;
            large = 0;
            for (int i = ki + 1; i < nums.length; i++) {
                if (nums[i] < k) {
                    small++;
                } else {
                    large++;
                }
                res += count.getOrDefault(small - large + 1, 0);
                res += count.getOrDefault(small - large, 0);
            }

            return res;
        }
    }
}

class CountSubarraysWithMedianKTest extends AbstractTest<CountSubarraysWithMedianK> {
}
