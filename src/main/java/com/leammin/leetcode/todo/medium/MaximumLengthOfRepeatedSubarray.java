package com.leammin.leetcode.todo.medium;

import java.util.ArrayList;
import java.util.List;

import com.leammin.leetcode.util.test.AbstractTest;
import com.leammin.leetcode.util.test.ExpectedTestcase;
import com.leammin.leetcode.util.test.Testsuite;

/**
 * 718. 最长重复子数组
 * 
 * <p>给两个整数数组&nbsp;<code>A</code>&nbsp;和&nbsp;<code>B</code>&nbsp;，返回两个数组中公共的、长度最长的子数组的长度。</p>
 * 
 * <p><strong>示例 1:</strong></p>
 * 
 * <pre>
 * <strong>输入:</strong>
 * A: [1,2,3,2,1]
 * B: [3,2,1,4,7]
 * <strong>输出:</strong> 3
 * <strong>解释:</strong> 
 * 长度最长的公共子数组是 [3, 2, 1]。
 * </pre>
 * 
 * <p><strong>说明:</strong></p>
 * 
 * <ol>
 * 	<li>1 &lt;= len(A), len(B) &lt;= 1000</li>
 * 	<li>0 &lt;= A[i], B[i] &lt; 100</li>
 * </ol>
 * 
 * 
 * @author Leammin
 * @date 2020-07-01
 */
public interface MaximumLengthOfRepeatedSubarray {
    int findLength(int[] A, int[] B);

    static Testsuite<MaximumLengthOfRepeatedSubarray> testsuite() {
        return Testsuite.<MaximumLengthOfRepeatedSubarray>builder()
                .add(ExpectedTestcase.of(t -> t.findLength(new int[]{1,2,3,2,1}, new int[]{3,2,1,4,7}), 3))
                .build();
    }


    class Solution implements MaximumLengthOfRepeatedSubarray {

        @Override
        public int findLength(int[] A, int[] B) {
            List<Integer>[] map = new List[100];
            for (int i = 0; i < A.length; i++) {
                if (map[A[i]] == null) {
                    map[A[i]] = new ArrayList<>();
                }
                map[A[i]].add(i);
            }
            int max = 0;
            for (int i = 0; i < B.length; i++) {
                List<Integer> list = map[B[i]];
                if (list == null) {
                    continue;
                }
                for (int a : list) {
                    int len = 0;
                    int b = i;
                    while (a < A.length && b < B.length && A[a] == B[b]) {
                        a++;
                        b++;
                        len++;
                    }
                    max = Math.max(max, len);
                }
            }
            return max;
        }
    }
}

class MaximumLengthOfRepeatedSubarrayTest extends AbstractTest<MaximumLengthOfRepeatedSubarray> {
}
