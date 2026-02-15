package com.leammin.leetcode.easy;

import com.leammin.leetcode.util.test.AbstractTest;
import com.leammin.leetcode.util.test.Testcase;
import com.leammin.leetcode.util.test.Testsuite;
import org.assertj.core.api.Assertions;

/**
 * 705. 设计哈希集合
 * 
 * <p>不使用任何内建的哈希表库设计一个哈希集合</p>
 * 
 * <p>具体地说，你的设计应该包含以下的功能</p>
 * 
 * <ul>
 * 	<li><code>add(value)</code>：向哈希集合中插入一个值。</li>
 * 	<li><code>contains(value)</code> ：返回哈希集合中是否存在这个值。</li>
 * 	<li><code>remove(value)</code>：将给定值从哈希集合中删除。如果哈希集合中没有这个值，什么也不做。</li>
 * </ul>
 * 
 * <p><br>
 * <strong>示例:</strong></p>
 * 
 * <pre>MyHashSet hashSet = new MyHashSet();
 * hashSet.add(1); &nbsp; &nbsp; &nbsp; &nbsp; 
 * hashSet.add(2); &nbsp; &nbsp; &nbsp; &nbsp; 
 * hashSet.contains(1); &nbsp;&nbsp;&nbsp;// 返回 true
 * hashSet.contains(3); &nbsp;&nbsp;&nbsp;// 返回 false (未找到)
 * hashSet.add(2); &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
 * hashSet.contains(2); &nbsp;&nbsp;&nbsp;// 返回 true
 * hashSet.remove(2); &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
 * hashSet.contains(2); &nbsp;&nbsp;&nbsp;// 返回  false (已经被删除)
 * </pre>
 * 
 * <p><br>
 * <strong>注意：</strong></p>
 * 
 * <ul>
 * 	<li>所有的值都在&nbsp;<code>[0, 1000000]</code>的范围内。</li>
 * 	<li>操作的总数目在<code>[1, 10000]</code>范围内。</li>
 * 	<li>不要使用内建的哈希集合库。</li>
 * </ul>
 * 
 * 
 * @author Leammin
 * @date 2020-06-27
 */
public interface DesignHashset {
    void add(int key);

    void remove(int key);

    boolean contains(int key);

    static Testsuite<DesignHashset> testsuite() {
        return Testsuite.<DesignHashset>builder()
                .add(Testcase.of(t -> {
                    long b = System.nanoTime();
                    t.add(1);
                    t.add(2);
                    boolean r1 = t.contains(1);// 返回 true
                    boolean r2 = t.contains(3);// 返回 false (未找到)
                    t.add(2);
                    boolean r3 = t.contains(2);// 返回 true
                    t.remove(2);
                    boolean r4 = t.contains(2);// 返回  false (已经被删除)
                    long a = System.nanoTime();
                    Assertions.assertThat(r1).isTrue();
                    Assertions.assertThat(r2).isFalse();
                    Assertions.assertThat(r3).isTrue();
                    Assertions.assertThat(r4).isFalse();
                    return a - b;
                }))
                .build();
    }


    class Solution implements DesignHashset {
        boolean[] hash = new boolean[1000001];

        @Override
        public void add(int key) {
            hash[key] = true;
        }

        @Override
        public void remove(int key) {
            hash[key] = false;
        }

        @Override
        public boolean contains(int key) {
            return hash[key];
        }
    }
    
    class Solution2 implements DesignHashset {
        class Node {
            int key;
            Node next;

            public Node(int key) {
                this.key = key;
            }

            public Node(int key, Node next) {
                this.key = key;
                this.next = next;
            }
        }

        Node[] nodes = new Node[1021];

        @Override
        public void add(int key) {
            int h = hash(key);
            Node node = getNode(key);
            if (node == null) {
                nodes[h] = new Node(key, nodes[h]);
            }
        }

        @Override
        public boolean contains(int key) {
            return getNode(key) != null;
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

class DesignHashsetTest extends AbstractTest<DesignHashset> {
}
