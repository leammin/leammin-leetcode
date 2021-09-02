package com.leammin.leetcode.medium;

import com.leammin.leetcode.struct.TreeNode;

/**
 * 面试题07. 重建二叉树
 *
 * <p>输入某二叉树的前序遍历和中序遍历的结果，请重建该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。</p>
 *
 * <p>&nbsp;</p>
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
 * <p>&nbsp;</p>
 *
 * <p><strong>限制：</strong></p>
 *
 * <p><code>0 &lt;= 节点个数 &lt;= 5000</code></p>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>注意</strong>：本题与主站 105 题重复：<a href="https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/">https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/</a></p>
 *
 * @author Leammin
 * @date 2021-08-21
 */
public interface ZhongJianErChaShuLcof {
    TreeNode buildTree(int[] preorder, int[] inorder);

    class Solution implements ZhongJianErChaShuLcof {

        @Override
        public TreeNode buildTree(int[] preorder, int[] inorder) {
            return buildTree(preorder, 0, preorder.length, inorder, 0, inorder.length);
        }

        private TreeNode buildTree(int[] preorder, int pfrom, int pto, int[] inorder, int ifrom, int ito) {
            if (pto <= pfrom || ito <= ifrom) {
                return null;
            }
            int rootVal = preorder[pfrom];
            TreeNode root = new TreeNode(rootVal);
            int rootIndexInInorder = indexOf(inorder, ifrom, ito, rootVal);
            int leftCount = rootIndexInInorder - ifrom;
            root.left = buildTree(preorder, pfrom + 1, pfrom + 1 + leftCount, inorder, ifrom, rootIndexInInorder);
            root.right = buildTree(preorder, pfrom + 1 + leftCount, pto, inorder, rootIndexInInorder + 1, ito);
            return root;
        }

        private int indexOf(int[] arr, int from, int to, int x) {
            for (int i = from; i < to; i++) {
                if (arr[i] == x) {
                    return i;
                }
            }
            return -1;
        }
    }


    class Solution2 implements ZhongJianErChaShuLcof {

        @Override
        public TreeNode buildTree(int[] preorder, int[] inorder) {
            int[] inorderIndexMap = new int[6001];
            for (int i = 0; i < inorder.length; i++) {
                inorderIndexMap[inorder[i] + 3000] = i;
            }
            return buildTree(preorder, 0, preorder.length, inorder, 0, inorder.length, inorderIndexMap);
        }

        private TreeNode buildTree(int[] preorder, int pfrom, int pto, int[] inorder, int ifrom, int ito, int[] inorderIndexMap) {
            if (pto <= pfrom || ito <= ifrom) {
                return null;
            }
            int rootVal = preorder[pfrom];
            TreeNode root = new TreeNode(rootVal);
            int rootIndexInInorder = inorderIndexMap[rootVal + 3000];
            int leftCount = rootIndexInInorder - ifrom;
            root.left = buildTree(preorder, pfrom + 1, pfrom + 1 + leftCount, inorder, ifrom, rootIndexInInorder, inorderIndexMap);
            root.right = buildTree(preorder, pfrom + 1 + leftCount, pto, inorder, rootIndexInInorder + 1, ito, inorderIndexMap);
            return root;
        }

        private int indexOf(int[] arr, int from, int to, int x) {
            for (int i = from; i < to; i++) {
                if (arr[i] == x) {
                    return i;
                }
            }
            return -1;
        }
    }
}
