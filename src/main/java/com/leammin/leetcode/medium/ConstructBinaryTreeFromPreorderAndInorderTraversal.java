package com.leammin.leetcode.medium;

import com.leammin.leetcode.struct.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * 105. 从前序与中序遍历序列构造二叉树
 * 
 * <p>根据一棵树的前序遍历与中序遍历构造二叉树。</p>
 * 
 * <p><strong>注意:</strong><br>
 * 你可以假设树中没有重复的元素。</p>
 * 
 * <p>例如，给出</p>
 * 
 * <pre>前序遍历 preorder =&nbsp;[3,9,20,15,7]
 * 中序遍历 inorder = [9,3,15,20,7]</pre>
 * 
 * <p>返回如下的二叉树：</p>
 * 
 * <pre>    3
 *    / \
 *   9  20
 *     /  \
 *    15   7</pre>
 * 
 * 
 * @author Leammin
 * @date 2019-09-23
 */
public interface ConstructBinaryTreeFromPreorderAndInorderTraversal {
    TreeNode buildTree(int[] preorder, int[] inorder);

    class Solution implements ConstructBinaryTreeFromPreorderAndInorderTraversal {

        @Override
        public TreeNode buildTree(int[] preorder, int[] inorder) {
            if (preorder == null || preorder.length == 0) {
                return null;
            }
            Map<Integer, Integer> inorderIndexMap = new HashMap<>();
            for (int i = 0; i < inorder.length; i++) {
                inorderIndexMap.put(inorder[i], i);
            }
            TreeNode root = new TreeNode(preorder[0]);
            TreeNode last = root;
            for (int i = 1; i < preorder.length; i++) {
                TreeNode node = new TreeNode(preorder[i]);
                int inorderIndex = inorderIndexMap.get(preorder[i]);

                int lastInorderIndex = inorderIndexMap.get(last.val);
                if (inorderIndex < lastInorderIndex) {
                    last.left = node;
                } else {
                    TreeNode parent = root;
                    while (true) {
                        int parentInorderIndex = inorderIndexMap.get(parent.val);
                        if (inorderIndex < parentInorderIndex) {
                            if (parent.left == null) {
                                parent.left = node;
                                break;
                            }
                            parent = parent.left;
                        } else {
                            if (parent.right == null) {
                                parent.right = node;
                                break;
                            }
                            parent = parent.right;
                        }
                    }
                }
                last = node;
            }
            return root;
        }
    }

    class Solution2 implements ConstructBinaryTreeFromPreorderAndInorderTraversal {

        @Override
        public TreeNode buildTree(int[] preorder, int[] inorder) {
            Map<Integer, Integer> inorderIndexMap = new HashMap<>();
            for (int i = 0; i < inorder.length; i++) {
                inorderIndexMap.put(inorder[i], i);
            }
            return buildTree(preorder, 0, preorder.length, inorderIndexMap, 0, inorder.length);
        }
        public TreeNode buildTree(int[] preorder, int preorderStart, int preorderEnd, Map<Integer, Integer> inorderIndexMap, int inorderStart, int inorderEnd) {
            if (preorderStart >= preorderEnd || inorderStart >= inorderEnd) {
                return null;
            }
            TreeNode root = new TreeNode(preorder[preorderStart]);
            int rootInorderIndex = inorderIndexMap.get(preorder[preorderStart]);
            root.left = buildTree(preorder, preorderStart + 1, preorderStart + rootInorderIndex - inorderStart + 1,
                    inorderIndexMap, inorderStart, rootInorderIndex);
            root.right = buildTree(preorder, preorderStart + rootInorderIndex - inorderStart + 1, preorderEnd,
                    inorderIndexMap, rootInorderIndex + 1, inorderEnd
            );
            return root;
        }
    }
}
