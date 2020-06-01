package com.leammin.leetcode.undone.hard;


import com.leammin.leetcode.struct.TreeNode;

/**
 * 99. 恢复二叉搜索树
 *
 * <p>二叉搜索树中的两个节点被错误地交换。</p>
 *
 * <p>请在不改变其结构的情况下，恢复这棵树。</p>
 *
 * <p><strong>示例&nbsp;1:</strong></p>
 *
 * <pre><strong>输入:</strong> [1,3,null,null,2]
 *
 * &nbsp;  1
 * &nbsp; /
 * &nbsp;3
 * &nbsp; \
 * &nbsp;  2
 *
 * <strong>输出:</strong> [3,1,null,null,2]
 *
 * &nbsp;  3
 * &nbsp; /
 * &nbsp;1
 * &nbsp; \
 * &nbsp;  2
 * </pre>
 *
 * <p><strong>示例&nbsp;2:</strong></p>
 *
 * <pre><strong>输入:</strong> [3,1,4,null,null,2]
 *
 *   3
 *  / \
 * 1   4
 * &nbsp;  /
 * &nbsp; 2
 *
 * <strong>输出:</strong> [2,1,4,null,null,3]
 *
 *   2
 *  / \
 * 1   4
 * &nbsp;  /
 *  &nbsp;3</pre>
 *
 * <p><strong>进阶:</strong></p>
 *
 * <ul>
 * 	<li>使用 O(<em>n</em>) 空间复杂度的解法很容易实现。</li>
 * 	<li>你能想出一个只使用常数空间的解决方案吗？</li>
 * </ul>
 *
 *
 * @author Leammin
 * @date 2019-09-22
 */
public interface RecoverBinarySearchTree {
    void recoverTree(TreeNode root);

    class Solution implements RecoverBinarySearchTree {

        @Override
        public void recoverTree(TreeNode root) {

        }

        public void recoverNode(TreeNode node) {
            if (node == null) {
                return;
            }
            if (node.left != null) {
                if (node.val <= node.left.val) {
                    swap(node, node.left);
                } else {
                    recoverNode(node.left);
                    if (node.val <= node.left.val) {
                        swap(node, node.left);
                    }
                }
            }
            if (node.right != null) {
                if (node.val >= node.right.val) {
                    swap(node, node.right);
                } else {
                    recoverNode(node.right);
                    if (node.val >= node.right.val) {
                        swap(node, node.right);
                    }
                }
            }
        }

        private void swap(TreeNode a, TreeNode b) {
            int t = a.val;
            a.val = b.val;
            b.val = t;
        }
    }
}
