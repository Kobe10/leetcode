package 高频题.堆;

import com.google.common.collect.Lists;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

/**
 * <p></p>
 * <p>
 * Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei), find the minimum number of conference rooms required.
 * <p>
 * Example 1:
 * <p>
 * Input:
 * [[0, 30],[5, 10],[15, 20]]
 * <p>
 * Output: 2
 * Example 2:
 * <p>
 * Input: [[7,10],[2,4]]
 * Output: 1
 * <PRE>
 * <BR>    修改记录
 * <BR>-----------------------------------------------
 * <BR>    修改日期         修改人          修改内容
 * </PRE>
 *
 * @author fuzq
 * @version 1.0
 * @date 2021年07月14日 3:58 下午
 * @since 1.0
 */

public class 会议室II {
    public static class Interval {
        int start;
        int end;
        Interval() {
            start = 0;
            end = 0;
        }
        Interval(int s, int e) {
            start = s;
            end = e;
        }
    }

    // 最小房间个数  先将list按照start时间进行排序(正序)，然后开始遍历list， 当最小堆的队首元素存在而且，队首的元素大于
    public static int minMeetingRooms(List<Interval> intervalList) {
        intervalList = intervalList.stream().sorted(Comparator.comparingInt(o -> o.start)).collect(Collectors.toList());
        // 优先队列创建(默认最小优先队列)  存储Interval的end_time   当前最小的endTime永远是放在队首的，
        // 所以后续所有元素只需要和队首元素进行比较，不满足最小元素的话，其他元素也是不满足的
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        // 进行判断筛选
        for (Interval interval : intervalList) {
            if (!minHeap.isEmpty() && minHeap.peek() <= interval.start) {
                // 当最小堆不为空  并且队首元素(存放的是end_time)小于当前会议室的开始时间   说明当前会议室不需要新建会议室
                minHeap.poll();
            }
            minHeap.add(interval.end);
        }
        return minHeap.size();
    }

    public static void main(String[] args) {
        List<Interval> list = Lists.newArrayList();
        Interval interval = new Interval(0, 30);
        Interval interval1 = new Interval(5, 15);
        Interval interval2 = new Interval(15, 20);
        list.add(interval);
        list.add( interval1);
        list.add( interval2);
        System.out.println(minMeetingRooms(list));
    }
}
