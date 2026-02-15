package com.leammin.leetcode.easy;

import com.leammin.leetcode.util.test.AbstractTest;
import com.leammin.leetcode.util.test.ExpectedTestcase;
import com.leammin.leetcode.util.test.Testsuite;

/**
 * 189. 旋转数组
 *
 * <div><p>给定一个数组，将数组中的元素向右移动&nbsp;<em>k&nbsp;</em>个位置，其中&nbsp;<em>k&nbsp;</em>是非负数。</p>
 *
 * <p><strong>示例 1:</strong></p>
 *
 * <pre><strong>输入:</strong> <code>[1,2,3,4,5,6,7]</code> 和 <em>k</em> = 3
 * <strong>输出:</strong> <code>[5,6,7,1,2,3,4]</code>
 * <strong>解释:</strong>
 * 向右旋转 1 步: <code>[7,1,2,3,4,5,6]</code>
 * 向右旋转 2 步: <code>[6,7,1,2,3,4,5]
 * </code>向右旋转 3 步: <code>[5,6,7,1,2,3,4]</code>
 * </pre>
 *
 * <p><strong>示例&nbsp;2:</strong></p>
 *
 * <pre><strong>输入:</strong> <code>[-1,-100,3,99]</code> 和 <em>k</em> = 2
 * <strong>输出:</strong> [3,99,-1,-100]
 * <strong>解释:</strong>
 * 向右旋转 1 步: [99,-1,-100,3]
 * 向右旋转 2 步: [3,99,-1,-100]</pre>
 *
 * <p><strong>说明:</strong></p>
 *
 * <ul>
 * <li>尽可能想出更多的解决方案，至少有三种不同的方法可以解决这个问题。</li>
 * <li>要求使用空间复杂度为&nbsp;O(1) 的原地算法。</li>
 * </ul>
 * </div>
 *
 * @author Leammin
 * @date 2018-09-01
 */
public interface RotateArray {
    void rotate(int[] nums, int k);

    /**
     * 通过三次反转
     * 时间复杂度 O(n)
     * 空间复杂度 O(1)
     */

    static Testsuite<RotateArray> testsuite() {
        return Testsuite.<RotateArray>builder()
                .add(ExpectedTestcase.of(
                        t -> {
                            int[] nums = new int[]{1, 2, 3, 4, 5, 6,};
                            t.rotate(nums, 3);
                            return nums;
                        }, new int[]{4, 5, 6, 1, 2, 3,}
                ))
                .add(ExpectedTestcase.of(
                        t -> {
                            int[] nums = new int[]{1, 2, 3, 4, 5, 6, 7};
                            t.rotate(nums, 4);
                            return nums;
                        }, new int[]{4, 5, 6, 7, 1, 2, 3,}
                ))
                .add(ExpectedTestcase.of(
                        t -> {
                            int[] nums = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10,};
                            t.rotate(nums, 4);
                            return nums;
                        }, new int[]{7, 8, 9, 10, 1, 2, 3, 4, 5, 6,}
                ))
                .build();
    }

    class Solution implements RotateArray {
        @Override
        public void rotate(int[] nums, int k) {
            if (nums == null || nums.length == 0 || k <= 0) {
                return;
            }
            int n = nums.length;
            k = k % n;
            if (k <= 0) {
                return;
            }

            reverse(nums, n - k, n);
            reverse(nums, 0, n - k);
            reverse(nums, 0, n);
        }

        private void reverse(int[] nums, int start, int end) {
            if (nums == null || nums.length < 1) {
                return;
            }

            for (int i = 0; i < (end + start) / 2 - start; i++) {
                int tmp = nums[start + i];
                nums[start + i] = nums[end - i - 1];
                nums[end - i - 1] = tmp;
            }
        }
    }

    /**
     * 最常规解法
     * 时间复杂度 O(nk)
     * 空间复杂度 O(1)
     */
    class Solution2 implements RotateArray {
        @Override
        public void rotate(int[] nums, int k) {
            if (nums == null || nums.length == 0 || k <= 0) {
                return;
            }
            int n = nums.length;
            k = k % n;
            if (k <= 0) {
                return;
            }
            for (int i = 0; i < k; i++) {
                int tail = nums[n - 1];
                System.arraycopy(nums, 0, nums, 1, n - 1);
                nums[0] = tail;
            }
        }
    }


    /**
     * 时间复杂度 O(n)
     * 空间复杂度 O(k)
     */
    class Solution3 implements RotateArray {
        @Override
        public void rotate(int[] nums, int k) {
            if (nums == null || nums.length == 0 || k <= 0) {
                return;
            }
            int n = nums.length;
            k = k % n;
            if (k <= 0) {
                return;
            }
            int[] cache = new int[k];
            System.arraycopy(nums, n - k, cache, 0, k);
            System.arraycopy(nums, 0, nums, k, n - k);
            System.arraycopy(cache, 0, nums, 0, k);
        }
    }
}

class RotateArrayTest extends AbstractTest<RotateArray> {
}
