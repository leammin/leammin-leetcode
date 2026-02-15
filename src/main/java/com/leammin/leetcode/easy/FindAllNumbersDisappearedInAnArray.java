package com.leammin.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

import com.leammin.leetcode.util.test.AbstractTest;
import com.leammin.leetcode.util.test.ExpectedTestcase;
import com.leammin.leetcode.util.test.Testsuite;

/**
 * 448. 找到所有数组中消失的数字
 * 
 * <p>给定一个范围在&nbsp; 1 &le; a[i] &le; <em>n</em> (&nbsp;<em>n</em> = 数组大小 ) 的 整型数组，数组中的元素一些出现了两次，另一些只出现一次。</p>
 * 
 * <p>找到所有在 [1, <em>n</em>] 范围之间没有出现在数组中的数字。</p>
 * 
 * <p>您能在不使用额外空间且时间复杂度为<em>O(n)</em>的情况下完成这个任务吗? 你可以假定返回的数组不算在额外空间内。</p>
 * 
 * <p><strong>示例:</strong></p>
 * 
 * <pre>
 * <strong>输入:</strong>
 * [4,3,2,7,8,2,3,1]
 * 
 * <strong>输出:</strong>
 * [5,6]
 * </pre>
 * 
 * 
 * @author Leammin
 * @date 2021-02-13
 */
public interface FindAllNumbersDisappearedInAnArray {
    List<Integer> findDisappearedNumbers(int[] nums);

    static Testsuite<FindAllNumbersDisappearedInAnArray> testsuite() {
        return Testsuite.<FindAllNumbersDisappearedInAnArray>builder()
                .add(ExpectedTestcase.of(t -> t.findDisappearedNumbers(new int[]{4, 3, 2, 7, 8, 2, 3, 1}), List.of(5, 6)))
                .build();
    }


    class Solution implements FindAllNumbersDisappearedInAnArray {

        @Override
        public List<Integer> findDisappearedNumbers(int[] nums) {
            for (int i = 0; i < nums.length; i++) {
                while (nums[i] > 0 && nums[i] - 1 != i) {
                    if (nums[nums[i] - 1] == nums[i]) {
                        nums[i] = 0;
                    } else {
                        int t = nums[nums[i] - 1];
                        nums[nums[i] - 1] = nums[i];
                        nums[i] = t;
                    }
                }
            }
            List<Integer> res = new ArrayList<>();
            for (int i = 0; i < nums.length; i++) {
                int num = nums[i];
                if (num == 0) {
                    res.add(i + 1);
                }
            }
            return res;
        }
    }
}

class FindAllNumbersDisappearedInAnArrayTest extends AbstractTest<FindAllNumbersDisappearedInAnArray> {
}
