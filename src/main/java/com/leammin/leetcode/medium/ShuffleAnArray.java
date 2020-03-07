package com.leammin.leetcode.medium;

import java.util.Random;

/**
 * 384. 打乱数组
 *
 * <div><p>打乱一个没有重复元素的数组。</p>
 *
 * <p><strong>示例:</strong></p>
 *
 * <pre>// 以数字集合 1, 2 和 3 初始化数组。
 * int[] nums = {1,2,3};
 * Solution solution = new Solution(nums);
 *
 * // 打乱数组 [1,2,3] 并返回结果。任何 [1,2,3]的排列返回的概率应该相同。
 * solution.shuffle();
 *
 * // 重设数组到它的初始状态[1,2,3]。
 * solution.reset();
 *
 * // 随机返回数组[1,2,3]打乱后的结果。
 * solution.shuffle();
 * </pre>
 * </div>
 *
 * @author Leammin
 * @date 2018-08-31
 */
public abstract class ShuffleAnArray {
    /**
     * Your Solution object will be instantiated and called as such:
     * Solution obj = new Solution(nums);
     * int[] param_1 = obj.reset();
     * int[] param_2 = obj.shuffle();
     */
    public ShuffleAnArray(int[] nums) {
    }

    /**
     * Resets the array to its original configuration and return it.
     */
    public abstract int[] reset();

    /**
     * Returns a random shuffling of the array.
     */
    public abstract int[] shuffle();

    public static class Solution extends ShuffleAnArray {
        private int[] nums;


        public Solution(int[] nums) {
            super(nums);
            this.nums = copyArray(nums);
        }


        @Override
        public int[] reset() {
            return copyArray(nums);
        }


        @Override
        public int[] shuffle() {
            int[] newInts = copyArray(nums);

            Random random = new Random();
            for (int i = 1; i < newInts.length; i++) {
                int randomInt = random.nextInt(i + 1);
                int temp = newInts[randomInt];
                newInts[randomInt] = newInts[i];
                newInts[i] = temp;
            }
            return newInts;
        }

        private int[] copyArray(int[] src) {
            int[] dest = new int[src.length];
            return copyArray(src, dest);
        }

        private int[] copyArray(int[] src, int[] dest) {
            System.arraycopy(src, 0, dest, 0, src.length);
            return dest;
        }
    }
}
