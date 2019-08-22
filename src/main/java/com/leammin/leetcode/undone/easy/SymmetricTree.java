package com.leammin.leetcode.undone.easy;

import com.leammin.leetcode.struct.TreeNode;

import java.util.*;

/**
 * 101. 对称二叉树
 *
 * <div><p>给定一个二叉树，检查它是否是镜像对称的。</p>
 *
 * <p>例如，二叉树&nbsp;<code>[1,2,2,3,4,4,3]</code> 是对称的。</p>
 *
 * <pre>    1
 *    / \
 *   2   2
 *  / \ / \
 * 3  4 4  3
 * </pre>
 *
 * <p>但是下面这个&nbsp;<code>[1,2,2,null,3,null,3]</code> 则不是镜像对称的:</p>
 *
 * <pre>    1
 *    / \
 *   2   2
 *    \   \
 *    3    3
 * </pre>
 *
 * <p><strong>说明:</strong></p>
 *
 * <p>如果你可以运用递归和迭代两种方法解决这个问题，会很加分。</p>
 * </div>
 *
 * @author Leammin
 * @date 2018-09-16
 */
public interface SymmetricTree {
    boolean isSymmetric(TreeNode root);

    /**
     * 递归
     */
    class SolutionRecursively implements SymmetricTree {
        @Override
        public boolean isSymmetric(TreeNode root) {
            if (root == null) {
                return true;
            }
            return isSymmetric(root.left, root.right);
        }

        private boolean isSymmetric(TreeNode a, TreeNode b) {
            if (a == null && b == null) {
                return true;
            } else if (a == null || b == null) {
                return false;
            }
            if (a.val != b.val) {
                return false;
            }
            return isSymmetric(a.left, b.right) && isSymmetric(a.right, b.left);
        }
    }

    /**
     * 循环 数组
     */
    class SolutionArray implements SymmetricTree {
        @Override
        public boolean isSymmetric(TreeNode root) {
            if (root == null) {
                return true;
            }
            List<TreeNode> nodes = Arrays.asList(root.left, root.right);
            while (!nodes.isEmpty()) {
                if (!isSymmetric(nodes)) {
                    return false;
                }
                List<TreeNode> newNodes = new ArrayList<>(2 * nodes.size());
                for (TreeNode node : nodes) {
                    if (node != null) {
                        newNodes.add(node.left);
                        newNodes.add(node.right);
                    }
                }
                nodes = newNodes;
            }
            return true;
        }

        private boolean isSymmetric(List<TreeNode> nodes) {
            int size = nodes.size();
            for (int i = 0; i < size / 2; i++) {
                if (!equals(nodes.get(i), nodes.get(size - 1 - i))) {
                    return false;
                }
            }
            return true;
        }

        private boolean equals(TreeNode a, TreeNode b) {
            return (a == b) || (a != null && b != null && a.val == b.val);
        }
    }

    /**
     * 循环 队列
     */
    class SolutionQueue implements SymmetricTree {
        @Override
        public boolean isSymmetric(TreeNode root) {
            if (root == null) {
                return true;
            }
            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root.left);
            queue.add(root.right);
            while (!queue.isEmpty()) {
                TreeNode n1 = queue.poll();
                TreeNode n2 = queue.poll();
                if (!equals(n1, n2)) {
                    return false;
                }
                if (n1 != null && n2 != null) {
                    queue.add(n1.left);
                    queue.add(n2.right);
                    queue.add(n1.right);
                    queue.add(n2.left);
                }
            }
            return true;
        }

        private boolean equals(TreeNode a, TreeNode b) {
            return (a == b) || (a != null && b != null && a.val == b.val);
        }
    }
}
