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
 * @date Created in 2021年03月30日 14:22
 * @since 1.0
 */
public class 链表奇偶次序排序 {
    public static class ListNode {
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

    public static ListNode reorderList(ListNode head) {
        // 用俩list存储链表   从链表中部开始， list1存储中点之前的， list2存储中点之后的
        // 然后同时遍历两个list  list1从后往前， list2 从前往后 依次进行连接
        // 当前这个整体也可以不用list来存储，直接先找到中点，然后拆分成两个链表， 将链表二反转，然后进行合并

        if (head == null || head.next == null) {
            return null;
        }
        int num= 1;
        // 利用快慢指针来找到中点
        ListNode slow = head, fast = head.next;
        while (fast != null) {
            if (fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;
                num++;
                num++;
            } else {
                num++;
                break;
            }
        }
        // slow 为中点  将slow的next进行反转
        ListNode cur = null;
        ListNode prev = slow.next;
        while (prev != null) {
            ListNode temp = prev.next;
            prev.next = cur;
            cur = prev;
            prev = temp;
        }
        // 反转完毕 将first和prev进行合并
        ListNode list = head;
        ListNode first = head.next;
        for (int i = 1; i < num; i++) {
            if (i % 2 == 0) {
                list.next = first;
                list = list.next;
                if (i == num - 1) {
                    first.next = null;
                }
                first = first.next;
            } else {
                list.next = cur;
                list = list.next;
                cur = cur.next;
            }
        }

        // 保证是找到中点
        return head;

    }

    public static void main(String[] args) {
        ListNode v1 = new ListNode(1);
        ListNode v2 = new ListNode(2);
        ListNode v3 = new ListNode(3);
        ListNode v4 = new ListNode(4);
        ListNode v5 = new ListNode(5);

        v1.next = v2;
        v2.next = v3;
        v3.next = v4;
        v4.next = v5;
        ListNode temp = reorderList(v1);
        while (temp != null) {
            System.out.println(temp.val);
            temp = temp.next;
        }
    }
}
