package com.leammin.leetcode.hard;

import com.leammin.leetcode.struct.TreeNode;
import com.leammin.leetcode.util.test.AbstractTest;
import com.leammin.leetcode.util.test.ExpectedTestcase;
import com.leammin.leetcode.util.test.Testsuite;

/**
 * 124. 二叉树中的最大路径和
 * 
 * <p>给定一个<strong>非空</strong>二叉树，返回其最大路径和。</p>
 * 
 * <p>本题中，路径被定义为一条从树中任意节点出发，达到任意节点的序列。该路径<strong>至少包含一个</strong>节点，且不一定经过根节点。</p>
 * 
 * <p><strong>示例 1:</strong></p>
 * 
 * <pre><strong>输入:</strong> [1,2,3]
 * 
 *        <strong>1</strong>
 *       <strong>/ \</strong>
 *      <strong>2</strong>   <strong>3</strong>
 * 
 * <strong>输出:</strong> 6
 * </pre>
 * 
 * <p><strong>示例&nbsp;2:</strong></p>
 * 
 * <pre><strong>输入:</strong> [-10,9,20,null,null,15,7]
 * 
 * &nbsp;  -10
 * &nbsp; &nbsp;/ \
 * &nbsp; 9 &nbsp;<strong>20</strong>
 * &nbsp; &nbsp; <strong>/ &nbsp;\</strong>
 * &nbsp; &nbsp;<strong>15 &nbsp; 7</strong>
 * 
 * <strong>输出:</strong> 42</pre>
 * 
 * 
 * @author Leammin
 * @date 2019-10-03
 */
public interface BinaryTreeMaximumPathSum {
    int maxPathSum(TreeNode root);

    static Testsuite<BinaryTreeMaximumPathSum> testsuite() {
        return Testsuite.<BinaryTreeMaximumPathSum>builder()
                .add(ExpectedTestcase.of(t -> t.maxPathSum(TreeNode.of(1, 2, 3)), 6))
                .add(ExpectedTestcase.of(t -> t.maxPathSum(TreeNode.of(-10, 9, 20, null, null, 15, 7)), 42))
                .add(ExpectedTestcase.of(t -> t.maxPathSum(TreeNode.of(-3)), -3))
                .add(ExpectedTestcase.of(t -> t.maxPathSum(TreeNode.of(5, 4, 8, 11, null, 13, 4, 7, 2, null, null, null, 1)), 48))
                .build();
    }


    class Solution implements BinaryTreeMaximumPathSum {
        int max = Integer.MIN_VALUE;

        @Override
        public int maxPathSum(TreeNode root) {
            maxLeftOrRightWithRoot(root);
            return max;
        }

        private int maxLeftOrRightWithRoot(TreeNode root) {
            if (root == null) {
                return 0;
            }
            int rootVal = root.val;
            int leftVal = maxLeftOrRightWithRoot(root.left);
            int rightVal = maxLeftOrRightWithRoot(root.right);
            int result = max(rootVal, rootVal + leftVal, rootVal + rightVal);
            max = max(result, rootVal + leftVal + rightVal, max);
            return result;
        }

        private int max(int a, int b, int c) {
            return Math.max(Math.max(a, b), c);
        }
    }
}

class BinaryTreeMaximumPathSumTest extends AbstractTest<BinaryTreeMaximumPathSum> {
}
