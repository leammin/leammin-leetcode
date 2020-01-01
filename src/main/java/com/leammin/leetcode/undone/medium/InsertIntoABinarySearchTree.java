package com.leammin.leetcode.undone.medium;

import com.leammin.leetcode.struct.TreeNode;

/**
 * 701. 二叉搜索树中的插入操作
 * 
 * <p>给定二叉搜索树（BST）的根节点和要插入树中的值，将值插入二叉搜索树。 返回插入后二叉搜索树的根节点。 保证原始二叉搜索树中不存在新值。</p>
 * 
 * <p>注意，可能存在多种有效的插入方式，只要树在插入后仍保持为二叉搜索树即可。 你可以返回任意有效的结果。</p>
 * 
 * <p>例如,&nbsp;</p>
 * 
 * <pre>
 * 给定二叉搜索树:
 * 
 *         4
 *        / \
 *       2   7
 *      / \
 *     1   3
 * 
 * 和 插入的值: 5
 * </pre>
 * 
 * <p>你可以返回这个二叉搜索树:</p>
 * 
 * <pre>
 *          4
 *        /   \
 *       2     7
 *      / \   /
 *     1   3 5
 * </pre>
 * 
 * <p>或者这个树也是有效的:</p>
 * 
 * <pre>
 *          5
 *        /   \
 *       2     7
 *      / \   
 *     1   3
 *          \
 *           4
 * </pre>
 * 
 * 
 * @author Leammin
 * @date 2020-01-01
 */
public interface InsertIntoABinarySearchTree {
    TreeNode insertIntoBST(TreeNode root, int val);

    class Solution implements InsertIntoABinarySearchTree {

        @Override
        public TreeNode insertIntoBST(TreeNode root, int val) {
            if (root == null) {
                return new TreeNode(val);
            }
            if (root.val > val) {
                root.left = insertIntoBST(root.left, val);
            }
            if (root.val < val) {
                root.right = insertIntoBST(root.right, val);
            }
            return root;
        }
    }
}
