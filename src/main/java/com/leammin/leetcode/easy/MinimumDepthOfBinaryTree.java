package com.leammin.leetcode.easy;

import com.leammin.leetcode.struct.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 111. 二叉树的最小深度
 * 
 * <p>给定一个二叉树，找出其最小深度。</p>
 * 
 * <p>最小深度是从根节点到最近叶子节点的最短路径上的节点数量。</p>
 * 
 * <p><strong>说明:</strong>&nbsp;叶子节点是指没有子节点的节点。</p>
 * 
 * <p><strong>示例:</strong></p>
 * 
 * <p>给定二叉树&nbsp;<code>[3,9,20,null,null,15,7]</code>,</p>
 * 
 * <pre>    3
 *    / \
 *   9  20
 *     /  \
 *    15   7</pre>
 * 
 * <p>返回它的最小深度 &nbsp;2.</p>
 * 
 * 
 * @author Leammin
 * @date 2019-10-02
 */
public interface MinimumDepthOfBinaryTree {
    int minDepth(TreeNode root);

    class Solution implements MinimumDepthOfBinaryTree {

        @Override
        public int minDepth(TreeNode root) {
            if (root == null) {
                return 0;
            }
            int depth = 1;
            List<TreeNode> nodes = Collections.singletonList(root);
            while (!nodes.isEmpty()) {
                List<TreeNode> children = new ArrayList<>(nodes.size() * 2);
                for (TreeNode node : nodes) {
                    if (node.left == null && node.right == null) {
                        return depth;
                    }
                    if (node.left != null) {
                        children.add(node.left);
                    }
                    if (node.right != null) {
                        children.add(node.right);
                    }
                }
                depth++;
                nodes = children;
            }

            return depth;
        }
    }

    class Solution2 implements MinimumDepthOfBinaryTree {
        @Override
        public int minDepth(TreeNode root) {
            if (root == null) {
                return 0;
            }
            if (root.left == null && root.right == null) {
                return 1;
            }
            if (root.left == null) {
                return minDepth(root.right) + 1;
            }
            if (root.right == null) {
                return minDepth(root.left) + 1;
            }
            return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
        }
    }
}
