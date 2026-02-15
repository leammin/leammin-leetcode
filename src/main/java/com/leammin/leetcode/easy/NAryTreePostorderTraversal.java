package com.leammin.leetcode.easy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.leammin.leetcode.util.test.AbstractTest;
import com.leammin.leetcode.util.test.Testsuite;

/**
 * 590. N叉树的后序遍历
 * 
 * <p>给定一个 N 叉树，返回其节点值的<em>后序遍历</em>。</p>
 * 
 * <p>例如，给定一个&nbsp;<code>3叉树</code>&nbsp;:</p>
 * 
 * <p>&nbsp;</p>
 * 
 * <p><img src="https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2018/10/12/narytreeexample.png" style="width: 100%; max-width: 300px;"></p>
 * 
 * <p>&nbsp;</p>
 * 
 * <p>返回其后序遍历: <code>[5,6,3,2,4,1]</code>.</p>
 * 
 * <p>&nbsp;</p>
 * 
 * <p><strong>说明:</strong>&nbsp;递归法很简单，你可以使用迭代法完成此题吗?</p>
 * 
 * @author Leammin
 * @date 2021-04-05
 */
public interface NAryTreePostorderTraversal {
    List<Integer> postorder(Node root);

    static Testsuite<NAryTreePostorderTraversal> testsuite() {
        NAryTreePostorderTraversal.Node root = new NAryTreePostorderTraversal.Node(1,
                List.of(new NAryTreePostorderTraversal.Node(3,
                                List.of(new NAryTreePostorderTraversal.Node(5),
                                        new NAryTreePostorderTraversal.Node(6))),
                        new NAryTreePostorderTraversal.Node(2),
                        new NAryTreePostorderTraversal.Node(4)));

        return Testsuite.<NAryTreePostorderTraversal>builder()
                .addExpected(t -> t.postorder(root), List.of(5,6,3,2,4,1))
                .build();
    }


    class Solution implements NAryTreePostorderTraversal {

        @Override
        public List<Integer> postorder(Node root) {
            ArrayList<Integer> res = new ArrayList<>();
            postorder(res, root);
            return res;
        }

        public void postorder(List<Integer> res, Node node) {
            if (node == null) {
                return;
            }
            List<Node> children = node.children == null ? Collections.emptyList() : node.children;
            for (Node child : children) {
                postorder(res, child);
            }
            res.add(node.val);
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

class NAryTreePostorderTraversalTest extends AbstractTest<NAryTreePostorderTraversal> {
}
