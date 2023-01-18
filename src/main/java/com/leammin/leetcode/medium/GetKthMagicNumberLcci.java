package com.leammin.leetcode.medium;

import java.util.HashMap;
import java.util.PriorityQueue;

/**
 * 面试题 17.09. 第 k 个数
 *
 * <p>有些数的素因子只有 3，5，7，请设计一个算法找出第 k 个数。注意，不是必须有这些素因子，而是必须不包含其他的素因子。例如，前几个数按顺序应该是 1，3，5，7，9，15，21。</p>
 *
 * <p><strong>示例 1:</strong></p>
 *
 * <pre><strong>输入: </strong>k = 5
 *
 * <strong>输出: </strong>9
 * </pre>
 *
 * @author Leammin
 * @date 2022-09-28
 */
public interface GetKthMagicNumberLcci {
    int getKthMagicNumber(int k);

    class Solution implements GetKthMagicNumberLcci {

        @Override
        public int getKthMagicNumber(int k) {
            if (k <= 1) {
                return k;
            }
            PriorityQueue<Long> minHeap = new PriorityQueue<>();
            HashMap<Long, Boolean> exists = new HashMap<>();
            minHeap.add(1L);
            exists.put(1L, true);
            for (int i = 0; i < k - 1; i++) {
                long min = minHeap.poll();
                exists.computeIfAbsent(min * 3, minHeap::add);
                exists.computeIfAbsent(min * 5, minHeap::add);
                exists.computeIfAbsent(min * 7, minHeap::add);
            }
            return Math.toIntExact(minHeap.peek());
        }
    }

    class Solution2 implements GetKthMagicNumberLcci {

        @Override
        public int getKthMagicNumber(int k) {
            if (k <= 1) {
                return k;
            }
            int[] ugly = new int[k];
            ugly[0] = 1;
            int x = 0, y = 0, z = 0;
            for (int i = 1; i < k; i++) {
                ugly[i] = Math.min(Math.min(ugly[x] * 3, ugly[y] * 5), ugly[z] * 7);
                if (ugly[i] == ugly[x] * 3) x++;
                if (ugly[i] == ugly[y] * 5) y++;
                if (ugly[i] == ugly[z] * 7) z++;
            }
            return ugly[k - 1];
        }
    }
}
