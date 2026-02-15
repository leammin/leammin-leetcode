package com.leammin.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

import com.leammin.leetcode.util.test.AbstractTest;
import com.leammin.leetcode.util.test.Testsuite;

/**
 * 589. N叉树的前序遍历
 * 
 * <p>给定一个 N 叉树，返回其节点值的<em>前序遍历</em>。</p>
 * 
 * <p>例如，给定一个&nbsp;<code>3叉树</code>&nbsp;:</p>
 * 
 * <p>&nbsp;</p>
 * 
 * <p><img src="https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2018/10/12/narytreeexample.png" style="width: 100%; max-width: 300px;"></p>
 * 
 * <p>&nbsp;</p>
 * 
 * <p>返回其前序遍历: <code>[1,3,5,6,2,4]</code>。</p>
 * 
 * <p>&nbsp;</p>
 * 
 * <p><strong>说明:&nbsp;</strong>递归法很简单，你可以使用迭代法完成此题吗?</p>
 * 
 * @author Leammin
 * @date 2021-04-05
 */
public interface NAryTreePreorderTraversal {
    List<Integer> preorder(Node root);

    static Testsuite<NAryTreePreorderTraversal> testsuite() {
        NAryTreePreorderTraversal.Node root = new NAryTreePreorderTraversal.Node(1,
                List.of(new NAryTreePreorderTraversal.Node(3,
                                List.of(new NAryTreePreorderTraversal.Node(5),
                                        new NAryTreePreorderTraversal.Node(6))),
                        new NAryTreePreorderTraversal.Node(2),
                        new NAryTreePreorderTraversal.Node(4)));

        return Testsuite.<NAryTreePreorderTraversal>builder()
                .addExpected(t -> t.preorder(root), List.of(1,3,5,6,2,4))
                .build();
    }


    class Solution implements NAryTreePreorderTraversal {

        @Override
        public List<Integer> preorder(Node root) {
            ArrayList<Integer> res = new ArrayList<>();
            preorder(res, root);
            return res;
        }

        public void preorder(List<Integer> res, Node node) {
            if (node == null) {
                return;
            }
            res.add(node.val);
            if (node.children == null) {
                return;
            }
            for (Node child : node.children) {
                preorder(res, child);
            }
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

class NAryTreePreorderTraversalTest extends AbstractTest<NAryTreePreorderTraversal> {
}
