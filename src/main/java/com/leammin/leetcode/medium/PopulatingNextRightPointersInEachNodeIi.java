package com.leammin.leetcode.medium;

import java.util.*;

/**
 * 117. 填充每个节点的下一个右侧节点指针 II
 * 
 * <p>给定一个二叉树</p>
 * 
 * <pre>struct Node {
 *   int val;
 *   Node *left;
 *   Node *right;
 *   Node *next;
 * }</pre>
 * 
 * <p>填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 <code>NULL</code>。</p>
 * 
 * <p>初始状态下，所有&nbsp;next 指针都被设置为 <code>NULL</code>。</p>
 * 
 * <p>&nbsp;</p>
 * 
 * <p><strong>进阶：</strong></p>
 * 
 * <ul>
 * 	<li>你只能使用常量级额外空间。</li>
 * 	<li>使用递归解题也符合要求，本题中递归程序占用的栈空间不算做额外的空间复杂度。</li>
 * </ul>
 * 
 * <p>&nbsp;</p>
 * 
 * <p><strong>示例：</strong></p>
 * 
 * <p><img alt="" src="https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2019/02/15/117_sample.png" style="height: 218px; width: 640px;"></p>
 * 
 * <pre><strong>输入</strong>：root = [1,2,3,4,5,null,7]
 * <strong>输出：</strong>[1,#,2,3,#,4,5,7,#]
 * <strong>解释：</strong>给定二叉树如图 A 所示，你的函数应该填充它的每个 next 指针，以指向其下一个右侧节点，如图 B 所示。</pre>
 * 
 * <p>&nbsp;</p>
 * 
 * <p><strong>提示：</strong></p>
 * 
 * <ul>
 * 	<li>树中的节点数小于 <code>6000</code></li>
 * 	<li><code>-100&nbsp;&lt;= node.val &lt;= 100</code></li>
 * </ul>
 * 
 * <p>&nbsp;</p>
 * 
 * <ul>
 * </ul>
 * 
 * 
 * @author Leammin
 * @date 2020-06-29
 */
public interface PopulatingNextRightPointersInEachNodeIi {
    Node connect(Node root);

    class Solution implements PopulatingNextRightPointersInEachNodeIi {

        @Override
        public Node connect(Node root) {
            if (root == null) {
                return null;
            }
            Queue<Node> queue = new LinkedList<>();
            queue.add(root);
            while (!queue.isEmpty()) {
                Node last = null;
                for (int i = queue.size() - 1; i >= 0; i--) {
                    Node node = queue.poll();
                    if (last != null) {
                        last.next = node;
                    }
                    last = node;
                    if (node.left != null) {
                        queue.add(node.left);
                    }
                    if (node.right != null) {
                        queue.add(node.right);
                    }
                }
            }
            return root;
        }

    }

    class Solution2 implements PopulatingNextRightPointersInEachNodeIi {

        @Override
        public Node connect(Node root) {
            if (root == null) {
                return null;
            } else if (root.left == null) {
                connect(root.right);
            } else if (root.right == null) {
                connect(root.left);
            } else {
                connect(root.left, root.right);
            }
            return root;
        }

        private void connect(Node n1, Node n2) {
            if (n1.next == null) {
                n1.next = n2;
            }
            List<Node> nodes = filterNotNull(n1.left, n1.right, n2.left, n2.right);
            if (nodes.size() == 1) {
                connect(nodes.get(0));
            } else {
                for (int i = 0; i < nodes.size(); i++) {
                    for (int j = i + 1; j < nodes.size(); j++) {
                        connect(nodes.get(i), nodes.get(j));
                    }
                }
            }
        }

        private List<Node> filterNotNull(Node... nodes) {
            List<Node> res = new ArrayList<>();
            for (Node node : nodes) {
                if (node != null) {
                    res.add(node);
                }
            }
            return res;
        }
    }

    class Solution3 implements PopulatingNextRightPointersInEachNodeIi {

        @Override
        public Node connect(Node root) {
            if (root == null) {
                return null;
            }
            connect(Collections.singletonList(root));
            return root;
        }

        private void connect(List<Node> list) {
            List<Node> newList = new ArrayList<>(list.size() * 2);
            Node last = null;
            for (Node node : list) {
                if (last != null) {
                    last.next = node;
                }
                last = node;
                if (node.left != null) {
                    newList.add(node.left);
                }
                if (node.right != null) {
                    newList.add(node.right);
                }
            }
            if (!newList.isEmpty()) {
                connect(newList);
            }
        }
    }

    class Solution4 implements PopulatingNextRightPointersInEachNodeIi {

        @Override
        public Node connect(Node root) {
            connectNode(root);
            return root;
        }

        private void connectNode(Node parent) {
            Node next = null;
            Node last = null;
            while (parent != null) {
                if (parent.left != null) {
                    if (next == null) {
                        next = parent.left;
                    }
                    if (last == null) {
                        last = parent.left;
                    } else {
                        last.next = parent.left;
                        last = parent.left;
                    }
                }
                if (parent.right != null) {
                    if (next == null) {
                        next = parent.right;
                    }
                    if (last == null) {
                        last = parent.right;
                    } else {
                        last.next = parent.right;
                        last = parent.right;
                    }
                }
                parent = parent.next;
            }
            if (next != null) {
                connectNode(next);
            }
        }
    }

    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }
}
