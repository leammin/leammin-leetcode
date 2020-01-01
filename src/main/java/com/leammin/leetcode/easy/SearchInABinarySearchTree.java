package com.leammin.leetcode.easy;

import com.leammin.leetcode.struct.TreeNode;

/**
 * 700. 二叉搜索树中的搜索
 * 
 * <p>给定二叉搜索树（BST）的根节点和一个值。 你需要在BST中找到节点值等于给定值的节点。 返回以该节点为根的子树。 如果节点不存在，则返回 NULL。</p>
 * 
 * <p>例如，</p>
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
 * 和值: 2
 * </pre>
 * 
 * <p>你应该返回如下子树:</p>
 * 
 * <pre>
 *       2     
 *      / \   
 *     1   3
 * </pre>
 * 
 * <p>在上述示例中，如果要找的值是 <code>5</code>，但因为没有节点值为 <code>5</code>，我们应该返回 <code>NULL</code>。</p>
 * 
 * 
 * @author Leammin
 * @date 2020-01-01
 */
public interface SearchInABinarySearchTree {
    TreeNode searchBST(TreeNode root, int val);

    class Solution implements SearchInABinarySearchTree {

        @Override
        public TreeNode searchBST(TreeNode root, int val) {
            if (root == null) {
                return null;
            }
            if (root.val > val) {
                return searchBST(root.left, val);
            } else if (root.val < val){
                return searchBST(root.right, val);
            } else {
                return root;
            }
        }
    }
}
