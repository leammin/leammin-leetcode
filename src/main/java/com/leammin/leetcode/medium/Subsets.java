package com.leammin.leetcode.medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 78. 子集
 * 
 * <p>给定一组<strong>不含重复元素</strong>的整数数组&nbsp;<em>nums</em>，返回该数组所有可能的子集（幂集）。</p>
 * 
 * <p><strong>说明：</strong>解集不能包含重复的子集。</p>
 * 
 * <p><strong>示例:</strong></p>
 * 
 * <pre><strong>输入:</strong> nums = [1,2,3]
 * <strong>输出:</strong>
 * [
 *   [3],
 * &nbsp; [1],
 * &nbsp; [2],
 * &nbsp; [1,2,3],
 * &nbsp; [1,3],
 * &nbsp; [2,3],
 * &nbsp; [1,2],
 * &nbsp; []
 * ]</pre>
 * 
 * 
 * @author Leammin
 * @date 2020-03-22
 */
public interface Subsets {
    List<List<Integer>> subsets(int[] nums);

    class Solution implements Subsets {

        @Override
        public List<List<Integer>> subsets(int[] nums) {
            List<List<Integer>> ans = new LinkedList<>();
            backtrack(ans, nums, new LinkedList<>(), 0);
            return ans;
        }

        private void backtrack(List<List<Integer>> ans, int[] nums, LinkedList<Integer> list, int index) {
            ans.add(new ArrayList<>(list));
            for (int i = index; i < nums.length; i++) {
                list.add(nums[i]);
                backtrack(ans, nums, list, i + 1);
                list.removeLast();
            }
        }
    }
}
