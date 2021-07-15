package 高频题.堆;

import com.google.common.collect.Maps;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Objects;
import java.util.PriorityQueue;

/**
 * <p></p>
 * <p> xx
 * <PRE>
 * <BR>    修改记录
 * <BR>-----------------------------------------------
 * <BR>    修改日期         修改人          修改内容
 * </PRE>
 *
 * @author fuzq
 * @version 1.0
 * @date 2021年07月15日 9:36 上午
 * @since 1.0
 */

public class 前K个高频元素 {
    public static int[] topKFrequent(int[] nums, int k) {
        // 遍历 统计出所有元素出现的次数  用hashmap存储
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            // 然后将每个数字和其对饮的出现次数组成一个空间为2的数组   a[0]是key  a[1] 是value --> 出现次数
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        // 小顶堆   a[0] 存的是map的key   a[1]存的是map的value
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });

        // 然后去遍历这个hashMap  和最小堆的堆顶进行比较；
        map.forEach((key, value) -> {
            if (priorityQueue.size() < k) {
                // 如果堆内大小小于k， 那么直接入堆
                priorityQueue.add(new int[]{key, value});
            } else {
                // 如果堆内大小大于等于k， 那么将更大的出现次数入堆，将堆顶数字删除
                if (!priorityQueue.isEmpty() && priorityQueue.peek()[1] < value) {
                    priorityQueue.poll();
                    priorityQueue.add(new int[]{key, value});
                }
            }
        });
        int[] result = new int[k];
        // 最后遍历k次  依次弹出堆顶元素
        for (int i = k - 1; i >= 0; i--) {
            result[i] = Objects.requireNonNull(priorityQueue.poll())[0];
        }
        return result;
    }

    public static void main(String[] args) {
        // nums = [1,1,1,2,2,3], k = 2
        int[] nums = {1, 1, 1, 2, 2, 3};
        int k = 2;
        nums = topKFrequent(nums, k);
        for (int i = 0; i < k; i++) {
            System.out.println(nums[i]);
        }
    }
}
