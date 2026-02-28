package com.leammin.leetcode.hard;


import java.util.Arrays;
import java.util.TreeMap;

import com.leammin.leetcode.util.ClassUtils;
import com.leammin.leetcode.util.test.AbstractTest;
import com.leammin.leetcode.util.test.ExpectedTestcase;
import com.leammin.leetcode.util.test.Testsuite;
import java.util.ArrayList;
import java.util.List;

/**
 * 5729. 求出 MK 平均值
 * 
 * <p>给你两个整数 <code>m</code> 和 <code>k</code> ，以及数据流形式的若干整数。你需要实现一个数据结构，计算这个数据流的 <b>MK 平均值</b> 。</p>
 * 
 * <p><strong>MK 平均值</strong> 按照如下步骤计算：</p>
 * 
 * <ol>
 * 	<li>如果数据流中的整数少于 <code>m</code> 个，<strong>MK 平均值</strong> 为 <code>-1</code> ，否则将数据流中最后 <code>m</code> 个元素拷贝到一个独立的容器中。</li>
 * 	<li>从这个容器中删除最小的 <code>k</code> 个数和最大的 <code>k</code> 个数。</li>
 * 	<li>计算剩余元素的平均值，并 <strong>向下取整到最近的整数</strong> 。</li>
 * </ol>
 * 
 * <p>请你实现 <code>MKAverage</code> 类：</p>
 * 
 * <ul>
 * 	<li><code>MKAverage(int m, int k)</code> 用一个空的数据流和两个整数 <code>m</code> 和 <code>k</code> 初始化 <strong>MKAverage</strong> 对象。</li>
 * 	<li><code>void addElement(int num)</code> 往数据流中插入一个新的元素 <code>num</code> 。</li>
 * 	<li><code>int calculateMKAverage()</code> 对当前的数据流计算并返回 <strong>MK 平均数</strong> ，结果需 <strong>向下取整到最近的整数</strong> 。</li>
 * </ul>
 * 
 * <p> </p>
 * 
 * <p><strong>示例 1：</strong></p>
 * 
 * <pre>
 * <strong>输入：</strong>
 * ["MKAverage", "addElement", "addElement", "calculateMKAverage", "addElement", "calculateMKAverage", "addElement", "addElement", "addElement", "calculateMKAverage"]
 * [[3, 1], [3], [1], [], [10], [], [5], [5], [5], []]
 * <strong>输出：</strong>
 * [null, null, null, -1, null, 3, null, null, null, 5]
 * 
 * <strong>解释：</strong>
 * MKAverage obj = new MKAverage(3, 1); 
 * obj.addElement(3);        // 当前元素为 [3]
 * obj.addElement(1);        // 当前元素为 [3,1]
 * obj.calculateMKAverage(); // 返回 -1 ，因为 m = 3 ，但数据流中只有 2 个元素
 * obj.addElement(10);       // 当前元素为 [3,1,10]
 * obj.calculateMKAverage(); // 最后 3 个元素为 [3,1,10]
 *                           // 删除最小以及最大的 1 个元素后，容器为 <code>[3]
 *                           // [3] 的平均值等于 3/1 = 3 ，故返回 3
 * obj.addElement(5);        // 当前元素为 [3,1,10,5]
 * obj.addElement(5);        // 当前元素为 [3,1,10,5,5]
 * obj.addElement(5);        // 当前元素为 [3,1,10,5,5,5]
 * obj.calculateMKAverage(); // 最后 3 个元素为 [5,5,5]
 *                           // </code>删除最小以及最大的 1 个元素后，容器为 <code>[5]<code>
 *                           // </code>[5] 的平均值等于 5/1 = 5 ，故返回 5<code>
 * </code></code></pre>
 * 
 * <p> </p>
 * 
 * <p><strong>提示：</strong></p>
 * 
 * <ul>
 * 	<li><code>3 <= m <= 10<sup>5</sup></code></li>
 * 	<li><code>1 <= k*2 < m</code></li>
 * 	<li><code>1 <= num <= 10<sup>5</sup></code></li>
 * 	<li><code>addElement</code> 与 <code>calculateMKAverage</code> 总操作次数不超过 <code>10<sup>5</sup></code> 次。</li>
 * </ul>
 * 
 * 
 * @author Leammin
 * @date 2021-04-11
 */
public abstract class FindingMkAverage {
    public FindingMkAverage(int m, int k){

    }

    public abstract void addElement(int num);

    public abstract int calculateMKAverage();

    static class Solution extends FindingMkAverage {
        private int m;
        private int k;
        int[] nums;
        int size = 0;

        public Solution(int m, int k) {
            super(m, k);
            this.m = m;
            this.k = k;
            nums = new int[m];
        }

        @Override
        public void addElement(int num) {
            nums[size % m] = num;
            size++;
        }

        @Override
        public int calculateMKAverage() {
            if (size < m) {
                return -1;
            }
            int[] clone = nums.clone();
            Arrays.sort(clone);
            long sum = 0;
            for (int i = k; i < m - k; i++) {
                sum += clone[i];
            }
            return (int) (sum / (m - 2 * k));
        }
    }

    static class Solution2 extends FindingMkAverage {
        static class CountMap {
            private TreeMap<Integer, Integer> map = new TreeMap<>();
            private int count;
            private int capacity;
            private long sum;

            public CountMap(int capacity) {
                this.capacity = capacity;
            }

            public int capacity() {
                return capacity;
            }

            public int get(int num) {
                return map.getOrDefault(num, 0);
            }

            public int max() {
                return map.lastKey();
            }

            public int min() {
                return map.firstKey();
            }

            public int count() {
                return count;
            }

            public long sum() {
                return sum;
            }

            public void add(int num) {
                map.compute(num, (key, value) -> value == null ? 1 : (value + 1));
                count++;
                sum += num;
            }

            public boolean remove(int num) {
                int c;
                if ((c = get(num)) > 0) {
                    if (c == 1) {
                        map.remove(num);
                    } else {
                        map.put(num, c - 1);
                    }
                    count--;
                    sum -= num;
                    return true;
                }
                return false;
            }
        }

        private int m;
        private int k;
        int[] nums;
        int size = 0;
        CountMap left;
        CountMap mid;
        CountMap right;

        public Solution2(int m, int k) {
            super(m, k);
            this.m = m;
            this.k = k;
            nums = new int[m];
            left = new CountMap(k);
            mid = new CountMap(m - 2 * k);
            right = new CountMap(k);
        }

        @Override
        public void addElement(int num) {
            int removed = nums[size % m];
            nums[size % m] = num;
            size++;
            if (size == m) {
                // init
                int[] clone = nums.clone();
                Arrays.sort(clone);
                for (int i = 0; i < k; i++) {
                    left.add(clone[i]);
                    right.add(clone[m - i - 1]);
                }
                for (int i = k; i < m - k; i++) {
                    mid.add(clone[i]);
                }
            } else if (size > m) {
                // insert
                if (num <= left.max()) {
                    left.add(num);
                } else if (num <= mid.max()) {
                    mid.add(num);
                } else {
                    right.add(num);
                }
                // remove
                boolean r = left.remove(removed) || mid.remove(removed) || right.remove(removed);

                CountMap[] countMaps = new CountMap[]{left, mid, right};
                for (int i = 0; i < 2; i++) {
                    if (countMaps[i].count() > countMaps[i].capacity()) {
                        int imax = countMaps[i].max();
                        countMaps[i].remove(imax);
                        countMaps[i + 1].add(imax);
                    }
                }
                for (int i = 2; i > 0; i--) {
                    if (countMaps[i].count() > countMaps[i].capacity()) {
                        int imin = countMaps[i].min();
                        countMaps[i].remove(imin);
                        countMaps[i - 1].add(imin);
                    }
                }
            }
        }


        @Override
        public int calculateMKAverage() {
            if (size < m) {
                return -1;
            }
            return (int) (mid.sum() / mid.count());
        }
    }

    static Testsuite<FindingMkAverage> testsuite() {
        return Testsuite.<FindingMkAverage>builder()
                .add(ExpectedTestcase.create(c -> ClassUtils.newInstance(c, 3, 1), t -> {
                    List<Integer> res = new ArrayList<>();
                    t.addElement(3);
                    t.addElement(1);
                    res.add(t.calculateMKAverage());
                    t.addElement(10);
                    res.add(t.calculateMKAverage());
                    t.addElement(5);
                    t.addElement(5);
                    t.addElement(5);
                    res.add(t.calculateMKAverage());
                    return res;
                }, List.of(-1, 3, 5)))
                .add(ExpectedTestcase.create(c -> ClassUtils.newInstance(c, 3, 1), t -> {
                    List<Integer> res = new ArrayList<>();
                    t.addElement(17612);
                    t.addElement(74607);
                    res.add(t.calculateMKAverage());
                    t.addElement(8272);
                    t.addElement(33433);
                    res.add(t.calculateMKAverage());
                    t.addElement(15456);
                    t.addElement(64938);
                    res.add(t.calculateMKAverage());
                    t.addElement(99741);
                    return res;
                }, List.of(-1, 33433, 33433)))
                .build();
    }
}

class FindingMkAverageTest extends AbstractTest<FindingMkAverage> {
}
