package com.fuzq.leetcode.字节跳动.数组;

/**
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。例如，数组 [0,1,2,4,5,6,7] 可能变为 [6,7,0,1,2,4,5] 。4,5,6,7,0,1,2,
 * <p>
 * 请找出其中最小的元素。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [3,4,5,1,2]
 * 输出：1
 * 示例 2：
 * <p>
 * 输入：nums = [4,5,6,7,0,1,2]
 * 输出：0
 * 示例 3：
 * <p>
 * 输入：nums = [1]
 * 输出：1
 */
public class 寻找旋转排序数组中的最小值 {

    /**
     * 找到数组的中间元素 mid。
     * 如果中间元素 > 数组第一个元素，我们需要在 mid 右边搜索变化点。
     * 如果中间元素 < 数组第一个元素，我们需要在 mid 左边搜索变化点。
     * 当我们找到变化点时停止搜索，当以下条件满足任意一个即可：
     * 1、nums[mid] > nums[mid + 1]，因此 mid+1 是最小值。
     * <p>
     * 2、nums[mid - 1] > nums[mid]，因此 mid 是最小值。
     *
     * @param num
     * @return
     */
    public static int findMinNum(int[] num) {
        if (num.length < 1)
            return 0;
        if (num.length == 1)
            return num[0];
        // 二分法
        int left = 0, right = num.length - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            // int mid = left + (right - left) / 2
            // 如果中间数小于mid  那么最小数肯定在左边
            if (num[mid] < num[right]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return num[left];
    }

    public static void main(String[] args) {
        int nums[] = {6, 7, 0, 1, 2, 4, 5};
        int nums2[] = {4, 5, 6, 7, 0, 1, 2};
        int nums3[] = {2,2,2,1,1};
        System.out.println(findMinNum(nums));
        System.out.println(findMinNum(nums2));
        System.out.println(findMinNum(nums3));
    }
}
