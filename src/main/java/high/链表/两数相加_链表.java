package high.链表;

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
 * @date Created in 2021年03月26日 15:07
 * @since 1.0
 */

/**
 * 给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
 * <p>
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 * <p>
 * 你可以假设除了数字 0 之外，这两个数都不会以 0 开头
 * <p>
 * 输入：l1 = [2,4,3], l2 = [5,6,4]
 * 输出：[7,0,8]
 * 解释：342 + 465 = 807.
 */
// 这个属于正序链表相加   遍历就和从个位数相加一样
public class 两数相加_链表 {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = null,tail = null;
        // 补全0
        int flag = 0;
        ListNode cur = null;
        while (l1 != null || l2 != null) {
            int l1Num = 0;
            int l2Num = 0;
            if (l1 != null) {
                l1Num = l1.val;
            }
            if (l2 != null) {
                l2Num = l2.val;
            }
            int num = l1Num + l2Num + flag;
            if (head == null) {
                head = new ListNode(num % 10);
                tail = head;
            } else {
                tail.next = new ListNode(num % 10);
                tail = tail.next;
            }
            flag = num / 10;

            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }

        }
        if (flag != 0) {
            tail.next = new ListNode(flag);
        }

        return head;
    }

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(0);
//        ListNode listNode2 = new ListNode(0);
//        ListNode listNode3 = new ListNode(3);
//        listNode1.next = listNode2;
//        listNode2.next = listNode3;


        ListNode listNode4 = new ListNode(0);


//        ListNode listNode5 = new ListNode(6);
//        ListNode listNode6 = new ListNode(4);
//        listNode4.next = listNode5;
//        listNode5.next = listNode6;

        ListNode temp = addTwoNumbers(listNode1, listNode4);
        while (temp != null) {
            System.out.println(temp.val);
            temp = temp.next;
        }
    }
}
