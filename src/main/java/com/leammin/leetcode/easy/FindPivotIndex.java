package com.leammin.leetcode.easy;

import com.leammin.leetcode.util.test.AbstractTest;
import com.leammin.leetcode.util.test.ExpectedTestcase;
import com.leammin.leetcode.util.test.Testsuite;

/**
 * 724. 寻找数组的中心索引
 * 
 * <p>给定一个整数类型的数组&nbsp;<code>nums</code>，请编写一个能够返回数组<strong>&ldquo;中心索引&rdquo;</strong>的方法。</p>
 * 
 * <p>我们是这样定义数组<strong>中心索引</strong>的：数组中心索引的左侧所有元素相加的和等于右侧所有元素相加的和。</p>
 * 
 * <p>如果数组不存在中心索引，那么我们应该返回 -1。如果数组有多个中心索引，那么我们应该返回最靠近左边的那一个。</p>
 * 
 * <p><strong>示例 1:</strong></p>
 * 
 * <pre>
 * <strong>输入:</strong> 
 * nums = [1, 7, 3, 6, 5, 6]
 * <strong>输出:</strong> 3
 * <strong>解释:</strong> 
 * 索引3 (nums[3] = 6) 的左侧数之和(1 + 7 + 3 = 11)，与右侧数之和(5 + 6 = 11)相等。
 * 同时, 3 也是第一个符合要求的中心索引。
 * </pre>
 * 
 * <p><strong>示例 2:</strong></p>
 * 
 * <pre>
 * <strong>输入:</strong> 
 * nums = [1, 2, 3]
 * <strong>输出:</strong> -1
 * <strong>解释:</strong> 
 * 数组中不存在满足此条件的中心索引。</pre>
 * 
 * <p><strong>说明:</strong></p>
 * 
 * <ul>
 * 	<li><code>nums</code> 的长度范围为&nbsp;<code>[0, 10000]</code>。</li>
 * 	<li>任何一个&nbsp;<code>nums[i]</code> 将会是一个范围在&nbsp;<code>[-1000, 1000]</code>的整数。</li>
 * </ul>
 * 
 * 
 * @author Leammin
 * @date 2020-06-12
 */
public interface FindPivotIndex {
    int pivotIndex(int[] nums);

    static Testsuite<FindPivotIndex> testsuite() {
        return Testsuite.<FindPivotIndex>builder()
                .add(ExpectedTestcase.of(t -> t.pivotIndex(new int[]{1, 7, 3, 6, 5, 6}), 3))
                .add(ExpectedTestcase.of(t -> t.pivotIndex(new int[]{1, 2, 3}), -1))
                .build();
    }


    class Solution implements FindPivotIndex {

        @Override
        public int pivotIndex(int[] nums) {
            int left = 0;
            int right = 0;
            for (int i = 1; i < nums.length; i++) {
                right += nums[i];
            }
            for (int i = 0; i < nums.length; i++) {
                if (left == right) {
                    return i;
                }
                left += nums[i];
                if (i + 1 < nums.length) {
                    right -= nums[i + 1];
                }
            }
            return -1;
        }
    }
}

class FindPivotIndexTest extends AbstractTest<FindPivotIndex> {
}
