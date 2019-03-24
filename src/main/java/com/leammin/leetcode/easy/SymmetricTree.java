package com.leammin.leetcode.easy;

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
public class SymmetricTree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }


    /**
     * 递归
     */
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
