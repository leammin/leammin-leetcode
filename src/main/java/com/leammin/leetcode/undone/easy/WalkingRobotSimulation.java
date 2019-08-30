package com.leammin.leetcode.undone.easy;

import java.util.*;

/**
 * 906. 模拟行走机器人
 *
 * <p>机器人在一个无限大小的网格上行走，从点&nbsp;(0, 0) 处开始出发，面向北方。该机器人可以接收以下三种类型的命令：</p>
 *
 * <ul>
 * 	<li><code>-2</code>：向左转&nbsp;90 度</li>
 * 	<li><code>-1</code>：向右转 90 度</li>
 * 	<li><code>1 &lt;= x &lt;= 9</code>：向前移动&nbsp;<code>x</code>&nbsp;个单位长度</li>
 * </ul>
 *
 * <p>在网格上有一些格子被视为障碍物。</p>
 *
 * <p>第 <code>i</code>&nbsp;个障碍物位于网格点 &nbsp;<code>(obstacles[i][0], obstacles[i][1])</code></p>
 *
 * <p>如果机器人试图走到障碍物上方，那么它将停留在障碍物的前一个网格方块上，但仍然可以继续该路线的其余部分。</p>
 *
 * <p>返回从原点到机器人的最大欧式距离的<strong>平方</strong>。</p>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>示例 1：</strong></p>
 *
 * <pre><strong>输入: </strong>commands = [4,-1,3], obstacles = []
 * <strong>输出: </strong>25
 * <strong>解释:</strong> 机器人将会到达 (3, 4)
 * </pre>
 *
 * <p><strong>示例&nbsp;2：</strong></p>
 *
 * <pre><strong>输入: </strong>commands = [4,-1,4,-2,4], obstacles = [[2,4]]
 * <strong>输出: </strong>65
 * <strong>解释</strong>: 机器人在左转走到 (1, 8) 之前将被困在 (1, 4) 处
 * </pre>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>提示：</strong></p>
 *
 * <ol>
 * 	<li><code>0 &lt;= commands.length &lt;= 10000</code></li>
 * 	<li><code>0 &lt;= obstacles.length &lt;= 10000</code></li>
 * 	<li><code>-30000 &lt;= obstacle[i][0] &lt;= 30000</code></li>
 * 	<li><code>-30000 &lt;= obstacle[i][1] &lt;= 30000</code></li>
 * 	<li>答案保证小于&nbsp;<code>2 ^ 31</code></li>
 * </ol>
 *
 * @author Leammin
 * @date 2019-08-30
 */
public interface WalkingRobotSimulation {
    int robotSim(int[] commands, int[][] obstacles);

    class Solution implements WalkingRobotSimulation {
        @Override
        public int robotSim(int[] commands, int[][] obstacles) {
            Map<Integer, Set<Integer>> obstacleMap = new HashMap<>();
            for (int[] obstacle : obstacles) {
                obstacleMap.computeIfAbsent(obstacle[0], k -> new HashSet<>()).add(obstacle[1]);
            }
            // 坐标
            int[] robot = new int[]{0, 0};
            // 坐标轴，初始面朝北面
            int axis = 1;
            int dir = 1;
            for (int command : commands) {
                switch (command) {
                    case -2:
                        // 左转
                        dir ^= axis;
                        axis ^= 1;
                        break;
                    case -1:
                        // 右转
                        axis ^= 1;
                        dir ^= axis;
                        break;
                    default:
                        for (int i = command; i > 0; i--) {
                            robot[axis] += (dir == 1 ? 1 : -1);
                            if (hasObstacle(obstacleMap, robot[0], robot[1])) {
                                robot[axis] -= (dir == 1 ? 1 : -1);
                                break;
                            }
                        }
                }
            }
            return robot[0] * robot[0] + robot[1] * robot[1];
        }

        private boolean hasObstacle(Map<Integer, Set<Integer>> obstacleMap, int x, int y) {
            return obstacleMap.getOrDefault(x, Collections.emptySet()).contains(y);
        }
    }
}
