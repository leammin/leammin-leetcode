package com.leammin.leetcode.easy;

/**
 * 面试题04. 二维数组中的查找
 * 
 * <p>在一个 n * m 的二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。</p>
 * 
 * <p>&nbsp;</p>
 * 
 * <p><strong>示例:</strong></p>
 * 
 * <p>现有矩阵 matrix 如下：</p>
 * 
 * <pre>[
 *   [1,   4,  7, 11, 15],
 *   [2,   5,  8, 12, 19],
 *   [3,   6,  9, 16, 22],
 *   [10, 13, 14, 17, 24],
 *   [18, 21, 23, 26, 30]
 * ]
 * </pre>
 * 
 * <p>给定 target&nbsp;=&nbsp;<code>5</code>，返回&nbsp;<code>true</code>。</p>
 * 
 * <p>给定&nbsp;target&nbsp;=&nbsp;<code>20</code>，返回&nbsp;<code>false</code>。</p>
 * 
 * <p>&nbsp;</p>
 * 
 * <p><strong>限制：</strong></p>
 * 
 * <p><code>0 &lt;= n &lt;= 1000</code></p>
 * 
 * <p><code>0 &lt;= m &lt;= 1000</code></p>
 * 
 * <p>&nbsp;</p>
 * 
 * <p><strong>注意：</strong>本题与主站 240 题相同：<a href="https://leetcode-cn.com/problems/search-a-2d-matrix-ii/">https://leetcode-cn.com/problems/search-a-2d-matrix-ii/</a></p>
 * 
 * 
 * @author Leammin
 * @date 2021-08-17
 */
public interface ErWeiShuZuZhongDeChaZhaoLcof {
    boolean findNumberIn2DArray(int[][] matrix, int target);
    
    class Solution implements ErWeiShuZuZhongDeChaZhaoLcof {

        @Override
        public boolean findNumberIn2DArray(int[][] matrix, int target) {
            int i = matrix.length - 1;
            int j = 0;
            while(i >= 0 && j < matrix[i].length) {
                if(matrix[i][j] < target) {
                    j++;
                } else if(matrix[i][j] > target) {
                    i--;
                } else {
                    return true;
                }
            }
            return false;
        }
        
    }
}
