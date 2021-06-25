package high.排序;

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
 * @date Created in 2021年03月29日 19:08
 * @since 1.0
 */
public class 快排 {
    // 手撕快排
    // 找第一个数最为基准数，先从右往左查找，找到比基准数小的，停下来，然后从左往右找，找到比基准数大的，停下来；
    // 交换这两个数；然后继续找，直到i，j相等，将基准数和i，j相等的这个数替换，一轮查找结束

    // 我们可以把快速排序看着三个步骤：
    //1.选择基准值：在待排序列中，按照某种方式挑出一个元素，作为基准值。
    //2.分割操作：以该基准值在序列中的实际位置，把序列分成两个子序列，一边是比它大的值，另外一边是比它小的值。
    //3.递归：对两个子序列进行快排，直到序列为空或者只有一个元素。
    public static int[] sortArray(int[] nums) {
        int left = 0, right = nums.length - 1;
        if (left > right) return nums;
        int p = quick_sort(nums, left, right);
        quick_sort(nums, left, p - 1);
        quick_sort(nums, p + 1, right);
        return nums;
    }

    public static int quick_sort(int[] nums, int left, int right) {
        // 这里会将元素进行分部排序， 排完序之后把基准值返回，
        // 设置数组的最后值为基准值
        int p = nums[left];
        int i = left;
        while (left<right) {
            // 从后往前找到第一个小于p的值
            while (left < right && nums[right] >= p)
                right--;
            // 从前往后找到第一个大于p的值
            while (left < right && nums[left] <= p)
                left++;

            // 交换两个值
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
        }
        // 最后对mid 进行赋值
        nums[i] = nums[left];
        nums[left] = p;
        // 返回基准元素的位置
        return i;
    }

    public static void main(String[] args) {
        int nums[] = {5,2,3,1};
        nums = sortArray(nums);
        for (int i: nums) {
            System.out.println(i);
        }
    }
}
