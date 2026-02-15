package com.leammin.leetcode.medium;

import com.leammin.leetcode.struct.TreeNode;

import java.util.ArrayList;
import java.util.List;

import com.leammin.leetcode.util.test.AbstractTest;
import com.leammin.leetcode.util.test.ExpectedTestcase;
import com.leammin.leetcode.util.test.Testsuite;

/**
 * 1305. 两棵二叉搜索树中的所有元素
 * 
 * <p>给你&nbsp;<code>root1</code> 和 <code>root2</code>&nbsp;这两棵二叉搜索树。</p>
 * 
 * <p>请你返回一个列表，其中包含&nbsp;<strong>两棵树&nbsp;</strong>中的所有整数并按 <strong>升序</strong> 排序。.</p>
 * 
 * <p>&nbsp;</p>
 * 
 * <p><strong>示例 1：</strong></p>
 * 
 * <p><img alt="" src="https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2019/12/29/q2-e1.png"></p>
 * 
 * <pre><strong>输入：</strong>root1 = [2,1,4], root2 = [1,0,3]
 * <strong>输出：</strong>[0,1,1,2,3,4]
 * </pre>
 * 
 * <p><strong>示例 2：</strong></p>
 * 
 * <pre><strong>输入：</strong>root1 = [0,-10,10], root2 = [5,1,7,0,2]
 * <strong>输出：</strong>[-10,0,0,1,2,5,7,10]
 * </pre>
 * 
 * <p><strong>示例 3：</strong></p>
 * 
 * <pre><strong>输入：</strong>root1 = [], root2 = [5,1,7,0,2]
 * <strong>输出：</strong>[0,1,2,5,7]
 * </pre>
 * 
 * <p><strong>示例 4：</strong></p>
 * 
 * <pre><strong>输入：</strong>root1 = [0,-10,10], root2 = []
 * <strong>输出：</strong>[-10,0,10]
 * </pre>
 * 
 * <p><strong>示例 5：</strong></p>
 * 
 * <p><img alt="" src="https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2019/12/29/q2-e5-.png"></p>
 * 
 * <pre><strong>输入：</strong>root1 = [1,null,8], root2 = [8,1]
 * <strong>输出：</strong>[1,1,8,8]
 * </pre>
 * 
 * <p>&nbsp;</p>
 * 
 * <p><strong>提示：</strong></p>
 * 
 * <ul>
 * 	<li>每棵树最多有&nbsp;<code>5000</code>&nbsp;个节点。</li>
 * 	<li>每个节点的值在&nbsp;<code>[-10^5, 10^5]</code>&nbsp;之间。</li>
 * </ul>
 * 
 * 
 * @author Leammin
 * @date 2020-01-04
 */
public interface AllElementsInTwoBinarySearchTrees {
    List<Integer> getAllElements(TreeNode root1, TreeNode root2);

    static Testsuite<AllElementsInTwoBinarySearchTrees> testsuite() {
        return Testsuite.<AllElementsInTwoBinarySearchTrees>builder()
                .add(ExpectedTestcase.of(s -> s.getAllElements(TreeNode.of(2, 1, 4), TreeNode.of(1, 0, 3)), List.of(0, 1, 1, 2, 3, 4)))
                .add(ExpectedTestcase.of(s -> s.getAllElements(TreeNode.of(0, -10, 10), TreeNode.of(5, 1, 7, 0, 2)), List.of(-10, 0, 0, 1, 2, 5, 7, 10)))
                .add(ExpectedTestcase.of(s -> s.getAllElements(TreeNode.of(), TreeNode.of(5, 1, 7, 0, 2)), List.of(0, 1, 2, 5, 7)))
                .add(ExpectedTestcase.of(s -> s.getAllElements(TreeNode.of(0, -10, 10), TreeNode.of()), List.of(-10, 0, 10)))
                .add(ExpectedTestcase.of(s -> s.getAllElements(TreeNode.of(1, null, 8), TreeNode.of(8, 1)), List.of(1, 1, 8, 8)))
                .build();
    }


    class Solution implements AllElementsInTwoBinarySearchTrees {

        @Override
        public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
            List<Integer> elements1 = getAllElements(new ArrayList<>(), root1);
            List<Integer> elements2 = getAllElements(new ArrayList<>(), root2);
            List<Integer> result = new ArrayList<>(elements1.size() + elements2.size());
            int i1 = 0;
            int i2 = 0;
            while (i1 < elements1.size() && i2 < elements2.size()) {
                Integer e1 = elements1.get(i1);
                Integer e2 = elements2.get(i2);
                if (e1 <= e2) {
                    result.add(e1);
                    i1++;
                } else {
                    result.add(e2);
                    i2++;
                }
            }
            for (; i1 < elements1.size(); i1++) {
                result.add(elements1.get(i1));
            }
            for (; i2 < elements2.size(); i2++) {
                result.add(elements2.get(i2));
            }
            return result;
        }

        private List<Integer> getAllElements(List<Integer> elements, TreeNode root) {
            if (root != null) {
                getAllElements(elements, root.left);
                elements.add(root.val);
                getAllElements(elements, root.right);
            }
            return elements;
        }
    }
}

class AllElementsInTwoBinarySearchTreesTest extends AbstractTest<AllElementsInTwoBinarySearchTrees> {
}
