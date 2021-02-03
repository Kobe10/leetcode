package com.fuzq.leetcode.字节跳动.链表;

/**
 * <p></p>
 * <p>
 * <PRE>
 * <BR>    修改记录
 * <BR>-----------------------------------------------
 * <BR>    修改日期         修改人          修改内容
 * </PRE>
 * <p>
 * 给你一个链表和一个特定值 x ，请你对链表进行分隔，使得所有小于 x 的节点都出现在大于或等于 x 的节点之前。
 * <p>
 * 你应当保留两个分区中每个节点的初始相对位置。
 * 输入：head = 1->4->3->2->5->2, x = 3
 * 输出：1->2->2->4->3->5
 * <p>
 * 两个链表记录然后合并
 *
 * @author fuzq
 * @version 1.0
 * @Desc
 * @date Created in 2021年02月01日 18:58
 * @since 1.0
 */
public class 分隔链表 {
    public static class ListNode {
        public int val;
        public ListNode next;

        public ListNode(int num) {
            this.val = num;
        }
    }

    /**
     * 分隔链表  根据x来分隔出两个链表
     *
     * @param head
     * @return
     */
    public static ListNode spliteListNode(ListNode head, int x) {
        if (head == null)
            return head;
        ListNode leftX = head;
        ListNode result = new ListNode(0);
        ListNode rightX = new ListNode(0);
        ListNode rightXX = rightX;
        while (leftX != null ) {
            if (leftX.val < x) {
                result.next = leftX;
                result = result.next;
                leftX = leftX.next;
            } else {
                rightX.next = leftX;

                rightX = rightX.next;
                leftX = leftX.next;
            }
        }
        // 最后将右边的指针的next置为null， 这样就保证了next的剩下遍历不到的节点给去除了，防止链表呈环状
        rightX.next = null;
        result.next = rightXX.next;
        return head;
    }

    public static void main(String[] args) {
        ListNode head1 = new ListNode(1);
        ListNode head2 = new ListNode(4);
        ListNode head3 = new ListNode(3);
        head1.next = head2;
        head2.next = head3;

        ListNode head5 = new ListNode(2);
        ListNode head6 = new ListNode(5);
        ListNode head7 = new ListNode(2);
        head3.next = head5;
        head5.next = head6;
        head6.next = head7;
        ListNode result = spliteListNode(head1, 3);
        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }
}
