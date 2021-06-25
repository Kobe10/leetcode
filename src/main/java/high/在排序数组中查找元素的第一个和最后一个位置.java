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
 * @date Created in 2021年03月30日 10:44
 * @since 1.0
 */

/**
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 * <p>
 * 如果数组中不存在目标值 target，返回[-1, -1]。
 * 进阶：
 * 你可以设计并实现时间复杂度为O(log n)的算法解决此问题吗？
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [5,7,7,8,8,10], target = 8
 * 输出：[3,4]
 * 示例2：
 * <p>
 * 输入：nums = [5,7,7,8,8,10], target = 6
 * 输出：[-1,-1]
 * 示例 3：
 * <p>
 * 输入：nums = [], target = 0
 * 输出：[-1,-1]
 */
public class 在排序数组中查找元素的第一个和最后一个位置 {
    public static int[] searchRange(int[] nums, int target) {
        if (nums.length == 0) {
            return new int[]{-1, -1};
        }
        // 上来就是一个排序数组   直接整二分法或者双指针
        // 这里需要分成两段  找到target之后  需要分成两段去二分，当然如果写不出来所有都用二分法
        int left = 0, right = nums.length - 1;
        // 找到第一个大于等于target的数 index = leftIndex;
        // 找到第一个大于target的数 index = rightIndex - 1;
        int leftIndex = erfen(nums, left, right, 1, target);
        int rightIndex = erfen(nums, left, right, 2, target) - 1;
        // 这里还需要判断  left一定小于等于right
        if (leftIndex <= rightIndex && rightIndex < nums.length && nums[leftIndex] == target && nums[rightIndex] == target) {
            return new int[]{leftIndex, rightIndex};
        } else {
            return new int[]{-1, -1};
        }

    }

    public static int erfen(int[] nums, int left, int right, int flag, int target) {
        int ans = nums.length;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] > target && flag == 2) {
                right = mid - 1;
                // 找到比target大的
                ans = mid;
            } else if (nums[mid] >= target && flag == 1) {
                right = mid - 1;
                // 找到大于等于target的  每次都记录下来位置，然后还会接着遍历的
                ans = mid;
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int nums[] = {1};
        System.out.println(searchRange(nums, 0));
    }
}
