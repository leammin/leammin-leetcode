package com.leammin.leetcode.medium;

import java.util.*;

/**
 * 380. 常数时间插入、删除和获取随机元素
 * 
 * <p>设计一个支持在<em>平均&nbsp;</em>时间复杂度 <strong>O(1)</strong>&nbsp;下，执行以下操作的数据结构。</p>
 * 
 * <ol>
 * 	<li><code>insert(val)</code>：当元素 val 不存在时，向集合中插入该项。</li>
 * 	<li><code>remove(val)</code>：元素 val 存在时，从集合中移除该项。</li>
 * 	<li><code>getRandom</code>：随机返回现有集合中的一项。每个元素应该有<strong>相同的概率</strong>被返回。</li>
 * </ol>
 * 
 * <p><strong>示例 :</strong></p>
 * 
 * <pre>
 * // 初始化一个空的集合。
 * RandomizedSet randomSet = new RandomizedSet();
 * 
 * // 向集合中插入 1 。返回 true 表示 1 被成功地插入。
 * randomSet.insert(1);
 * 
 * // 返回 false ，表示集合中不存在 2 。
 * randomSet.remove(2);
 * 
 * // 向集合中插入 2 。返回 true 。集合现在包含 [1,2] 。
 * randomSet.insert(2);
 * 
 * // getRandom 应随机返回 1 或 2 。
 * randomSet.getRandom();
 * 
 * // 从集合中移除 1 ，返回 true 。集合现在包含 [2] 。
 * randomSet.remove(1);
 * 
 * // 2 已在集合中，所以返回 false 。
 * randomSet.insert(2);
 * 
 * // 由于 2 是集合中唯一的数字，getRandom 总是返回 2 。
 * randomSet.getRandom();
 * </pre>
 * 
 * 
 * @author Leammin
 * @date 2020-04-07
 */
public interface InsertDeleteGetrandomO1 {

    boolean insert(int val);

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    boolean remove(int val);

    /** Get a random element from the set. */
    int getRandom();

    class Solution implements InsertDeleteGetrandomO1 {
        Set<Integer> set = new HashSet<>();
        List<Integer> list = new ArrayList<>();
        Random random = new Random();

        @Override
        public boolean insert(int val) {
            list.add(val);
            return set.add(val);
        }

        @Override
        public boolean remove(int val) {
            return set.remove(val);
        }

        @Override
        public int getRandom() {
            int randomIndex = random.nextInt(list.size());
            Integer val = list.get(randomIndex);
            while (!set.contains(val)) {
                list.set(randomIndex, list.get(list.size() - 1));
                list.remove(list.size() - 1);
                randomIndex = random.nextInt(list.size());
                val = list.get(randomIndex);
            }
            return val;
        }
    }

    class Solution2 implements InsertDeleteGetrandomO1 {
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        Random random = new Random();

        @Override
        public boolean insert(int val) {
            if (map.containsKey(val)) {
                return false;
            }
            map.put(val, list.size());
            list.add(val);
            return true;
        }

        @Override
        public boolean remove(int val) {
            if (!map.containsKey(val)) {
                return false;
            }
            Integer index = map.remove(val);
            Integer lastElement = list.get(list.size() - 1);
            list.set(index, lastElement);
            if (val != lastElement) {
                map.put(lastElement, index);
            }
            list.remove(list.size() - 1);
            return true;
        }

        @Override
        public int getRandom() {
            return list.get(random.nextInt(list.size()));
        }
    }
}
