package high;

import java.util.Stack;

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
 * @date Created in 2021年03月26日 12:06
 * @since 1.0
 */
public class 用栈实现队列 {
    Stack<Integer> in;
    Stack<Integer> out;

    /**
     * Initialize your data structure here.
     */
    public 用栈实现队列() {
        in = new Stack<>();
        out = new Stack<>();
    }

    /**
     * Push element x to the back of queue.
     */
    public void push(int x) {
        // 用in栈来推进数据
        in.add(x);
    }

    /**
     * Removes the element from in front of queue and returns that element.
     */
    public int pop() {
        // pop 从队列的开头移除队列中的数 并删除
        // 出栈， 需要把所有的in的数据全部推倒out中去，这样可以让先进的数据在最外层
        if (out.isEmpty()) {
            while (!in.isEmpty()) {
                out.push(in.pop());
            }
        }
        return out.pop();
    }

    /**
     * Get the front element.
     */
    public int peek() {
        if (out.isEmpty()) {
            while (!in.isEmpty()) {
                out.push(in.pop());
            }
        }
        return out.peek();
    }

    /**
     * Returns whether the queue is empty.
     */
    public boolean empty() {
        if (in.isEmpty() && out.isEmpty()) {
            return true;
        }
        return false;
    }
}
