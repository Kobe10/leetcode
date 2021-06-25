package high.链表;

import java.util.List;

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
 * @date Created in 2021年03月29日 17:07
 * @since 1.0
 * 请判断一个链表是否为回文链表。
 */
public class 回文链表 {

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

    /**
     * 最简单的方法  双指针判断是否回文
     *
     * @param head
     * @return
     */

    public boolean isPalindrome(ListNode head) {
        // 反转链表 一半的链表  然后依次遍历比较
        // 利用快慢指针，返回最后一半的链表
        // 然后反转最后一半的链表，然后从头遍历，比较两个链表的值看是否回文
        ListNode tail = head;
        ListNode cur = null;
        ListNode prev = head;
        int length = 0;
        while (prev != null) {
            length++;
            ListNode temp = prev.next;
            prev.next = cur;
            cur = prev;
            prev = temp;
        }
        int mid = length / 2;
        while (mid > 0) {
            if (cur.val != head.val) {
                return false;
            }
            cur = cur.next;
            tail = tail.next;
        }
        return true;
    }
}
