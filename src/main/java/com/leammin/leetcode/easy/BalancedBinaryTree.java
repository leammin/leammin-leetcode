package com.leammin.leetcode.easy;

import com.leammin.leetcode.struct.TreeNode;
import com.leammin.leetcode.util.test.AbstractTest;
import com.leammin.leetcode.util.test.ExpectedTestcase;
import com.leammin.leetcode.util.test.Testsuite;

/**
 * 110. 平衡二叉树
 * 
 * <p>给定一个二叉树，判断它是否是高度平衡的二叉树。</p>
 * 
 * <p>本题中，一棵高度平衡二叉树定义为：</p>
 * 
 * <blockquote>
 * <p>一个二叉树<em>每个节点&nbsp;</em>的左右两个子树的高度差的绝对值不超过1。</p>
 * </blockquote>
 * 
 * <p><strong>示例 1:</strong></p>
 * 
 * <p>给定二叉树 <code>[3,9,20,null,null,15,7]</code></p>
 * 
 * <pre>    3
 *    / \
 *   9  20
 *     /  \
 *    15   7</pre>
 * 
 * <p>返回 <code>true</code> 。<br>
 * <br>
 * <strong>示例 2:</strong></p>
 * 
 * <p>给定二叉树 <code>[1,2,2,3,3,null,null,4,4]</code></p>
 * 
 * <pre>       1
 *       / \
 *      2   2
 *     / \
 *    3   3
 *   / \
 *  4   4
 * </pre>
 * 
 * <p>返回&nbsp;<code>false</code> 。</p>
 * 
 * 
 * @author Leammin
 * @date 2019-10-02
 */
public interface BalancedBinaryTree {
    boolean isBalanced(TreeNode root);

    static Testsuite<BalancedBinaryTree> testsuite() {
        return Testsuite.<BalancedBinaryTree>builder()
                .add(ExpectedTestcase.of(t -> t.isBalanced(TreeNode.of(3, 9, 20, null, null, 15, 7)), true))
                .add(ExpectedTestcase.of(t -> t.isBalanced(TreeNode.of(1,2,2,3,3,null,null,4,4)), false))
                .build();
    }


    class Solution implements BalancedBinaryTree {

        @Override
        public boolean isBalanced(TreeNode root) {
            return hight(root) >= 0;
        }

        private int hight(TreeNode node) {
            if (node == null) {
                return 0;
            }
            int left = hight(node.left);
            if (left < 0) {
                return -1;
            }
            int right = hight(node.right);
            if (right < 0) {
                return -1;
            }
            return Math.abs(left - right) <= 1 ? Math.max(left, right) + 1 : -1;
        }
    }
}

class BalancedBinaryTreeTest extends AbstractTest<BalancedBinaryTree> {
}
