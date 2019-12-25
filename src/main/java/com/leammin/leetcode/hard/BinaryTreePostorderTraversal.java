package com.leammin.leetcode.hard;

import com.leammin.leetcode.struct.TreeNode;

import java.util.*;

/**
 * 145. 二叉树的后序遍历
 *
 * <p>给定一个二叉树，返回它的 <em>后序&nbsp;</em>遍历。</p>
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
 * <strong>输出:</strong> [3,2,1]</pre>
 *
 * <p><strong>进阶:</strong>&nbsp;递归算法很简单，你可以通过迭代算法完成吗？</p>
 *
 * @author Leammin
 * @date 2019-10-06
 */
public interface BinaryTreePostorderTraversal {
    List<Integer> postorderTraversal(TreeNode root);

    /**
     * 递归写法
     */
    class Solution implements BinaryTreePostorderTraversal {

        @Override
        public List<Integer> postorderTraversal(TreeNode root) {
            if (root == null) {
                return new LinkedList<>();
            }

            List<Integer> left = postorderTraversal(root.left);
            List<Integer> right = postorderTraversal(root.right);
            left.addAll(right);
            left.add(root.val);
            return left;
        }
    }

    /**
     * 迭代写法
     * 耗费内存，不如 Best
     */
    class Solution2 implements BinaryTreePostorderTraversal {
        @Override
        public List<Integer> postorderTraversal(TreeNode root) {
            if (root == null) {
                return new LinkedList<>();
            }

            List<Integer> result = new LinkedList<>();
            Deque<TreeNode> stack = new LinkedList<>();
            stack.push(root);
            if (root.right != null) {
                stack.push(root.right);
            }
            if (root.left != null) {
                stack.push(root.left);
            }
            Set<TreeNode> popped = new HashSet<>();
            while (!stack.isEmpty()) {
                TreeNode current = stack.peek();
                boolean hasPush = false;
                if (current.right != null && !popped.contains(current.right)) {
                    hasPush = true;
                    stack.push(current.right);
                }
                if (current.left != null && !popped.contains(current.left)) {
                    hasPush = true;
                    stack.push(current.left);
                }
                if (!hasPush) {
                    popped.add(stack.pop());
                    result.add(current.val);
                }
            }
            return result;
        }
    }

    class Best implements BinaryTreePostorderTraversal {
        @Override
        public List<Integer> postorderTraversal(TreeNode root) {
            List<Integer> res = new ArrayList<Integer>();
            if (root == null)
                return res;
            Deque<TreeNode> stack = new LinkedList<>();
            TreeNode pre = null;
            stack.push(root);
            while (!stack.isEmpty()) {
                TreeNode curr = stack.peek();
                if ((curr.left == null && curr.right == null) ||
                        (pre != null && (pre == curr.left || pre == curr.right))) {
                    //如果当前结点左右子节点为空或上一个访问的结点为当前结点的子节点时，当前结点出栈
                    res.add(curr.val);
                    pre = curr;
                    stack.pop();
                } else {
                    if (curr.right != null) stack.push(curr.right); //先将右结点压栈
                    if (curr.left != null) stack.push(curr.left);   //再将左结点入栈
                }
            }
            return res;
        }
    }
}
