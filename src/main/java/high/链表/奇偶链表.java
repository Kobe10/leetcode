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
 * @date Created in 2021年04月05日 18:04
 * @since 1.0
 */
public class 奇偶链表 {
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

    public ListNode oddEvenList(ListNode head) {
        // 奇数  偶数同时遍历  奇数指向偶数  偶数指向奇数的next
        if (head == null || head.next == null) {
            return head;
        }
        ListNode js = head;
        ListNode os = head.next;
        ListNode currentOs = os;
        while (os != null && os.next != null) {
            js.next = os.next;
            js = js.next;
            os.next = js.next;
            os = os.next;
        }
        js.next = currentOs;
        return head;
    }
}
