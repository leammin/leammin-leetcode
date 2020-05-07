package com.leammin.leetcode.undone.medium;

/**
 * 面试题56 - I. 数组中数字出现的次数
 * 
 * <p>一个整型数组 <code>nums</code> 里除两个数字之外，其他数字都出现了两次。请写程序找出这两个只出现一次的数字。要求时间复杂度是O(n)，空间复杂度是O(1)。</p>
 * 
 * <p>&nbsp;</p>
 * 
 * <p><strong>示例 1：</strong></p>
 * 
 * <pre><strong>输入：</strong>nums = [4,1,4,6]
 * <strong>输出：</strong>[1,6] 或 [6,1]
 * </pre>
 * 
 * <p><strong>示例 2：</strong></p>
 * 
 * <pre><strong>输入：</strong>nums = [1,2,10,4,1,4,3,3]
 * <strong>输出：</strong>[2,10] 或 [10,2]</pre>
 * 
 * <p>&nbsp;</p>
 * 
 * <p><strong>限制：</strong></p>
 * 
 * <ul>
 * 	<li><code>2 &lt;= nums &lt;= 10000</code></li>
 * </ul>
 * 
 * <p>&nbsp;</p>
 * 
 * 
 * @author Leammin
 * @date 2020-04-28
 */
public interface ShuZuZhongShuZiChuXianDeCiShuLcof {
    int[] singleNumbers(int[] nums);

    class Solution implements ShuZuZhongShuZiChuXianDeCiShuLcof {

        @Override
        public int[] singleNumbers(int[] nums) {
            return new int[0];
        }
    }
}
