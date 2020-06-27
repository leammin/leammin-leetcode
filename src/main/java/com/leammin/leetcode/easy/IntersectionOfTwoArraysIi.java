package com.leammin.leetcode.easy;

import java.util.*;

/**
 * 350. 两个数组的交集 II
 *
 * <div><p>给定两个数组，编写一个函数来计算它们的交集。</p>
 *
 * <p><strong>示例 1:</strong></p>
 *
 * <pre><strong>输入: </strong>nums1 = [1,2,2,1], nums2 = [2,2]
 * <strong>输出: </strong>[2,2]
 * </pre>
 *
 * <p><strong>示例 2:</strong></p>
 *
 * <pre><strong>输入: </strong>nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * <strong>输出: </strong>[4,9]</pre>
 *
 * <p><strong>说明：</strong></p>
 *
 * <ul>
 * <li>输出结果中每个元素出现的次数，应与元素在两个数组中出现的次数一致。</li>
 * <li>我们可以不考虑输出结果的顺序。</li>
 * </ul>
 *
 * <p><strong><strong>进阶:</strong></strong></p>
 *
 * <ul>
 * <li>如果给定的数组已经排好序呢？你将如何优化你的算法？</li>
 * <li>如果&nbsp;<em>nums1&nbsp;</em>的大小比&nbsp;<em>nums2&nbsp;</em>小很多，哪种方法更优？</li>
 * <li>如果&nbsp;<em>nums2&nbsp;</em>的元素存储在磁盘上，磁盘内存是有限的，并且你不能一次加载所有的元素到内存中，你该怎么办？</li>
 * </ul>
 * </div>
 *
 * @author Leammin
 * @date 2018-09-25
 */
public interface IntersectionOfTwoArraysIi {
    int[] intersect(int[] nums1, int[] nums2);

    /**
     * nums1 大小比 nums2 小很多此方法更优
     * nums2 存储在此磁盘上也使用此方法 分多次读取磁盘数据
     */
    class Solution implements IntersectionOfTwoArraysIi {

        @Override
        public int[] intersect(int[] nums1, int[] nums2) {
            List<Integer> resList = new ArrayList<>(nums1.length);
            Map<Integer, Integer> map1 = new HashMap<>(nums1.length);
            for (int i : nums1) {
                Integer v = map1.get(i);
                map1.put(i, v == null ? 1 : v + 1);
            }
            for (int num : nums2) {
                Integer v = map1.get(num);
                if (v != null && v > 0) {
                    map1.put(num, v - 1);
                    resList.add(num);
                }
            }
            int[] res = new int[resList.size()];
            for (int i = 0; i < resList.size(); i++) {
                res[i] = resList.get(i);
            }
            return res;
        }
    }

    class Solution1 implements IntersectionOfTwoArraysIi {
        @Override
        public int[] intersect(int[] nums1, int[] nums2) {
            List<Integer> resList = new ArrayList<>(nums1.length);
            // 若已排好序去掉两个排序过程
            Arrays.sort(nums1);
            // 若已排好序去掉两个排序过程
            Arrays.sort(nums2);
            int i1 = 0;
            int i2 = 0;
            while (i1 < nums1.length && i2 < nums2.length) {
                if (nums1[i1] < nums2[i2]) {
                    i1++;
                } else if (nums1[i1] > nums2[i2]) {
                    i2++;
                } else {
                    resList.add(nums1[i1]);
                    i1++;
                    i2++;
                }
            }
            int[] res = new int[resList.size()];
            for (int i = 0; i < resList.size(); i++) {
                res[i] = resList.get(i);
            }
            return res;
        }
    }


}
