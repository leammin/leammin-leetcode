package com.leammin.leetcode.undone.medium;

import java.util.ArrayDeque;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 621. 任务调度器
 *
 * <p>给定一个用字符数组表示的 CPU 需要执行的任务列表。其中包含使用大写的 A - Z 字母表示的26 种不同种类的任务。任务可以以任意顺序执行，并且每个任务都可以在 1 个单位时间内执行完。CPU 在任何一个单位时间内都可以执行一个任务，或者在待命状态。</p>
 *
 * <p>然而，两个<strong>相同种类</strong>的任务之间必须有长度为<strong>&nbsp;n </strong>的冷却时间，因此至少有连续 n 个单位时间内 CPU 在执行不同的任务，或者在待命状态。</p>
 *
 * <p>你需要计算完成所有任务所需要的<strong>最短时间</strong>。</p>
 *
 * <p><strong>示例 1：</strong></p>
 *
 * <pre>
 * <strong>输入:</strong> tasks = [&quot;A&quot;,&quot;A&quot;,&quot;A&quot;,&quot;B&quot;,&quot;B&quot;,&quot;B&quot;], n = 2
 * <strong>输出:</strong> 8
 * <strong>执行顺序:</strong> A -&gt; B -&gt; (待命) -&gt; A -&gt; B -&gt; (待命) -&gt; A -&gt; B.
 * </pre>
 *
 * <p><strong>注：</strong></p>
 *
 * <ol>
 * 	<li>任务的总个数为&nbsp;[1, 10000]。</li>
 * 	<li>n 的取值范围为 [0, 100]。</li>
 * </ol>
 *
 * @author Leammin
 * @date 2020-05-14
 */
public interface TaskScheduler {
    int leastInterval(char[] tasks, int n);

    class Solution implements TaskScheduler {

        @Override
        public int leastInterval(char[] tasks, int n) {
            if (n == 0) {
                return tasks.length;
            }
            int[] count = new int[26];
            for (char c : tasks) {
                count[c - 'A']++;
            }
            PriorityQueue<Integer> sorted = new PriorityQueue<>(26, Comparator.reverseOrder());

            for (int value : count) {
                if (value > 0) {
                    sorted.add(value);
                }
            }
            Queue<Integer> wait = new ArrayDeque<>(n);
            int run = 0;
            Integer task;
            while ((task = sorted.poll()) != null) {
                if (wait.size() == n) {
                    Integer wt = wait.poll();
                    if (wt > 0) {
                        sorted.add(wt);
                    }
                }
                wait.add(--task);
                System.out.println(task);
                run++;
            }
            int max = 0;
            int mc = 0;
            for (Integer w : wait) {
                if (w > max) {
                    max = w;
                    mc = 1;
                } else if (w == max) {
                    mc++;
                }
            }
            return run + (max > 0 ? (max - 1) * (n + 1) + mc : 0);
        }
    }
}
