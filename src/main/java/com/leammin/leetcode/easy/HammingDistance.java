package com.leammin.leetcode.easy;

/**
 * 461. 汉明距离
 *
 * <div><p>两个整数之间的<a href="https://baike.baidu.com/item/%E6%B1%89%E6%98%8E%E8%B7%9D%E7%A6%BB">汉明距离</a>指的是这两个数字对应二进制位不同的位置的数目。</p>
 *
 * <p>给出两个整数 <code>x</code> 和 <code>y</code>，计算它们之间的汉明距离。</p>
 *
 * <p><strong>注意：</strong><br>
 * 0 ≤ <code>x</code>, <code>y</code> &lt; 2<sup>31</sup>.</p>
 *
 * <p><strong>示例:</strong></p>
 *
 * <pre><strong>输入:</strong> x = 1, y = 4
 *
 * <strong>输出:</strong> 2
 *
 * <strong>解释:</strong>
 * 1   (0 0 0 1)
 * 4   (0 1 0 0)
 *        ↑   ↑
 *
 * 上面的箭头指出了对应二进制位不同的位置。
 * </pre>
 * </div>
 *
 * @author Leammin
 * @date 2018-09-10
 */
public interface HammingDistance {
    int hammingDistance(int x, int y);
    class Solution implements HammingDistance {
        @Override
        public int hammingDistance(int x, int y) {
            return hammingWeight(x ^ y);
        }

        private int hammingWeight(int n) {
            int res = 0;
            int c = 1;
            for (int i = 0; i < 32; i++) {
                if ((n & c) != 0) {
                    res++;
                }
                c = c << 1;
            }
            return res;
        }
    }

}
