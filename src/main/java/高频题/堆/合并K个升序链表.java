package 高频题.堆;

import java.util.PriorityQueue;

/**
 * <p></p>
 * https://leetcode-cn.com/problems/merge-k-sorted-lists/solution/he-bing-kge-pai-xu-lian-biao-by-leetcode-solutio-2/
 * <p> 给你一个链表数组，每个链表都已经按升序排列。
 * 请你将所有链表合并到一个升序链表中，返回合并后的链表。
 * * 输入：lists = [[1,4,5],[1,3,4],[2,6]]
 * * 输出：[1,1,2,3,4,4,5,6]
 * * 解释：链表数组如下：
 * * [
 * *   1->4->5,
 * *   1->3->4,
 * *   2->6
 * * ]
 * * 将它们合并到一个有序链表中得到。
 * * 1->1->2->3->4->4->5->6
 * <PRE>
 * <BR>    修改记录
 * <BR>-----------------------------------------------
 * <BR>    修改日期         修改人          修改内容
 * </PRE>
 *
 * @author fuzq
 * @version 1.0
 * @date 2021年07月15日 10:53 上午
 * @since 1.0
 */
public class 合并K个升序链表 {
    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    // 1、解法一 通过优先队列解决
    // 这个方法和前两种方法的思路有所不同，我们需要维护当前每个链表没有被合并的元素的最前面一个，kk 个链表就最多有 kk 个满足这样条件的元素，
    // 每次在这些元素里面选取 val 属性最小的元素合并到答案中。在选取最小元素的时候，我们可以用优先队列来优化这个过程。
    class Data implements Comparable<Data> {
        Integer minValue;
        ListNode node;
        public Data(Integer minValue, ListNode listNode) {
            this.node = listNode;
            this.minValue = minValue;
        }

        @Override
        public int compareTo(Data o) {
            return this.minValue - o.minValue;
        }
    }

    PriorityQueue<Data> queue = new PriorityQueue<Data>();

    public ListNode mergeKListsByPriorityQueue(ListNode[] lists) {
        // 遍历list 链表  将链表入队列  同时将链表的首元素获取出来充当minValue的角色
        for (ListNode l : lists) {
            queue.offer(new Data(l.val, l));
        }

        // 创建新链表
        ListNode head = new ListNode(0);
        ListNode tail = head;
        while (!queue.isEmpty()) {
            // 将队首的所有链表首部的最小值对应的链表取出，然后进行链表赋值
            Data data = queue.poll();
            tail.next = data.node;
            tail = tail.next;
            // 如果当前链表未到尾部，将链表的next重新加入到优先队列中
            if (data.node.next != null) {
                queue.offer(new Data(data.node.next.val, data.node.next));
            }
        }
        return head;
    }

    // 2、解法二 通过分治算法解决
    public ListNode mergeKLists(ListNode[] lists) {
        return merge(lists, 0, lists.length - 1);
    }

    public ListNode merge(ListNode[] lists, int l, int r) {
        if (l == r) {
            return lists[l];
        }
        if (l > r) {
            return null;
        }
        int mid = (l + r) >> 1;
        // 递归去合并链表
        return mergeTwoLists(merge(lists, l, mid), merge(lists, mid + 1, r));
    }

    public ListNode mergeTwoLists(ListNode a, ListNode b) {
        if (a == null || b == null) {
            return a != null ? a : b;
        }
        ListNode head = new ListNode(0);
        ListNode tail = head, aPtr = a, bPtr = b;
        while (aPtr != null && bPtr != null) {
            if (aPtr.val < bPtr.val) {
                tail.next = aPtr;
                aPtr = aPtr.next;
            } else {
                tail.next = bPtr;
                bPtr = bPtr.next;
            }
            tail = tail.next;
        }
        tail.next = (aPtr != null ? aPtr : bPtr);
        return head.next;
    }

}
