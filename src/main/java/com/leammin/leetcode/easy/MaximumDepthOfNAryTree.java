package com.leammin.leetcode.easy;

import java.util.Collections;
import java.util.List;

/**
 * 559. N叉树的最大深度
 * 
 * <p>给定一个 N 叉树，找到其最大深度。</p>
 * 
 * <p>最大深度是指从根节点到最远叶子节点的最长路径上的节点总数。</p>
 * 
 * <p>例如，给定一个&nbsp;<code>3叉树</code>&nbsp;:</p>
 * 
 * <p>&nbsp;</p>
 * 
 * <p><img src="https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2018/10/12/narytreeexample.png" style="width: 100%; max-width: 300px;"></p>
 * 
 * <p>&nbsp;</p>
 * 
 * <p>我们应返回其最大深度，3。</p>
 * 
 * <p><strong>说明:</strong></p>
 * 
 * <ol>
 * 	<li>树的深度不会超过&nbsp;<code>1000</code>。</li>
 * 	<li>树的节点总不会超过&nbsp;<code>5000</code>。</li>
 * </ol>
 * 
 * @author Leammin
 * @date 2021-04-05
 */
public interface MaximumDepthOfNAryTree {
    int maxDepth(Node root);

    class Solution implements MaximumDepthOfNAryTree {

        @Override
        public int maxDepth(Node root) {
            if (root == null) {
                return 0;
            }
            int max = 0;
            List<Node> children = root.children == null ? Collections.emptyList() : root.children;
            for (Node child : children) {
                int childDepth = maxDepth(child);
                max = Math.max(max, childDepth);
            }
            return max + 1;
        }
    }

    class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }
}
