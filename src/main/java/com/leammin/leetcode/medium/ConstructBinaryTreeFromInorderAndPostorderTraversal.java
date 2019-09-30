package com.leammin.leetcode.medium;

import com.leammin.leetcode.struct.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * 106. 从中序与后序遍历序列构造二叉树
 * 
 * <p>根据一棵树的中序遍历与后序遍历构造二叉树。</p>
 * 
 * <p><strong>注意:</strong><br>
 * 你可以假设树中没有重复的元素。</p>
 * 
 * <p>例如，给出</p>
 * 
 * <pre>中序遍历 inorder =&nbsp;[9,3,15,20,7]
 * 后序遍历 postorder = [9,15,7,20,3]</pre>
 * 
 * <p>返回如下的二叉树：</p>
 * 
 * <pre>    3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * </pre>
 * 
 * 
 * @author Leammin
 * @date 2019-09-30
 */
public interface ConstructBinaryTreeFromInorderAndPostorderTraversal {
    TreeNode buildTree(int[] inorder, int[] postorder);

    class Solution implements ConstructBinaryTreeFromInorderAndPostorderTraversal {
        @Override
        public TreeNode buildTree(int[] inorder, int[] postorder) {
            Map<Integer, Integer> inorderIndexMap = new HashMap<>();
            for (int i = 0; i < inorder.length; i++) {
                inorderIndexMap.put(inorder[i], i);
            }
            return buildTree(inorderIndexMap, 0, inorder.length, postorder, 0, postorder.length);
        }

        private TreeNode buildTree(Map<Integer, Integer> inorderIndexMap, int inorderStart, int inorderEnd, int[] postorder, int postorderStart, int postorderEnd) {
            if (inorderEnd <= inorderStart || postorderEnd <= postorderStart) {
                return null;
            }
            int rootIndex = postorderEnd - 1;
            TreeNode root = new TreeNode(postorder[rootIndex]);
            int rootInorderIndex = inorderIndexMap.get(postorder[rootIndex]);
            int leftLength = rootInorderIndex - inorderStart;
            int rightLength = inorderEnd - rootInorderIndex - 1;
            root.right = buildTree(inorderIndexMap, rootInorderIndex + 1, inorderEnd,
                    postorder, postorderEnd - 1 - rightLength, postorderEnd - 1);
            root.left = buildTree(inorderIndexMap, inorderStart, rootInorderIndex,
                    postorder, postorderStart, postorderEnd - 1 - rightLength);
            return root;
        }
    }
}
