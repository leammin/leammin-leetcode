package com.leammin.leetcode.medium;

import com.leammin.leetcode.struct.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 102. 二叉树的层次遍历
 *
 * <div><p>给定一个二叉树，返回其按层次遍历的节点值。 （即逐层地，从左到右访问所有节点）。</p>
 *
 * <p>例如:<br>
 * 给定二叉树:&nbsp;<code>[3,9,20,null,null,15,7]</code>,</p>
 *
 * <pre>    3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * </pre>
 *
 * <p>返回其层次遍历结果：</p>
 *
 * <pre>[
 *   [3],
 *   [9,20],
 *   [15,7]
 * ]
 * </pre>
 * </div>
 *
 * @author Leammin
 * @date 2018-10-21
 */
public interface BinaryTreeLevelOrderTraversal {
    List<List<Integer>> levelOrder(TreeNode root);

    class Solution implements BinaryTreeLevelOrderTraversal {
        @Override
        public List<List<Integer>> levelOrder(TreeNode root) {
            List<List<Integer>> res = new LinkedList<>();
            if (root == null) {
                return res;
            }
            List<TreeNode> parentsList = new ArrayList<>();
            parentsList.add(root);
            List<TreeNode> childrenList;
            while (!parentsList.isEmpty()) {
                List<Integer> resItem = new ArrayList<>(parentsList.size());
                childrenList = new ArrayList<>(2 * parentsList.size());
                for (TreeNode parentsNode : parentsList) {
                    resItem.add(parentsNode.val);
                    if (parentsNode.left != null) {
                        childrenList.add(parentsNode.left);
                    }
                    if (parentsNode.right != null) {
                        childrenList.add(parentsNode.right);
                    }
                }
                parentsList = childrenList;
                res.add(resItem);
            }
            return res;
        }
    }
}
