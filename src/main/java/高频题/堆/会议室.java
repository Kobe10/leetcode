package 高频题.堆;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <p></p>
 * <p>
 * Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei), determine if a person could attend all meetings.
 * <p>
 * Example 1:
 * <p>
 * Input:
 * [[0,30],[5,10],[15,20]]
 * <p>
 * Output: false
 * Example 2:
 * <p>
 * Input: [[7,10],[2,4]]
 * Output: true
 * NOTE: input types have been changed on April 15, 2019. Please reset to default code definition to get new method signature.
 * <PRE>
 * <BR>    修改记录
 * <BR>-----------------------------------------------
 * <BR>    修改日期         修改人          修改内容
 * </PRE>
 *
 * @author fuzq
 * @version 1.0
 * @date 2021年07月14日 3:54 下午
 * @since 1.0
 */
public class 会议室 {
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

    public boolean canAttendMeetings(List<Interval> intervalList) {
        intervalList = intervalList.stream().sorted(Comparator.comparingInt(o -> o.start)).collect(Collectors.toList());
        int end = intervalList.get(0).end;
        for (Interval i : intervalList) {
            if (end > i.start) {
                return false;
            }
        }
        return true;
    }
}

