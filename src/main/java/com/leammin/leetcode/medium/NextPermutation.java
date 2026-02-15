package com.leammin.leetcode.medium;

import com.leammin.leetcode.util.test.AbstractTest;
import com.leammin.leetcode.util.test.ExpectedTestcase;
import com.leammin.leetcode.util.test.Testsuite;

/**
 * 31. 下一个排列
 * 
 * <p>实现获取下一个排列的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。</p>
 * 
 * <p>如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。</p>
 * 
 * <p>必须<strong><a href="https://baike.baidu.com/item/%E5%8E%9F%E5%9C%B0%E7%AE%97%E6%B3%95" target="_blank">原地</a></strong>修改，只允许使用额外常数空间。</p>
 * 
 * <p>以下是一些例子，输入位于左侧列，其相应输出位于右侧列。<br>
 * <code>1,2,3</code> &rarr; <code>1,3,2</code><br>
 * <code>3,2,1</code> &rarr; <code>1,2,3</code><br>
 * <code>1,1,5</code> &rarr; <code>1,5,1</code></p>
 * 
 * 
 * @author Leammin
 * @date 2021-01-09
 */
public interface NextPermutation {
    void nextPermutation(int[] nums);

    static Testsuite<NextPermutation> testsuite() {
        return Testsuite.<NextPermutation>builder()
                .add(ExpectedTestcase.of(t -> {
                    int[] nums = {1, 2, 3};
                    t.nextPermutation(nums);
                    return nums;
                }, new int[]{1, 3, 2}))
                .add(ExpectedTestcase.of(t -> {
                    int[] nums = {3, 2, 1};
                    t.nextPermutation(nums);
                    return nums;
                }, new int[]{1, 2, 3}))
                .add(ExpectedTestcase.of(t -> {
                    int[] nums = {1, 1, 5};
                    t.nextPermutation(nums);
                    return nums;
                }, new int[]{1, 5, 1}))
                .add(ExpectedTestcase.of(t -> {
                    int[] nums = {1,3,2};
                    t.nextPermutation(nums);
                    return nums;
                }, new int[]{2,1,3}))
                .add(ExpectedTestcase.of(t -> {
                    int[] nums = {2,2,7,5,4,3,2,2,1};
                    t.nextPermutation(nums);
                    return nums;
                }, new int[]{2,3,1,2,2,2,4,5,7}))
                .build();
    }


    class Solution implements NextPermutation {

        @Override
        public void nextPermutation(int[] nums) {
            int index = nums.length - 2;
            while (index >= 0 && nums[index] >= nums[index + 1]) {
                index--;
            }
            if (index >= 0) {
                swap(nums, index, findNextKey(nums, index + 1, nums.length, nums[index]));
            }
            reverse(nums, index + 1, nums.length);
        }

        private void reverse(int[] array, int from, int to) {
            for (int i = 0; i < (to - from) / 2; i++) {
                swap(array, i + from, to - i - 1);
            }
        }

        private void swap(int[] array, int i, int j) {
            int t = array[i];
            array[i] = array[j];
            array[j] = t;
        }

        private int findNextKey(int[] a, int from, int to, int key) {
            int low = from;
            int high = to - 1;

            while (low <= high) {
                int mid = (low + high) >>> 1;
                int midVal = a[mid];

                if (midVal <= key) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
            return low - 1;
        }
    }
}

class NextPermutationTest extends AbstractTest<NextPermutation> {
}
