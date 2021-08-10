package com.leammin.leetcode.util;

import com.google.common.base.Preconditions;

/**
 * @author xiebao.llm
 * @date 2021/04/22
 */
public interface Codes {
    class BinarySearch {
        /**
         * 二分查找，查找到key后直接返回下标。<br>
         * 若key不存在，则返回key的插入点：((-insertion point) - 1)。 <br>
         * 参考源码 {@link java.util.Arrays#binarySearch(int[], int, int, int)}
         */
        public int binarySearch(int[] nums, int from, int to, int key) {
            int l = from;
            int r = to - 1;
            while (l <= r) {
                int mid = l + (r - l) / 2;
                if (nums[mid] < key) {
                    l = mid + 1;
                } else if (nums[mid] > key) {
                    r = mid - 1;
                } else {
                    return mid;
                }
            }
            return -(l + 1);
        }

        /**
         * 二分查找，当有多个key时，返回左边界，否则返回插入点。
         */
        public int binarySearchLeft(int[] nums, int from, int to, int key) {
            int l = from;
            int r = to - 1;
            while (l <= r) {
                int mid = l + (r - l) / 2;
                if (nums[mid] >= key) {  //这里需要注意
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            }
            return l < to && nums[l] == key ? l : (-l - 1);
        }

        /**
         * 二分查找，当有多个key时，返回右边界，否则返回插入点。
         */
        public int binarySearchRight(int[] nums, int from, int to, int key) {
            int l = from;
            int r = to - 1;
            while (l <= r) {
                int mid = l + (r - l) / 2;
                if (nums[mid] > key) {  //这里需要注意
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            }
            return r >= from && nums[r] == key ? r : (-r - 2);
        }

        public static void main(String[] args) {
            Preconditions.checkArgument(new BinarySearch().binarySearchLeft(new int[] {1, 3, 3, 3, 5}, 0, 5, 3) == 1);
            Preconditions.checkArgument(new BinarySearch().binarySearchLeft(new int[] {1, 3, 3, 3, 5}, 0, 5, 5) == 4);
            Preconditions.checkArgument(new BinarySearch().binarySearchLeft(new int[] {1, 3, 3, 3, 5}, 0, 5, 1) == 0);
            Preconditions.checkArgument(new BinarySearch().binarySearchLeft(new int[] {1, 3, 3, 3, 5}, 0, 5, 2) == -2);
            Preconditions.checkArgument(new BinarySearch().binarySearchLeft(new int[] {1, 3, 3, 3, 5}, 0, 5, 4) == -5);
            Preconditions.checkArgument(new BinarySearch().binarySearchLeft(new int[] {1, 3, 3, 3, 5}, 0, 5, 0) == -1);
            Preconditions.checkArgument(new BinarySearch().binarySearchLeft(new int[] {1, 3, 3, 3, 5}, 0, 5, 6) == -6);
            Preconditions.checkArgument(new BinarySearch().binarySearchLeft(new int[] {1, 3, 3, 3, 5}, 1, 5, 1) == -2);
            Preconditions.checkArgument(new BinarySearch().binarySearchLeft(new int[] {1, 3, 3, 3, 5}, 1, 4, 3) == 1);
            Preconditions.checkArgument(new BinarySearch().binarySearchLeft(new int[] {1, 3, 3, 3, 5}, 1, 4, 5) == -5);


            Preconditions.checkArgument(new BinarySearch().binarySearchRight(new int[] {1, 3, 3, 3, 5}, 0, 5, 3) == 3);
            Preconditions.checkArgument(new BinarySearch().binarySearchRight(new int[] {1, 3, 3, 3, 5}, 0, 5, 1) == 0);
            Preconditions.checkArgument(new BinarySearch().binarySearchRight(new int[] {1, 3, 3, 3, 5}, 0, 5, 5) == 4);
            Preconditions.checkArgument(new BinarySearch().binarySearchRight(new int[] {1, 3, 3, 3, 5}, 0, 5, 2) == -2);
            Preconditions.checkArgument(new BinarySearch().binarySearchRight(new int[] {1, 3, 3, 3, 5}, 0, 5, 4) == -5);
            Preconditions.checkArgument(new BinarySearch().binarySearchRight(new int[] {1, 3, 3, 3, 5}, 0, 5, 0) == -1);
            Preconditions.checkArgument(new BinarySearch().binarySearchRight(new int[] {1, 3, 3, 3, 5}, 0, 5, 6) == -6);
            Preconditions.checkArgument(new BinarySearch().binarySearchRight(new int[] {1, 3, 3, 3, 5}, 1, 5, 1) == -2);
            Preconditions.checkArgument(new BinarySearch().binarySearchRight(new int[] {1, 3, 3, 3, 5}, 1, 4, 5) == -5);
            Preconditions.checkArgument(new BinarySearch().binarySearchRight(new int[] {1, 3, 3, 3, 5}, 1, 4, 3) == 3);

        }
    }
}
