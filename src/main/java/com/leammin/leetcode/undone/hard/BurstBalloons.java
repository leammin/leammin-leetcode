package com.leammin.leetcode.undone.hard;

import com.leammin.leetcode.util.Execute;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import com.leammin.leetcode.util.test.AbstractTest;
import com.leammin.leetcode.util.test.ExpectedTestcase;
import com.leammin.leetcode.util.test.Testsuite;

/**
 * 312. 戳气球
 * 
 * <p>有 <code>n</code> 个气球，编号为<code>0</code> 到 <code>n-1</code>，每个气球上都标有一个数字，这些数字存在数组&nbsp;<code>nums</code>&nbsp;中。</p>
 * 
 * <p>现在要求你戳破所有的气球。每当你戳破一个气球 <code>i</code> 时，你可以获得&nbsp;<code>nums[left] * nums[i] * nums[right]</code>&nbsp;个硬币。&nbsp;这里的&nbsp;<code>left</code>&nbsp;和&nbsp;<code>right</code>&nbsp;代表和&nbsp;<code>i</code>&nbsp;相邻的两个气球的序号。注意当你戳破了气球 <code>i</code> 后，气球&nbsp;<code>left</code>&nbsp;和气球&nbsp;<code>right</code>&nbsp;就变成了相邻的气球。</p>
 * 
 * <p>求所能获得硬币的最大数量。</p>
 * 
 * <p><strong>说明:</strong></p>
 * 
 * <ul>
 * 	<li>你可以假设&nbsp;<code>nums[-1] = nums[n] = 1</code>，但注意它们不是真实存在的所以并不能被戳破。</li>
 * 	<li>0 &le; <code>n</code> &le; 500, 0 &le; <code>nums[i]</code> &le; 100</li>
 * </ul>
 * 
 * <p><strong>示例:</strong></p>
 * 
 * <pre><strong>输入:</strong> <code>[3,1,5,8]</code>
 * <strong>输出:</strong> <code>167 
 * <strong>解释: </strong></code>nums = [3,1,5,8] --&gt; [3,5,8] --&gt;   [3,8]   --&gt;  [8]  --&gt; []
 * &nbsp;    coins =  3*1*5      +  3*5*8    +  1*3*8      + 1*8*1   = 167
 * </pre>
 * 
 * 
 * @author Leammin
 * @date 2020-07-19
 */
public interface BurstBalloons {
    int maxCoins(int[] nums);

    // 跑起来太耗时了
    static Testsuite<BurstBalloons> testsuite() {
        return Testsuite.<BurstBalloons>builder()
                .add(ExpectedTestcase.of(t -> t.maxCoins(new int[]{3, 1, 5, 8}), 167))
                .add(ExpectedTestcase.of(t -> t.maxCoins(new int[]{7, 9, 8, 0, 7, 1, 3, 5, 5, 2, 3, 3}), 1717))
                .add(ExpectedTestcase.of(t -> t.maxCoins(new int[]{8, 3, 4, 3, 5, 0, 5, 6, 6, 2, 8, 5, 6, 2, 3, 8, 3, 5, 1, 0, 2}), 3394))
                .build();
    }


    @Execute(value = false)
    class Solution implements BurstBalloons {

        @Override
        public int maxCoins(int[] nums) {
            int max = 0;
            for (int i = 0; i < nums.length; i++) {
                int coins = (i == 0 ? 1 : nums[i - 1]) * nums[i] * (i == nums.length - 1 ? 1 : nums[i + 1]);
                int[] newNums = new int[nums.length - 1];
                System.arraycopy(nums, 0, newNums, 0, i);
                System.arraycopy(nums, i + 1, newNums, i, nums.length - i - 1);
                max = Math.max(max, maxCoins(newNums) + coins);
            }
            return max;
        }
    }

    class Solution2 implements BurstBalloons {

        Map<Array, Integer> dp = new HashMap<>();

        @Override
        public int maxCoins(int[] nums) {
            Array array = new Array(nums);
            Integer res = dp.get(array);
            if (res != null) {
                return res;
            }
            int max = 0;
            for (int i = 0; i < nums.length; i++) {
                int coins = (i == 0 ? 1 : nums[i - 1]) * nums[i] * (i == nums.length - 1 ? 1 : nums[i + 1]);
                int[] newNums = new int[nums.length - 1];
                System.arraycopy(nums, 0, newNums, 0, i);
                System.arraycopy(nums, i + 1, newNums, i, nums.length - i - 1);
                max = Math.max(max, maxCoins(newNums) + coins);
            }
            dp.put(array, max);
            return max;
        }

        static class Array {
            int[] array;

            public Array(int[] array) {
                this.array = array;
            }

            @Override
            public boolean equals(Object o) {
                if (this == o) return true;
                if (o == null || getClass() != o.getClass()) return false;
                Array array1 = (Array) o;
                return Arrays.equals(array, array1.array);
            }

            @Override
            public int hashCode() {
                return Arrays.hashCode(array);
            }
        }
    }
}

class BurstBalloonsTest extends AbstractTest<BurstBalloons> {
}
