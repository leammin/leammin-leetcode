package com.leammin.leetcode.easy;

/**
 * 374. 猜数字大小
 * 
 * <p>我们正在玩一个猜数字游戏。 游戏规则如下：<br>
 * 我从&nbsp;<strong>1</strong>&nbsp;到&nbsp;<em><strong>n</strong></em>&nbsp;选择一个数字。 你需要猜我选择了哪个数字。<br>
 * 每次你猜错了，我会告诉你这个数字是大了还是小了。<br>
 * 你调用一个预先定义好的接口&nbsp;<code>guess(int num)</code>，它会返回 3 个可能的结果（<code>-1</code>，<code>1</code>&nbsp;或 <code>0</code>）：</p>
 * 
 * <pre>-1 : 我的数字比较小
 *  1 : 我的数字比较大
 *  0 : 恭喜！你猜对了！
 * </pre>
 * 
 * <p><strong>示例 :</strong></p>
 * 
 * <pre><strong>输入: </strong>n = 10, pick = 6
 * <strong>输出: </strong>6</pre>
 * 
 * 
 * @author Leammin
 * @date 2020-06-17
 */
public interface GuessNumberHigherOrLower {
    int guessNumber(int n);

    default int guess(int num) {
        return Integer.compare(6, num);
    }

    class Solution implements GuessNumberHigherOrLower {

        @Override
        public int guessNumber(int n) {
            int lo = 1;
            int hi = n;
            while (lo <= hi) {
                int mid = lo + (hi - lo) / 2;
                int guess = guess(mid);
                if (guess < 0) {
                    hi = mid - 1;
                } else if (guess > 0) {
                    lo = mid + 1;
                } else {
                    return mid;
                }
            }
            return -1;
        }
    }
}
