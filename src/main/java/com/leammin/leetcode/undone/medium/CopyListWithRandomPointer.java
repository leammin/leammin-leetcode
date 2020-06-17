package com.leammin.leetcode.undone.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * 138. 复制带随机指针的链表
 * 
 * <p>给定一个链表，每个节点包含一个额外增加的随机指针，该指针可以指向链表中的任何节点或空节点。</p>
 * 
 * <p>要求返回这个链表的<strong><a href="https://baike.baidu.com/item/深拷贝/22785317?fr=aladdin" target="_blank">深拷贝</a></strong>。&nbsp;</p>
 * 
 * <p>&nbsp;</p>
 * 
 * <p><strong>示例：</strong></p>
 * 
 * <p><strong><img alt="" src="https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2019/02/23/1470150906153-2yxeznm.png"></strong></p>
 * 
 * <pre><strong>输入：
 * </strong>{&quot;$id&quot;:&quot;1&quot;,&quot;next&quot;:{&quot;$id&quot;:&quot;2&quot;,&quot;next&quot;:null,&quot;random&quot;:{&quot;$ref&quot;:&quot;2&quot;},&quot;val&quot;:2},&quot;random&quot;:{&quot;$ref&quot;:&quot;2&quot;},&quot;val&quot;:1}
 * 
 * <strong>解释：
 * </strong>节点 1 的值是 1，它的下一个指针和随机指针都指向节点 2 。
 * 节点 2 的值是 2，它的下一个指针指向 null，随机指针指向它自己。
 * </pre>
 * 
 * <p>&nbsp;</p>
 * 
 * <p><strong>提示：</strong></p>
 * 
 * <ol>
 * 	<li>你必须返回<strong>给定头的拷贝</strong>作为对克隆列表的引用。</li>
 * </ol>
 * 
 * 
 * @author Leammin
 * @date 2020-06-16
 */
public interface CopyListWithRandomPointer {
    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    Node copyRandomList(Node head);

    class Solution implements CopyListWithRandomPointer {

        @Override
        public Node copyRandomList(Node head) {
            if (head == null) {
                return null;
            }
            Map<Node, Node> oldNodeMapNewNode = new HashMap<>();
            Node newHead = new Node(head.val);
            Node newNode = newHead;
            oldNodeMapNewNode.put(head, newHead);
            Node node = head.next;
            while (node != null) {
                newNode.next = new Node(node.val);
                newNode = newNode.next;
                oldNodeMapNewNode.put(node, newNode);
                node = node.next;
            }
            node = head;
            newNode = newHead;
            while (node != null) {
                if (node.random != null) {
                    newNode.random = oldNodeMapNewNode.get(node.random);
                }
                node = node.next;
                newNode = newNode.next;
            }
            return newHead;
        }
    }
}
