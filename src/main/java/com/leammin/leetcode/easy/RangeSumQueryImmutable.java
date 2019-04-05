package com.leammin.leetcode.easy;

/**
 * 303. 区域和检索 - 数组不可变
 *
 * <div><p>给定一个整数数组 &nbsp;<em>nums</em>，求出数组从索引&nbsp;<em>i&nbsp;</em>到&nbsp;<em>j&nbsp;&nbsp;</em>(<em>i</em>&nbsp;≤&nbsp;<em>j</em>) 范围内元素的总和，包含&nbsp;<em>i,&nbsp; j&nbsp;</em>两点。</p>
 *
 * <p><strong>示例：</strong></p>
 *
 * <pre>给定 nums = [-2, 0, 3, -5, 2, -1]，求和函数为 sumRange()
 *
 * sumRange(0, 2) -&gt; 1
 * sumRange(2, 5) -&gt; -1
 * sumRange(0, 5) -&gt; -3</pre>
 *
 * <p><strong>说明:</strong></p>
 *
 * <ol>
 * <li>你可以假设数组不可变。</li>
 * <li>会多次调用&nbsp;<em>sumRange</em>&nbsp;方法。</li>
 * </ol>
 * </div>
 *
 * @author Leammin
 * @date 2019-03-17
 */
public abstract class RangeSumQueryImmutable {
    RangeSumQueryImmutable(int[] nums) {
    }

    public abstract int sumRange(int i, int j);

    public static class Solution extends RangeSumQueryImmutable {
        private int[] sum;
        private int[] nums;

        public Solution(int[] nums) {
            super(nums);
            this.nums = nums;
            sum = new int[nums.length];
            if (nums.length != 0) {
                sum[0] = nums[0];
                for (int i = 1; i < sum.length; i++) {
                    sum[i] = sum[i - 1] + nums[i];
                }
            }
        }

        @Override
        public int sumRange(int i, int j) {
            if (i == j) {
                return nums[i];
            }
            if (i == 0) {
                return sum[j];
            }
            return sum[j] - sum[i - 1];
        }
    }
}
