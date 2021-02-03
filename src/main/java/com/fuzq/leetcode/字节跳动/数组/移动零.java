package com.fuzq.leetcode.字节跳动.数组;

/**
 * <p></p>
 * <p>
 * <PRE>
 * <BR>    修改记录
 * <BR>-----------------------------------------------
 * <BR>    修改日期         修改人          修改内容
 * </PRE>
 * <p>
 * 给定一个数组 numss，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * 示例:
 * <p>
 * 输入: [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 * 说明:
 * <p>
 * 必须在原数组上操作，不能拷贝额外的数组。
 * 尽量减少操作次数。
 *
 * @author fuzq
 * @version 1.0
 * @Desc
 * @date Created in 2021年02月03日 15:03
 * @since 1.0
 */
public class 移动零 {
    /**
     * 双指针判断
     * 使用双指针，左指针指向当前已经处理好的序列的尾部，右指针指向待处理序列的头部。
     *
     * 右指针不断向右移动，每次右指针指向非零数，则将左右指针对应的数交换，同时左指针右移。
     *
     * 注意到以下性质：
     *
     * 左指针左边均为非零数；
     *
     * 右指针左边直到左指针处均为零。
     *
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/move-zeroes/solution/yi-dong-ling-by-leetcode-solution/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     *
     * @param nums
     * @return
     */
    public static int[] handlerZero(int[] nums) {
        if (nums.length == 1)
            return nums;
        int left = 0, right = 0;
        while (right < nums.length ) {
            if (nums[left] == 0 && nums[right] != 0) {
                //交换顺序  左移一位，右移一位
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                left++;
                right++;
            } else if (nums[left] != 0) {
                left++;
                right++;
            } else if (nums[right] == 0) {
                right++;
            }
        }
        return nums;
    }

    public static void main(String[] args) {
        int[] nums = {1,0,3};
        handlerZero(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }
    }
}
