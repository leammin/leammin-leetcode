package com.leammin.leetcode.easy;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 136. 只出现一次的数字
 *
 * <div><p>给定一个<strong>非空</strong>整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。</p>
 *
 * <p><strong>说明：</strong></p>
 *
 * <p>你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？</p>
 *
 * <p><strong>示例 1:</strong></p>
 *
 * <pre><strong>输入:</strong> [2,2,1]
 * <strong>输出:</strong> 1
 * </pre>
 *
 * <p><strong>示例&nbsp;2:</strong></p>
 *
 * <pre><strong>输入:</strong> [4,1,2,1,2]
 * <strong>输出:</strong> 4</pre>
 * </div>
 *
 * @author Leammin
 * @date 2018-09-15
 */
public class SingleNumber {
    public int singleNumber(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        Set<Integer> set = new HashSet<>(nums.length);
        for (int num : nums) {
            if (!set.remove(num)) {
                set.add(num);
            }
        }
        return set.iterator().next();
    }

    public int singleNumber2(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        Arrays.sort(nums);
        int i = 0;
        int j = 1;
        while (i < nums.length && j < nums.length) {
            if (nums[i] == nums[j]) {
                j++;
            } else {
                if (j - i == 1) {
                    return nums[i];
                } else {
                    i = j;
                    j++;
                }
            }
        }
        return nums[nums.length - 1];
    }

    public static int singleNumber3(int[] nums) {
        // 网上最佳答案，但只能是只有重复的数字是偶数数量才有用
        int a=0;
        for(int i:nums){
            a^=i;
        }
        return a;
    }

    public static void main(String[] args) {
        System.out.println(singleNumber3(new int[]{1,1,2,2,3,3,3,3,4,4,5,5,6}));
    }
}
