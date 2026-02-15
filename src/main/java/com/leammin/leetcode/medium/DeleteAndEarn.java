package com.leammin.leetcode.medium;

import com.leammin.leetcode.util.test.AbstractTest;
import com.leammin.leetcode.util.test.Testsuite;

/**
 * 740. 删除与获得点数
 * 
 * <p>给定一个整数数组&nbsp;<code>nums</code>&nbsp;，你可以对它进行一些操作。</p>
 * 
 * <p>每次操作中，选择任意一个&nbsp;<code>nums[i]</code>&nbsp;，删除它并获得&nbsp;<code>nums[i]</code>&nbsp;的点数。之后，你必须删除<strong>每个</strong>等于&nbsp;<code>nums[i] - 1</code>&nbsp;或&nbsp;<code>nums[i] + 1</code>&nbsp;的元素。</p>
 * 
 * <p>开始你拥有 0 个点数。返回你能通过这些操作获得的最大点数。</p>
 * 
 * <p><strong>示例 1:</strong></p>
 * 
 * <pre>
 * <strong>输入:</strong> nums = [3, 4, 2]
 * <strong>输出:</strong> 6
 * <strong>解释:</strong> 
 * 删除 4 来获得 4 个点数，因此 3 也被删除。
 * 之后，删除 2 来获得 2 个点数。总共获得 6 个点数。
 * </pre>
 * 
 * <p><strong>示例&nbsp;2:</strong></p>
 * 
 * <pre>
 * <strong>输入:</strong> nums = [2, 2, 3, 3, 3, 4]
 * <strong>输出:</strong> 9
 * <strong>解释:</strong> 
 * 删除 3 来获得 3 个点数，接着要删除两个 2 和 4 。
 * 之后，再次删除 3 获得 3 个点数，再次删除 3 获得 3 个点数。
 * 总共获得 9 个点数。
 * </pre>
 * 
 * <p><strong>注意:</strong></p>
 * 
 * <ul>
 * 	<li><code>nums</code>的长度最大为<code>20000</code>。</li>
 * 	<li>每个整数<code>nums[i]</code>的大小都在<code>[1, 10000]</code>范围内。</li>
 * </ul>
 * 
 * 
 * @author Leammin
 * @date 2021-05-05
 */
public interface DeleteAndEarn {
    int deleteAndEarn(int[] nums);

    static Testsuite<DeleteAndEarn> testsuite() {
        return Testsuite.<DeleteAndEarn>builder()
            .addExpected(t -> t.deleteAndEarn(new int[]{3, 4, 2}), 6)
            .addExpected(t -> t.deleteAndEarn(new int[]{2, 2, 3, 3, 3, 4}), 9)
                .build();
    }


    class Solution implements DeleteAndEarn {

        @Override
        public int deleteAndEarn(int[] nums) {
            int[] count = new int[10001];
            for (int num : nums) {
                count[num]++;
            }
            int a = 0, b = 0;
            for (int i = 1; i < count.length; i++) {
                int c = Math.max(a + i * count[i], b);
                a = b;
                b = c;
            }
            return b;
        }
    }
}

class DeleteAndEarnTest extends AbstractTest<DeleteAndEarn> {
}
