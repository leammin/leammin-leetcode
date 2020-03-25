package com.leammin.leetcode.easy;

/**
 * 面试题 17.16. 按摩师
 * 
 * <p>一个有名的按摩师会收到源源不断的预约请求，每个预约都可以选择接或不接。在每次预约服务之间要有休息时间，因此她不能接受相邻的预约。给定一个预约请求序列，替按摩师找到最优的预约集合（总预约时间最长），返回总的分钟数。</p>
 * 
 * <p><strong>注意：</strong>本题相对原题稍作改动</p>
 * 
 * <p>&nbsp;</p>
 * 
 * <p><strong>示例 1：</strong></p>
 * 
 * <pre><strong>输入：</strong> [1,2,3,1]
 * <strong>输出：</strong> 4
 * <strong>解释：</strong> 选择 1 号预约和 3 号预约，总时长 = 1 + 3 = 4。
 * </pre>
 * 
 * <p><strong>示例 2：</strong></p>
 * 
 * <pre><strong>输入：</strong> [2,7,9,3,1]
 * <strong>输出：</strong> 12
 * <strong>解释：</strong> 选择 1 号预约、 3 号预约和 5 号预约，总时长 = 2 + 9 + 1 = 12。
 * </pre>
 * 
 * <p><strong>示例 3：</strong></p>
 * 
 * <pre><strong>输入：</strong> [2,1,4,5,3,1,1,3]
 * <strong>输出：</strong> 12
 * <strong>解释：</strong> 选择 1 号预约、 3 号预约、 5 号预约和 8 号预约，总时长 = 2 + 4 + 3 + 3 = 12。
 * </pre>
 * 
 * 
 * @author Leammin
 * @date 2020-03-24
 */
public interface TheMasseuseLcci {
    int massage(int[] nums);

    class Solution implements TheMasseuseLcci {

        @Override
        public int massage(int[] nums) {
            if (nums == null || nums.length == 0) {
                return 0;
            }
            int a = 0;
            int b = 0;
            int c = 0;
            for (int i = 0; i < nums.length; i++) {
                int d = Math.max(a, b) + nums[i];
                a = b;
                b = c;
                c = d;
            }
            return Math.max(b, c);
        }

    }
}
