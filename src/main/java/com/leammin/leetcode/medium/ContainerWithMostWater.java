package com.leammin.leetcode.medium;

/**
 * 11. 盛最多水的容器
 * 
 * <p>给定 <em>n</em> 个非负整数 <em>a</em><sub>1</sub>，<em>a</em><sub>2，</sub>...，<em>a</em><sub>n，</sub>每个数代表坐标中的一个点&nbsp;(<em>i</em>,&nbsp;<em>a<sub>i</sub></em>) 。在坐标内画 <em>n</em> 条垂直线，垂直线 <em>i</em>&nbsp;的两个端点分别为&nbsp;(<em>i</em>,&nbsp;<em>a<sub>i</sub></em>) 和 (<em>i</em>, 0)。找出其中的两条线，使得它们与&nbsp;<em>x</em>&nbsp;轴共同构成的容器可以容纳最多的水。</p>
 * 
 * <p><strong>说明：</strong>你不能倾斜容器，且&nbsp;<em>n</em>&nbsp;的值至少为 2。</p>
 * 
 * <p><img alt="" src="https://aliyun-lc-upload.oss-cn-hangzhou.aliyuncs.com/aliyun-lc-upload/uploads/2018/07/25/question_11.jpg" style="height: 287px; width: 600px;"></p>
 * 
 * <p><small>图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为&nbsp;49。</small></p>
 * 
 * <p>&nbsp;</p>
 * 
 * <p><strong>示例:</strong></p>
 * 
 * <pre><strong>输入:</strong> [1,8,6,2,5,4,8,3,7]
 * <strong>输出:</strong> 49</pre>
 * 
 * 
 * @author Leammin
 * @date 2020-04-18
 */
public interface ContainerWithMostWater {
    int maxArea(int[] height);

    class Solution implements ContainerWithMostWater {

        @Override
        public int maxArea(int[] height) {
            int ans = 0;
            for (int i = 0; i < height.length - 1; i++) {
                for (int j = i + 1; j < height.length; j++) {
                    ans = Math.max(ans, (j - i) * Math.min(height[i], height[j]));
                }
            }
            return ans;
        }
    }

    class Solution2 implements ContainerWithMostWater {

        @Override
        public int maxArea(int[] height) {
            int ans = 0;
            for (int i = 0; i < height.length; i++) {
                for (int j = 0; j < i; j++) {
                    if (height[j] >= height[i]) {
                        ans = Math.max(ans, (i - j) * height[i]);
                        break;
                    }
                }
                for (int j = height.length - 1; j > i; j--) {
                    if (height[j] >= height[i]) {
                        ans = Math.max(ans, (j - i) * height[i]);
                        break;
                    }
                }
            }

            return ans;
        }
    }

    class Solution3 implements ContainerWithMostWater {

        @Override
        public int maxArea(int[] height) {
            int ans = 0;
            for (int i = 0; i < height.length - 1; i++) {
                boolean hasBigger = false;
                for (int j = height.length - 1; j > i; j--) {
                    if (height[j] >= height[i]) {
                        hasBigger = true;
                        ans = Math.max(ans, (j - i) * height[i]);
                        break;
                    }
                }
                if (!hasBigger) {
                    break;
                }
            }
            for (int i = height.length - 1; i > 0; i--) {
                boolean hasBigger = false;
                for (int j = 0; j < i; j++) {
                    if (height[j] >= height[i]) {
                        hasBigger = true;
                        ans = Math.max(ans, (i - j) * height[i]);
                        break;
                    }
                }
                if (!hasBigger) {
                    break;
                }
            }
            return ans;
        }
    }

    class Demo implements ContainerWithMostWater {

        @Override
        public int maxArea(int[] height) {
            int l = 0, r = height.length - 1;
            int ans = 0;
            while (l < r) {
                int area = Math.min(height[l], height[r]) * (r - l);
                ans = Math.max(ans, area);
                if (height[l] <= height[r]) {
                    ++l;
                }
                else {
                    --r;
                }
            }
            return ans;
        }
    }
}
