package 高频题.堆;
/**
 * <p></p>
 * <p> https://leetcode-cn.com/problems/kth-largest-element-in-an-array/solution/shu-zu-zhong-de-di-kge-zui-da-yuan-su-by-leetcode-/
 * 堆属性参考: https://zhuanlan.zhihu.com/p/124228169
 * <PRE>
 * <BR>    修改记录
 * <BR>-----------------------------------------------
 * <BR>    修改日期         修改人          修改内容
 * </PRE>
 *
 * @author fuzq
 * @date 2021年07月14日 1:51 下午
 * @version 1.0
 * @since 1.0
 */
public class 数组中第K大元素 {
    // 寻找倒数第k个大的元素
    public static int findKthLargest(int[] nums, int k) {
        int heapSize = nums.length;
        // 构建最大堆 (最大堆的定义是根节点的元素是最大值，左右子节点的值都小于根节点)  这一步是找出当前数组的最大值
        buildMaxHeap(nums, heapSize);
        // 为了找出数组的倒数第K个最大值 需要遍历K遍(同时将最大值放置在数组头部，方便取出)
        for (int i = nums.length - 1; i >= nums.length - k + 1; --i) {
            swap(nums, 0, i); // 将最大值放在最左边
            --heapSize;
            buildHeap(nums, 0, heapSize);
        }
        return nums[0];
    }

    // 建堆
    public static void buildHeap(int[] array, int i, int heapSize) {
        int l = i * 2 + 1;// 左子节点
        int r = i * 2 + 2; // 右子节点
        int largest = i; // 父节点index
        if (l < heapSize && array[l] > array[largest]) {
            // 比较左子节点和父节点大小
            largest = l;
        }
        if (r < heapSize && array[r] > array[largest]) {
            // 比较右子节点和父节点大小
            largest = r;
        }
        if (largest != i) {
            // 当存在左右子节点大于父节点时候，交换数值
            swap(array, i, largest);
            // 针对左子节点或者右子节点  寻找符合条件的节点(使其满足大顶堆规则)
            buildHeap(array, largest, heapSize);
        }
    }

    // 元素交换
    public static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static void buildMaxHeap(int[] a, int heapSize) {
        // 2分  从数组左边进行建堆  mid->left
        for (int i = heapSize / 2; i >= 0; --i) {
            buildHeap(a, i, heapSize);
        }
    }

    public static void main(String[] args) {
        int[] arr = {4, 1, 9, 3, 7, 8, 5, 6, 2};
        System.out.println(findKthLargest(arr, 2));
    }
}
