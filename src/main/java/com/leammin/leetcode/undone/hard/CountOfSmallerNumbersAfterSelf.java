package com.leammin.leetcode.undone.hard;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.TreeMap;

/**
 * 315. 计算右侧小于当前元素的个数
 *
 * <p>给定一个整数数组 <em>nums</em>，按要求返回一个新数组&nbsp;<em>counts</em>。数组 <em>counts</em> 有该性质： <code>counts[i]</code> 的值是&nbsp; <code>nums[i]</code> 右侧小于&nbsp;<code>nums[i]</code> 的元素的数量。</p>
 *
 * <p><strong>示例:</strong></p>
 *
 * <pre><strong>输入:</strong> [5,2,6,1]
 * <strong>输出:</strong> <code>[2,1,1,0]
 * <strong>解释:</strong></code>
 * 5 的右侧有 <strong>2 </strong>个更小的元素 (2 和 1).
 * 2 的右侧仅有 <strong>1 </strong>个更小的元素 (1).
 * 6 的右侧有 <strong>1 </strong>个更小的元素 (1).
 * 1 的右侧有 <strong>0 </strong>个更小的元素.
 * </pre>
 *
 * @author Leammin
 * @date 2020-07-11
 */
public interface CountOfSmallerNumbersAfterSelf {
    List<Integer> countSmaller(int[] nums);

    class Solution implements CountOfSmallerNumbersAfterSelf {

        @Override
        public List<Integer> countSmaller(int[] nums) {
            Integer[] res = new Integer[nums.length];
            Arrays.fill(res, 0);
            TreeMap<Integer, Integer> map = new TreeMap<>();
            for (int i = nums.length - 1; i >= 0; i--) {
                for (Integer value : map.headMap(nums[i]).values()) {
                    res[i] += value;
                }
                map.compute(nums[i], (k, v) -> v == null ? 1 : v + 1);
            }
            return Arrays.asList(res);
        }
    }

    class Solution2 implements CountOfSmallerNumbersAfterSelf {

        @Override
        public List<Integer> countSmaller(int[] nums) {
            if (nums.length == 0) {
                return Collections.emptyList();
            }
            Integer[] res = new Integer[nums.length];
            res[nums.length - 1] = 0;
            Node root = new Node(nums[nums.length - 1]);
            for (int i = nums.length - 2; i >= 0; i--) {
                res[i] = add(root, nums[i]);
            }
            return Arrays.asList(res);
        }

        private int add(Node root, int val) {
            int ret = 0;
            Node parent = root;
            Node node = root;
            while (node != null) {
                node.size++;
                if (node.val == val) {
                    return ret + (node.left == null ? 0 : node.left.size);
                }
                parent = node;
                if (val < node.val) {
                    node = node.left;
                }
                else {
                    ret += node.size - 1 - (node.right == null ? 0 : node.right.size);
                    node = node.right;
                }
            }
            Node newNode = new Node(val);
            if (val < parent.val) {
                parent.left = newNode;
            } else {
                parent.right = newNode;
            }
            return ret;
        }

        static class Node {
            Node left;
            Node right;
            int val;
            int size = 1;

            public Node(int val) {
                this.val = val;
            }
        }
    }
}
