package com.leammin.leetcode.medium;

import com.leammin.leetcode.util.test.AbstractTest;
import com.leammin.leetcode.util.test.Testcase;
import com.leammin.leetcode.util.test.Testsuite;

/**
 * 707. 设计链表
 *
 * <p>设计链表的实现。您可以选择使用单链表或双链表。单链表中的节点应该具有两个属性：<code>val</code>&nbsp;和&nbsp;<code>next</code>。<code>val</code>&nbsp;是当前节点的值，<code>next</code>&nbsp;是指向下一个节点的指针/引用。如果要使用双向链表，则还需要一个属性&nbsp;<code>prev</code>&nbsp;以指示链表中的上一个节点。假设链表中的所有节点都是 0-index 的。</p>
 *
 * <p>在链表类中实现这些功能：</p>
 *
 * <ul>
 * 	<li>get(index)：获取链表中第&nbsp;<code>index</code>&nbsp;个节点的值。如果索引无效，则返回<code>-1</code>。</li>
 * 	<li>addAtHead(val)：在链表的第一个元素之前添加一个值为&nbsp;<code>val</code>&nbsp;的节点。插入后，新节点将成为链表的第一个节点。</li>
 * 	<li>addAtTail(val)：将值为&nbsp;<code>val</code> 的节点追加到链表的最后一个元素。</li>
 * 	<li>addAtIndex(index,val)：在链表中的第&nbsp;<code>index</code>&nbsp;个节点之前添加值为&nbsp;<code>val</code>&nbsp; 的节点。如果&nbsp;<code>index</code>&nbsp;等于链表的长度，则该节点将附加到链表的末尾。如果 <code>index</code> 大于链表长度，则不会插入节点。如果<code>index</code>小于0，则在头部插入节点。</li>
 * 	<li>deleteAtIndex(index)：如果索引&nbsp;<code>index</code> 有效，则删除链表中的第&nbsp;<code>index</code> 个节点。</li>
 * </ul>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>示例：</strong></p>
 *
 * <pre>MyLinkedList linkedList = new MyLinkedList();
 * linkedList.addAtHead(1);
 * linkedList.addAtTail(3);
 * linkedList.addAtIndex(1,2);   //链表变为1-&gt; 2-&gt; 3
 * linkedList.get(1);            //返回2
 * linkedList.deleteAtIndex(1);  //现在链表是1-&gt; 3
 * linkedList.get(1);            //返回3
 * </pre>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>提示：</strong></p>
 *
 * <ul>
 * 	<li>所有<code>val</code>值都在&nbsp;<code>[1, 1000]</code>&nbsp;之内。</li>
 * 	<li>操作次数将在&nbsp;&nbsp;<code>[1, 1000]</code>&nbsp;之内。</li>
 * 	<li>请不要使用内置的 LinkedList 库。</li>
 * </ul>
 *
 * @author Leammin
 * @date 2020-06-16
 */
public interface DesignLinkedList {
    /**
     * Get the value of the index-th node in the linked list. If the index is invalid, return -1.
     */
    int get(int index);

    /**
     * Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list.
     */
    void addAtHead(int val);

    /**
     * Append a node of value val to the last element of the linked list.
     */
    void addAtTail(int val);

    /**
     * Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted.
     */
    void addAtIndex(int index, int val);

    /**
     * Delete the index-th node in the linked list, if the index is valid.
     */
    void deleteAtIndex(int index);

    static Testsuite<DesignLinkedList> testsuite() {
        return Testsuite.<DesignLinkedList>builder()
                .add(Testcase.of(t -> {
                    long before = System.nanoTime();
                    t.addAtHead(1);
                    t.addAtTail(3);
                    t.addAtIndex(1, 2);
                    assert t.get(1) == 2;
                    t.deleteAtIndex(1);
                    assert t.get(1) == 3;
                    return System.nanoTime() - before;
                }))
                .build();
    }


    class Solution implements DesignLinkedList {
        private static class Node {
            int val;
            Node next;
            Node prev;

            public Node(int val) {
                this.val = val;
            }
        }

        private final Node head = new Node(-1);
        private Node tail = head;
        private int size = 0;

        @Override
        public int get(int index) {
            if (!checkIndex(index)) {
                return -1;
            }
            return getNode(index).val;
        }

        @Override
        public void addAtHead(int val) {
            addNodeNext(head, val);
        }

        @Override
        public void addAtTail(int val) {
            addNodeNext(tail, val);
        }

        @Override
        public void addAtIndex(int index, int val) {
            if (index <= 0) {
                addAtHead(val);
            } else if (index <= size) {
                addNodeNext(getNode(index - 1), val);
            }
        }

        @Override
        public void deleteAtIndex(int index) {
            if (checkIndex(index)) {
                deleteNode(getNode(index));
            }
        }

        private boolean checkIndex(int index) {
            return index >= 0 && index < size;
        }

        private Node getNode(int index) {
            if (index < size / 2) {
                Node node = head.next;
                while (index-- > 0) {
                    node = node.next;
                }
                return node;
            } else {
                Node node = tail;
                while (++index < size) {
                    node = node.prev;
                }
                return node;
            }
        }

        private void deleteNode(Node node) {
            node.prev.next = node.next;
            if (node.next != null) {
                node.next.prev = node.prev;
            } else {
                tail = node.prev;
            }
            node.prev = null;
            node.next = null;
            size--;
        }

        private void addNodeNext(Node node, int val) {
            Node next = node.next;
            node.next = new Node(val);
            node.next.prev = node;
            node.next.next = next;
            if (next != null) {
                next.prev = node.next;
            } else {
                tail = node.next;
            }
            size++;
        }
    }
}

class DesignLinkedListTest extends AbstractTest<DesignLinkedList> {
}
