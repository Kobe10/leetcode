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
 * @date Created in 2021年03月29日 15:51
 * @since 1.0
 */

/**
 * [1,2,4]
 * [1,3,4]
 */

public class 合并两个有序链表 {
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

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(), tail = head;
        ListNode ll1 = l1, ll2 = l2;
        while (ll1 != null && ll2 != null) {
            if (ll1.val <= ll2.val) {
                head.next = ll1;
                ll1 = ll1.next;
            } else {
                head.next = ll2;
                ll2 = ll2.next;
            }
            head = head.next;
        }
        if (ll1 != null) {
            head.next = ll1;
        }
        if (ll2 != null) {
            head.next = ll2;
        }
        return tail.next;
    }

    public static void main(String[] args) {

    }
}
