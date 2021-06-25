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
 * @date Created in 2021年04月04日 21:38
 * @since 1.0
 */
public class 移除链表元素 {
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


    public ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return head;
        }
        ListNode tail = head;
        ListNode temp = new ListNode();
        ListNode temp1 = temp;
        temp.next = tail;
        while (temp.next != null) {
            if (temp.next.val == val) {
                temp.next = temp.next.next;
            }
            else {
                temp = temp.next;
            }
        }
        return temp1.next;
    }
}
