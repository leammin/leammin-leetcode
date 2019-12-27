package com.leammin.leetcode.medium;

import com.leammin.leetcode.struct.TreeNode;

import java.util.*;

/**
 * 930. 所有可能的满二叉树
 * 
 * <p><em>满二叉树</em>是一类二叉树，其中每个结点恰好有 0 或 2 个子结点。</p>
 * 
 * <p>返回包含 <code>N</code> 个结点的所有可能满二叉树的列表。 答案的每个元素都是一个可能树的根结点。</p>
 * 
 * <p>答案中每个树的每个<code>结点</code>都<strong>必须</strong>有 <code>node.val=0</code>。</p>
 * 
 * <p>你可以按任何顺序返回树的最终列表。</p>
 * 
 * <p>&nbsp;</p>
 * 
 * <p><strong>示例：</strong></p>
 * 
 * <pre><strong>输入：</strong>7
 * <strong>输出：</strong>[[0,0,0,null,null,0,0,null,null,0,0],[0,0,0,null,null,0,0,0,0],[0,0,0,0,0,0,0],[0,0,0,0,0,null,null,null,null,0,0],[0,0,0,0,0,null,null,0,0]]
 * <strong>解释：</strong>
 * <img alt="" src="https://aliyun-lc-upload.oss-cn-hangzhou.aliyuncs.com/aliyun-lc-upload/uploads/2018/08/24/fivetrees.png" style="height: 400px; width: 700px;">
 * </pre>
 * 
 * <p>&nbsp;</p>
 * 
 * <p><strong>提示：</strong></p>
 * 
 * <ul>
 * 	<li><code>1 &lt;= N &lt;= 20</code></li>
 * </ul>
 * 
 * 
 * @author Leammin
 * @date 2019-12-27
 */
public interface AllPossibleFullBinaryTrees {
    List<TreeNode> allPossibleFBT(int n);

    class Solution implements AllPossibleFullBinaryTrees {
        private Map<Integer, List<TreeNode>> map = new HashMap<>();
        private static final List<TreeNode> ONE = Collections.singletonList(new TreeNode(0));

        @Override
        public List<TreeNode> allPossibleFBT(int n) {
            if (n <= 0 || (n & 1) == 0) {
                return Collections.emptyList();
            }
            if (map.containsKey(n)) {
                return map.get(n);
            }
            if (n == 1) {
                return ONE;
            }
            List<TreeNode> result = new ArrayList<>();
            for (int i = 1; i < n - 1; i += 2) {
                List<TreeNode> leftNodes = allPossibleFBT(i);
                List<TreeNode> rightNodes = allPossibleFBT(n - 1 - i);
                for (TreeNode left : leftNodes) {
                    for (TreeNode right : rightNodes) {
                        TreeNode t = new TreeNode(0);
                        t.left = left;
                        t.right = right;
                        result.add(t);
                    }
                }
            }
            map.put(n, result);
            return result;
        }
    }
}
