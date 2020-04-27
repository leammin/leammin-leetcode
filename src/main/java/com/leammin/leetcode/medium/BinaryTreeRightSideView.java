package com.leammin.leetcode.medium;

import com.leammin.leetcode.struct.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * 199. 二叉树的右视图
 * 
 * <p>给定一棵二叉树，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。</p>
 * 
 * <p><strong>示例:</strong></p>
 * 
 * <pre><strong>输入:</strong>&nbsp;[1,2,3,null,5,null,4]
 * <strong>输出:</strong>&nbsp;[1, 3, 4]
 * <strong>解释:
 * </strong>
 *    1            &lt;---
 *  /   \
 * 2     3         &lt;---
 *  \     \
 *   5     4       &lt;---
 * </pre>
 * 
 * 
 * @author Leammin
 * @date 2020-04-22
 */
public interface BinaryTreeRightSideView {
    List<Integer> rightSideView(TreeNode root);

    class Solution implements BinaryTreeRightSideView {

        @Override
        public List<Integer> rightSideView(TreeNode root) {
            if (root == null) {
                return Collections.emptyList();
            }
            List<Integer> ans = new ArrayList<>();
            LinkedList<TreeNode> nodes = new LinkedList<>();
            nodes.add(root);
            while (!nodes.isEmpty()) {
                ans.add(nodes.getLast().val);
                LinkedList<TreeNode> children = new LinkedList<>();
                for (TreeNode node : nodes) {
                    if (node.left != null) {
                        children.add(node.left);
                    }
                    if (node.right != null) {
                        children.add(node.right);
                    }
                }
                nodes = children;
            }
            return ans;
        }
    }
}
