package com.leammin.leetcode.undone.easy;

import java.util.ArrayList;
import java.util.List;

import com.leammin.leetcode.struct.TreeNode;

/**
 * 872. 叶子相似的树
 * 
 * <p>请考虑一颗二叉树上所有的叶子，这些叶子的值按从左到右的顺序排列形成一个&nbsp;<em>叶值序列</em> 。</p>
 * 
 * <p><img alt="" src="https://s3-lc-upload.s3.amazonaws.com/uploads/2018/07/16/tree.png" style="height: 240px; width: 300px;"></p>
 * 
 * <p>举个例子，如上图所示，给定一颗叶值序列为&nbsp;<code>(6, 7, 4, 9, 8)</code>&nbsp;的树。</p>
 * 
 * <p>如果有两颗二叉树的叶值序列是相同，那么我们就认为它们是&nbsp;<em>叶相似&nbsp;</em>的。</p>
 * 
 * <p>如果给定的两个头结点分别为&nbsp;<code>root1</code> 和&nbsp;<code>root2</code>&nbsp;的树是叶相似的，则返回&nbsp;<code>true</code>；否则返回 <code>false</code> 。</p>
 * 
 * <p>&nbsp;</p>
 * 
 * <p><strong>提示：</strong></p>
 * 
 * <ul>
 * 	<li>给定的两颗树可能会有&nbsp;<code>1</code>&nbsp;到&nbsp;<code>100</code>&nbsp;个结点。</li>
 * </ul>
 * 
 * 
 * @author Leammin
 * @date 2021-05-10
 */
public interface LeafSimilarTrees {
    boolean leafSimilar(TreeNode root1, TreeNode root2);

    class Solution implements LeafSimilarTrees {

        @Override
        public boolean leafSimilar(TreeNode root1, TreeNode root2) {
            return leaves(root1).equals(leaves(root2));
        }

        private List<Integer> leaves(TreeNode root) {
            List<Integer> result = new ArrayList<>();
            leaves(root, result);
            return result;
        }

        private void leaves(TreeNode root, List<Integer> leaves) {
            if (root == null) {
                return;
            }
            if (root.left == null && root.right == null) {
                leaves.add(root.val);
                return;
            }
            leaves(root.left, leaves);
            leaves(root.right, leaves);
        }
    }
}
