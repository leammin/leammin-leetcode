package com.leammin.leetcode.hard;

/**
 * 765. 情侣牵手
 * 
 * <p>N 对情侣坐在连续排列的 2N 个座位上，想要牵到对方的手。 计算最少交换座位的次数，以便每对情侣可以并肩坐在一起。 <em>一</em>次交换可选择任意两人，让他们站起来交换座位。</p>
 * 
 * <p>人和座位用&nbsp;<code>0</code>&nbsp;到&nbsp;<code>2N-1</code>&nbsp;的整数表示，情侣们按顺序编号，第一对是&nbsp;<code>(0, 1)</code>，第二对是&nbsp;<code>(2, 3)</code>，以此类推，最后一对是&nbsp;<code>(2N-2, 2N-1)</code>。</p>
 * 
 * <p>这些情侣的初始座位&nbsp;&nbsp;<code>row[i]</code>&nbsp;是由最初始坐在第 i 个座位上的人决定的。</p>
 * 
 * <p><strong>示例 1:</strong></p>
 * 
 * <pre>
 * <strong>输入:</strong> row = [0, 2, 1, 3]
 * <strong>输出:</strong> 1
 * <strong>解释:</strong> 我们只需要交换row[1]和row[2]的位置即可。
 * </pre>
 * 
 * <p><strong>示例 2:</strong></p>
 * 
 * <pre>
 * <strong>输入:</strong> row = [3, 2, 0, 1]
 * <strong>输出:</strong> 0
 * <strong>解释:</strong> 无需交换座位，所有的情侣都已经可以手牵手了。
 * </pre>
 * 
 * <p><strong>说明:</strong></p>
 * 
 * <ol>
 * 	<li><code>len(row)</code> 是偶数且数值在&nbsp;<code>[4, 60]</code>范围内。</li>
 * 	<li>可以保证<code>row</code> 是序列&nbsp;<code>0...len(row)-1</code>&nbsp;的一个全排列。</li>
 * </ol>
 * 
 * 
 * @author Leammin
 * @date 2021-02-14
 */
public interface CouplesHoldingHands {
    int minSwapsCouples(int[] row);

    class Solution implements CouplesHoldingHands {

        @Override
        public int minSwapsCouples(int[] row) {
            int[] man = new int[row.length];
            for (int i = 0; i < row.length; i++) {
                man[row[i]] = i;
            }
            int swaps = 0;
            for (int i = 0; i < row.length; i += 2) {
                if (row[i] / 2 != row[i + 1] / 2) {
                    int a = row[i];
                    int b = (a & 1) == 1 ? a - 1 : a + 1;
                    int bi = man[b];
                    int tmp = row[i + 1];
                    row[i + 1] = row[bi];
                    row[bi] = tmp;
                    man[tmp] = bi;
                    man[b] = i + 1;
                    swaps++;
                }
            }
            return swaps;
        }
    }
}
