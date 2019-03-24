package com.leammin.leetcode.easy;

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
 * @date 2018-09-01
 * @author Leammin
 */
public class RotateArray {
    public static void rotate(int[] nums, int k) {
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

    private static void reverse(int[] nums, int start, int end) {
        if (nums == null || nums.length < 1) {
            return;
        }

        int tmp = 0;
        for (int i = 0; i < (end + start) / 2 - start; i++) {
            tmp = nums[start + i];
            nums[start + i] = nums[end - i - 1];
            nums[end - i - 1] = tmp;
        }
    }

    public static void main(String[] args) {
        int[] nums = {0, 1, 2, 3, 4, 5, 6};
        rotate(nums, 7);
    }
}
