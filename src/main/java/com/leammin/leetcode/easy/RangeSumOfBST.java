package com.leammin.leetcode.easy;

import com.leammin.leetcode.struct.TreeNode;

/**
 * 975. 二叉搜索树的范围和
 * 
 * <p>给定二叉搜索树的根结点&nbsp;<code>root</code>，返回 <code>L</code> 和 <code>R</code>（含）之间的所有结点的值的和。</p>
 * 
 * <p>二叉搜索树保证具有唯一的值。</p>
 * 
 * <p>&nbsp;</p>
 * 
 * <p><strong>示例 1：</strong></p>
 * 
 * <pre><strong>输入：</strong>root = [10,5,15,3,7,null,18], L = 7, R = 15
 * <strong>输出：</strong>32
 * </pre>
 * 
 * <p><strong>示例&nbsp;2：</strong></p>
 * 
 * <pre><strong>输入：</strong>root = [10,5,15,3,7,13,18,1,null,6], L = 6, R = 10
 * <strong>输出：</strong>23
 * </pre>
 * 
 * <p>&nbsp;</p>
 * 
 * <p><strong>提示：</strong></p>
 * 
 * <ol>
 * 	<li>树中的结点数量最多为&nbsp;<code>10000</code>&nbsp;个。</li>
 * 	<li>最终的答案保证小于&nbsp;<code>2^31</code>。</li>
 * </ol>
 * 
 * 
 * @author Leammin
 * @date 2019-12-27
 */
public interface RangeSumOfBST {
    int rangeSumBST(TreeNode root, int L, int R);

    class Solution implements RangeSumOfBST {

        @Override
        public int rangeSumBST(TreeNode root, int l, int r) {
            if (root == null) {
                return 0;
            }
            if (l > r) {
                return rangeSumBST(root, r, l);
            }
            return (root.val >= l && root.val <= r ? root.val : 0) + rangeSumBST(root.left, l, r) + rangeSumBST(root.right, l, r);
        }
    }
}
