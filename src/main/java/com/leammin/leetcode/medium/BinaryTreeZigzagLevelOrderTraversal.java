package com.leammin.leetcode.medium;

import com.leammin.leetcode.struct.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;

/**
 * 103. 二叉树的锯齿形层次遍历
 *
 * <p>给定一个二叉树，返回其节点值的锯齿形层次遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。</p>
 *
 * <p>例如：<br>
 * 给定二叉树&nbsp;<code>[3,9,20,null,null,15,7]</code>,</p>
 *
 * <pre>    3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * </pre>
 *
 * <p>返回锯齿形层次遍历如下：</p>
 *
 * <pre>[
 *   [3],
 *   [20,9],
 *   [15,7]
 * ]
 * </pre>
 *
 * @author Leammin
 * @date 2019-09-07
 */
public interface BinaryTreeZigzagLevelOrderTraversal {
    List<List<Integer>> zigzagLevelOrder(TreeNode root);

    class Solution implements BinaryTreeZigzagLevelOrderTraversal {
        @Override
        public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
            if (root == null) {
                return Collections.emptyList();
            }
            List<List<Integer>> res = new ArrayList<>();
            List<TreeNode> nodes = Collections.singletonList(root);
            boolean reverse = false;
            while (!nodes.isEmpty()) {
                List<TreeNode> newNodes = new ArrayList<>(nodes.size());
                for (TreeNode node : nodes) {
                    if (node.left != null) {
                        newNodes.add(node.left);
                    }
                    if (node.right != null) {
                        newNodes.add(node.right);
                    }
                }
                List<Integer> row = new ArrayList<>(nodes.size());
                if (reverse) {
                    for (ListIterator<TreeNode> iterator = nodes.listIterator(nodes.size()); iterator.hasPrevious(); ) {
                        row.add(iterator.previous().val);
                    }
                } else {
                    for (TreeNode node : nodes) {
                        row.add(node.val);
                    }
                }
                reverse = !reverse;
                nodes = newNodes;
                res.add(row);
            }
            return res;
        }
    }
}
