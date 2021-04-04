package com.leammin.leetcode.hard;

/**
 * 5725. 序列中不同最大公约数的数目
 * 
 * <p>给你一个由正整数组成的数组 <code>nums</code> 。</p>
 * 
 * <p>数字序列的 <strong>最大公约数</strong> 定义为序列中所有整数的共有约数中的最大整数。</p>
 * 
 * <ul>
 * 	<li>例如，序列 <code>[4,6,16]</code> 的最大公约数是 <code>2</code> 。</li>
 * </ul>
 * 
 * <p>数组的一个 <strong>子序列</strong> 本质是一个序列，可以通过删除数组中的某些元素（或者不删除）得到。</p>
 * 
 * <ul>
 * 	<li>例如，<code>[2,5,10]</code> 是 <code>[1,2,1,<strong>2</strong>,4,1,<strong>5</strong>,<strong>10</strong>]</code> 的一个子序列。</li>
 * </ul>
 * 
 * <p>计算并返回 <code>nums</code> 的所有 <strong>非空</strong> 子序列中 <strong>不同</strong> 最大公约数的 <strong>数目</strong> 。</p>
 * 
 * <p> </p>
 * 
 * <p><strong>示例 1：</strong></p>
 * <img alt="" src="https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2021/04/03/image-1.png" />
 * <pre>
 * <strong>输入：</strong>nums = [6,10,3]
 * <strong>输出：</strong>5
 * <strong>解释：</strong>上图显示了所有的非空子序列与各自的最大公约数。
 * 不同的最大公约数为 6 、10 、3 、2 和 1 。
 * </pre>
 * 
 * <p><strong>示例 2：</strong></p>
 * 
 * <pre>
 * <strong>输入：</strong>nums = [5,15,40,5,6]
 * <strong>输出：</strong>7
 * </pre>
 * 
 * <p> </p>
 * 
 * <p><strong>提示：</strong></p>
 * 
 * <ul>
 * 	<li><code>1 <= nums.length <= 10<sup>5</sup></code></li>
 * 	<li><code>1 <= nums[i] <= 2 * 10<sup>5</sup></code></li>
 * </ul>
 * 
 * 
 * @author Leammin
 * @date 2021-04-04
 */
public interface NumberOfDifferentSubsequencesGcds {
    int countDifferentSubsequenceGCDs(int[] nums);

    class Solution implements NumberOfDifferentSubsequencesGcds {

        @Override
        public int countDifferentSubsequenceGCDs(int[] nums) {
            int max = 0;
            for (int num : nums) {
                max = Math.max(max, num);
            }
            boolean[] contains = new boolean[max + 1];
            for (int num : nums) {
                contains[num] = true;
            }
            int res = 0;
            for (int i = 1; i <= max; i++) {
                if (!contains[i]) {
                    int t = 0;
                    for (int j = i + i; j <= max && t != i; j += i) {
                        if (contains[j]) {
                            if (t == 0) {
                                t = j;
                            } else {
                                t = gcd(t, j);
                                contains[t] = true;
                            }
                        }
                    }
                }
                if (contains[i]) {
                    res++;
                }
            }
            return res;
        }

        private int gcd(int a, int b) {
            if (a < b) {
                int temp = a;
                a = b;
                b = temp;
            }
            while (b != 0) {
                int temp = a % b;
                a = b;
                b = temp;
            }
            return a;
        }
    }
}
