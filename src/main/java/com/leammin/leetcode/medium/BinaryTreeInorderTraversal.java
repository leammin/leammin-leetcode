package com.leammin.leetcode.medium;

import com.leammin.leetcode.struct.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 94. 二叉树的中序遍历
 *
 * <div><p>给定一个二叉树，返回它的<em>中序&nbsp;</em>遍历。</p>
 *
 * <p><strong>示例:</strong></p>
 *
 * <pre><strong>输入:</strong> [1,null,2,3]
 *    1
 *     \
 *      2
 *     /
 *    3
 *
 * <strong>输出:</strong> [1,3,2]</pre>
 *
 * <p><strong>进阶:</strong>&nbsp;递归算法很简单，你可以通过迭代算法完成吗？</p>
 * </div>
 *
 * @author Leammin
 * @date 2018-10-21
 */
public interface BinaryTreeInorderTraversal {
    List<Integer> inorderTraversal(TreeNode root);

    class Solution implements BinaryTreeInorderTraversal {
        @Override
        public List<Integer> inorderTraversal(TreeNode root) {
            if (root == null) {
                return new ArrayList<>();
            }
            List<Integer> result = inorderTraversal(root.left);
            result.add(root.val);
            result.addAll(inorderTraversal(root.right));
            return result;
        }
    }

    class Solution1 implements BinaryTreeInorderTraversal {
        @Override
        public List<Integer> inorderTraversal(TreeNode root) {
            if (root == null) {
                return new ArrayList<>();
            }
            List<Integer> result = new ArrayList<>();
            LinkedList<TreeNode> stack = new LinkedList<>();
            stack.push(root);
            while (!stack.isEmpty()) {
                TreeNode top = stack.pop();
                if (top.left != null) {
                    stack.push(top.left);
                } else {
                    result.add(top.val);
                    if (top.right != null) {
                        stack.push(top.right);
                    }
                }

            }
            return result;
        }
    }

}
