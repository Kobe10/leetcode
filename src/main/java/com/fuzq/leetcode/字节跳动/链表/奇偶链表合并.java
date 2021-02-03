package com.fuzq.leetcode.字节跳动.链表;

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
 * @date Created in 2021年02月01日 21:43
 * @since 1.0
 */
public class 奇偶链表合并 {
    public static class ListNode {
        public int val;
        public ListNode next;

        public ListNode(int num) {
            this.val = num;
        }
    }

    /**
     * 合并链表
     *
     * @param head
     * @return
     */
    public static ListNode mergeOE(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode evenHead = head.next;
        ListNode odd = head, two = head.next;
        while (odd.next != null && two.next != null) {
            odd.next = two.next;
            odd = odd.next;
            two.next = odd;
            two = two.next;
        }
        head.next = evenHead;
        return head;
    }

    public static void main(String[] args) {
        ListNode head1 = new ListNode(1);
        ListNode head2 = new ListNode(2);
        ListNode head3 = new ListNode(3);
        head1.next = head2;
        head2.next = head3;

        ListNode head5 = new ListNode(4);
        ListNode head6 = new ListNode(5);
        ListNode head7 = new ListNode(6);
        head3.next = head5;
        head5.next = head6;
        head6.next = head7;
        ListNode result = mergeOE(head1);
        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }
}
