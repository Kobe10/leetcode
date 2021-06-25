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
 * @date Created in 2021年03月30日 16:31
 * @since 1.0
 */

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 实现获取 下一个排列 的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。
 * <p>
 * 如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。
 * <p>
 * 必须 原地 修改，只允许使用额外常数空间。
 * 示例 1：
 * <p>
 * 输入：nums = [1,2,3]
 * 输出：[1,3,2]
 * 示例 2：
 * <p>
 * 输入：nums = [3,2,1]
 * 输出：[1,2,3]
 * 示例 3：
 * <p>
 * 输入：nums = [1,1,5]
 * 输出：[1,5,1]
 * 示例 4：
 * <p>
 * 输入：nums = [1]
 * 输出：[1]
 */
public class 下一个排列 {
    public static int[] nextPermutation(int[] nums) {
        // 直接从右边往左边找  找到第一个递减序列的开头值 并且这个递减序列的开头值不为数组第一个数  然后这个递减序列的上一个值就是坐标较小的值
        // 但是是靠近右边的较小的值(类似就是右边的第一个递减序列， 拐点处的前一个值就是相对较小的值)
        // 然后从这个递减序列中再找一个刚刚好比这个拐点处的前一个值大的数字，他俩替换一下  然后再把后面
        int left = nums.length - 2;
        while (left >= 0 && nums[left] >= nums[left+1]) {
            left--;
        }
        // 减完之后 left位置就是从右边数起  相对较小的值
        if (left >= 0) {
            int right = nums.length-1;
            while (nums[left] >= nums[right] && right >0) {
                right--;
            }
            // 这里找到了right和left
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
        }
        // 排序
        Arrays.sort(nums, left + 1, nums.length);
        return nums;
    }


    public static void main(String[] args) {
        int nums[] = {4, 2, 0, 2, 3, 2, 0};

//        Arrays.stream(nums).sorted();
//        Arrays.sort(nums, 1 ,3);
        nums = nextPermutation(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }
    }
}
