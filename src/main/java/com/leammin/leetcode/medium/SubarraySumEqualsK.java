package com.leammin.leetcode.medium;

import java.util.*;

import com.leammin.leetcode.util.test.AbstractTest;
import com.leammin.leetcode.util.test.ExpectedTestcase;
import com.leammin.leetcode.util.test.Testsuite;

/**
 * 560. 和为K的子数组
 * 
 * <p>给定一个整数数组和一个整数&nbsp;<strong>k，</strong>你需要找到该数组中和为&nbsp;<strong>k&nbsp;</strong>的连续的子数组的个数。</p>
 * 
 * <p><strong>示例 1 :</strong></p>
 * 
 * <pre>
 * <strong>输入:</strong>nums = [1,1,1], k = 2
 * <strong>输出:</strong> 2 , [1,1] 与 [1,1] 为两种不同的情况。
 * </pre>
 * 
 * <p><strong>说明 :</strong></p>
 * 
 * <ol>
 * 	<li>数组的长度为 [1, 20,000]。</li>
 * 	<li>数组中元素的范围是 [-1000, 1000] ，且整数&nbsp;<strong>k&nbsp;</strong>的范围是&nbsp;[-1e7, 1e7]。</li>
 * </ol>
 * 
 * 
 * @author Leammin
 * @date 2020-05-15
 */
public interface SubarraySumEqualsK {
    int subarraySum(int[] nums, int k);

    static Testsuite<SubarraySumEqualsK> testsuite() {
        return Testsuite.<SubarraySumEqualsK>builder()
                .add(ExpectedTestcase.of(t -> t.subarraySum(new int[]{1,1,1}, 2), 2))
                .add(ExpectedTestcase.of(t -> t.subarraySum(new int[]{1}, 0), 0))
                .add(ExpectedTestcase.of(t -> t.subarraySum(new int[]{1,1}, 0), 0))
                .build();
    }


    class Solution implements SubarraySumEqualsK {

        @Override
        public int subarraySum(int[] nums, int k) {
            int count = 0;
            for (int i = 0; i < nums.length; i++) {
                int sum = 0;
                for (int j = i; j < nums.length; j++) {
                    sum += nums[j];
                    if (sum == k) {
                        count++;
                    }
                }
            }
            return count;
        }
    }

    class Solution2 implements SubarraySumEqualsK {

        @Override
        public int subarraySum(int[] nums, int k) {
            if (nums == null || nums.length == 0) {
                return 0;
            }
            Map<Integer, List<Integer>> cache = new HashMap<>();
            int count = 0;
            for (int i = 0; i < nums.length; i++) {
                cache.computeIfAbsent((count += nums[i]), key -> new ArrayList<>()).add(i);
            }
            count = 0;
            int res = 0;
            for (int i = 0; i < nums.length; i++) {
                count += nums[i];
                List<Integer> indexes = cache.get(k + count);
                if (indexes != null) {
                    int s = Collections.binarySearch(indexes, i);
                    s = s < 0 ? -s - 1 : s + 1;
                    res += indexes.size() - s;
                }
                if (count == k) {
                    res++;
                }
            }
            return res;
        }
    }
}

class SubarraySumEqualsKTest extends AbstractTest<SubarraySumEqualsK> {
}
