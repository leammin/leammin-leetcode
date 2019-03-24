package com.leammin.leetcode.easy;

/**
 * 66. 加一
 * 
 * <div><p>给定一个由<strong>整数</strong>组成的<strong>非空</strong>数组所表示的非负整数，在该数的基础上加一。</p>
 *
 * <p>最高位数字存放在数组的首位， 数组中每个元素只存储一个数字。</p>
 *
 * <p>你可以假设除了整数 0 之外，这个整数不会以零开头。</p>
 *
 * <p><strong>示例&nbsp;1:</strong></p>
 *
 * <pre><strong>输入:</strong> [1,2,3]
 * <strong>输出:</strong> [1,2,4]
 * <strong>解释:</strong> 输入数组表示数字 123。
 * </pre>
 *
 * <p><strong>示例&nbsp;2:</strong></p>
 *
 * <pre><strong>输入:</strong> [4,3,2,1]
 * <strong>输出:</strong> [4,3,2,2]
 * <strong>解释:</strong> 输入数组表示数字 4321。
 * </pre>
 * </div>
 * 
 * @author Leammin
 * @date 2018-09-28
 */
public class PlusOne {
    public int[] plusOne(int[] digits) {
        int addOne = 1;
        int index = digits.length - 1;
        while (addOne != 0) {
            if (index < 0) {
                int[] res = new int[digits.length + 1];
                res[0] = 1;
                System.arraycopy(digits, 0, res, 1, digits.length);
                return res;
            }
            if (digits[index] == 9) {
                digits[index] = 0;
                index--;
            } else {
                digits[index] = digits[index] + 1;
                addOne = 0;
            } 
        }
        return digits;
    }
}
