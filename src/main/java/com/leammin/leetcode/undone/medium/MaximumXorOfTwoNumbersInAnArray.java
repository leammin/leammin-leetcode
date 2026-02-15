package com.leammin.leetcode.undone.medium;

import com.leammin.leetcode.util.test.AbstractTest;
import com.leammin.leetcode.util.test.Testsuite;

/**
 * 421. 数组中两个数的最大异或值
 * 
 * <p>给定一个非空数组，数组中元素为 a<sub>0</sub>, a<sub>1</sub>, a<sub>2</sub>, &hellip; , a<sub>n-1</sub>，其中 0 &le; a<sub>i</sub> &lt; 2<sup>31&nbsp;</sup>。</p>
 * 
 * <p>找到 a<sub>i</sub> 和a<sub>j&nbsp;</sub>最大的异或 (XOR) 运算结果，其中0 &le; <em>i</em>,&nbsp;&nbsp;<em>j</em> &lt; <em>n&nbsp;</em>。</p>
 * 
 * <p>你能在O(<em>n</em>)的时间解决这个问题吗？</p>
 * 
 * <p><strong>示例:</strong></p>
 * 
 * <pre>
 * <strong>输入:</strong> [3, 10, 5, 25, 2, 8]
 * 
 * <strong>输出:</strong> 28
 * 
 * <strong>解释:</strong> 最大的结果是 <strong>5</strong> ^ <strong>25</strong> = 28.
 * </pre>
 * 
 * 
 * @author Leammin
 * @date 2021-04-28
 */
public interface MaximumXorOfTwoNumbersInAnArray {
    int findMaximumXOR(int[] nums);

    static Testsuite<MaximumXorOfTwoNumbersInAnArray> testsuite() {
        return Testsuite.<MaximumXorOfTwoNumbersInAnArray>builder()
            .addExpected(t -> t.findMaximumXOR(new int[]{3, 10, 5, 25, 2, 8}), 28)
            .build();
    }


    class Solution implements MaximumXorOfTwoNumbersInAnArray {

        @Override
        public int findMaximumXOR(int[] nums) {
            int max = 0;
            for (int i = 0; i < nums.length; i++) {
                for (int j = i + 1; j < nums.length; j++) {
                    max = Math.max(nums[i] ^ nums[j], max);
                }
            }
            return max;
        }
    }
}

class MaximumXorOfTwoNumbersInAnArrayTest extends AbstractTest<MaximumXorOfTwoNumbersInAnArray> {
}
