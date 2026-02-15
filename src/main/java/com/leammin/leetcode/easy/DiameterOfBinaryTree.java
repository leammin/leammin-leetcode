package com.leammin.leetcode.easy;

import com.leammin.leetcode.struct.TreeNode;
import com.leammin.leetcode.util.test.AbstractTest;
import com.leammin.leetcode.util.test.ExpectedTestcase;
import com.leammin.leetcode.util.test.Testsuite;

/**
 * 543. 二叉树的直径
 * 
 * <p>给定一棵二叉树，你需要计算它的直径长度。一棵二叉树的直径长度是任意两个结点路径长度中的最大值。这条路径可能穿过根结点。</p>
 * 
 * <p><strong>示例 :</strong><br />
 * 给定二叉树</p>
 * 
 * <pre>
 *           1
 *          / \
 *         2   3
 *        / \     
 *       4   5    
 * </pre>
 * 
 * <p>返回&nbsp;<strong>3</strong>, 它的长度是路径 [4,2,1,3] 或者&nbsp;[5,2,1,3]。</p>
 * 
 * <p><strong>注意：</strong>两结点之间的路径长度是以它们之间边的数目表示。</p>
 * 
 * 
 * @author Leammin
 * @date 2020-03-10
 */
public interface DiameterOfBinaryTree {
    int diameterOfBinaryTree(TreeNode root);

    static Testsuite<DiameterOfBinaryTree> testsuite() {
        return Testsuite.<DiameterOfBinaryTree>builder()
                .add(ExpectedTestcase.of(t -> t.diameterOfBinaryTree(TreeNode.of(1, 2, 3, 4, 5)), 3))
                .build();
    }


    class Solution implements DiameterOfBinaryTree {
        int result = 0;

        @Override
        public int diameterOfBinaryTree(TreeNode root) {
            dfs(root);
            return result;
        }

        private int dfs(TreeNode root) {
            if (root == null) {
                return 0;
            }
            int left = dfs(root.left);
            int right = dfs(root.right);
            if (left + right > result) {
                result = left + right;
            }
            return Math.max(left, right) + 1;
        }
    }
}

class DiameterOfBinaryTreeTest extends AbstractTest<DiameterOfBinaryTree> {
}
