package com.leammin.leetcode.medium;

import com.leammin.leetcode.struct.TreeNode;
import com.leammin.leetcode.util.Execute;

/**
 * 450. 删除二叉搜索树中的节点
 * 
 * <p>给定一个二叉搜索树的根节点 <strong>root </strong>和一个值 <strong>key</strong>，删除二叉搜索树中的&nbsp;<strong>key&nbsp;</strong>对应的节点，并保证二叉搜索树的性质不变。返回二叉搜索树（有可能被更新）的根节点的引用。</p>
 * 
 * <p>一般来说，删除节点可分为两个步骤：</p>
 * 
 * <ol>
 * 	<li>首先找到需要删除的节点；</li>
 * 	<li>如果找到了，删除它。</li>
 * </ol>
 * 
 * <p><strong>说明：</strong> 要求算法时间复杂度为&nbsp;O(h)，h 为树的高度。</p>
 * 
 * <p><strong>示例:</strong></p>
 * 
 * <pre>
 * root = [5,3,6,2,4,null,7]
 * key = 3
 * 
 *     5
 *    / \
 *   3   6
 *  / \   \
 * 2   4   7
 * 
 * 给定需要删除的节点值是 3，所以我们首先找到 3 这个节点，然后删除它。
 * 
 * 一个正确的答案是 [5,4,6,2,null,null,7], 如下图所示。
 * 
 *     5
 *    / \
 *   4   6
 *  /     \
 * 2       7
 * 
 * 另一个正确答案是 [5,2,6,null,4,null,7]。
 * 
 *     5
 *    / \
 *   2   6
 *    \   \
 *     4   7
 * </pre>
 * 
 * 
 * @author Leammin
 * @date 2020-06-30
 */
public interface DeleteNodeInABst {
    TreeNode deleteNode(TreeNode root, int key);

    @Execute(cases = 0)
    class Solution implements DeleteNodeInABst {

        @Override
        public TreeNode deleteNode(TreeNode root, int key) {
            TreeNode parent = null;
            TreeNode target = root;
            while (target != null && target.val != key) {
                parent = target;
                if (target.val > key) {
                    target = target.left;
                } else {
                    target = target.right;
                }
            }
            if (target == null) {
                return root;
            }
            if (target.left == null || target.right == null) {
                if (parent == null) {
                    // target == root
                    return target.left != null ? target.left : target.right;
                }
                if (parent.left == target) {
                    parent.left = target.left != null ? target.left : target.right;
                } else {
                    parent.right = target.left != null ? target.left : target.right;
                }
                return root;
            }
            if (target.right.left == null) {
                target.right.left = target.left;
                if (parent == null) {
                    return target.right;
                }
                if (parent.left == target) {
                    parent.left = target.right;
                } else {
                    parent.right = target.right;
                }
                return root;
            }
            TreeNode replaceParent = target;
            TreeNode replace = replaceParent.right;
            while (replace.left != null) {
                replaceParent = replace;
                replace = replace.left;
            }
            replaceParent.left = replace.right;
            replace.left = target.left;
            replace.right = target.right;
            if (parent == null) {
                return replace;
            }
            if (parent.left == target) {
                parent.left = replace;
            } else {
                parent.right = replace;
            }
            return root;
        }
    }
}
