package com.leammin.leetcode.util;

import java.util.Arrays;

/**
 * @author xiebao.llm
 * @date 2021/04/22
 */
public interface Codes {
    class BinarySearch {
        /**
         * 二分查找，查找到key后直接返回下标。<br>
         * 若key不存在，则返回key到插入点：((-insertion point) - 1)。 <br>
         * 参考源码 {@link java.util.Arrays#binarySearch(int[], int, int, int)}
         */
        public int binarySearch(int[] nums, int from, int to, int key) {
            int low = from;
            int high = to - 1;

            while (low <= high) {
                int mid = (low + high) >>> 1;
                int midVal = nums[mid];

                if (midVal < key) {
                    low = mid + 1;
                } else if (midVal > key) {
                    high = mid - 1;
                } else {
                    return mid; // key found
                }
            }
            return -(low + 1);  // key not found.
        }

        /**
         * 二分查找，当有多个key时，返回左边界，否则返回插入点。
         */
        public int binarySearchLeft(int[] nums, int from, int to, int key) {
            int low = from;
            int high = to - 1;

            while (low <= high) {
                int mid = (low + high) >>> 1;
                int midVal = nums[mid];

                if (midVal < key) {
                    low = mid + 1;
                } else if (midVal > key) {
                    high = mid - 1;
                }
            }
            return -(low + 1);
        }
    }
}
