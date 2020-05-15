package com.leammin.leetcode.medium;

import com.leammin.leetcode.struct.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;

/**
 * 236. 二叉树的最近公共祖先
 * 
 * <p>给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。</p>
 * 
 * <p><a href="https://baike.baidu.com/item/%E6%9C%80%E8%BF%91%E5%85%AC%E5%85%B1%E7%A5%96%E5%85%88/8918834?fr=aladdin" target="_blank">百度百科</a>中最近公共祖先的定义为：&ldquo;对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（<strong>一个节点也可以是它自己的祖先</strong>）。&rdquo;</p>
 * 
 * <p>例如，给定如下二叉树:&nbsp; root =&nbsp;[3,5,1,6,2,0,8,null,null,7,4]</p>
 * 
 * <p><img alt="" src="https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2018/12/15/binarytree.png" style="height: 190px; width: 200px;"></p>
 * 
 * <p>&nbsp;</p>
 * 
 * <p><strong>示例 1:</strong></p>
 * 
 * <pre><strong>输入:</strong> root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
 * <strong>输出:</strong> 3
 * <strong>解释: </strong>节点 <code>5 </code>和节点 <code>1 </code>的最近公共祖先是节点 <code>3。</code>
 * </pre>
 * 
 * <p><strong>示例&nbsp;2:</strong></p>
 * 
 * <pre><strong>输入:</strong> root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
 * <strong>输出:</strong> 5
 * <strong>解释: </strong>节点 <code>5 </code>和节点 <code>4 </code>的最近公共祖先是节点 <code>5。</code>因为根据定义最近公共祖先节点可以为节点本身。
 * </pre>
 * 
 * <p>&nbsp;</p>
 * 
 * <p><strong>说明:</strong></p>
 * 
 * <ul>
 * 	<li>所有节点的值都是唯一的。</li>
 * 	<li>p、q 为不同节点且均 存在于给定的二叉树中。</li>
 * </ul>
 * 
 * 
 * @author Leammin
 * @date 2020-05-11
 */
public interface LowestCommonAncestorOfABinaryTree {
    TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q);

    class Solution implements LowestCommonAncestorOfABinaryTree {
        @Override
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            if (root.val == p.val || root.val == q.val) {
                return root;
            }
            List<TreeNode> plist = dfs(root, p.val);
            List<TreeNode> qlist = dfs(root, q.val);
            ListIterator<TreeNode> pit = plist.listIterator(plist.size());
            ListIterator<TreeNode> qit = qlist.listIterator(qlist.size());
            TreeNode last = null;
            while (pit.hasPrevious() && qit.hasPrevious()) {
                TreeNode previous = pit.previous();
                if (previous == qit.previous()) {
                    last = previous;
                } else {
                    return last;
                }
            }

            return last;
        }

        private List<TreeNode> dfs(TreeNode node, int n) {
            if (node == null) {
                return Collections.emptyList();
            }
            if (node.val == n) {
                return new ArrayList<>(Collections.singletonList(node));
            }
            List<TreeNode> left = dfs(node.left, n);
            if (!left.isEmpty()) {
                left.add(node);
                return left;
            }
            List<TreeNode> right = dfs(node.right, n);
            if (!right.isEmpty()) {
                right.add(node);
                return right;
            }
            return Collections.emptyList();
        }
    }

    class Best implements LowestCommonAncestorOfABinaryTree {
        private TreeNode ans;

        private boolean dfs(TreeNode root, TreeNode p, TreeNode q) {
            if (root == null) return false;
            boolean lson = dfs(root.left, p, q);
            boolean rson = dfs(root.right, p, q);
            if ((lson && rson) || ((root.val == p.val || root.val == q.val) && (lson || rson))) {
                ans = root;
            }
            return lson || rson || (root.val == p.val || root.val == q.val);
        }

        @Override
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            this.dfs(root, p, q);
            return this.ans;
        }
    }
}
