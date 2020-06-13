package com.leammin.leetcode.easy;

/**
 * 167. 两数之和 II - 输入有序数组
 * 
 * <p>给定一个已按照<strong><em>升序排列</em>&nbsp;</strong>的有序数组，找到两个数使得它们相加之和等于目标数。</p>
 * 
 * <p>函数应该返回这两个下标值<em> </em>index1 和 index2，其中 index1&nbsp;必须小于&nbsp;index2<em>。</em></p>
 * 
 * <p><strong>说明:</strong></p>
 * 
 * <ul>
 * 	<li>返回的下标值（index1 和 index2）不是从零开始的。</li>
 * 	<li>你可以假设每个输入只对应唯一的答案，而且你不可以重复使用相同的元素。</li>
 * </ul>
 * 
 * <p><strong>示例:</strong></p>
 * 
 * <pre><strong>输入:</strong> numbers = [2, 7, 11, 15], target = 9
 * <strong>输出:</strong> [1,2]
 * <strong>解释:</strong> 2 与 7 之和等于目标数 9 。因此 index1 = 1, index2 = 2 。</pre>
 * 
 * 
 * @author Leammin
 * @date 2020-06-13
 */
public interface TwoSumIiInputArrayIsSorted {
    int[] twoSum(int[] numbers, int target);

    class Solution implements TwoSumIiInputArrayIsSorted {

        @Override
        public int[] twoSum(int[] numbers, int target) {
            int left = 0, right = numbers.length - 1;
            while (left < right) {
                int s = numbers[left] + numbers[right];
                if (s < target) {
                    left++;
                } else if (s > target) {
                    right--;
                } else {
                    return new int[]{left + 1, right + 1};
                }
            }
            return null;
        }
    }
}
