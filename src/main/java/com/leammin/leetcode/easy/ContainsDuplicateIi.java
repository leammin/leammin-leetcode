package com.leammin.leetcode.easy;

import java.util.HashMap;
import java.util.Map;

import com.leammin.leetcode.util.test.AbstractTest;
import com.leammin.leetcode.util.test.ExpectedTestcase;
import com.leammin.leetcode.util.test.Testsuite;

/**
 * 219. 存在重复元素 II
 *
 * <p>给定一个整数数组和一个整数&nbsp;<em>k</em>，判断数组中是否存在两个不同的索引<em>&nbsp;i</em>&nbsp;和<em>&nbsp;j</em>，使得&nbsp;<strong>nums [i] = nums [j]</strong>，并且 <em>i</em> 和 <em>j</em>&nbsp;的差的绝对值最大为 <em>k</em>。</p>
 *
 * <p><strong>示例&nbsp;1:</strong></p>
 *
 * <pre><strong>输入:</strong> nums = [1,2,3,1], k<em> </em>= 3
 * <strong>输出:</strong> true</pre>
 *
 * <p><strong>示例 2:</strong></p>
 *
 * <pre><strong>输入: </strong>nums = [1,0,1,1], k<em> </em>=<em> </em>1
 * <strong>输出:</strong> true</pre>
 *
 * <p><strong>示例 3:</strong></p>
 *
 * <pre><strong>输入: </strong>nums = [1,2,3,1,2,3], k<em> </em>=<em> </em>2
 * <strong>输出:</strong> false</pre>
 *
 * @author Leammin
 * @date 2020-06-28
 */
public interface ContainsDuplicateIi {
    boolean containsNearbyDuplicate(int[] nums, int k);

    static Testsuite<ContainsDuplicateIi> testsuite() {
        return Testsuite.<ContainsDuplicateIi>builder()
                .add(ExpectedTestcase.of(t -> t.containsNearbyDuplicate(new int[]{1,2,3,1}, 3), true))
                .add(ExpectedTestcase.of(t -> t.containsNearbyDuplicate(new int[]{1,0,1,1}, 1), true))
                .add(ExpectedTestcase.of(t -> t.containsNearbyDuplicate(new int[]{1,2,3,1,2,3}, 2), false))
                .build();
    }


    class Solution implements ContainsDuplicateIi {

        @Override
        public boolean containsNearbyDuplicate(int[] nums, int k) {
            Map<Integer, Integer> map = new HashMap<>((int) (nums.length / 0.75F + 1.0F));
            for (int i = 0; i < nums.length; i++) {
                Integer oldIndex = map.put(nums[i], i);
                if (oldIndex != null && i - oldIndex <= k) {
                    return true;
                }
            }
            return false;
        }
    }
}

class ContainsDuplicateIiTest extends AbstractTest<ContainsDuplicateIi> {
}
