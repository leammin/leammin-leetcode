package com.leammin.leetcode.medium;

import com.leammin.leetcode.util.Execute;
import com.leammin.leetcode.util.test.AbstractTest;
import com.leammin.leetcode.util.test.Testsuite;

/**
 * 1144. 递减元素使数组呈锯齿状
 *
 * <p>给你一个整数数组&nbsp;<code>nums</code>，每次 <strong>操作</strong>&nbsp;会从中选择一个元素并 <strong>将该元素的值减少&nbsp;1</strong>。</p>
 *
 * <p>如果符合下列情况之一，则数组&nbsp;<code>A</code>&nbsp;就是 <strong>锯齿数组</strong>：</p>
 *
 * <ul>
 * 	<li>每个偶数索引对应的元素都大于相邻的元素，即&nbsp;<code>A[0] &gt; A[1] &lt; A[2] &gt; A[3] &lt; A[4] &gt; ...</code></li>
 * 	<li>或者，每个奇数索引对应的元素都大于相邻的元素，即&nbsp;<code>A[0] &lt; A[1] &gt; A[2] &lt; A[3] &gt; A[4] &lt; ...</code></li>
 * </ul>
 *
 * <p>返回将数组&nbsp;<code>nums</code>&nbsp;转换为锯齿数组所需的最小操作次数。</p>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>示例 1：</strong></p>
 *
 * <pre><strong>输入：</strong>nums = [1,2,3]
 * <strong>输出：</strong>2
 * <strong>解释：</strong>我们可以把 2 递减到 0，或把 3 递减到 1。
 * </pre>
 *
 * <p><strong>示例 2：</strong></p>
 *
 * <pre><strong>输入：</strong>nums = [9,6,1,6,2]
 * <strong>输出：</strong>4
 * </pre>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>提示：</strong></p>
 *
 * <ul>
 * 	<li><code>1 &lt;= nums.length &lt;= 1000</code></li>
 * 	<li><code>1 &lt;= nums[i] &lt;= 1000</code></li>
 * </ul>
 *
 * @author Leammin
 * @date 2023-02-27
 */
public interface DecreaseElementsToMakeArrayZigzag {
    int movesToMakeZigzag(int[] nums);

    static Testsuite<DecreaseElementsToMakeArrayZigzag> testsuite() {
        return Testsuite.<DecreaseElementsToMakeArrayZigzag>builder()
                .addExpected(t -> t.movesToMakeZigzag(new int[]{1,2,3}), 2)
                .addExpected(t -> t.movesToMakeZigzag(new int[]{9,6,1,6,2}), 4)
                .build();
    }
    @Execute(cases = -1)


    class Solution implements DecreaseElementsToMakeArrayZigzag {

        @Override
        public int movesToMakeZigzag(int[] nums) {
            return Math.min(peak(0, nums), peak(1, nums));
        }

        private int peak(int s, int[] nums) {
            int res = 0;
            int near = s == 0 ? 0 :nums[s - 1];
            for (int i = s; i < nums.length; i += 2) {
                if (near >= nums[i]) {
                    res += near - nums[i] + 1;
                }
                if (i < nums.length - 1) {
                    near = nums[i + 1];
                    if (near >= nums[i]) {
                        res += near - nums[i] + 1;
                        near = nums[i] - 1;
                    }
                }
            }
            return res;
        }
    }
}

class DecreaseElementsToMakeArrayZigzagTest extends AbstractTest<DecreaseElementsToMakeArrayZigzag> {
}
