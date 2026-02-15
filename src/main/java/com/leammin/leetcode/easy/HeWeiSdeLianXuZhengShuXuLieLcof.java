package com.leammin.leetcode.easy;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import com.google.common.primitives.Ints;
import com.leammin.leetcode.util.test.AbstractTest;
import com.leammin.leetcode.util.test.Testsuite;
import com.leammin.leetcode.util.test.VerifiableTestcase;
import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * 面试题57 - II. 和为s的连续正数序列
 * 
 * <p>输入一个正整数 <code>target</code> ，输出所有和为 <code>target</code> 的连续正整数序列（至少含有两个数）。</p>
 * 
 * <p>序列内的数字由小到大排列，不同序列按照首个数字从小到大排列。</p>
 * 
 * <p>&nbsp;</p>
 * 
 * <p><strong>示例 1：</strong></p>
 * 
 * <pre><strong>输入：</strong>target = 9
 * <strong>输出：</strong>[[2,3,4],[4,5]]
 * </pre>
 * 
 * <p><strong>示例 2：</strong></p>
 * 
 * <pre><strong>输入：</strong>target = 15
 * <strong>输出：</strong>[[1,2,3,4,5],[4,5,6],[7,8]]
 * </pre>
 * 
 * <p>&nbsp;</p>
 * 
 * <p><strong>限制：</strong></p>
 * 
 * <ul>
 * 	<li><code>1 &lt;= target &lt;= 10^5</code></li>
 * </ul>
 * 
 * <p>&nbsp;</p>
 * 
 * 
 * @author Leammin
 * @date 2020-03-07
 */
public interface HeWeiSdeLianXuZhengShuXuLieLcof {
    int[][] findContinuousSequence(int target);

    static Testsuite<HeWeiSdeLianXuZhengShuXuLieLcof> testsuite() {
        return Testsuite.<HeWeiSdeLianXuZhengShuXuLieLcof>builder()
                .add(VerifiableTestcase.of(t -> t.findContinuousSequence(9), output -> {
                    List<List<Integer>> expected = List.of(
                            List.of(2, 3, 4),
                            List.of(4, 5)
                    );
                    List<List<Integer>> outputSet = Arrays.stream(output)
                            .map(Ints::asList)
                            .collect(Collectors.toList());
                    return expected.equals(outputSet);
                }))
                .add(VerifiableTestcase.of(t -> t.findContinuousSequence(15), output -> {
                    List<List<Integer>> expected = List.of(
                            List.of(1, 2, 3, 4, 5),
                            List.of(4, 5, 6),
                            List.of(7, 8)
                    );
                    List<List<Integer>> outputSet = Arrays.stream(output)
                            .map(Ints::asList)
                            .collect(Collectors.toList());
                    return expected.equals(outputSet);
                }))
                .build();
    }


    class Solution implements HeWeiSdeLianXuZhengShuXuLieLcof {

        @Override
        public int[][] findContinuousSequence(int target) {
            List<int[]> result = new ArrayList<>();
            int n = 2;
            int x;
            while ((x = 2 * target - n * n + n) > 0) {
                int y = 2 * n;
                if (x % y == 0) {
                    int[] nums = new int[n];
                    int a = x / y;
                    for (int i = 0; i < n; i++) {
                        nums[i] = a + i;
                    }
                    result.add(nums);
                }
                n++;
            }
            result.sort(Comparator.comparingInt(arr -> arr[0]));
            return result.toArray(int[][]::new);
        }
    }
}

class HeWeiSdeLianXuZhengShuXuLieLcofTest extends AbstractTest<HeWeiSdeLianXuZhengShuXuLieLcof> {
}
