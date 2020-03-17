package com.leammin.leetcode.medium;

import com.leammin.leetcode.struct.TreeNode;

/**
 * 230. 二叉搜索树中第K小的元素
 *
 * <p>给定一个二叉搜索树，编写一个函数&nbsp;<code>kthSmallest</code>&nbsp;来查找其中第&nbsp;<strong>k&nbsp;</strong>个最小的元素。</p>
 *
 * <p><strong>说明：</strong><br>
 * 你可以假设 k 总是有效的，1 &le; k &le; 二叉搜索树元素个数。</p>
 *
 * <p><strong>示例 1:</strong></p>
 *
 * <pre><strong>输入:</strong> root = [3,1,4,null,2], k = 1
 *    3
 *   / \
 *  1   4
 *   \
 * &nbsp;  2
 * <strong>输出:</strong> 1</pre>
 *
 * <p><strong>示例 2:</strong></p>
 *
 * <pre><strong>输入:</strong> root = [5,3,6,2,4,null,null,1], k = 3
 *        5
 *       / \
 *      3   6
 *     / \
 *    2   4
 *   /
 *  1
 * <strong>输出:</strong> 3</pre>
 *
 * <p><strong>进阶：</strong><br>
 * 如果二叉搜索树经常被修改（插入/删除操作）并且你需要频繁地查找第 k 小的值，你将如何优化&nbsp;<code>kthSmallest</code>&nbsp;函数？</p>
 *
 * @author Leammin
 * @date 2020-03-17
 */
public interface KthSmallestElementInABst {
    int kthSmallest(TreeNode root, int k);

    class Solution implements KthSmallestElementInABst {
        int[] sequentialVal;
        int index = 0;

        @Override
        public int kthSmallest(TreeNode root, int k) {
            index = 0;
            sequentialVal = new int[k];
            sequential(root);
            return sequentialVal[k - 1];
        }

        private void sequential(TreeNode root) {
            if (root == null || index >= sequentialVal.length) {
                return;
            }
            sequential(root.left);
            if (index < sequentialVal.length) {
                sequentialVal[index++] = root.val;
                sequential(root.right);
            }
        }
    }

    class Solution2 implements KthSmallestElementInABst {
        int val;
        int index;
        int max;

        @Override
        public int kthSmallest(TreeNode root, int k) {
            index = 0;
            max = k - 1;
            sequential(root);
            return val;
        }

        private void sequential(TreeNode root) {
            if (root == null || index > max) {
                return;
            }
            sequential(root.left);
            if (index++ <= max) {
                val = root.val;
                sequential(root.right);
            }
        }
    }
}
