package com.leammin.leetcode.easy;

import com.leammin.leetcode.util.test.AbstractTest;
import com.leammin.leetcode.util.test.Testsuite;

/**
 * 面试题03. 数组中重复的数字
 * 
 * <p>找出数组中重复的数字。</p>
 * 
 * <p><br>
 * 在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。请找出数组中任意一个重复的数字。</p>
 * 
 * <p><strong>示例 1：</strong></p>
 * 
 * <pre><strong>输入：</strong>
 * [2, 3, 1, 0, 2, 5, 3]
 * <strong>输出：</strong>2 或 3 
 * </pre>
 * 
 * <p>&nbsp;</p>
 * 
 * <p><strong>限制：</strong></p>
 * 
 * <p><code>2 &lt;= n &lt;= 100000</code></p>
 * 
 * 
 * @author Leammin
 * @date 2021-08-16
 */
public interface ShuZuZhongZhongFuDeShuZiLcof {
    int findRepeatNumber(int[] nums);

    static Testsuite<ShuZuZhongZhongFuDeShuZiLcof> testsuite() {
        return Testsuite.<ShuZuZhongZhongFuDeShuZiLcof>builder()
                .addExpected(t -> t.findRepeatNumber(new int[]{2, 3, 1, 0, 2, 5, 3}), 2)
                .build();
    }

    
    class Solution implements ShuZuZhongZhongFuDeShuZiLcof {

        @Override
        public int findRepeatNumber(int[] nums) {
            for (int i = 0; i < nums.length; i++) {
                while (nums[i] != i) {
                    if (nums[nums[i]] == nums[i]) {
                        return nums[i];
                    }
                    int t = nums[nums[i]];
                    nums[nums[i]] = nums[i];
                    nums[i] = t;
                }
            }
            return -1;
        }
        
    }
}

class ShuZuZhongZhongFuDeShuZiLcofTest extends AbstractTest<ShuZuZhongZhongFuDeShuZiLcof> {
}
