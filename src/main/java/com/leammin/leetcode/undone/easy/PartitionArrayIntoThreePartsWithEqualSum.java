package com.leammin.leetcode.undone.easy;

/**
 * 1013. 将数组分成和相等的三个部分
 * 
 * <p>给定一个整数数组&nbsp;<code>A</code>，只有我们可以将其划分为三个和相等的非空部分时才返回&nbsp;<code>true</code>，否则返回 <code>false</code>。</p>
 * 
 * <p>形式上，如果我们可以找出索引&nbsp;<code>i+1 &lt; j</code>&nbsp;且满足&nbsp;<code>(A[0] + A[1] + ... + A[i] == A[i+1] + A[i+2] + ... + A[j-1] == A[j] + A[j-1] + ... + A[A.length - 1])</code>&nbsp;就可以将数组三等分。</p>
 * 
 * <p>&nbsp;</p>
 * 
 * <p><strong>示例 1：</strong></p>
 * 
 * <pre><strong>输出：</strong>[0,2,1,-6,6,-7,9,1,2,0,1]
 * <strong>输出：</strong>true
 * <strong>解释：</strong>0 + 2 + 1 = -6 + 6 - 7 + 9 + 1 = 2 + 0 + 1
 * </pre>
 * 
 * <p><strong>示例 2：</strong></p>
 * 
 * <pre><strong>输入：</strong>[0,2,1,-6,6,7,9,-1,2,0,1]
 * <strong>输出：</strong>false
 * </pre>
 * 
 * <p><strong>示例 3：</strong></p>
 * 
 * <pre><strong>输入：</strong>[3,3,6,5,-2,2,5,1,-9,4]
 * <strong>输出：</strong>true
 * <strong>解释：</strong>3 + 3 = 6 = 5 - 2 + 2 + 5 + 1 - 9 + 4
 * </pre>
 * 
 * <p>&nbsp;</p>
 * 
 * <p><strong>提示：</strong></p>
 * 
 * <ol>
 * 	<li><code>3 &lt;= A.length &lt;= 50000</code></li>
 * 	<li><code>-10000 &lt;= A[i] &lt;= 10000</code></li>
 * </ol>
 * 
 * 
 * @author Leammin
 * @date 2020-03-11
 */
public interface PartitionArrayIntoThreePartsWithEqualSum {
    boolean canThreePartsEqualSum(int[] A);

    class Solution implements PartitionArrayIntoThreePartsWithEqualSum {

        @Override
        public boolean canThreePartsEqualSum(int[] A) {
            int sum = 0;
            for (int value : A) {
                sum += value;
            }
            if (sum % 3 != 0) {
                return false;
            }
            int partSum = sum / 3;
            int x = 0;
            int xSum = 0;
            while (x < A.length - 2) {
                xSum += A[x];
                if (xSum == partSum) {
                    break;
                }
                x++;
            }
            if (x == A.length - 2) {
                return false;
            }
            int y = x + 1;
            int ySum = 0;
            while (y < A.length - 1) {
                ySum += A[y];
                if (ySum == partSum) {
                    break;
                }
                y++;
            }
            if (y == A.length - 1) {
                return false;
            }
            int zSum = 0;
            for (int i = y + 1; i < A.length; i++) {
                zSum += A[i];
            }
            return zSum == partSum;
        }


    }
}
