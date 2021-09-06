package com.leammin.leetcode.medium;

/**
 * 面试题14- II. 剪绳子 II
 * 
 * <p>给你一根长度为 <code>n</code> 的绳子，请把绳子剪成整数长度的 <code>m</code> 段（m、n都是整数，n&gt;1并且m&gt;1），每段绳子的长度记为 <code>k[0],k[1]...k[m]</code> 。请问 <code>k[0]*k[1]*...*k[m]</code> 可能的最大乘积是多少？例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。</p>
 * 
 * <p>答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。</p>
 * 
 * <p>&nbsp;</p>
 * 
 * <p><strong>示例 1：</strong></p>
 * 
 * <pre><strong>输入: </strong>2
 * <strong>输出: </strong>1
 * <strong>解释: </strong>2 = 1 + 1, 1 &times; 1 = 1</pre>
 * 
 * <p><strong>示例&nbsp;2:</strong></p>
 * 
 * <pre><strong>输入: </strong>10
 * <strong>输出: </strong>36
 * <strong>解释: </strong>10 = 3 + 3 + 4, 3 &times;&nbsp;3 &times;&nbsp;4 = 36</pre>
 * 
 * <p>&nbsp;</p>
 * 
 * <p><strong>提示：</strong></p>
 * 
 * <ul>
 * 	<li><code>2 &lt;= n &lt;= 1000</code></li>
 * </ul>
 * 
 * <p>注意：本题与主站 343 题相同：<a href="https://leetcode-cn.com/problems/integer-break/">https://leetcode-cn.com/problems/integer-break/</a></p>
 * 
 * 
 * @author Leammin
 * @date 2021-09-06
 */
public interface JianShengZiIiLcof {
    int cuttingRope(int n);

    class Solution implements JianShengZiIiLcof {

        @Override
        public int cuttingRope(int n) {
            if (n <= 3) {
                return n - 1;
            }
            int m = n / 3;
            switch (n % 3) {
                case 0:
                    return threePow(1, m);
                case 1:
                    return threePow(4, m - 1);
                case 2:
                    return threePow(2, m);
                default:
                    throw new RuntimeException();
            }
        }

        private int threePow(int k, int n) {
            long r = k;
            while (n > 0) {
                r *= n >= 19 ? 1162261467 : (int) Math.pow(3, n);
                r %= 1000000007;
                n -= 19;
            }
            return (int) r;
        }
    }

    public static void main(String[] args) {
        System.out.println(Math.log(Long.MAX_VALUE) / Math.log(3));
    }
}
