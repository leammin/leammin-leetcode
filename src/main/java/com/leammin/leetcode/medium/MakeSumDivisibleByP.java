package com.leammin.leetcode.medium;

import com.leammin.leetcode.util.test.AbstractTest;
import com.leammin.leetcode.util.test.Testsuite;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.cn/problems/make-sum-divisible-by-p/">1590. 使数组和能被 P 整除</a>
 * 
 * <p>给你一个正整数数组&nbsp;<code>nums</code>，请你移除 <strong>最短</strong>&nbsp;子数组（可以为 <strong>空</strong>），使得剩余元素的 <strong>和</strong>&nbsp;能被 <code>p</code>&nbsp;整除。 <strong>不允许</strong>&nbsp;将整个数组都移除。</p>
 * 
 * <p>请你返回你需要移除的最短子数组的长度，如果无法满足题目要求，返回 <code>-1</code>&nbsp;。</p>
 * 
 * <p><strong>子数组</strong>&nbsp;定义为原数组中连续的一组元素。</p>
 * 
 * <p>&nbsp;</p>
 * 
 * <p><strong>示例 1：</strong></p>
 * 
 * <pre><strong>输入：</strong>nums = [3,1,4,2], p = 6
 * <strong>输出：</strong>1
 * <strong>解释：</strong>nums 中元素和为 10，不能被 p 整除。我们可以移除子数组 [4] ，剩余元素的和为 6 。
 * </pre>
 * 
 * <p><strong>示例 2：</strong></p>
 * 
 * <pre><strong>输入：</strong>nums = [6,3,5,2], p = 9
 * <strong>输出：</strong>2
 * <strong>解释：</strong>我们无法移除任何一个元素使得和被 9 整除，最优方案是移除子数组 [5,2] ，剩余元素为 [6,3]，和为 9 。
 * </pre>
 * 
 * <p><strong>示例&nbsp;3：</strong></p>
 * 
 * <pre><strong>输入：</strong>nums = [1,2,3], p = 3
 * <strong>输出：</strong>0
 * <strong>解释：</strong>和恰好为 6 ，已经能被 3 整除了。所以我们不需要移除任何元素。
 * </pre>
 * 
 * <p><strong>示例&nbsp; 4：</strong></p>
 * 
 * <pre><strong>输入：</strong>nums = [1,2,3], p = 7
 * <strong>输出：</strong>-1
 * <strong>解释：</strong>没有任何方案使得移除子数组后剩余元素的和被 7 整除。
 * </pre>
 * 
 * <p><strong>示例 5：</strong></p>
 * 
 * <pre><strong>输入：</strong>nums = [1000000000,1000000000,1000000000], p = 3
 * <strong>输出：</strong>0
 * </pre>
 * 
 * <p>&nbsp;</p>
 * 
 * <p><strong>提示：</strong></p>
 * 
 * <ul>
 * 	<li><code>1 &lt;= nums.length &lt;= 10<sup>5</sup></code></li>
 * 	<li><code>1 &lt;= nums[i] &lt;= 10<sup>9</sup></code></li>
 * 	<li><code>1 &lt;= p &lt;= 10<sup>9</sup></code></li>
 * </ul>
 * 
 * 
 * @author Leammin
 * @date 2023-03-10
 */
public interface MakeSumDivisibleByP {
    int minSubarray(int[] nums, int p);

    static Testsuite<MakeSumDivisibleByP> testsuite() {
        return Testsuite.<MakeSumDivisibleByP>builder()
                .addExpected(t -> t.minSubarray(new int[]{3,1,4,2}, 6), 1)
                .addExpected(t -> t.minSubarray(new int[]{6,3,5,2}, 9), 2)
                .addExpected(t -> t.minSubarray(new int[]{1,2,3}, 3), 0)
                .addExpected(t -> t.minSubarray(new int[]{1,2,3}, 7), -1)
                .build();
    }

    class Solution implements MakeSumDivisibleByP {

        @Override
        public int minSubarray(int[] nums, int p) {
            long sum = 0;
            for (int num : nums) {
                sum += num;
            }
            if (sum < p) {
                return -1;
            }
            int x = (int) (sum % p);
            if (x == 0) {
                return 0;
            }
            int res = nums.length;
            for (int i = 0; i < nums.length; i++) {
                long sub = 0;
                for (int j = i; j < nums.length; j++) {
                    sub += nums[j];
                    if (sub % p == x) {
                        res = Math.min(j - i + 1, res);
                    }
                }
            }
            return res == nums.length ? -1 : res;
        }
    }


    class Solution2 implements MakeSumDivisibleByP {

        @Override
        public int minSubarray(int[] nums, int p) {
            long sum = 0;
            for (int num : nums) {
                sum += num;
            }
            if (sum < p) {
                return -1;
            }
            int x = (int) (sum % p);
            if (x == 0) {
                return 0;
            }
            int res = nums.length;
            for (int i = 0; i < nums.length; i++) {
                long sub = 0;
                for (int j = i; j < nums.length; j++) {
                    if (nums[j] == x) {
                        return 1;
                    }
                    sub += nums[j];
                    if (sub % p == x) {
                        res = Math.min(j - i + 1, res);
                    }
                }
            }
            return res == nums.length ? -1 : res;
        }
    }

    class Solution3 implements MakeSumDivisibleByP {

        @Override
        public int minSubarray(int[] nums, int p) {
            int a = 0;
            for(int i = 0; i < nums.length; i++) {
                a = (nums[i] + a) % p;

            }
            if (a == 0) {
                return 0;
            }

            int res = nums.length;
            int last = 0;
            Map<Integer, Integer> m = new HashMap<>();
            m.put(0, -1);
            for(int i = 0; i < nums.length; i++) {
                int x = (nums[i] + last) % p;
                last = x;
                int y = x - a;
                if (y < 0) {
                    y += p;
                }
                Integer j = m.get(y);
                if (j != null) {
                    res = Math.min(i - j, res);
                }
                m.put(x, i);
            }
            return res == nums.length ? -1 : res;
        }
    }
}

class MakeSumDivisibleByPTest extends AbstractTest<MakeSumDivisibleByP> {
}
