package com.leammin.leetcode.medium;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.TreeMap;

/**
 * 面试题59 - II. 队列的最大值
 *
 * <p>请定义一个队列并实现函数 <code>max_value</code> 得到队列里的最大值，要求函数<code>max_value</code>、<code>push_back</code> 和 <code>pop_front</code> 的<strong>均摊</strong>时间复杂度都是O(1)。</p>
 *
 * <p>若队列为空，<code>pop_front</code> 和 <code>max_value</code>&nbsp;需要返回 -1</p>
 *
 * <p><strong>示例 1：</strong></p>
 *
 * <pre><strong>输入:</strong>
 * [&quot;MaxQueue&quot;,&quot;push_back&quot;,&quot;push_back&quot;,&quot;max_value&quot;,&quot;pop_front&quot;,&quot;max_value&quot;]
 * [[],[1],[2],[],[],[]]
 * <strong>输出:&nbsp;</strong>[null,null,null,2,1,2]
 * </pre>
 *
 * <p><strong>示例 2：</strong></p>
 *
 * <pre><strong>输入:</strong>
 * [&quot;MaxQueue&quot;,&quot;pop_front&quot;,&quot;max_value&quot;]
 * [[],[],[]]
 * <strong>输出:&nbsp;</strong>[null,-1,-1]
 * </pre>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>限制：</strong></p>
 *
 * <ul>
 * 	<li><code>1 &lt;= push_back,pop_front,max_value的总操作数&nbsp;&lt;= 10000</code></li>
 * 	<li><code>1 &lt;= value &lt;= 10^5</code></li>
 * </ul>
 *
 * @author Leammin
 * @date 2020-03-07
 */
public interface DuiLieDeZuiDaZhiLcof {

    int max_value();

    void push_back(int value);

    int pop_front();

    class Solution implements DuiLieDeZuiDaZhiLcof {

        private TreeMap<Integer, Integer> valueCount = new TreeMap<>();
        private Queue<Integer> queue = new LinkedList<>();

        @Override
        public int max_value() {
            if (queue.isEmpty()) {
                return -1;
            }
            return valueCount.lastKey();
        }

        @Override
        public void push_back(int value) {
            queue.add(value);
            valueCount.compute(value, (k, v) -> {
                if (v == null) {
                    return 1;
                } else {
                    return v + 1;
                }
            });
        }

        @Override
        public int pop_front() {
            if (queue.isEmpty()) {
                return -1;
            }
            Integer value = queue.poll();
            valueCount.compute(value, (k, v) -> {
                if (v == 1) {
                    return null;
                } else {
                    return v - 1;
                }
            });
            return value;
        }
    }

    class Solution2 implements DuiLieDeZuiDaZhiLcof {

        Queue<Integer> queue = new LinkedList<>();
        Deque<Integer> minToMaxDequeue = new LinkedList<>();

        @Override
        public int max_value() {
            if (queue.isEmpty()) {
                return -1;
            }
            return minToMaxDequeue.getLast();
        }

        @Override
        public void push_back(int value) {
            queue.add(value);
            while (!minToMaxDequeue.isEmpty() && minToMaxDequeue.peekFirst() < value) {
                minToMaxDequeue.removeFirst();
            }
            minToMaxDequeue.addFirst(value);
        }

        @Override
        public int pop_front() {
            if (queue.isEmpty()) {
                return -1;
            }
            Integer value = queue.poll();
            if (value.equals(minToMaxDequeue.peekLast())) {
                minToMaxDequeue.removeLast();
            }
            return value;
        }
    }
}
