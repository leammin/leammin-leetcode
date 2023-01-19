package com.leammin.leetcode.medium;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * 5708. 统计一个数组中好对子的数目
 *
 * <p>给你一个数组 <code>nums</code> ，数组中只包含非负整数。定义 <code>rev(x)</code> 的值为将整数 <code>x</code> 各个数字位反转得到的结果。比方说 <code>rev(123) = 321</code> ， <code>rev(120) = 21</code> 。我们称满足下面条件的下标对 <code>(i, j)</code> 是 <strong>好的</strong> ：</p>
 *
 * <ul>
 * 	<li><code>0 &lt;= i &lt; j &lt; nums.length</code></li>
 * 	<li><code>nums[i] + rev(nums[j]) == nums[j] + rev(nums[i])</code></li>
 * </ul>
 *
 * <p>请你返回好下标对的数目。由于结果可能会很大，请将结果对 <code>10<sup>9</sup> + 7</code> <b>取余</b> 后返回。</p>
 *
 * <p> </p>
 *
 * <p><strong>示例 1：</strong></p>
 *
 * <pre><b>输入：</b>nums = [42,11,1,97]
 * <b>输出：</b>2
 * <b>解释：</b>两个坐标对为：
 *  - (0,3)：42 + rev(97) = 42 + 79 = 121, 97 + rev(42) = 97 + 24 = 121 。
 *  - (1,2)：11 + rev(1) = 11 + 1 = 12, 1 + rev(11) = 1 + 11 = 12 。
 * </pre>
 *
 * <p><strong>示例 2：</strong></p>
 *
 * <pre><b>输入：</b>nums = [13,10,35,24,76]
 * <b>输出：</b>4
 * </pre>
 *
 * <p> </p>
 *
 * <p><strong>提示：</strong></p>
 *
 * <ul>
 * 	<li><code>1 &lt;= nums.length &lt;= 10<sup>5</sup></code></li>
 * 	<li><code>0 &lt;= nums[i] &lt;= 10<sup>9</sup></code></li>
 * </ul>
 *
 * @author Leammin
 * @date 2023-01-18
 */
public interface CountNicePairsInAnArray {
    int countNicePairs(int[] nums);

    class Solution implements CountNicePairsInAnArray {

        @Override
        public int countNicePairs(int[] nums) {
            Map<Integer, Integer> count = new HashMap<>();
            for (int n : nums) {
                count.compute(n - rev(n), (k, ov) -> ov == null ? 1 : ov + 1);
            }
            long result = 0;
            for (Map.Entry<Integer, Integer> entry : count.entrySet()) {
                long lv = entry.getValue().longValue();
                result += (lv * (lv - 1) / 2);
            }
            return (int) (result % 1000_000_007);
        }

        private int rev(int num) {
            int r = 0;
            while (num > 0) {
                int x = num % 10;
                r *= 10;
                r += x;
                num /= 10;
            }
            return r;
        }
    }
}
