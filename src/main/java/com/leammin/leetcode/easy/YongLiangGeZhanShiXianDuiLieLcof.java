package com.leammin.leetcode.easy;

import java.util.Deque;
import java.util.LinkedList;

import com.leammin.leetcode.util.test.AbstractTest;
import com.leammin.leetcode.util.test.Testcase;
import com.leammin.leetcode.util.test.Testsuite;
import org.assertj.core.api.Assertions;

/**
 * 面试题09. 用两个栈实现队列
 * 
 * <p>用两个栈实现一个队列。队列的声明如下，请实现它的两个函数 <code>appendTail</code> 和 <code>deleteHead</code> ，分别完成在队列尾部插入整数和在队列头部删除整数的功能。(若队列中没有元素，<code>deleteHead</code>&nbsp;操作返回 -1 )</p>
 * 
 * <p>&nbsp;</p>
 * 
 * <p><strong>示例 1：</strong></p>
 * 
 * <pre><strong>输入：</strong>
 * [&quot;CQueue&quot;,&quot;appendTail&quot;,&quot;deleteHead&quot;,&quot;deleteHead&quot;]
 * [[],[3],[],[]]
 * <strong>输出：</strong>[null,null,3,-1]
 * </pre>
 * 
 * <p><strong>示例 2：</strong></p>
 * 
 * <pre><strong>输入：</strong>
 * [&quot;CQueue&quot;,&quot;deleteHead&quot;,&quot;appendTail&quot;,&quot;appendTail&quot;,&quot;deleteHead&quot;,&quot;deleteHead&quot;]
 * [[],[],[5],[2],[],[]]
 * <strong>输出：</strong>[null,-1,null,null,5,2]
 * </pre>
 * 
 * <p><strong>提示：</strong></p>
 * 
 * <ul>
 * 	<li><code>1 &lt;= values &lt;= 10000</code></li>
 * 	<li><code>最多会对&nbsp;appendTail、deleteHead 进行&nbsp;10000&nbsp;次调用</code></li>
 * </ul>
 * 
 * 
 * @author Leammin
 * @date 2020-06-30
 */
public interface YongLiangGeZhanShiXianDuiLieLcof {

    void appendTail(int value);

    int deleteHead();

    static Testsuite<YongLiangGeZhanShiXianDuiLieLcof> testsuite() {
        return Testsuite.<YongLiangGeZhanShiXianDuiLieLcof>builder()
                .add(Testcase.of(queue -> {
                    long before = System.nanoTime();
                    queue.appendTail(3);
                    Assertions.assertThat(queue.deleteHead()).isEqualTo(3);
                    Assertions.assertThat(queue.deleteHead()).isEqualTo(-1);
                    return System.nanoTime() - before;
                }))
                .add(Testcase.of(queue -> {
                    long before = System.nanoTime();
                    Assertions.assertThat(queue.deleteHead()).isEqualTo(-1);
                    queue.appendTail(5);
                    queue.appendTail(2);
                    Assertions.assertThat(queue.deleteHead()).isEqualTo(5);
                    Assertions.assertThat(queue.deleteHead()).isEqualTo(2);
                    return System.nanoTime() - before;
                }))
                .build();
    }


    class Solution implements YongLiangGeZhanShiXianDuiLieLcof {

        Deque<Integer> stack1 = new LinkedList<>();
        Deque<Integer> stack2 = new LinkedList<>();

        @Override
        public void appendTail(int value) {
            stack1.push(value);
        }

        @Override
        public int deleteHead() {
            if (stack2.isEmpty()) {
                while (!stack1.isEmpty()) {
                    stack2.push(stack1.pop());
                }
            }
            return stack2.isEmpty() ? -1 : stack2.pop();
        }
    }
}

class YongLiangGeZhanShiXianDuiLieLcofTest extends AbstractTest<YongLiangGeZhanShiXianDuiLieLcof> {
}
