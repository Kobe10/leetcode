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
 * @date Created in 2020年12月14日 14:46
 * @since 1.0
 */
public class 合并有序双链表 {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode(int x) { val = x; }
     * }
     */
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }

    /**
     * 弄一个伪头指针，然后双指针遍历两个链表，条件是把其中一个链表遍历完毕，然后将剩余的链表接入
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode listNode = new ListNode(0);
        while (l1.next != null && l2.next != null) {
//            if ()
        }
        return null;
    }
}
