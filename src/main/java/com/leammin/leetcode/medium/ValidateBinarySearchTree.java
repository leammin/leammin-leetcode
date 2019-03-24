package com.leammin.leetcode.medium;

/**
 * 98. 验证二叉搜索树
 *
 * <div><p>给定一个二叉树，判断其是否是一个有效的二叉搜索树。</p>
 *
 * <p>假设一个二叉搜索树具有如下特征：</p>
 *
 * <ul>
 * <li>节点的左子树只包含<strong>小于</strong>当前节点的数。</li>
 * <li>节点的右子树只包含<strong>大于</strong>当前节点的数。</li>
 * <li>所有左子树和右子树自身必须也是二叉搜索树。</li>
 * </ul>
 *
 * <p><strong>示例&nbsp;1:</strong></p>
 *
 * <pre><strong>输入:</strong>
 *     2
 *    / \
 *   1   3
 * <strong>输出:</strong> true
 * </pre>
 *
 * <p><strong>示例&nbsp;2:</strong></p>
 *
 * <pre><strong>输入:
 * </strong>    5
 *    / \
 *   1   4
 * &nbsp;    / \
 * &nbsp;   3   6
 * <strong>输出:</strong> false
 * <strong>解释:</strong> 输入为: [5,1,4,null,null,3,6]。
 * &nbsp;    根节点的值为 5 ，但是其右子节点值为 4 。
 * </pre>
 * 
 * @date 2018-09-02
 * @author Leammin
 */
public class ValidateBinarySearchTree {
    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public boolean isValidBST(TreeNode root) {
        return validateNode(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean validateNode(TreeNode node, long min, long max) {
        if (node == null) {
            return true;
        }
        if (node.val >= max || node.val <= min) {
            return false;
        }
        return validateNode(node.left, min, node.val) && validateNode(node.right, node.val, max);
    }

}
