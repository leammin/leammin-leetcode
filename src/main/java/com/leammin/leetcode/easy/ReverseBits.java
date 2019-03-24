package com.leammin.leetcode.easy;

/**
 * 190. 颠倒二进制位
 * 
 * <div><p>颠倒给定的 32 位无符号整数的二进制位。</p>
 *
 * <p><strong>示例:</strong></p>
 *
 * <pre><strong>输入:</strong> 43261596
 * <strong>输出:</strong> 964176192
 * <strong>解释: </strong>43261596 的二进制表示形式为 <strong>00000010100101000001111010011100 </strong>，
 * &nbsp;    返回 964176192，其二进制表示形式为 <strong>00111001011110000010100101000000 </strong>。</pre>
 *
 * <p><strong>进阶</strong>:<br>
 * 如果多次调用这个函数，你将如何优化你的算法？</p>
 * </div>
 * 
 * @author Leammin
 * @date 2018-09-15
 */
public class ReverseBits {
    public static int reverseBits(int n) {
        int result = 0;
        for (int i = 0; i < 32; i++) {
            result = (result << 1);
            if (n != 0) {
                result += (n & 1);
                n = n >>> 1;
            } 
        }
        return result;
    }

    public static void main(String[] args) {
        int arg = -1;
        System.out.println(Integer.toBinaryString(arg));
        System.out.println(ReverseBits.reverseBits(arg));
        System.out.println(Integer.toBinaryString(ReverseBits.reverseBits(arg)));
    }
}
