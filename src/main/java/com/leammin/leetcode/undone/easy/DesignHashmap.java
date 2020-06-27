package com.leammin.leetcode.undone.easy;

import java.util.Arrays;

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
}
