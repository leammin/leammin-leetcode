package com.leammin.leetcode.easy;

/**
 * 169. 多数元素
 * 
 * <p>给定一个大小为 <em>n </em>的数组，找到其中的多数元素。多数元素是指在数组中出现次数<strong>大于</strong>&nbsp;<code>&lfloor; n/2 &rfloor;</code>&nbsp;的元素。</p>
 * 
 * <p>你可以假设数组是非空的，并且给定的数组总是存在多数元素。</p>
 * 
 * <p><strong>示例&nbsp;1:</strong></p>
 * 
 * <pre><strong>输入:</strong> [3,2,3]
 * <strong>输出:</strong> 3</pre>
 * 
 * <p><strong>示例&nbsp;2:</strong></p>
 * 
 * <pre><strong>输入:</strong> [2,2,1,1,1,2,2]
 * <strong>输出:</strong> 2
 * </pre>
 * 
 * 
 * @author Leammin
 * @date 2020-03-13
 */
public interface MajorityElement {
    int majorityElement(int[] nums);

    class Solution implements MajorityElement {

        @Override
        public int majorityElement(int[] nums) {
            int result = 0;
            int count = 0;
            for (int num : nums) {
                if (count == 0) {
                    result = num;
                    count = 1;
                } else if (num == result) {
                    count++;
                } else {
                    count--;
                }
            }
            return result;
        }
    }
}
