package com.leammin.leetcode.medium;

import com.leammin.leetcode.struct.TreeNode;

import java.util.*;

import com.leammin.leetcode.util.test.AbstractTest;
import com.leammin.leetcode.util.test.ExpectedTestcase;
import com.leammin.leetcode.util.test.Testsuite;
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

    static Testsuite<BinaryTreeInorderTraversal> testsuite() {
        return Testsuite.<BinaryTreeInorderTraversal>builder()
                .add(ExpectedTestcase.of(s -> s.inorderTraversal(TreeNode.of(1, null, 2, 3)), List.of(1, 3, 2)))
                .build();
    }


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
                return Collections.emptyList();
            }
            List<Integer> result = new ArrayList<>();
            Deque<TreeNode> stack = new LinkedList<>();
            stack.push(root);
            while (!stack.isEmpty()) {
                TreeNode top = stack.pop();
                if (top.right != null) {
                    stack.push(top.right);
                }
                if (top.left == null) {
                    result.add(top.val);
                } else {
                    stack.push(new TreeNode(top.val));
                    stack.push(top.left);
                }
            }
            return result;
        }
    }

    class Best implements BinaryTreeInorderTraversal {

        @Override
        public List<Integer> inorderTraversal(TreeNode root) {
            if (root == null) {
                return Collections.emptyList();
            }
            List<Integer> result = new ArrayList<>();
            Deque<TreeNode> stack = new LinkedList<>();
            while (root != null || !stack.isEmpty()) {
                while (root != null) {
                    stack.push(root);
                    root = root.left;
                }
                root = stack.pop();
                result.add(root.val);
                root = root.right;
            }
            return result;
        }
    }

}

class BinaryTreeInorderTraversalTest extends AbstractTest<BinaryTreeInorderTraversal> {
}
