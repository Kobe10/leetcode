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
 * @date Created in 2021年04月05日 15:21
 * @since 1.0
 */
public class 调整数组顺序使奇数位于偶数前面 {
    // 双指针   前后同时遍历，碰到奇数、偶数，直接调换位置
    public static int[] exchange(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            while (left < right && nums[left] % 2 == 1) {
                left++;
            }
            while (left< right&& nums[right] % 2 == 0) {
                right--;
            }
            if (left < right) {
                // 交换两个数字
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
            }
        }
        return nums;
    }

    public static void main(String[] args) {
        int num[] = {1, 2, 3, 4};
        System.out.println(exchange(num).toString());
    }
}
