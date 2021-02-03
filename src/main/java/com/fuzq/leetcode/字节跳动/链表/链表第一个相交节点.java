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
 * @date Created in 2021年02月01日 18:58
 * @since 1.0
 */
public class 链表第一个相交节点 {
    public static class ListNode {
        public int val;
        public ListNode next;

        public ListNode(int num) {
            this.val = num;
        }
    }

    /**
     * 获取A/B相交节点   时间复杂度  O(M+N)
     * @param headA
     * @param headB
     * @return
     */
    public static ListNode getFirstXNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null)
            return null;
        ListNode headAA = headA, headBB = headB;
        while (headA != headB) {
            headA = headA == null? headBB: headA.next;
            headB = headB == null? headAA: headB.next;
        }
        return headA;
    }

    public static void main(String[] args) {
        ListNode head1 = new ListNode(6);
        ListNode head2 = new ListNode(1);
        ListNode head3 = new ListNode(7);
        ListNode head33 = new ListNode(11);
        head1.next = head2;
        head2.next = head3;
        head3.next = head33;

        ListNode head5 = new ListNode(2);
        ListNode head6 = new ListNode(9);
        ListNode head7 = new ListNode(7);
        ListNode head8 = new ListNode(5);
        head5.next = head6;
        head6.next = head3;
        head3.next = head8;
        ListNode result = getFirstXNode(head1, head5);
        System.out.println(result.val);
    }
}
