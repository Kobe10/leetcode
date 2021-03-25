package com.fuzq.leetcode.字节跳动.数组;

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
 * @Desc [1, 1, 2],
 * @date Created in 2021年02月07日 16:09
 * @since 1.0
 */
public class 删除排序数组中的重复项 {
    public static int delNums(int[] nums) {
        int length = 0;
        for (int j = 1; j < nums.length; j++) {
            // 这里借用的排序的特点
            if (nums[length] == nums[j]) {
                // 说明数值重复，那么就跳过当前元素
            } else {
                // 如果不相等，说明不重复，那么直接长度+1
                length++;
                nums[length] = nums[j];
            }
        }
        return length + 1;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 2};
        System.out.println(delNums(nums));
    }
}
