package com.leammin.leetcode.easy;

import java.util.Arrays;

/**
 * 1046. 最后一块石头的重量
 * 
 * <p>有一堆石头，每块石头的重量都是正整数。</p>
 * 
 * <p>每一回合，从中选出两块<strong>最重的</strong>石头，然后将它们一起粉碎。假设石头的重量分别为&nbsp;<code>x</code> 和&nbsp;<code>y</code>，且&nbsp;<code>x &lt;= y</code>。那么粉碎的可能结果如下：</p>
 * 
 * <ul>
 * 	<li>如果&nbsp;<code>x == y</code>，那么两块石头都会被完全粉碎；</li>
 * 	<li>如果&nbsp;<code>x != y</code>，那么重量为&nbsp;<code>x</code>&nbsp;的石头将会完全粉碎，而重量为&nbsp;<code>y</code>&nbsp;的石头新重量为&nbsp;<code>y-x</code>。</li>
 * </ul>
 * 
 * <p>最后，最多只会剩下一块石头。返回此石头的重量。如果没有石头剩下，就返回 <code>0</code>。</p>
 * 
 * <p>&nbsp;</p>
 * 
 * <p><strong>提示：</strong></p>
 * 
 * <ol>
 * 	<li><code>1 &lt;= stones.length &lt;= 30</code></li>
 * 	<li><code>1 &lt;= stones[i] &lt;= 1000</code></li>
 * </ol>
 * 
 * 
 * @author Leammin
 * @date 2019-08-26
 */
public interface LastStoneWeight {
    int lastStoneWeight(int[] stones);

    class Solution implements LastStoneWeight {
        @Override
        public int lastStoneWeight(int[] stones) {
            if (stones == null || stones.length == 0) {
                return 0;
            }
            if (stones.length == 1) {
                return stones[0];
            }
            Arrays.sort(stones);
            for (int i = stones.length - 2; i >= 0; i--) {
                stones[i] = stones[i + 1] - stones[i];
                bubble(stones, i);
            }
            return stones[0];
        }

        private void bubble(int[] array, int index) {
            for (; index > 0 && array[index - 1] > array[index]; index--) {
                int temp = array[index - 1];
                array[index - 1] = array[index];
                array[index] = temp;
            }
        }
    }
}
