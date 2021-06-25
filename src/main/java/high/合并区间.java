package high;

/**
 * <p></p>
 * <p>
 * <PRE>
 * <BR>    修改记录
 * <BR>-----------------------------------------------
 * <BR>    修改日期         修改人          修改内容
 * </PRE>
 *
 * @author fuzq
 * @version 1.0
 * @Desc
 * @date Created in 2021年03月29日 17:37
 * @since 1.0
 */

import java.util.Arrays;
import java.util.Comparator;

/**
 * 以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。请你合并所有重叠的区间，并返回一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
 * 输出：[[1,6],[8,10],[15,18]]
 * 解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 * 示例 2：
 *
 * 输入：intervals = [[1,4],[4,5]]
 * 输出：[[1,5]]
 * 解释：区间 [1,4] 和 [4,5] 可被视为重叠区间。
 *
 */
public class 合并区间 {
    public int[][] merge(int[][] intervals) {
        // 首先对数组进行排序  让数组以开头的值进行排序
        Arrays.sort(intervals, Comparator.comparingInt(interval -> interval[0]));

        // 排完序之后在数组中去合并   遍历整个数组，  把当前序列的左右值取出，然后再把数组上一个的左右值取出，然后比较L的大小
        // 如果L的大  那么直接add
        // 如果L的小  那说明有交叉， 那么就比较R的大小， 取大的那个R的序列
        return null;
    }
}
