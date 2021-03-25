package high;

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
 * @date Created in 2021年03月25日 16:14
 * @since 1.0
 * <p>
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) {
 * val = x;
 * next = null;
 * }
 * }
 */

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) {
 * val = x;
 * next = null;
 * }
 * }
 */

/**
 * 双指针法    保证走了M+N步之内  会相交
 * A链表走完之后直接把A的末尾指向B
 * B链表走完之后直接指向A链表
 * 只需要判断他俩相不相等就行了
 * 因为5+2  一定等于 2+5
 */
public class 相交链表 {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // 双指针法
        int m = 0;
        int n = 0;

        ListNode left = headA;
        ListNode right = headB;

        while (left != right) {
            if (left == null)
                left = headB;
            else
                left = left.next;

            if (right == null)
                right = headA;
            else
                right = right.next;
        }
        return left;
    }

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);

        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        listNode1.next = listNode2;
        listNode2.next = listNode3;


        ListNode listNode4 = new ListNode(1);


        ListNode listNode5 = new ListNode(4);
        listNode4.next = listNode2;
        listNode2.next = listNode5;

        ListNode temp = getIntersectionNode(listNode1, listNode4);
        System.out.println(temp.val);

    }
}
