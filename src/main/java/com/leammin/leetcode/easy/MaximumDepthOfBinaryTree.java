package com.leammin.leetcode.easy;

/**
 * 104. 二叉树的最大深度
 *
 * <div><p>给定一个二叉树，找出其最大深度。</p>
 *
 * <p>二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。</p>
 *
 * <p><strong>说明:</strong>&nbsp;叶子节点是指没有子节点的节点。</p>
 *
 * <p><strong>示例：</strong><br>
 * 给定二叉树 <code>[3,9,20,null,null,15,7]</code>，</p>
 *
 * <pre>       3
 *    / \
 *   9  20
 *     /  \
 *    15   7</pre>
 *
 * <p>返回它的最大深度&nbsp;3 。</p>
 * </div>
 *
 * @date 2018-08-26
 * @author Leammin
 */
public class MaximumDepthOfBinaryTree {
    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }


    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftMax = maxDepth(root.left) + 1;
        int rightMax = maxDepth(root.right) + 1;
        return leftMax > rightMax ? leftMax : rightMax;
    }
}
