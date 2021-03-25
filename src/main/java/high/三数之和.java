package high;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.Arrays;
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
 * @date Created in 2021年03月25日 14:33
 * @since 1.0
 */

/**
 * 总结就是将三次遍历拆解   利用双指针拆成两次遍历，但是需要控制左右指针的顺序
 * 还有就是需要保证不重复，保证不重复的条件就是  a<=b<=c
 * 碰到a相等的  直接左指针增加，知道遇到相邻不是相等的值
 * 碰到b相等的  处理过程类似
 * 同时在处理 b+c 的值的时候，需要控制总和大小， 总和大了需要减小右指针
 */
public class 三数之和 {
    public static List<List<Integer>> threeSum(int[] nums) {
        // 三数之和  且不重复的三元组
        // 1. 排序  快排算法  时间复杂度  O(N方)
        nums = Arrays.stream(nums).sorted().toArray();
        // 双指针遍历
        int left = 0;
        List<List<Integer>> list1 = new ArrayList<>();
        while (left < nums.length - 2) {
            // 必须保证第一层循环的元素不等于第二层循环的元素  (除了刚刚开始的元素)
            if (left > 0 && nums[left] == nums[left - 1]) {
                left++;
                continue;
            }
            int num = -nums[left];
            int right = nums.length - 1;
            for (int j = left + 1; j < right; j++) {
                List<Integer> list = new ArrayList<>();
                // 第二层元素也必须不相等
                if (j > left + 1 && (nums[j] == nums[j - 1])) {
                    continue;
                }
                while (j < right && nums[j] + nums[right] > num) {
                    right--;
                }
                if (j == right) {
                    break;
                }
                // 调整右指针  保证b + c 应该等于
                if (nums[j] + nums[right] == num) {
                    // 找到元素之后  需要把右边的指针依次递减
                    list.add(nums[left]);
                    list.add(nums[right]);
                    list.add(nums[j]);
                    list1.add(list);

                }
            }
            left++;
        }
        return list1;
    }

    public static void main(String[] args) {
//        int[] nums = {-1, 0, 1, 2, -1, -4};
//        int[] nums = {1,2,-2,-1};
        int[] nums = {-1, 0, 1, 2, -1, -4, -2, -3, 3, 0, 4};
        List<List<Integer>> list = threeSum(nums);
        list.forEach(e -> {
            System.out.println(e);
        });

    }
}
