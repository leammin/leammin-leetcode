package com.leammin.leetcode.easy;

import java.util.Deque;
import java.util.LinkedList;

import com.leammin.leetcode.util.test.AbstractTest;
import com.leammin.leetcode.util.test.Testcase;
import com.leammin.leetcode.util.test.Testsuite;
import org.assertj.core.api.Assertions;

/**
 * 232. 用栈实现队列
 * 
 * <p>使用栈实现队列的下列操作：</p>
 * 
 * <ul>
 * 	<li>push(x) -- 将一个元素放入队列的尾部。</li>
 * 	<li>pop() -- 从队列首部移除元素。</li>
 * 	<li>peek() -- 返回队列首部的元素。</li>
 * 	<li>empty() -- 返回队列是否为空。</li>
 * </ul>
 * 
 * <p><strong>示例:</strong></p>
 * 
 * <pre>MyQueue queue = new MyQueue();
 * 
 * queue.push(1);
 * queue.push(2);  
 * queue.peek();  // 返回 1
 * queue.pop();   // 返回 1
 * queue.empty(); // 返回 false</pre>
 * 
 * <p><strong>说明:</strong></p>
 * 
 * <ul>
 * 	<li>你只能使用标准的栈操作 -- 也就是只有&nbsp;<code>push to top</code>,&nbsp;<code>peek/pop from top</code>,&nbsp;<code>size</code>, 和&nbsp;<code>is empty</code>&nbsp;操作是合法的。</li>
 * 	<li>你所使用的语言也许不支持栈。你可以使用 list 或者 deque（双端队列）来模拟一个栈，只要是标准的栈操作即可。</li>
 * 	<li>假设所有操作都是有效的 （例如，一个空的队列不会调用 pop 或者 peek 操作）。</li>
 * </ul>
 * 
 * 
 * @author Leammin
 * @date 2020-06-11
 */
public interface ImplementQueueUsingStacks {

    void push(int x);

    int pop();

    int peek();

    boolean empty();

    static Testsuite<ImplementQueueUsingStacks> testsuite() {
        return Testsuite.<ImplementQueueUsingStacks>builder()
                .add(Testcase.of(queue -> {
                    long before = System.nanoTime();
                    queue.push(1);
                    queue.push(2);
                    Assertions.assertThat(queue.peek()).isEqualTo(1);
                    Assertions.assertThat(queue.pop()).isEqualTo(1);
                    Assertions.assertThat(queue.empty()).isFalse();
                    return System.nanoTime() - before;
                }))
                .build();
    }


    class Solution implements ImplementQueueUsingStacks {
        Deque<Integer> pushStack = new LinkedList<>();
        Deque<Integer> popStack = new LinkedList<>();
        @Override
        public void push(int x) {
            pushStack.push(x);
        }

        @Override
        public int pop() {
            ensurePop();
            return popStack.pop();
        }

        @Override
        public int peek() {
            ensurePop();
            return popStack.peek();
        }

        private void ensurePop() {
            if (popStack.isEmpty()) {
                while (!pushStack.isEmpty()) {
                    popStack.push(pushStack.pop());
                }
            }
        }

        @Override
        public boolean empty() {
            return pushStack.isEmpty() && popStack.isEmpty();
        }
    }
}

class ImplementQueueUsingStacksTest extends AbstractTest<ImplementQueueUsingStacks> {
}
