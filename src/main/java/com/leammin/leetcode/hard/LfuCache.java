package com.leammin.leetcode.hard;

import java.util.HashMap;
import java.util.Map;

/**
 * 460. LFU缓存
 *
 * <p>设计并实现<a href="https://baike.baidu.com/item/%E7%BC%93%E5%AD%98%E7%AE%97%E6%B3%95">最不经常使用（LFU）</a>缓存的数据结构。它应该支持以下操作：<code>get</code>&nbsp;和&nbsp;<code>put</code>。</p>
 *
 * <p><code>get(key)</code>&nbsp;- 如果键存在于缓存中，则获取键的值（总是正数），否则返回 -1。<br />
 * <code>put(key, value)</code>&nbsp;- 如果键不存在，请设置或插入值。当缓存达到其容量时，它应该在插入新项目之前，使最不经常使用的项目无效。在此问题中，当存在平局（即两个或更多个键具有相同使用频率）时，<strong>最近</strong>最少使用的键将被去除。</p>
 *
 * <p><strong>进阶：</strong><br />
 * 你是否可以在&nbsp;<strong>O(1)&nbsp;</strong>时间复杂度内执行两项操作？</p>
 *
 * <p><strong>示例：</strong></p>
 *
 * <pre>
 * LFUCache cache = new LFUCache(2);
 *
 * cache.put(1, 1);
 * cache.put(2, 2);
 * cache.get(1);       // 返回 1
 * cache.put(3, 3);    // 去除 key 2
 * cache.get(2);       // 返回 -1 (未找到key 2)
 * cache.get(3);       // 返回 3
 * cache.put(4, 4);    // 去除 key 1
 * cache.get(1);       // 返回 -1 (未找到 key 1)
 * cache.get(3);       // 返回 3
 * cache.get(4);       // 返回 4</pre>
 *
 * @author Leammin
 * @date 2020-04-05
 */
public abstract class LfuCache {

    public LfuCache(int capacity) {
    }

    public abstract int get(int key);

    public abstract void put(int key, int value);

    public static class Solution extends LfuCache {
        private Map<Integer, Node> cache;
        private Map<Integer, Linked> timesLinked;
        private int minTimes = 0;
        private int capacity;

        public Solution(int capacity) {
            super(capacity);
            this.capacity = capacity;
            if (capacity != 0) {
                cache = new HashMap<>((int) ((float) capacity / 0.75F + 1.0F));
                timesLinked = new HashMap<>((int) ((float) capacity / 0.75F + 1.0F));
            }
        }

        @Override
        public int get(int key) {
            if (capacity == 0) {
                return -1;
            }
            Node node = cache.get(key);
            if (node == null) {
                return -1;
            }
            addTimes(node);
            return node.value;
        }

        private void addTimes(Node node) {
            Linked linked = timesLinked.get(node.times);
            removeLinkedNode(linked, node);
            node.times++;
            addTimesLinked(node);
        }

        @Override
        public void put(int key, int value) {
            if (capacity == 0) {
                return;
            }
            Node oldNode = cache.get(key);
            if (oldNode != null) {
                addTimes(oldNode);
                oldNode.value = value;
                return;
            }
            if (cache.size() >= capacity) {
                removeMinTimes();
            }
            addNode(new Node(key, value));
        }

        private void addNode(Node node) {
            cache.put(node.key, node);
            minTimes = 0;
            addTimesLinked(node);
        }

        private void addTimesLinked(Node node) {
            timesLinked.computeIfAbsent(node.times, k -> new Linked()).add(node);
        }

        private void removeMinTimes() {
            Linked minTimesLinked = timesLinked.get(minTimes);
            Node minTimesNode = minTimesLinked.head.next;
            removeLinkedNode(minTimesLinked, minTimesNode);
            cache.remove(minTimesNode.key);
        }

        private void removeLinkedNode(Linked linked, Node node) {
            linked.remove(node);
            if (linked.isEmpty()) {
                timesLinked.remove(node.times);
                if (node.times == minTimes) {
                    minTimes++;
                }
            }
        }

        static class Linked {
            Node head;
            Node tail;

            Linked() {
                head = tail = new Node(0, 0);
            }

            void add(Node node) {
                tail.next = node;
                node.prev = tail;
                node.next = null;
                tail = node;
            }

            void remove(Node node) {
                node.prev.next = node.next;
                if (tail == node) {
                    tail = node.prev;
                } else {
                    node.next.prev = node.prev;
                }
                node.prev = null;
                node.next = null;
            }

            boolean isEmpty() {
                return head == tail;
            }
        }

        static class Node {
            int key;
            int value;
            int times;
            Node prev;
            Node next;

            Node(int key, int value) {
                this.key = key;
                this.value = value;
            }
        }
    }
}
