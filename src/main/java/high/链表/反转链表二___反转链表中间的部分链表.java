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
 * @date Created in 2021年03月26日 12:27
 * @since 1.0
 */

/**
 * 给你单链表的头指针 head 和两个整数 left 和 right ，其中 left <= right 。请你反转从位置 left 到位置 right 的链表节点，返回 反转后的链表
 */

public class 反转链表二___反转链表中间的部分链表 {
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

    public static ListNode reverseBetween(ListNode head, int left, int right) {
        // 遍历 链表  找到反转之前的  left的父节点和right的子节点
        ListNode current = head;
        ListNode leftA = head;
        ListNode rightB = null;

        ListNode rightIndexA = null;
        ListNode rightIndexB = null;
        if (left == 1) {
            leftA = null;
        }

        while (current != null) {
            if (left == 2) {
                // 如果left等于1  标记等于1的时候的当前节点就是前驱节点
                leftA = current;
            }
            if (left == 1) {
                rightIndexA = current;
            }
            if (right == 1) {
                rightIndexB = current;
            }
            left--;
            // 计算右节点的子节点
            right--;
            if (right == 0)
                rightB = current.next;
            current = current.next;
        }
        // 反转链表  这里最重要的是处理  开头和结尾的指针
        // 反转前必须把当初的头节点的next指向rightB
        ListNode cur = rightB;
        ListNode prev = rightIndexA;
        while (prev != rightIndexB) {
            ListNode temp = prev.next;
            prev.next = cur;
            cur = prev;
            prev = temp;
        }
        // 上述循环完之后  需要手动将rightIndexB的节点转到
        if (prev == rightIndexB) {
            rightIndexB.next = cur;
        }
        if (leftA == null) {
            return rightIndexB;
        }
        // 反转完之后再把  leftA 指向 反转后的头结点
        leftA.next = rightIndexB;
        // 反转完之后进行拼接
        rightIndexA.next = rightB;
        return head;
    }

    public static void main(String[] args) {
        ListNode cur = new ListNode(1);
        ListNode cur1 = new ListNode(2);
//        ListNode cur2 = new ListNode(3);
//        ListNode cur3 = new ListNode(4);
//        ListNode cur4 = new ListNode(5);
        cur.next = cur1;
//        cur1.next = cur2;
//        cur2.next = cur3;
//        cur3.next = cur4;
        ListNode listNode = reverseBetween(cur, 1,1);

        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }
}