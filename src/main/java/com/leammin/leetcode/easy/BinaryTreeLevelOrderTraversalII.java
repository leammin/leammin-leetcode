package com.leammin.leetcode.easy;

import com.leammin.leetcode.struct.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * 107. 二叉树的层次遍历 II
 *
 * <p>给定一个二叉树，返回其节点值自底向上的层次遍历。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）</p>
 *
 * <p>例如：<br>
 * 给定二叉树 <code>[3,9,20,null,null,15,7]</code>,</p>
 *
 * <pre>    3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * </pre>
 *
 * <p>返回其自底向上的层次遍历为：</p>
 *
 * <pre>[
 *   [15,7],
 *   [9,20],
 *   [3]
 * ]
 * </pre>
 *
 * @author Leammin
 * @date 2019-09-30
 */
public interface BinaryTreeLevelOrderTraversalII {
    List<List<Integer>> levelOrderBottom(TreeNode root);

    class Solution implements BinaryTreeLevelOrderTraversalII {
        @Override
        public List<List<Integer>> levelOrderBottom(TreeNode root) {
            if (root == null) {
                return Collections.emptyList();
            }
            LinkedList<List<Integer>> result = new LinkedList<>();
            List<TreeNode> nodes = Collections.singletonList(root);
            while (!nodes.isEmpty()) {
                List<TreeNode> children = new ArrayList<>(nodes.size() * 2);
                List<Integer> e = new ArrayList<>(nodes.size());
                for (TreeNode node : nodes) {
                    e.add(node.val);
                    if (node.left != null) {
                        children.add(node.left);
                    }
                    if (node.right != null) {
                        children.add(node.right);
                    }
                }
                result.addFirst(e);
                nodes = children;
            }
            return result;
        }
    }
}
