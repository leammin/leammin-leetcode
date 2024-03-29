package com.leammin.leetcode.medium;

/**
 * 338. 比特位计数
 *
 * <div><p>给定一个非负整数&nbsp;<strong>num</strong>。对于&nbsp;<strong>0 ≤ i ≤ num </strong>范围中的每个数字&nbsp;<strong>i&nbsp;</strong>，计算其二进制数中的 1 的数目并将它们作为数组返回。</p>
 *
 * <p><strong>示例 1:</strong></p>
 *
 * <pre><strong>输入: </strong>2
 * <strong>输出: </strong>[0,1,1]</pre>
 *
 * <p><strong>示例&nbsp;2:</strong></p>
 *
 * <pre><strong>输入: </strong>5
 * <strong>输出: </strong><code>[0,1,1,2,1,2]</code></pre>
 *
 * <p><strong>进阶:</strong></p>
 *
 * <ul>
 * <li>给出时间复杂度为<strong>O(n*sizeof(integer))</strong>的解答非常容易。但你可以在线性时间<strong>O(n)</strong>内用一趟扫描做到吗？</li>
 * <li>要求算法的空间复杂度为<strong>O(n)</strong>。</li>
 * <li>你能进一步完善解法吗？要求在C++或任何其他语言中不使用任何内置函数（如 C++ 中的&nbsp;<strong>__builtin_popcount</strong>）来执行此操作。</li>
 * </ul>
 * </div>
 *
 * @author Leammin
 * @date 2019-03-24
 */
public interface CountingBits {
    int[] countBits(int num);

    class Solution implements CountingBits {
        @Override
        public int[] countBits(int num) {
            int[] res = new int[num + 1];
            for (int i = 1; i < res.length; i++) {
                res[i] = res[i >> 1] + (i & 1);
            }
            return res;
        }
    }

    class Solution1 implements CountingBits {
        @Override
        public int[] countBits(int num) {
            int[] res = new int[num + 1];
            if (num == 0) {
                return res;
            }
            int f = 1;
            for (int i = 1; i < res.length; i++) {
                int t = f << 1;
                if (i < t) {
                    res[i] = 1 + res[i - f];
                } else {
                    res[i] = 1;
                    f = t;
                }
            }
            return res;
        }
    }
}
