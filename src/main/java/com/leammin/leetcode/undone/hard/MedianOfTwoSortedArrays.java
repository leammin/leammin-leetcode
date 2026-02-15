package com.leammin.leetcode.undone.hard;

import java.util.Arrays;

import com.leammin.leetcode.util.test.AbstractTest;
import com.leammin.leetcode.util.test.ExpectedTestcase;
import com.leammin.leetcode.util.test.Testsuite;

/**
 * 4. 寻找两个有序数组的中位数
 *
 * <p>给定两个大小为 m 和 n 的有序数组&nbsp;<code>nums1</code> 和&nbsp;<code>nums2</code>。</p>
 *
 * <p>请你找出这两个有序数组的中位数，并且要求算 法的时间复杂度为&nbsp;O(log(m + n))。</p>
 *
 * <p>你可以假设&nbsp;<code>nums1</code>&nbsp;和&nbsp;<code>nums2</code>&nbsp;不会同时为空。</p>
 *
 * <p><strong>示例 1:</strong></p>
 *
 * <pre>nums1 = [1, 3]
 * nums2 = [2]
 *
 * 则中位数是 2.0
 * </pre>
 *
 * <p><strong>示例 2:</strong></p>
 *
 * <pre>nums1 = [1, 2]
 * nums2 = [3, 4]
 *
 * 则中位数是 (2 + 3)/2 = 2.5
 * </pre>
 *
 * @author Leammin
 * @date 2020-05-24
 */
public interface MedianOfTwoSortedArrays {
    double findMedianSortedArrays(int[] nums1, int[] nums2);

    /**
     * O(m+n)
     */

    static Testsuite<MedianOfTwoSortedArrays> testsuite() {
        return Testsuite.<MedianOfTwoSortedArrays>builder()
                .add(ExpectedTestcase.of(t -> t.findMedianSortedArrays(new int[]{1, 3}, new int[]{2}), 2.0))
                .add(ExpectedTestcase.of(t -> t.findMedianSortedArrays(new int[]{1, 2}, new int[]{3, 4}), 2.5))
                .add(ExpectedTestcase.of(t -> t.findMedianSortedArrays(new int[]{0, 1, 2, 3}, new int[]{1, 2, 3, 4, 5}), 2.0))
                .add(ExpectedTestcase.of(t -> t.findMedianSortedArrays(new int[]{0, 1, 2, 3}, new int[]{2, 3, 4, 5}), 2.5))
                .add(ExpectedTestcase.of(t -> t.findMedianSortedArrays(new int[]{0, 1, 2, 3, 4}, new int[]{2, 3, 4, 5}), 3.0))
                .add(ExpectedTestcase.of(t -> t.findMedianSortedArrays(new int[]{1, 3}, new int[]{2, 7}), 2.5))
                .add(ExpectedTestcase.of(t -> t.findMedianSortedArrays(new int[]{1, 2}, new int[]{1, 2}), 1.5))
                .build();
    }

    class Solution implements MedianOfTwoSortedArrays {

        @Override
        public double findMedianSortedArrays(int[] nums1, int[] nums2) {
            int a = 0;
            int b = 0;
            for (int r = (nums1.length + nums2.length) / 2, i1 = 0, i2 = 0; r >= 0; r--) {
                a = b;
                b = i1 < nums1.length && (i2 >= nums2.length || nums1[i1] <= nums2[i2]) ? nums1[i1++] : nums2[i2++];
            }
            return (nums1.length + nums2.length) % 2 == 0 ? (a + b) / 2.0 : b;
        }
    }

//    @Execute(cases = 2)
    class Solution2 implements MedianOfTwoSortedArrays {

        @Override
        public double findMedianSortedArrays(int[] nums1, int[] nums2) {
            int[] a = nums1, b = nums2;
            if (nums2.length != 0 && (nums1.length == 0 || nums1[0] > nums2[0])) {
                a = nums2;
                b = nums1;
            }
            if (b.length == 0 || a[a.length - 1] <= b[0]) {
                // 如果两个数组没有交集，直接计算
                int i = (a.length + b.length) / 2;
                int iv = i < a.length ? a[i] : b[i - a.length];
                return (a.length + b.length) % 2 == 0 ? ((i - 1 < a.length ? a[i - 1] : b[i - 1 - a.length]) + iv) / 2.0 : iv;
            }
            int s = (a.length + b.length - 1) / 2;
            int lo = a[0];
            int hi = Math.max(a[a.length - 1], b[b.length - 1]);
            while (lo <= hi) {
                int mid = (lo + hi) / 2;

                int ai = searchIndex(a, mid);
                int bi = searchIndex(b, mid);

                if (ai + bi < s) {
                    lo = mid + 1;
                } else if (ai + bi > s) {
                    hi = mid - 1;
                } else {
                    lo = mid + 1;
                    break;
                }
            }

            int as = searchIndex(a, lo - 1);
            int bs = searchIndex(b, lo - 1);
            if ((a.length + b.length) % 2 == 0) {
                if (as + bs < s) {
                    int m1 = a[as];
                    int m2 = as + 1 >= a.length ? b[bs + 1] : bs + 1 >= b.length ? a[as + 1] : Math.min(a[as + 1], b[bs + 1]);
                    return (m1 + m2) / 2.0;
                }
                int[] x = new int[]{
                        as < a.length ? a[as] : Integer.MAX_VALUE,
                        as + 1 < a.length ? a[as + 1] : Integer.MAX_VALUE,
                        bs < b.length ? b[bs] : Integer.MAX_VALUE,
                        bs + 1 < b.length ? b[bs + 1] : Integer.MAX_VALUE
                };
                Arrays.sort(x);
                return (x[0] + x[1]) / 2.0;
            } else {
                return as >= a.length ? b[bs] : bs >= b.length ? a[as] : Math.min(a[as], b[bs]);
            }
        }

        private int searchIndex(int[] a, int key) {
            int as;
            int ai = Arrays.binarySearch(a, key);
            as = ai < 0 ? (-ai - 1) : ai;
            return as;
        }
    }
}

class MedianOfTwoSortedArraysTest extends AbstractTest<MedianOfTwoSortedArrays> {
}
