package com.fuzq.leetcode.字节跳动.链表;

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
 * @date Created in 2021年01月27日 16:37
 * @since 1.0
 */
public class 判断链表是否有环 {
    public class Node {
        int val;
        private Node next;
    }

    public boolean isQuanZi(Node head) {
        Node fast = head, slow = head;
        do {
            if (slow.next == null ||  fast.next.next == null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        } while (slow != fast);
        return true;
    }

    public int findChongfuNum(int[] nums) {
        int slow = 0, fast = 0;
        // 这个循环找到相遇处
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);
        // 将慢指针放到起点处
        slow = 0;
        // 两个指针以相同步伐同时走，相遇处就是环入口处
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }

        return slow;
    }

    public static void main(String[] args) {
        //判断链表中是否有环

    }
}
