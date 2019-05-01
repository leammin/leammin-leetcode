package com.leammin.leetcode.util;

import com.leammin.leetcode.struct.TreeNode;

/**
 * @author Leammin
 * @date 2019-05-01
 */
public class TreeNodeUtils {
    private TreeNodeUtils() {
    }

    /**
     * @param root 树
     * @return 判断是否是二叉树搜索树
     */
    public static boolean isBst(TreeNode root) {
        return isBst(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private static boolean isBst(TreeNode node, long min, long max) {
        if (node == null) {
            return true;
        }
        if (node.val >= max || node.val <= min) {
            return false;
        }
        return isBst(node.left, min, node.val) && isBst(node.right, node.val, max);
    }

    public static int height(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Integer.max(height(root.left), height(root.right)) + 1;
    }

    /**
     * @param root 树
     * @return 判断是否是平衡二叉树搜索树
     */
    public static boolean isAvl(TreeNode root) {
        return isBst(root) && (avlHeight(root) >= 0);
    }

    /**
     * @param root 树
     * @return 该树的每个节点的左右子树高度差不超过1，则返回高度，否则返回-1
     */
    private static int avlHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftHeight = avlHeight(root.left);
        if (leftHeight < 0) {
            return -1;
        }
        int rightHeight = avlHeight(root.right);
        if (rightHeight < 0) {
            return -1;
        }
        if (Math.abs(leftHeight - rightHeight) > 1) {
            return -1;
        } else {
            return Integer.max(leftHeight, rightHeight) + 1;
        }
    }
}
