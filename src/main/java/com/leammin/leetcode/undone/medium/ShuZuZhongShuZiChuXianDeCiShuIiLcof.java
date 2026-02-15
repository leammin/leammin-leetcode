package com.leammin.leetcode.undone.medium;

import com.leammin.leetcode.util.test.AbstractTest;
import com.leammin.leetcode.util.test.Testsuite;

/**
 * 面试题56 - II. 数组中数字出现的次数 II
 * 
 * <p>在一个数组 <code>nums</code> 中除一个数字只出现一次之外，其他数字都出现了三次。请找出那个只出现一次的数字。</p>
 * 
 * <p>&nbsp;</p>
 * 
 * <p><strong>示例 1：</strong></p>
 * 
 * <pre><strong>输入：</strong>nums = [3,4,3,3]
 * <strong>输出：</strong>4
 * </pre>
 * 
 * <p><strong>示例 2：</strong></p>
 * 
 * <pre><strong>输入：</strong>nums = [9,1,7,9,7,9,7]
 * <strong>输出：</strong>1</pre>
 * 
 * <p>&nbsp;</p>
 * 
 * <p><strong>限制：</strong></p>
 * 
 * <ul>
 * 	<li><code>1 &lt;= nums.length &lt;= 10000</code></li>
 * 	<li><code>1 &lt;= nums[i] &lt; 2^31</code></li>
 * </ul>
 * 
 * <p>&nbsp;</p>
 * 
 * 
 * @author Leammin
 * @date 2020-06-18
 */
public interface ShuZuZhongShuZiChuXianDeCiShuIiLcof {
    int singleNumber(int[] nums);

    static Testsuite<ShuZuZhongShuZiChuXianDeCiShuIiLcof> testsuite() {
        return Testsuite.<ShuZuZhongShuZiChuXianDeCiShuIiLcof>builder()
                .build();
    }


    class Solution implements ShuZuZhongShuZiChuXianDeCiShuIiLcof {

        @Override
        public int singleNumber(int[] nums) {
            return 0;
        }
    }
}

class ShuZuZhongShuZiChuXianDeCiShuIiLcofTest extends AbstractTest<ShuZuZhongShuZiChuXianDeCiShuIiLcof> {
}
