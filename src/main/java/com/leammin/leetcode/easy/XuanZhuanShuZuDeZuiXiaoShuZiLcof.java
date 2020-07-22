package com.leammin.leetcode.easy;

/**
 * 面试题11. 旋转数组的最小数字
 * 
 * <p>把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。输入一个递增排序的数组的一个旋转，输出旋转数组的最小元素。例如，数组&nbsp;<code>[3,4,5,1,2]</code> 为 <code>[1,2,3,4,5]</code> 的一个旋转，该数组的最小值为1。&nbsp;&nbsp;</p>
 * 
 * <p><strong>示例 1：</strong></p>
 * 
 * <pre><strong>输入：</strong>[3,4,5,1,2]
 * <strong>输出：</strong>1
 * </pre>
 * 
 * <p><strong>示例 2：</strong></p>
 * 
 * <pre><strong>输入：</strong>[2,2,2,0,1]
 * <strong>输出：</strong>0
 * </pre>
 * 
 * <p>注意：本题与主站 154 题相同：<a href="https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array-ii/">https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array-ii/</a></p>
 * 
 * 
 * @author Leammin
 * @date 2020-07-22
 */
public interface XuanZhuanShuZuDeZuiXiaoShuZiLcof {
    int minArray(int[] numbers);
    
    class Solution implements XuanZhuanShuZuDeZuiXiaoShuZiLcof {

        @Override
        public int minArray(int[] numbers) {
            if (numbers.length == 1 || numbers[0] < numbers[numbers.length - 1]) {
                return numbers[0];
            }
            int lo = 0;
            int hi = numbers.length - 1;
            while (lo < hi) {
                int mid = lo + (hi - lo) / 2;

                if (numbers[mid] > numbers[mid + 1]) {
                    return numbers[mid + 1];
                }
                if (numbers[mid] > numbers[lo] || numbers[mid] > numbers[hi]) {
                    lo = mid + 1;
                } else if (numbers[mid] < numbers[lo] || numbers[mid] < numbers[hi]) {
                    hi = mid;
                } else {
                    hi--;
                }
            }
            return numbers[lo];
        }
    }
}
