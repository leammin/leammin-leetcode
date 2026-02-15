package com.leammin.leetcode.easy;

import java.util.*;

import com.leammin.leetcode.util.test.AbstractTest;
import com.leammin.leetcode.util.test.ExpectedTestcase;
import com.leammin.leetcode.util.test.Testsuite;

/**
 * 1365. 有多少小于当前数字的数字
 * 
 * <p>给你一个数组&nbsp;<code>nums</code>，对于其中每个元素&nbsp;<code>nums[i]</code>，请你统计数组中比它小的所有数字的数目。</p>
 * 
 * <p>换而言之，对于每个&nbsp;<code>nums[i]</code>&nbsp;你必须计算出有效的&nbsp;<code>j</code>&nbsp;的数量，其中 <code>j</code> 满足&nbsp;<code>j != i</code> <strong>且</strong> <code>nums[j] &lt; nums[i]</code>&nbsp;。</p>
 * 
 * <p>以数组形式返回答案。</p>
 * 
 * <p>&nbsp;</p>
 * 
 * <p><strong>示例 1：</strong></p>
 * 
 * <pre><strong>输入：</strong>nums = [8,1,2,2,3]
 * <strong>输出：</strong>[4,0,1,1,3]
 * <strong>解释：</strong> 
 * 对于 nums[0]=8 存在四个比它小的数字：（1，2，2 和 3）。 
 * 对于 nums[1]=1 不存在比它小的数字。
 * 对于 nums[2]=2 存在一个比它小的数字：（1）。 
 * 对于 nums[3]=2 存在一个比它小的数字：（1）。 
 * 对于 nums[4]=3 存在三个比它小的数字：（1，2 和 2）。
 * </pre>
 * 
 * <p><strong>示例 2：</strong></p>
 * 
 * <pre><strong>输入：</strong>nums = [6,5,4,8]
 * <strong>输出：</strong>[2,1,0,3]
 * </pre>
 * 
 * <p><strong>示例 3：</strong></p>
 * 
 * <pre><strong>输入：</strong>nums = [7,7,7,7]
 * <strong>输出：</strong>[0,0,0,0]
 * </pre>
 * 
 * <p>&nbsp;</p>
 * 
 * <p><strong>提示：</strong></p>
 * 
 * <ul>
 * 	<li><code>2 &lt;= nums.length &lt;= 500</code></li>
 * 	<li><code>0 &lt;= nums[i] &lt;= 100</code></li>
 * </ul>
 * 
 * 
 * @author Leammin
 * @date 2020-10-26
 */
public interface HowManyNumbersAreSmallerThanTheCurrentNumber {

    int[] smallerNumbersThanCurrent(int[] nums);

    static Testsuite<HowManyNumbersAreSmallerThanTheCurrentNumber> testsuite() {
        return Testsuite.<HowManyNumbersAreSmallerThanTheCurrentNumber>builder()
                .add(ExpectedTestcase.of(t -> t.smallerNumbersThanCurrent(new int[]{8,1,2,2,3}), new int[]{4,0,1,1,3}))
                .add(ExpectedTestcase.of(t -> t.smallerNumbersThanCurrent(new int[]{6,5,4,8}), new int[]{2,1,0,3}))
                .add(ExpectedTestcase.of(t -> t.smallerNumbersThanCurrent(new int[]{7,7,7,7}), new int[]{0,0,0,0}))
                .build();
    }


    class Solution implements HowManyNumbersAreSmallerThanTheCurrentNumber {

        @Override
        public int[] smallerNumbersThanCurrent(int[] nums) {
            int[] cn = nums.clone();
            Arrays.sort(cn);
            Map<Integer, List<Integer>> map = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                map.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
            }
            int[] result = new int[nums.length];
            for (int i = 0; i < cn.length; i++) {
                if (i != 0 && cn[i - 1] == cn[i]) {
                    continue;
                }
                for (Integer index : map.getOrDefault(cn[i], Collections.emptyList())) {
                    result[index] = i;
                }
            }
            return result;
        }
    }

    class Solution2 implements HowManyNumbersAreSmallerThanTheCurrentNumber {

        @Override
        public int[] smallerNumbersThanCurrent(int[] nums) {
            int[] b = new int[101];
            for (int num : nums) {
                b[num]++;
            }
            int c = 0;
            for (int i = 0; i < b.length; i++) {
                int t = b[i];
                b[i] = c;
                c += t;
            }
            int[] result = new int[nums.length];
            for (int i = 0; i < nums.length; i++) {
                result[i] = b[nums[i]];
            }
            return result;
        }
    }
}

class HowManyNumbersAreSmallerThanTheCurrentNumberTest extends AbstractTest<HowManyNumbersAreSmallerThanTheCurrentNumber> {
}
