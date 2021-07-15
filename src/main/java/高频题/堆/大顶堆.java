package 高频题.堆;

/**
 * <p></p>
 * <p> xx
 * <PRE>
 * <BR>    修改记录
 * <BR>-----------------------------------------------
 * <BR>    修改日期         修改人          修改内容
 * </PRE>
 *
 * @author fuzq
 * @version 1.0
 * @date 2021年07月14日 1:53 下午
 * @since 1.0
 */
public class 大顶堆 {

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

    public static int[] buildMaxHeap(int[] a, int heapSize) {
        // 2分  从数组左边进行建堆  mid->left
        for (int i = heapSize / 2; i >= 0; --i) {
            buildHeap(a, i, heapSize);
        }
        return a;
    }

    public static void main(String[] args) {
        int[] arr = {4, 1, 9, 3, 7, 8, 5, 6, 2};
        buildMaxHeap(arr, arr.length);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}
