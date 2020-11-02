package com.fuzq.leetcode.字节跳动;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

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
 * @date Created in 2020年09月09日 18:07
 * @since 1.0
 * <p>
 * 经验：区间类的问题，一般而言是需要画图思考的。因为只有建立直观的感觉，才能更有效的去思考解决问题的方案。
 * <p>
 * 还有需要画图思考的相关算法问题有（其实绝大部分都需要打草稿，大神除外）：
 * <p>
 * + 和物理现象相关的：第 42 题：接雨水问题、第 11 题：盛最多水的容器、第 218 题：天际线问题；
 * + 本身问题描述就和图形相关的问题：第 84 题：柱状图中最大的矩形；
 * + 链表问题：穿针引线如果不画图容易把自己绕晕；
 * + 回溯算法问题：根据示例画图发现每一步的选择和剪枝的条件；
 * + 动态规划问题：画示意图发现最优子结构。
 * <p>
 * <p>
 * <p>
 * 得出结论：**可以被合并的区间一定是有交集的区间**，前提是区间按照左端点排好序，这里的交集可以是一个点（例如例 2）。
 * <p>
 * 至于为什么按照左端点升序排序，这里要靠一点直觉猜想，我没有办法说清楚是怎么想到的，有些问题的策略是按照右端点升序排序（也有可能是降序排序，具体问题具体分析）。
 * <p>
 * 接着说，直觉上，只需要对所有的区间**按照左端点升序排序**，然后遍历。
 * <p>
 * + 如果当前遍历到的区间的左端点 > 结果集中最后一个区间的右端点，说明它们没有交集，此时把区间添加到结果集；
 * + 如果当前遍历到的区间的左端点 <= 结果集中最后一个区间的右端点，说明它们有交集，此时产生合并操作，即：对结果集中最后一个区间的右端点更新（取两个区间的最大值）。
 * <p>
 * 经验：区间类的问题，一般而言是需要画图思考的。因为只有建立直观的感觉，才能更有效的去思考解决问题的方案。
 * <p>
 * 还有需要画图思考的相关算法问题有（其实绝大部分都需要打草稿，大神除外）：
 * <p>
 * + 和物理现象相关的：第 42 题：接雨水问题、第 11 题：盛最多水的容器、第 218 题：天际线问题；
 * + 本身问题描述就和图形相关的问题：第 84 题：柱状图中最大的矩形；
 * + 链表问题：穿针引线如果不画图容易把自己绕晕；
 * + 回溯算法问题：根据示例画图发现每一步的选择和剪枝的条件；
 * + 动态规划问题：画示意图发现最优子结构。
 * <p>
 * <p>
 * <p>
 * 得出结论：**可以被合并的区间一定是有交集的区间**，前提是区间按照左端点排好序，这里的交集可以是一个点（例如例 2）。
 * <p>
 * 至于为什么按照左端点升序排序，这里要靠一点直觉猜想，我没有办法说清楚是怎么想到的，有些问题的策略是按照右端点升序排序（也有可能是降序排序，具体问题具体分析）。
 * <p>
 * 接着说，直觉上，只需要对所有的区间**按照左端点升序排序**，然后遍历。
 * <p>
 * + 如果当前遍历到的区间的左端点 > 结果集中最后一个区间的右端点，说明它们没有交集，此时把区间添加到结果集；
 * + 如果当前遍历到的区间的左端点 <= 结果集中最后一个区间的右端点，说明它们有交集，此时产生合并操作，即：对结果集中最后一个区间的右端点更新（取两个区间的最大值）。
 */
//题目java:合并区间
//给出一个区间的集合，请合并所有重叠的区间。
//
//
//
// 示例 1:
//
// 输入: intervals = [[1,3],[2,6],[8,10],[15,18]]
//输出: [[1,6],[8,10],[15,18]]
//解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
//
//
// 示例 2:
//
// 输入: intervals = [[1,4],[4,5]]
//输出: [[1,5]]
//解释: 区间 [1,4] 和 [4,5] 可被视为重叠区间。
//
// 注意：输入类型已于2019年4月15日更改。 请重置默认代码定义以获取新方法签名。
//
//
//
// 提示：
//
//
// intervals[i][0] <= intervals[i][1]
//
// Related Topics 排序 数组

/**
 * 经验：区间类的问题，一般而言是需要画图思考的。因为只有建立直观的感觉，才能更有效的去思考解决问题的方案。
 *
 * 还有需要画图思考的相关算法问题有（其实绝大部分都需要打草稿，大神除外）：
 *
 * + 和物理现象相关的：第 42 题：接雨水问题、第 11 题：盛最多水的容器、第 218 题：天际线问题；
 * + 本身问题描述就和图形相关的问题：第 84 题：柱状图中最大的矩形；
 * + 链表问题：穿针引线如果不画图容易把自己绕晕；
 * + 回溯算法问题：根据示例画图发现每一步的选择和剪枝的条件；
 * + 动态规划问题：画示意图发现最优子结构。
 *
 *
 *
 * 得出结论：**可以被合并的区间一定是有交集的区间**，前提是区间按照左端点排好序，这里的交集可以是一个点（例如例 2）。
 *
 * 至于为什么按照左端点升序排序，这里要靠一点直觉猜想，我没有办法说清楚是怎么想到的，有些问题的策略是按照右端点升序排序（也有可能是降序排序，具体问题具体分析）。
 *
 * 接着说，直觉上，只需要对所有的区间**按照左端点升序排序**，然后遍历。
 *
 * + 如果当前遍历到的区间的左端点 > 结果集中最后一个区间的右端点，说明它们没有交集，此时把区间添加到结果集；
 * + 如果当前遍历到的区间的左端点 <= 结果集中最后一个区间的右端点，说明它们有交集，此时产生合并操作，即：对结果集中最后一个区间的右端点更新（取两个区间的最大值）。
 */

/**
 * **复杂度分析**：
 * + 时间复杂度：![O(N\logN) ](./p__O_N_log_N__.png) ，这里 *N* 是区间的长度；
 * + 空间复杂度：*O(N)*，保存结果集需要的空间，这里计算的是最坏情况，也就是所有的区间都没有交点的时候。
 *
 * 说明：`Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));` 是 Java8 以后提供的一种函数式编程语法，在这里就不展开叙述了。
 */
public class P56MergeIntervals {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[][] merge(int[][] intervals) {
            int len = intervals.length;
            if (len < 2) {
                return intervals;
            }

            // 按照起点排序
            Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));

            // 也可以使用 Stack，因为我们只关心结果集的最后一个区间
            List<int[]> res = new ArrayList<>();
            res.add(intervals[0]);

            for (int i = 1; i < len; i++) {
                int[] curInterval = intervals[i];

                // 每次新遍历到的列表与当前结果集中的最后一个区间的末尾端点进行比较
                int[] peek = res.get(res.size() - 1);

                if (curInterval[0] > peek[1]) {
                    res.add(curInterval);
                } else {
                    // 注意，这里应该取最大
                    peek[1] = Math.max(curInterval[1], peek[1]);
                }
            }
            return res.toArray(new int[res.size()][]);
        }
    }
}
