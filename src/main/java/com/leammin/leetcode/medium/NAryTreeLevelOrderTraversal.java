package com.leammin.leetcode.medium;

import java.util.*;

/**
 * 429. N叉树的层序遍历
 * 
 * <p>给定一个 N 叉树，返回其节点值的<em>层序遍历</em>。 (即从左到右，逐层遍历)。</p>
 * 
 * <p>例如，给定一个&nbsp;<code>3叉树</code>&nbsp;:</p>
 * 
 * <p>&nbsp;</p>
 * 
 * <p><img src="https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2018/10/12/narytreeexample.png" style="width: 100%; max-width: 300px;"></p>
 * 
 * <p>&nbsp;</p>
 * 
 * <p>返回其层序遍历:</p>
 * 
 * <pre>[
 *      [1],
 *      [3,2,4],
 *      [5,6]
 * ]
 * </pre>
 * 
 * <p>&nbsp;</p>
 * 
 * <p><strong>说明:</strong></p>
 * 
 * <ol>
 * 	<li>树的深度不会超过&nbsp;<code>1000</code>。</li>
 * 	<li>树的节点总数不会超过&nbsp;<code>5000</code>。</li>
 * </ol>
 * 
 * @author Leammin
 * @date 2021-04-05
 */
public interface NAryTreeLevelOrderTraversal {
    List<List<Integer>> levelOrder(Node root);

    class Solution implements NAryTreeLevelOrderTraversal {

        @Override
        public List<List<Integer>> levelOrder(Node root) {
            if (root == null) {
                return Collections.emptyList();
            }
            List<List<Integer>> res = new ArrayList<>();
            Queue<Node> queue = new LinkedList<>();
            queue.add(root);
            while (!queue.isEmpty()) {
                int size = queue.size();
                List<Integer> vals = new ArrayList<>(size);
                for (int i = 0; i < size; i++) {
                    Node node = queue.poll();
                    vals.add(node.val);
                    if (node.children != null) {
                        queue.addAll(node.children);
                    }
                }
                res.add(vals);
            }
            return res;
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
