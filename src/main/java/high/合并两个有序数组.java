package high;

import java.lang.reflect.Array;

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
 * @date Created in 2021年03月29日 15:51
 * @since 1.0
 * 给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组。
 *
 * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。你可以假设 nums1 的空间大小等于 m + n，这样它就有足够的空间保存来自 nums2 的元素。
 */
public class 合并两个有序数组 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] nums = new int[m+n];
        int mm = 0, nn = 0, flag = 0;
        while (m > 0 && n > 0) {
            if (nums1[mm] <= nums2[nn]) {
                nums[flag] = nums1[mm];
                mm++;
                m--;
            } else {
                nums[flag] = nums2[nn];
                nn++;
                n--;
            }
            flag++;
        }
        while (m > 0) {
            nums[flag] = nums1[mm];
            mm++;
            m--;
            flag++;
        }
        while (n > 0) {
            nums[flag] = nums2[nn];
            nn++;
            n--;
            flag++;
        }
        for (int i = 0; i < nums1.length; i++) {
            nums1[i] = nums[i];
        }
    }
}
