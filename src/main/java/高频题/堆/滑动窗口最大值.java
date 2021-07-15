package 高频题.堆;

import java.util.*;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * <p></p>
 * <p> https://leetcode-cn.com/problems/sliding-window-maximum/
 * 给你一个整数数组 nums，有一个大小为k的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k个数字。滑动窗口每次只向右移动一位。
 * <p>
 * 返回滑动窗口中的最大值。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,3,-1,-3,5,3,6,7], k = 3
 * 输出：[3,3,5,5,6,7]
 * 解释：
 * 滑动窗口的位置                最大值
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 * 1 [3  -1  -3] 5  3  6  7       3
 * 1  3 [-1  -3  5] 3  6  7       5
 * 1  3  -1 [-3  5  3] 6  7       5
 * 1  3  -1  -3 [5  3  6] 7       6
 * 1  3  -1  -3  5 [3  6  7]      7
 * 示例 2：
 * <p>
 * 输入：nums = [1], k = 1
 * 输出：[1]
 *
 * <PRE>
 * <BR>    修改记录
 * <BR>-----------------------------------------------
 * <BR>    修改日期         修改人          修改内容
 * </PRE>
 *
 * @author fuzq
 * @version 1.0
 * @date 2021年07月15日 2:08 下午
 * @since 1.0
 */

public class 滑动窗口最大值 {
    // 利用优先队列存储 大小为k的数组   -----> 超出时间限制
    public static int[] maxSlidingWindow(int[] nums, int k) {
        int[] result = new int[nums.length - k + 1];
        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < k - 1; i++) {
            queue.offer(nums[i]);
        }
        PriorityQueue<Integer> queue1 = new PriorityQueue<>((o1, o2) -> o2 - o1);
        for (int i = k - 1; i < nums.length; i++) {

            if (i == k - 1) {
                queue.offer(nums[i]);
            } else {
                queue.poll();
                queue.offer(nums[i]);
            }
            queue1.addAll(queue);
            result[i - k + 1] = queue1.peek();
            queue1.clear();
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        nums = maxSlidingWindow(nums, k);
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }
    }
}
