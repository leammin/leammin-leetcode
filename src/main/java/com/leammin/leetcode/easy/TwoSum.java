package com.leammin.leetcode.easy;

import java.util.HashMap;
import java.util.Map;

import com.leammin.leetcode.util.test.AbstractTest;
import com.leammin.leetcode.util.test.Testsuite;
import com.leammin.leetcode.util.test.VerifiableTestcase;
import org.assertj.core.api.Assertions;

/**
 * 1. 两数之和
 *
 * <div><p>给定一个整数数组和一个目标值，找出数组中和为目标值的<strong>两个</strong>数。</p>
 *
 * <p>你可以假设每个输入只对应一种答案，且同样的元素不能被重复利用。</p>
 *
 * <p><strong>示例:</strong></p>
 *
 * <pre>给定 nums = [2, 7, 11, 15], target = 9
 *
 * 因为 nums[<strong>0</strong>] + nums[<strong>1</strong>] = 2 + 7 = 9
 * 所以返回 [<strong>0, 1</strong>]
 * </pre>
 * </div>
 *
 * @author Leammin
 * @date 2018-08-26
 */
public interface TwoSum {
    int[] twoSum(int[] nums, int target);

    static Testsuite<TwoSum> testsuite() {
        return Testsuite.<TwoSum>builder()
                .add(VerifiableTestcase.ofConsumer(t -> t.twoSum(new int[]{2, 7, 11, 15}, 9),
                        r -> Assertions.assertThat(r).containsExactlyInAnyOrder(0, 1)))
                .build();
    }


    class Solution implements TwoSum {
        @Override
        public int[] twoSum(int[] nums, int target) {
            if (nums == null || nums.length < 2) {
                return null;
            }
            Map<Integer, Integer> map = new HashMap<>((int) (nums.length / 0.75 + 1));
            for (int i = 0; i < nums.length; i++) {
                Integer add = map.get(target - nums[i]);
                if (add != null) {
                    return new int[]{i, add};
                }
                map.put(nums[i], i);
            }
            return null;
        }
    }

    class Solution2 implements TwoSum {
        @Override
        public int[] twoSum(int[] nums, int target) {
            Map<Integer, Integer> numToIdx = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                Integer r = numToIdx.get(target - nums[i]);
                if (r != null && r != i) {
                    return new int[]{i, r};
                }
                numToIdx.put(nums[i], i);
            }
            return null;
        }
    }
}

class TwoSumTest extends AbstractTest<TwoSum> {
}
