package com.leammin.leetcode.easy;

import com.leammin.leetcode.util.test.AbstractTest;
import com.leammin.leetcode.util.test.ExpectedTestcase;
import com.leammin.leetcode.util.test.Testsuite;

/**
 * 896. 单调数列
 * 
 * <p>如果数组是单调递增或单调递减的，那么它是<em>单调的</em>。</p>
 * 
 * <p>如果对于所有 <code>i &lt;= j</code>，<code>A[i] &lt;= A[j]</code>，那么数组 <code>A</code> 是单调递增的。 如果对于所有 <code>i &lt;= j</code>，<code>A[i]&gt; = A[j]</code>，那么数组 <code>A</code> 是单调递减的。</p>
 * 
 * <p>当给定的数组 <code>A</code>&nbsp;是单调数组时返回 <code>true</code>，否则返回 <code>false</code>。</p>
 * 
 * <p>&nbsp;</p>
 * 
 * <ol>
 * </ol>
 * 
 * <p><strong>示例 1：</strong></p>
 * 
 * <pre><strong>输入：</strong>[1,2,2,3]
 * <strong>输出：</strong>true
 * </pre>
 * 
 * <p><strong>示例 2：</strong></p>
 * 
 * <pre><strong>输入：</strong>[6,5,4,4]
 * <strong>输出：</strong>true
 * </pre>
 * 
 * <p><strong>示例 3：</strong></p>
 * 
 * <pre><strong>输入：</strong>[1,3,2]
 * <strong>输出：</strong>false
 * </pre>
 * 
 * <p><strong>示例 4：</strong></p>
 * 
 * <pre><strong>输入：</strong>[1,2,4,5]
 * <strong>输出：</strong>true
 * </pre>
 * 
 * <p><strong>示例&nbsp;5：</strong></p>
 * 
 * <pre><strong>输入：</strong>[1,1,1]
 * <strong>输出：</strong>true
 * </pre>
 * 
 * <p>&nbsp;</p>
 * 
 * <p><strong>提示：</strong></p>
 * 
 * <ol>
 * 	<li><code>1 &lt;= A.length &lt;= 50000</code></li>
 * 	<li><code>-100000 &lt;= A[i] &lt;= 100000</code></li>
 * </ol>
 * 
 * 
 * @author Leammin
 * @date 2021-02-28
 */
public interface MonotonicArray {
    boolean isMonotonic(int[] A);

    static Testsuite<MonotonicArray> testsuite() {
        return Testsuite.<MonotonicArray>builder()
                .add(ExpectedTestcase.of(t -> t.isMonotonic(new int[]{1,2,2,3}), true))
                .add(ExpectedTestcase.of(t -> t.isMonotonic(new int[]{1,3,2,3}), false))
                .build();
    }


    class Solution implements MonotonicArray {

        @Override
        public boolean isMonotonic(int[] A) {
            for (int x = 0, i = 1; i < A.length; i++) {
                if (A[i] > A[i - 1] && x < 0 || A[i] < A[i - 1] && x > 0) {
                    return false;
                }
                if (x == 0) {
                    x = A[i] - A[i - 1];
                }
            }
            return true;
        }
    }
}

class MonotonicArrayTest extends AbstractTest<MonotonicArray> {
}
