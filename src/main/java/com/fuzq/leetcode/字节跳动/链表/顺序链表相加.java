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
 * @date Created in 2021年01月30日 12:39
 * @since 1.0
 */
public class 顺序链表相加 {
    public static class ListNode {
        public int val;
        public ListNode next;

        public ListNode(int num) {
            this.val = num;
        }
    }

    /**
     * 可以将链表翻转  然后继续利用上述方法
     *
     * @param head1
     * @param head2
     * @return
     */
    public static ListNode twoListNodeAdd(ListNode head1, ListNode head2) {
        //两个链表相加
        head1 = reserveListNode(head1);
        head2 = reserveListNode(head2);
        ListNode result = new ListNode(0);
        ListNode prev = result;
        int carry = 0;
        // 遍历两个链表，  同位相加，直到所有位全部相加完成；
        // 然后最后一位可能还有进位，所以还需要将最后一位的进位补上
        while (head1 != null || head2 != null) {
            // 如果当前node为空， 那么当前节点的值就是0
            int num1 = (head1 != null ? head1.val : 0);
            int num2 = (head2 != null ? head2.val : 0);
            int sum = num1 + num2 + carry;
            int val = sum % 10;
            carry = sum / 10;
            prev.val = val;
            ListNode temp = new ListNode(0);
            prev.next = temp;
            prev = prev.next;
            if (head1 != null)
                head1 = head1.next;
            if (head2 != null)
                head2 = head2.next;
        }
        result = reserveListNode(result);
        return result;
    }

    /**
     * 翻转链表
     *
     * @param head
     * @return
     */
    public static ListNode reserveListNode(ListNode head) {
        ListNode cur = null;
        ListNode prev = head;
        while (prev != null) {
            ListNode temp = prev.next;
            prev.next = cur;
            cur = prev;
            prev = temp;
        }
        return cur;
    }

    public static void main(String[] args) {
        ListNode head1 = new ListNode(6);
        ListNode head2 = new ListNode(1);
        ListNode head3 = new ListNode(7);
        head1.next = head2;
        head2.next = head3;

        ListNode head5 = new ListNode(2);
        ListNode head6 = new ListNode(9);
        ListNode head7 = new ListNode(5);
        head5.next = head6;
        head6.next = head7;
        ListNode result = twoListNodeAdd(head1, head5);
        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }
}
