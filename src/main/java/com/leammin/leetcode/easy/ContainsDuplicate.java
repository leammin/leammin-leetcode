package com.leammin.leetcode.easy;

import java.util.HashSet;
import java.util.Set;

import com.leammin.leetcode.util.test.AbstractTest;
import com.leammin.leetcode.util.test.ExpectedTestcase;
import com.leammin.leetcode.util.test.Testsuite;

/**
 * 217. 存在重复元素
 *
 * <div><p>给定一个整数数组，判断是否存在重复元素。</p>
 *
 * <p>如果任何值在数组中出现至少两次，函数返回 true。如果数组中每个元素都不相同，则返回 false。</p>
 *
 * <p><strong>示例 1:</strong></p>
 *
 * <pre><strong>输入:</strong> [1,2,3,1]
 * <strong>输出:</strong> true</pre>
 *
 * <p><strong>示例 2:</strong></p>
 *
 * <pre><strong>输入: </strong>[1,2,3,4]
 * <strong>输出:</strong> false</pre>
 *
 * <p><strong>示例&nbsp;3:</strong></p>
 *
 * <pre><strong>输入: </strong>[1,1,1,3,3,4,3,2,4,2]
 * <strong>输出:</strong> true</pre>
 * </div>
 *
 * @author Leammin
 * @date 2018-09-15
 */
public interface ContainsDuplicate {
    boolean containsDuplicate(int[] nums);

    static Testsuite<ContainsDuplicate> testsuite() {
        return Testsuite.<ContainsDuplicate>builder()
                .add(ExpectedTestcase.of(s -> s.containsDuplicate(new int[]{1, 2, 3, 1}), true))
                .add(ExpectedTestcase.of(s -> s.containsDuplicate(new int[]{1, 2, 3, 4, 5}), false))
                .add(ExpectedTestcase.of(s -> s.containsDuplicate(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 12}), true))
                .build();
    }


    class Solution implements ContainsDuplicate {
        @Override
        public boolean containsDuplicate(int[] nums) {
            Set<Integer> set = new HashSet<>(nums.length);
            for (int num : nums) {
                if (!set.add(num)) {
                    return true;
                }
            }
            return false;
        }
    }
}

class ContainsDuplicateTest extends AbstractTest<ContainsDuplicate> {
}
