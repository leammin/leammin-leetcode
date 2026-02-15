package com.leammin.leetcode.medium;

import com.leammin.leetcode.util.ClassUtils;
import com.leammin.leetcode.util.test.AbstractTest;
import com.leammin.leetcode.util.test.Testcase;
import com.leammin.leetcode.util.test.Testsuite;
import org.assertj.core.api.Assertions;

/**
 * 622. 设计循环队列
 * 
 * <p>设计你的循环队列实现。 循环队列是一种线性数据结构，其操作表现基于 FIFO（先进先出）原则并且队尾被连接在队首之后以形成一个循环。它也被称为&ldquo;环形缓冲器&rdquo;。</p>
 * 
 * <p>循环队列的一个好处是我们可以利用这个队列之前用过的空间。在一个普通队列里，一旦一个队列满了，我们就不能插入下一个元素，即使在队列前面仍有空间。但是使用循环队列，我们能使用这些空间去存储新的值。</p>
 * 
 * <p>你的实现应该支持如下操作：</p>
 * 
 * <ul>
 * 	<li><code>MyCircularQueue(k)</code>: 构造器，设置队列长度为 k 。</li>
 * 	<li><code>Front</code>: 从队首获取元素。如果队列为空，返回 -1 。</li>
 * 	<li><code>Rear</code>: 获取队尾元素。如果队列为空，返回 -1 。</li>
 * 	<li><code>enQueue(value)</code>: 向循环队列插入一个元素。如果成功插入则返回真。</li>
 * 	<li><code>deQueue()</code>: 从循环队列中删除一个元素。如果成功删除则返回真。</li>
 * 	<li><code>isEmpty()</code>: 检查循环队列是否为空。</li>
 * 	<li><code>isFull()</code>: 检查循环队列是否已满。</li>
 * </ul>
 * 
 * <p>&nbsp;</p>
 * 
 * <p><strong>示例：</strong></p>
 * 
 * <pre>MyCircularQueue circularQueue = new MycircularQueue(3); // 设置长度为 3
 * 
 * circularQueue.enQueue(1); &nbsp;// 返回 true
 * 
 * circularQueue.enQueue(2); &nbsp;// 返回 true
 * 
 * circularQueue.enQueue(3); &nbsp;// 返回 true
 * 
 * circularQueue.enQueue(4); &nbsp;// 返回 false，队列已满
 * 
 * circularQueue.Rear(); &nbsp;// 返回 3
 * 
 * circularQueue.isFull(); &nbsp;// 返回 true
 * 
 * circularQueue.deQueue(); &nbsp;// 返回 true
 * 
 * circularQueue.enQueue(4); &nbsp;// 返回 true
 * 
 * circularQueue.Rear(); &nbsp;// 返回 4
 * &nbsp;</pre>
 * 
 * <p>&nbsp;</p>
 * 
 * <p><strong>提示：</strong></p>
 * 
 * <ul>
 * 	<li>所有的值都在 0&nbsp;至 1000 的范围内；</li>
 * 	<li>操作数将在 1 至 1000 的范围内；</li>
 * 	<li>请不要使用内置的队列库。</li>
 * </ul>
 * 
 * 
 * @author Leammin
 * @date 2020-06-01
 */
public abstract class DesignCircularQueue {
    /** Initialize your data structure here. Set the size of the queue to be k. */
    public DesignCircularQueue(int k) {
    }

    /** Insert an element into the circular queue. Return true if the operation is successful. */
    public abstract boolean enQueue(int value);

    /** Delete an element from the circular queue. Return true if the operation is successful. */
    public abstract boolean deQueue();

    /** Get the front item from the queue. */
    public abstract int Front();

    /** Get the last item from the queue. */
    public abstract int Rear();

    /** Checks whether the circular queue is empty or not. */
    public abstract boolean isEmpty();

    /** Checks whether the circular queue is full or not. */
    public abstract boolean isFull();

    public static class Solution extends DesignCircularQueue {
        private int[] elements;
        private int head = 0;
        private int tail = 0;
        private int size = 0;
        private int k;

        /**
         * Initialize your data structure here. Set the size of the queue to be k.
         *
         * @param k
         */
        public Solution(int k) {
            super(k);
            this.k = k;
            this.elements = new int[k];
        }

        @Override
        public boolean enQueue(int value) {
            if (size >= k) {
                return false;
            }
            elements[tail] = value;
            tail = (tail + 1) % k;
            size++;
            return true;
        }

        @Override
        public boolean deQueue() {
            if (size <= 0) {
                return false;
            }
            head = (head + 1) % k;
            size--;
            return true;
        }

        @Override
        public int Front() {
            return size == 0 ? -1 : elements[head];
        }

        @Override
        public int Rear() {
            return size == 0 ? -1 : elements[(tail - 1 + k) % k];
        }

        @Override
        public boolean isEmpty() {
            return size == 0;
        }

        @Override
        public boolean isFull() {
            return size == k;
        }
    }

    static Testsuite<DesignCircularQueue> testsuite() {
        return Testsuite.<DesignCircularQueue>builder()
                .add(Testcase.create(clazz -> ClassUtils.newInstance(clazz, 3), t -> {
                    long time = System.nanoTime();
                    Assertions.assertThat(t.enQueue(1)).isTrue();
                    Assertions.assertThat(t.enQueue(2)).isTrue();
                    Assertions.assertThat(t.enQueue(3)).isTrue();
                    Assertions.assertThat(t.enQueue(4)).isFalse();
                    Assertions.assertThat(t.Rear()).isEqualTo(3);
                    Assertions.assertThat(t.isFull()).isTrue();
                    Assertions.assertThat(t.deQueue()).isTrue();
                    Assertions.assertThat(t.enQueue(4)).isTrue();
                    Assertions.assertThat(t.Rear()).isEqualTo(4);
                    return System.nanoTime() - time;
                }))
                .build();
    }
}

class DesignCircularQueueTest extends AbstractTest<DesignCircularQueue> {
}
