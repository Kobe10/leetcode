package high;

import com.fuzq.leetcode.字节跳动.链表.分隔链表;

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
 * @date Created in 2021年03月22日 09:21
 * @since 1.0
 */
public class 反转链表 {
    public 分隔链表.ListNode reverseList(分隔链表.ListNode head) {
        分隔链表.ListNode cur = null;
        分隔链表.ListNode prev = head;
        while (prev != null) {
            分隔链表.ListNode temp = prev.next;
            prev.next = cur;
            cur = prev;
            prev = temp;
        }
        return cur;
    }
}
