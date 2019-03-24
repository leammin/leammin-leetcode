package com.leammin.leetcode.easy;

import java.util.LinkedList;

/**
 * 155. 最小栈
 * 
 * <div><p>设计一个支持 push，pop，top 操作，并能在常数时间内检索到最小元素的栈。</p>
 *
 * <ul>
 * 	<li>push(x)&nbsp;-- 将元素 x 推入栈中。</li>
 * 	<li>pop()&nbsp;-- 删除栈顶的元素。</li>
 * 	<li>top()&nbsp;-- 获取栈顶元素。</li>
 * 	<li>getMin() -- 检索栈中的最小元素。</li>
 * </ul>
 *
 * <p><strong>示例:</strong></p>
 *
 * <pre>MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.getMin();   --&gt; 返回 -3.
 * minStack.pop();
 * minStack.top();      --&gt; 返回 0.
 * minStack.getMin();   --&gt; 返回 -2.
 * </pre>
 * </div>
 * 
 * @author Leammin
 * @date 2018-09-09
 */
public class MinStack {
    private LinkedList<Pair> list;

    /** initialize your data structure here. */
    public MinStack() {
        list = new LinkedList<>();
    }

    public void push(int x) {
        Pair peek = list.peekFirst();
        if (peek == null) {
            list.push(new Pair(x, x));
        } else {
            list.push(new Pair(x, x < peek.min ? x : peek.min));
        }
    }

    public void pop() {
        list.pollFirst();
    }

    public int top() {
        return list.peekFirst().val;
    }

    public int getMin() {
        return list.peekFirst().min;
    }
    
    private class Pair {
        int val;
        int min;
        Pair(int val, int min) {
            this.val = val;
            this.min = min;
        }
    }
}
