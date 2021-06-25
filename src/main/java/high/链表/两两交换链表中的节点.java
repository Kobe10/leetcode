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
 * @date Created in 2021年04月05日 16:40
 * @since 1.0
 */
public class 两两交换链表中的节点 {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    /**
     * @param head
     * @return
     */
    public static ListNode swapPairs(ListNode head) {
        ListNode tail = new ListNode(0);
        tail.next = head;
        ListNode tx = tail;
        while (tx.next != null && tx.next.next != null) {

            // 交换位置
            ListNode right = tx.next.next.next;
            ListNode mid = tx.next.next;
            ListNode left = tx.next;

            tx.next = mid;
            tx.next.next = left;
            left.next = right;
            tx = tx.next.next;

        }
        return tail.next;
    }

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;


        ListNode temp = swapPairs(listNode1);
        while (temp != null) {
            System.out.println(temp.val);
            temp = temp.next;
        }
    }
}
