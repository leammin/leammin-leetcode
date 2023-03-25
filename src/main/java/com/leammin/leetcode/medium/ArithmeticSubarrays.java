package com.leammin.leetcode.medium;

import com.leammin.leetcode.util.test.Testsuite;

import java.util.*;

/**
 * <a href="https://leetcode.cn/problems/arithmetic-subarrays/">1630. 等差子数组</a>
 *
 * <p>如果一个数列由至少两个元素组成，且每两个连续元素之间的差值都相同，那么这个序列就是 <strong>等差数列</strong> 。更正式地，数列 <code>s</code> 是等差数列，只需要满足：对于每个有效的 <code>i</code> ， <code>s[i+1] - s[i] == s[1] - s[0]</code> 都成立。</p>
 *
 * <p>例如，下面这些都是 <strong>等差数列</strong> ：</p>
 *
 * <pre>1, 3, 5, 7, 9
 * 7, 7, 7, 7
 * 3, -1, -5, -9</pre>
 *
 * <p>下面的数列 <strong>不是等差数列</strong> ：</p>
 *
 * <pre>1, 1, 2, 5, 7</pre>
 *
 * <p>给你一个由 <code>n</code> 个整数组成的数组 <code>nums</code>，和两个由 <code>m</code> 个整数组成的数组 <code>l</code> 和 <code>r</code>，后两个数组表示 <code>m</code> 组范围查询，其中第 <code>i</code> 个查询对应范围 <code>[l[i], r[i]]</code> 。所有数组的下标都是 <strong>从 0 开始</strong> 的。</p>
 *
 * <p>返回<em> </em><code>boolean</code> 元素构成的答案列表 <code>answer</code> 。如果子数组 <code>nums[l[i]], nums[l[i]+1], ... , nums[r[i]]</code> 可以 <strong>重新排列</strong> 形成 <strong>等差数列</strong> ，<code>answer[i]</code> 的值就是 <code>true</code>；否则<code>answer[i]</code> 的值就是 <code>false</code> 。</p>
 *
 * <p> </p>
 *
 * <p><strong>示例 1：</strong></p>
 *
 * <pre><strong>输入：</strong>nums = <code>[4,6,5,9,3,7]</code>, l = <code>[0,0,2]</code>, r = <code>[2,3,5]</code>
 * <strong>输出：</strong><code>[true,false,true]</code>
 * <strong>解释：</strong>
 * 第 0 个查询，对应子数组 [4,6,5] 。可以重新排列为等差数列 [6,5,4] 。
 * 第 1 个查询，对应子数组 [4,6,5,9] 。无法重新排列形成等差数列。
 * 第 2 个查询，对应子数组 <code>[5,9,3,7] 。</code>可以重新排列为等差数列 <code>[3,5,7,9] 。</code></pre>
 *
 * <p><strong>示例 2：</strong></p>
 *
 * <pre><strong>输入：</strong>nums = [-12,-9,-3,-12,-6,15,20,-25,-20,-15,-10], l = [0,1,6,4,8,7], r = [4,4,9,7,9,10]
 * <strong>输出：</strong>[false,true,false,false,true,true]
 * </pre>
 *
 * <p> </p>
 *
 * <p><strong>提示：</strong></p>
 *
 * <ul>
 * 	<li><code>n == nums.length</code></li>
 * 	<li><code>m == l.length</code></li>
 * 	<li><code>m == r.length</code></li>
 * 	<li><code>2 &lt;= n &lt;= 500</code></li>
 * 	<li><code>1 &lt;= m &lt;= 500</code></li>
 * 	<li><code>0 &lt;= l[i] &lt; r[i] &lt; n</code></li>
 * 	<li><code>-10<sup>5</sup> &lt;= nums[i] &lt;= 10<sup>5</sup></code></li>
 * </ul>
 *
 * @author Leammin
 * @date 2023-03-23
 */
public interface ArithmeticSubarrays {
    List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r);

    static Testsuite<ArithmeticSubarrays> testsuite() {
        return Testsuite.<ArithmeticSubarrays>builder()
                .addExpected(t -> t.checkArithmeticSubarrays(new int[]{4, 6, 5, 9, 3, 7}, new int[]{0, 0, 2}, new int[]{2, 3, 5}), List.of(true, false, true))
                .addExpected(t -> t.checkArithmeticSubarrays(new int[]{-12, -9, -3, -12, -6, 15, 20, -25, -20, -15, -10}, new int[]{0, 1, 6, 4, 8, 7}, new int[]{4, 4, 9, 7, 9, 10}), List.of(false, true, false, false, true, true))
                .addExpected(t -> t.checkArithmeticSubarrays(new int[]{4,6,5,9,3,7}, new int[]{0,0,2}, new int[]{2,3,5}), List.of(true,false,true))
                .build();
    }

    class Solution implements ArithmeticSubarrays {

        @Override
        public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
            List<Boolean> res = new ArrayList<>(l.length);
            for (int i = 0; i < l.length; i++) {
                int[] subarr = Arrays.copyOfRange(nums, l[i], r[i] + 1);
                Arrays.sort(subarr);
                boolean isArithmetic = true;
                for (int j = 1; j < subarr.length - 1; j++) {
                    if (subarr[j - 1] - subarr[j] != subarr[j] - subarr[j + 1]) {
                        isArithmetic = false;
                        break;
                    }
                }
                res.add(isArithmetic);
            }
            return res;
        }
    }

//    @Execute(cases = 1)
    class Solution2 implements ArithmeticSubarrays {

        @Override
        public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
            List<Boolean> res = new ArrayList<>(l.length);
            for (int i = 0; i < l.length; i++) {
                if (l[i] + 1 >= r[i]) {
                    res.add(true);
                    continue;
                }
                int min = Integer.MAX_VALUE;
                int sec = Integer.MAX_VALUE;
                int max = Integer.MIN_VALUE;
                for (int j = l[i]; j <= r[i]; j++) {
                    max = Math.max(max, nums[j]);
                    if (nums[j] <= min) {
                        sec = min;
                        min = nums[j];
                    } else if (nums[j] < sec) {
                        sec = nums[j];
                    }
                }
                int k = sec - min;
                if (min + k * (r[i] - l[i]) != max) {
                    res.add(false);
                    continue;
                }
                if (min == max) {
                    res.add(true);
                    continue;
                }
                boolean is = true;
                boolean[] contains = new boolean[r[i] - l[i] + 1];
                for (int j = l[i]; j <= r[i]; j++) {
                    if ((nums[j] - min) % k != 0) {
                        is = false;
                        break;
                    }
                    int x = (nums[j] - min) / k;
                    if (contains[x]) {
                        is = false;
                        break;
                    }
                    contains[x] = true;
                }
                res.add(is);
            }
            return res;
        }
    }
}
