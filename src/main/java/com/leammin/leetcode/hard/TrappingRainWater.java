package com.leammin.leetcode.hard;

/**
 * 42. 接雨水
 *
 * <p>给定&nbsp;<em>n</em> 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。</p>
 *
 * <p><img src="https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2018/10/22/rainwatertrap.png" style="height: 161px; width: 412px;"></p>
 *
 * <p><small>上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。&nbsp;<strong>感谢 Marcos</strong> 贡献此图。</small></p>
 *
 * <p><strong>示例:</strong></p>
 *
 * <pre><strong>输入:</strong> [0,1,0,2,1,0,1,3,2,1,2,1]
 * <strong>输出:</strong> 6</pre>
 *
 * @author Leammin
 * @date 2020-04-04
 */
public interface TrappingRainWater {
    int trap(int[] height);

    class Solution implements TrappingRainWater {

        @Override
        public int trap(int[] height) {
            int ans = 0;
            while (true) {
                boolean doBreak = true;
                int last = -1;
                for (int i = 0; i < height.length; i++) {
                    if (height[i]-- > 0) {
                        if (last >= 0) {
                            ans += i - last - 1;
                            doBreak = false;
                        }
                        last = i;
                    }
                }
                if (doBreak) {
                    break;
                }
            }
            return ans;
        }
    }

    class Solution2 implements TrappingRainWater {

        @Override
        public int trap(int[] height) {
            int ans = 0;
            int max = -1;
            int maxIndex = -1;
            for (int i = 0; i < height.length; i++) {
                if (height[i] >= max) {
                    max = height[i];
                    maxIndex = i;
                }
            }
            if (max <= 0) {
                return 0;
            }
            int prevValue = height[0];
            for (int i = 1; i < maxIndex; i++) {
                if (height[i] < prevValue) {
                    ans += prevValue - height[i];
                } else {
                    prevValue = height[i];
                }
            }
            prevValue = height[height.length - 1];
            for (int i = height.length - 2; i > maxIndex; i--) {
                if (height[i] < prevValue) {
                    ans += prevValue - height[i];
                } else {
                    prevValue = height[i];
                }
            }
            return ans;
        }
    }
}
