package com.leammin.leetcode.easy;

import java.util.Arrays;

import com.leammin.leetcode.util.test.AbstractTest;
import com.leammin.leetcode.util.test.Testcase;
import com.leammin.leetcode.util.test.Testsuite;
import org.assertj.core.api.Assertions;

/**
 * 706. 设计哈希映射
 * 
 * <p>不使用任何内建的哈希表库设计一个哈希映射</p>
 * 
 * <p>具体地说，你的设计应该包含以下的功能</p>
 * 
 * <ul>
 * 	<li><code>put(key, value)</code>：向哈希映射中插入(键,值)的数值对。如果键对应的值已经存在，更新这个值。</li>
 * 	<li><code>get(key)</code>：返回给定的键所对应的值，如果映射中不包含这个键，返回-1。</li>
 * 	<li><code>remove(key)</code>：如果映射中存在这个键，删除这个数值对。</li>
 * </ul>
 * 
 * <p><br />
 * <strong>示例：</strong></p>
 * 
 * <pre>
 * MyHashMap hashMap = new MyHashMap();
 * hashMap.put(1, 1); &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
 * hashMap.put(2, 2); &nbsp; &nbsp; &nbsp; &nbsp; 
 * hashMap.get(1); &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;// 返回 1
 * hashMap.get(3); &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;// 返回 -1 (未找到)
 * hashMap.put(2, 1); &nbsp; &nbsp; &nbsp; &nbsp; // 更新已有的值
 * hashMap.get(2); &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;// 返回 1 
 * hashMap.remove(2); &nbsp; &nbsp; &nbsp; &nbsp; // 删除键为2的数据
 * hashMap.get(2); &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;// 返回 -1 (未找到) 
 * </pre>
 * 
 * <p><br />
 * <strong>注意：</strong></p>
 * 
 * <ul>
 * 	<li>所有的值都在&nbsp;<code>[1, 1000000]</code>的范围内。</li>
 * 	<li>操作的总数目在<code>[1, 10000]</code>范围内。</li>
 * 	<li>不要使用内建的哈希库。</li>
 * </ul>
 * 
 * 
 * @author Leammin
 * @date 2020-06-27
 */
public interface DesignHashmap {
    void put(int key, int value);

    int get(int key);

    void remove(int key);

    static Testsuite<DesignHashmap> testsuite() {
        return Testsuite.<DesignHashmap>builder()
                .add(Testcase.of(t -> {
                    long b = System.nanoTime();
                    t.put(1, 1);
                    t.put(2, 2);
                    int r1 = t.get(1);// 返回 1
                    int r2 = t.get(3);            // 返回 -1 (未找到)
                    t.put(2, 1);         // 更新已有的值
                    int r3 = t.get(2);            // 返回 1
                    t.remove(2);         // 删除键为2的数据
                    int r4 = t.get(2);            // 返回 -1 (未找到)
                    long a = System.nanoTime();
                    Assertions.assertThat(r1).isEqualTo(1);
                    Assertions.assertThat(r2).isEqualTo(-1);
                    Assertions.assertThat(r3).isEqualTo(1);
                    Assertions.assertThat(r4).isEqualTo(-1);
                    return a - b;
                }))
                .build();
    }


    class Solution implements DesignHashmap {
        int[] hash = new int[1000001];

        public Solution() {
            Arrays.fill(hash, -1);
        }

        @Override
        public void put(int key, int value) {
            hash[key] = value;
        }

        @Override
        public int get(int key) {
            return hash[key];
        }

        @Override
        public void remove(int key) {
            hash[key] = -1;
        }
    }

    class Solution2 implements DesignHashmap {
        class Node {
            int key;
            int value;
            Node next;

            public Node(int key, int value) {
                this.key = key;
                this.value = value;
            }

            public Node(int key, int value, Node next) {
                this.key = key;
                this.value = value;
                this.next = next;
            }
        }

        Node[] nodes = new Node[1021];

        @Override
        public void put(int key, int value) {
            int h = hash(key);
            Node node = getNode(key);
            if (node != null) {
                node.value = value;
            } else {
                nodes[h] = new Node(key, value, nodes[h]);
            }
        }

        @Override
        public int get(int key) {
            Node node = getNode(key);
            return node == null ? -1 : node.value;
        }

        private Node getNode(int key) {
            int h = hash(key);
            Node node = nodes[h];
            while (node != null && node.key != key) {
                node = node.next;
            }
            return node;
        }

        @Override
        public void remove(int key) {
            int h = hash(key);
            Node prev = null;
            Node node = nodes[h];
            while (node != null && node.key != key) {
                prev = node;
                node = node.next;
            }
            if (node != null) {
                if (prev != null) {
                    prev.next = node.next;
                } else {
                    nodes[h] = node.next;
                }
                node.next = null;
            }
        }

        private int hash(int key) {
            return key * 33 % nodes.length;
        }
    }
}

class DesignHashmapTest extends AbstractTest<DesignHashmap> {
}
