package com.leammin.leetcode.medium;

import com.leammin.leetcode.struct.TreeNode;

import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 144. 二叉树的前序遍历
 * 
 * <p>给定一个二叉树，返回它的&nbsp;<em>前序&nbsp;</em>遍历。</p>
 * 
 * <p>&nbsp;<strong>示例:</strong></p>
 * 
 * <pre><strong>输入:</strong> [1,null,2,3]  
 *    1
 *     \
 *      2
 *     /
 *    3 
 * 
 * <strong>输出:</strong> [1,2,3]
 * </pre>
 * 
 * <p><strong>进阶:</strong>&nbsp;递归算法很简单，你可以通过迭代算法完成吗？</p>
 * 
 * 
 * @author Leammin
 * @date 2019-10-13
 */
public interface BinaryTreePreorderTraversal {
    List<Integer> preorderTraversal(TreeNode root);

    class Solution implements BinaryTreePreorderTraversal {
        @Override
        public List<Integer> preorderTraversal(TreeNode root) {
            if (root == null) {
                return new LinkedList<>();
            }
            List<Integer> result = new LinkedList<>();
            result.add(root.val);
            result.addAll(preorderTraversal(root.left));
            result.addAll(preorderTraversal(root.right));
            return result;
        }
    }

    class Solution2 implements BinaryTreePreorderTraversal {
        @Override
        public List<Integer> preorderTraversal(TreeNode root) {
            if (root == null) {
                return Collections.emptyList();
            }
            List<Integer> result = new LinkedList<>();
            Deque<TreeNode> stack = new LinkedList<>();
            stack.add(root);
            while (!stack.isEmpty()) {
                TreeNode node = stack.pop();
                result.add(node.val);
                if (node.right != null) {
                    stack.push(node.right);
                }
                if (node.left != null) {
                    stack.push(node.left);
                }
            }
            return result;
        }
    }
}
